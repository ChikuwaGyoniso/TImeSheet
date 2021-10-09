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
all_nomaltime.innerHTML = xhh + ":" + xmm;