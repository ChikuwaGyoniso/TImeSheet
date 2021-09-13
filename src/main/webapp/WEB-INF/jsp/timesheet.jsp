<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TimeSheet</title>
<head>
<script>
	function timecalc1() {
		k1 = timesheet.start_time.value + ":";
		k2 = timesheet.end_time.value + ":";
		s1 = k1.split(":");
		s2 = k2.split(":");
		v1 = 60 * parseInt(s1[0]) + parseInt(s1[1]);
		v2 = 60 * parseInt(s2[0]) + parseInt(s2[1]);
		sabun = Math.abs(v1 - v2);
		xhh = Math.floor(sabun / 60);
		xmm = sabun % 60;
	    timesheet.nomal_time.value= "0" + xhh + ":" + xmm;

	}
	function timecalc2(){

		k1 = timesheet.nomal_time.value;
		k2 = timesheet.midnight_time.value + ":";
		k3 = timesheet.holiday_time.value + ":";
		k4 = timesheet.holiday_midnight_time.value + ":";

		s1 = k1.split(":");
		s2 = k2.split(":");
		s3 = k3.split(":");
		s4 = k4.split(":");

		v1 = 60 * parseInt(s1[0]) + parseInt(s1[1]);
		v2 = 60 * parseInt(s2[0]) + parseInt(s2[1]);
		v3 = 60 * parseInt(s3[0]) + parseInt(s3[1]);
		v4 = 60 * parseInt(s4[0]) + parseInt(s4[1]);

		goukei = Math.abs(v1 + v2 + v3 + v4);
		xhh = Math.floor(goukei / 60);
		xmm = goukei % 60;
		timesheet.worktime_sum.value = "0" + xhh + ":" + xmm;
	}

</script>
</head>

<body>
	<p>
		ようこそ
		<c:out value="${userId}" />
		さん
	</p>
	<p>業務終了には定時の終了時間を入力してください</p>
	<form action="RegisterTimeServlet" method="post" name="timesheet">
		ユーザーID：<input type="text" name="userid" value="${userId }" readonly="readonly">
		<table border="1">
			<tr>
				<th>日にち</th>
				<th>業務開始</th>
				<th>業務終了</th>
				<th>定時</th>
				<th>深夜</th>
				<th>休日</th>
				<th>休日深夜</th>
				<th>合計</th>
			</tr>
			<tr>
				<td><select name="date">
						<c:forEach var="i" begin="1" end="31" step="1">
							<option>${i}日</option>
						</c:forEach>
				</select></td>

				<td><input type="time" name="start_time" onChange="timecalc1();"></td>
				<td><input type="time" name="end_time" onChange="timecalc1();"></td>
				<td><input type="text" name="nomal_time" readonly="readonly"></td>
				<td><input type="time" name="midnight_time" onChange="timecalc2();"></td>
				<td><input type="time" name="holiday_time" onChange="timecalc2();"></td>
				<td><input type="time" name="holiday_midnight_time" onChange="timecalc2();"></td>
				<td><input type="text" name="worktime_sum" readonly="readonly">
			</tr>
		</table>
		<textarea name="work_contents" rows="5" cols="100"></textarea>
		<input type="submit" value="送信"><br>
	</form>
	<c:choose>
		<c:when test="${not empty errorMsg}">
			<p>${errorMsg }</p>
		</c:when>
		<c:otherwise>
			<p>${successMsg}</p>
		</c:otherwise>
	</c:choose>
	<a href="/TimeSheetApp/ViewTimeSheetServlet">
		<button type="button">一覧表示</button>
	</a>
	<a href="/TimeSheetApp/WelcomeServlet">
		<button type="button">記入完了</button>
	</a>
</body>
</html>