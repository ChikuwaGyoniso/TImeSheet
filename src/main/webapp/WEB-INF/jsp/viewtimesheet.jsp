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
</head>
<body>
	<p>
		<c:out value="${userId}" />
		さんのタイムシート
	</p>

	<%
	if (worktimelist != null && worktimelist.size() > 0) {
	%>
	<table border="1">
		<tr>
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
			<td><%=worktime.getDate()%></td>
			<td><%=worktime.getStart_Time()%></td>
			<td><%=worktime.getEnd_Time()%></td>
			<td><%=worktime.getWork_Contents()%></td>
			<td><%=worktime.getNomal_Time()%></td>
			<td><%=worktime.getMidnight_Time()%></td>
			<td><%=worktime.getHoliday_Time()%></td>
			<td><%=worktime.getHoliday_Midnight_Time()%></td>
			<td><%=worktime.getEnd_Time()%></td>

		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	%>
</body>
</html>