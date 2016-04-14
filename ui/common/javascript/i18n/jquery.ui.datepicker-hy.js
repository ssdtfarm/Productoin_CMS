/* Armenian(UTF-8) initialisation for the jQuery UI date picker plugin. */
/* Written by Levon Zakaryan (levon.zakaryan@gmail.com)*/
jQuery(function($){
	$.datepicker.regional['hy'] = {
		closeText: '論铡寨榨宅',
		prevText: '&#x3c;諉铡窄.',
		nextText: '諃铡栈.&#x3e;',
		currentText: '员盏战謪謤',
		monthNames: ['諃崭謧斩站铡謤','論榨湛謤站铡謤','談铡謤湛','员蘸謤斋宅','談铡盏斋战','諃崭謧斩斋战',
		'諃崭謧宅斋战','諘眨崭战湛崭战','諐榨蘸湛榨沾闸榨謤','諃崭寨湛榨沾闸榨謤','諉崭盏榨沾闸榨謤','源榨寨湛榨沾闸榨謤'],
		monthNamesShort: ['諃崭謧斩站','論榨湛謤','談铡謤湛','员蘸謤','談铡盏斋战','諃崭謧斩斋战',
		'諃崭謧宅','諘眨战','諐榨蘸','諃崭寨','諉崭盏','源榨寨'],
		dayNames: ['寨斋謤铡寨斋','榨寨崭謧辗铡闸诈斋','榨謤榨謩辗铡闸诈斋','展崭謤榨謩辗铡闸诈斋','瞻斋斩眨辗铡闸诈斋','崭謧謤闸铡诈','辗铡闸铡诈'],
		dayNamesShort: ['寨斋謤','榨謤寨','榨謤謩','展謤謩','瞻斩眨','崭謧謤闸','辗闸诈'],
		dayNamesMin: ['寨斋謤','榨謤寨','榨謤謩','展謤謩','瞻斩眨','崭謧謤闸','辗闸诈'],
		weekHeader: '諊圆諒',
		dateFormat: 'dd.mm.yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['hy']);
});