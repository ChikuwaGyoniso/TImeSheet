var goukei2 = 0;

var xhh2 = 0;
var xmm2 = 0;

var count2 = 0;

var v2 = 0;

var timetext2 = null;

var worktime_sum = document.getElementsByClassName("worktime_sum");

//総労働時間の計算
for (var l = 0; l < worktime_sum.length; l++) {
	timetext2 = worktime_sum[l].textContent;

	v2 = timetext2.split(":");

	goukei2 = goukei2 + 60 * parseInt(v2[0]) + parseInt(v2[1]);

}

count2 = Math.abs(goukei2);
xhh2 = Math.floor(count2 / 60);
xmm2 = count2 % 60;

all_worktime_sum.innerHTML = xhh2 + ":" + xmm2;