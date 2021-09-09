<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TimeSheet</title>

</head>

<body>
	<p>
		ようこそ
		<c:out value="${userId}" />
		さん
	</p>
	<p>業務終了には定時の終了時間を入力してください</p>
	<form action="RegisterTimeServlet" method="post">
		ユーザーID：<input type="text" name="userid" value="${userId }">
		<table border="1">
			<tr>
				<th>日にち</th>
				<th>業務開始</th>
				<th>業務終了</th>
				<th>定時</th>
				<th>深夜</th>
				<th>休日</th>
				<th>休日深夜</th>
				<th>労働時間合計</th>
			</tr>
			<tr>
				<td><select name="date">
						<c:forEach var="i" begin="1" end="31" step="1">
							<option>${i}日</option>
						</c:forEach>
				</select></td>
				<!-- nomal_timeとworktime_sumを自動計算にしたい -->
				<td><input type="time" name="start_time" value="00:00"></td>
				<td><input type="time" name="end_time" value="00:00"></td>
				<td><input type="time" name="nomal_time" value="00:00"></td>
				<td><input type="time" name="midnight_time" value="00:00"></td>
				<td><input type="time" name="holiday_time" value="00:00"></td>
				<td><input type="time" name="holiday_midnight_time"
					value="00:00"></td>
				<td><input type="time" name="worktime_sum">
			</tr>
		</table>
		<input type="text" name="work_contents" size="30"
			value="業務内容を入力してください"> <input type="submit" value="送信"><br>
	</form>
	<c:choose>
		<c:when test="${not empty errorMsg}">
			<p>${errorMsg }</p>
		</c:when>
		<c:otherwise>
			<p>${successMsg}</p>
		</c:otherwise>
	</c:choose>
	<a href="/TimeSheetApp/UserDateTableServlet">
		<button type="button">一覧表示</button>
	</a>
	<a href="/TimeSheetApp/WelcomeServlet">
		<button type="button">記入完了</button>
	</a>
</body>
</html>