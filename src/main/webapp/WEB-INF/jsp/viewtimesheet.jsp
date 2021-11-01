<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
List<WorkTime> worktimelist = (List<WorkTime>) request.getAttribute("worktimelist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TimeSheet</title>
<script src="https://code.jquery.com/jquery-3.2.1.js"
	integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
	crossorigin="anonymous">
</script>
<link rel="stylesheet" href="/TimeSheetApp/css/TimeSheetscreenDesign.css">
<link rel="shortcut icon" href="/TimeSheetApp/img/favicon.ico">
</head>
<body>
	<p>
		<c:out value="${userId}" />
		さんのタイムシート
	</p>

	<%
	if (worktimelist != null && worktimelist.size() > 0) {
	%>
	<table border="1" class="timesheet">
		<tr>
			<th>日にち</th>
			<th>業務開始</th>
			<th>業務終了</th>
			<th>業務内容</th>
			<th>通常</th>
			<th>深夜</th>
			<th>休日</th>
			<th>休日深夜</th>
			<th>合計</th>
		</tr>
		<%
		for (WorkTime worktime : worktimelist) {
		%>
		<tr>
			<td><%=worktime.getDate()%></td>
			<td><%=worktime.getStart_Time()%></td>
			<td><%=worktime.getEnd_Time()%></td>
			<td><%=worktime.getWork_Contents()%></td>
			<td class="nomal_time"><%=worktime.getNomal_Time()%></td>
			<!-- 合計を表示 -->
			<td><%=worktime.getMidnight_Time()%></td>
			<td><%=worktime.getHoliday_Time()%></td>
			<td><%=worktime.getHoliday_Midnight_Time()%></td>
			<td class="worktime_sum"><%=worktime.getWorkTime_Sum()%></td>
			<!-- 合計を表示 -->

		</tr>
		<%
		}
		%>
		<tr>
			<td>総合計</td>
			<td></td>
			<td></td>
			<td></td>
			<td id="all_nomaltime"></td>
			<td></td>
			<td></td>
			<td></td>
			<td id="all_worktime_sum"></td>
		</tr>
	</table>

	<%
	} else {
	%>
	<p>表示するデータがありません</p>
	<%
	}
	%>
	<script src="/TimeSheetApp/js/nomaltimecalc.js" ></script>
	<script src="/TimeSheetApp/js/all_worktimesum.js" ></script>

	<button type="button" id="csv">CSV出力</button>
	<a style="display: none" id="downloader" href="#"></a>
	<script src="/TimeSheetApp/js/outputcsv.js"></script>
	<a href="/TimeSheetApp/TimeSheetServlet">
		<button type="button">記入に戻る</button>
	</a>
</body>
</html>