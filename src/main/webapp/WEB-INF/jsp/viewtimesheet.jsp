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
	crossorigin="anonymous"></script>
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
			<th></th>
			<th>日にち</th>
			<th>業務開始</th>
			<th>業務終了</th>
			<th>業務内容</th>
			<th>定時</th>
			<th>深夜</th>
			<th>休日</th>
			<th>休日深夜</th>
			<th>合計</th>
		</tr>
		<%
		for (WorkTime worktime : worktimelist) {
		%>
		<tr>
			<td></td>
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
	<script>
		var goukei = 0;

		var xhh = 0;
		var xmm = 0;

		var count = 0;

		var v1 = 0;

		var timetext = null;

		var nomal_time = document.getElementsByClassName("nomal_time");

		//定時の合計時間の計算
		for (var i = 0; i < nomal_time.length; i++) {
			timetext = nomal_time[i].textContent;

			v1 = timetext.split(":");

			goukei = goukei + 60 * parseInt(v1[0]) + parseInt(v1[1]);

		}
		count = Math.abs(goukei);
		xhh = Math.floor(count / 60);
		xmm = count % 60;
		all_nomaltime.innerHTML =  xhh + ":" + xmm;
　
	   var goukei2 = 0;

	   var xhh2 = 0;
	   var xmm2 = 0;

	   var count2 = 0;

	   var v2 = 0;

       var timetext2 = null;

	   var worktime_sum = document.getElementsByClassName("worktime_sum");

		//総労働時間の計算
		for(var l = 0; l < worktime_sum.length; l++){
			timetext2 = worktime_sum[l].textContent;

			v2 = timetext2.split(":");

			goukei2 = goukei2 + 60 * parseInt(v2[0]) + parseInt(v2[1]);

		}

		count2 = Math.abs(goukei2);
		xhh2 = Math.floor(count2/ 60);
		xmm2 = count2 % 60;

		all_worktime_sum.innerHTML = xhh2 + ":" + xmm2;
	</script>

	<input type="button" id="csv" value="CSV出力">
	<a style="display: none" id="downloader" href="#"></a>
    <script><%@include file="/WEB-INF/js/outputcsv.js" %></script>
	<a href="/TimeSheetApp/TimeSheetServlet">
		<button type="button">記入に戻る</button>
	</a>
</body>
</html>