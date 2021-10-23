<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TimeSheet</title>
<head>
<script src="/TimeSheetApp/js/timecalc.js"></script>
<link rel="shortcut icon" href="/TimeSheetApp/img/favicon.ico">
<script>
function check() {
	var t1 = timesheet.start_time.value + ":";
	var t2 = timesheet.end_time.value + ":";
	var t3 = timesheet.nomal_time.value;
	var t4 = timesheet.midnight_time.value + ":";
	var t5 = timesheet.holiday_time.value + ":";
	var t6 = timesheet.holiday_midnight_time.value + ":";
	var t7 = timesheet.worktime_sum.value;

	var a1 = t1.split(":");
	var a2 = t2.split(":");
	var a3 = t3.split(":");
	var a4 = t4.split(":");
	var a5 = t5.split(":");
	var a6 = t6.split(":");
	var a7 = t7.split(":");

    var v1 = 60 * parseInt(a1[0]) + parseInt(a1[1]);
    var v2 = 60 * parseInt(a2[0]) + parseInt(a2[1]);
	var v3 = 60 * parseInt(a3[0]) + parseInt(a3[1]);
	var v4 = 60 * parseInt(a4[0]) + parseInt(a4[1]);
	var v5 = 60 * parseInt(a5[0]) + parseInt(a5[1]);
	var v6 = 60 * parseInt(a6[0]) + parseInt(a6[1]);
	var v7 = 60 * parseInt(a7[0]) + parseInt(a7[1]);

    var exe_sum = v3 + v4 + v5 + v6;

	if (v1 > v2) {
		alert("開始時間又は終了時間が誤っています");
		return false;
	} else　if(exe_sum < v7) {
		alert("お手数ですが左から順に記入をお願いします。");
		document.timesheet.reset();
		return false;
	}else{
		return true;
	}
}

</script>
</head>

<body>
	<p>
		ようこそ
		<c:out value="${userId}" />
		さん
	</p>
<h3>・労働時間と作業内容の入力</h3>
	<p>業務終了には定時の終了時間を入力してください</p>
	<form action="RegisterTimeServlet" method="post" name="timesheet">
		ユーザーID：<input type="text" name="userid" value="${userId }"
			readonly="readonly">
		<table border="1">
			<tr>
				<th>日にち</th>
				<th>業務開始</th>
				<th>業務終了</th>
				<th>休憩時間</th>
				<th>定時</th>
				<th>深夜</th>
				<th>休日</th>
				<th>休日深夜</th>
				<th>合計</th>
			</tr>
			<tr>
				<td><input type="date" name="date" max="9999-12-31" required></td>

				<td><input type="time" name="start_time" onChange="timecalc1();" required></td>
				<td><input type="time" name="end_time" onChange="timecalc1();" required></td>
				<td><input type="time" name="rest_time" onChange="timecalc1();" required></td>
				<td><input type="text" name="nomal_time" readonly="readonly"></td>
				<td><input type="time" name="midnight_time"	onChange="timecalc2();" required></td>
				<td><input type="time" name="holiday_time"	onChange="timecalc2();" required></td>
				<td><input type="time" name="holiday_midnight_time"	onChange="timecalc2();" required></td>
				<td><input type="text" name="worktime_sum" readonly="readonly">
			</tr>
		</table>
		<textarea name="work_contents" rows="5" cols="100" placeholder="作業内容を入力してください" required></textarea><br>
		<input type="submit" value="登録" onClick="return check();"><br>
	</form>
	<c:choose>
		<c:when test="${not empty errorMsg}">
			<p>${errorMsg }</p>
		</c:when>
		<c:otherwise>
			<p>${successMsg}</p>
		</c:otherwise>
	</c:choose>
	<h3>・特定年月のデータをテーブル表示する</h3>
	<form action="/TimeSheetApp/ViewTimeSheetServlet" method="post">
        <select name="year">
        <c:forEach var="year" begin="2021" end="2199" step="1">
        <option><c:out value="${year}" /></option>
        </c:forEach>
        </select>
       <select name="month">
        <c:forEach var="month" begin="1" end="12" step="1">
         <option><c:out value="${month}" /></option>
        </c:forEach>
       </select>
		<input type="text" name="userid" value="${userId }"	readonly="readonly">
		<br>
		 <button type="submit" class="viewbutton">一覧表示</button>
	</form>
	<a href="/TimeSheetApp/WelcomeServlet">
		<button type="button" class="finishbutton">記入完了</button>
	</a>
</body>
</html>