	function timecalc1() {
		const rest = 60 //休憩時間

		k1 = timesheet.start_time.value + ":";
		k2 = timesheet.end_time.value + ":";
		s1 = k1.split(":");
		s2 = k2.split(":");
		v1 = 60 * parseInt(s1[0]) + parseInt(s1[1]);//start_time
		v2 = 60 * parseInt(s2[0]) + parseInt(s2[1]);//end_time
		sabun = Math.abs(v1 - v2) - rest;
		xhh = Math.floor(sabun / 60);
		xmm = sabun % 60;

		if(xhh < 1){
			xhh = 0;
		}

		timesheet.nomal_time.value = xhh + ":" + xmm;
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
		timesheet.worktime_sum.value = xhh + ":" + xmm;
	}
