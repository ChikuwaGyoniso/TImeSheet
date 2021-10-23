function timecalc1() {

	k1 = timesheet.start_time.value + ":";
	k2 = timesheet.end_time.value + ":";
	k3 = timesheet.rest_time.value + ":";
	s1 = k1.split(":");
	s2 = k2.split(":");
	s3 = k3.split(":");
	v1 = 60 * parseInt(s1[0]) + parseInt(s1[1]);//start_time
	v2 = 60 * parseInt(s2[0]) + parseInt(s2[1]);//end_time
	v3 = 60 * parseInt(s3[0]) + parseInt(s3[1]);//rest_time
	sabun = Math.abs(v1 - v2) - v3;
	xhh = Math.floor(sabun / 60);
	xmm = sabun % 60;

	if (xhh < 1) {
		xhh = 0;
	}

	var strxhh = String(xhh);
	var strxmm = String(xmm);

	if (strxhh.length === 1) {
		strxhh = "0" + strxhh;
	}

	if (strxmm.length === 1) {
		strxmm = "0" + strxmm;
	}

	timesheet.nomal_time.value = strxhh + ":" + strxmm;
}

function timecalc2() {

	k1 = timesheet.nomal_time.value;
	k2 = timesheet.midnight_time.value + ":";
	k3 = timesheet.holiday_time.value + ":";
	k4 = timesheet.holiday_midnight_time.value + ":";

	s1 = k1.split(":");
	s2 = k2.split(":");
	s3 = k3.split(":");
	s4 = k4.split(":");

	v1 = 60 * parseInt(s1[0]) + parseInt(s1[1]);//nomal_time
	v2 = 60 * parseInt(s2[0]) + parseInt(s2[1]);//midnight_time
	v3 = 60 * parseInt(s3[0]) + parseInt(s3[1]);//holiday_time
	v4 = 60 * parseInt(s4[0]) + parseInt(s4[1]);//holiday_midnight_time

	goukei = Math.abs(v1 + v2 + v3 + v4);
	xhh = Math.floor(goukei / 60);
	xmm = goukei % 60;

	var strxhh = String(xhh);
	var strxmm = String(xmm);

	if (strxhh.length === 1) {
		strxhh = "0" + strxhh;
	}

	if (strxmm.length === 1) {
		strxmm = "0" + strxmm;
	}

	timesheet.worktime_sum.value = strxhh + ":" + strxmm;
}
