;(function($){
/**
 * jqGrid Bulgarian Translation 
 * Tony Tomov tony@trirand.com
 * http://trirand.com/blog/ 
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl.html
**/
$.jgrid = {
	defaults : {
		recordtext: "{0} - {1} 铗 {2}",
		emptyrecords: "�爨 玎镨��",
		loadtext: "青疱驿囔...",
		pgtext : "羊� {0} 铗 {1}"
	},
	search : {
		caption: "寅瘃屙�..",
		Find: "袜戾痂",
		Reset: "如麒耱�,
		odata : ['疣忭�, '疣珉梓眍', '镱-爨腙�, '镱-爨腙�桦�','镱-泐�祛','镱-泐�祛 桦�=', '玎镱麾��,'礤 玎镱麾��,'皴 磬扈疣 �,'礤 皴 磬扈疣 �,'玎恸瘌忄 �,'礤 玎恸瘌噔��,'聱潸疰�, '礤 聱潸疰� ],
	    groupOps: [	{ op: "AND", text: " �" },	{ op: "OR",  text: "人� }	],
		matchText: " 怅膻麒",
		rulesText: " 觌囿玎"
	},
	edit : {
		addCaption: "皖�青镨�,
		editCaption: "绣溧牿� 青镨�,
		bSubmit: "青镨",
		bCancel: "如躅�,
		bClose: "青蜮铕�,
		saveData: "泥眄栩�襦 镳铎屙屙� 泥 聱躔囗�腓 镳铎屙栩�",
		bYes : "泥",
		bNo : "湾",
		bExit : "悟赅�,
		msg: {
		    required:"项脲蝾 �玎潸腈栩咫眍",
		    number:"满忮溴蝈 忄腓漤�麒耠�",
		    minValue:"耱铋眍耱蜞 蝠�忄 溧 �镱-泐�爨 桦�疣忭�铗",
		    maxValue:"耱铋眍耱蜞 蝠�忄 溧 �镱-爨腙�桦�疣忭�铗",
		    email: "礤 �忄腓溴�咫. 噤疱�,
		    integer: "满忮溴蝈 忄腓漤��腩 麒耠�,
			date: "满忮溴蝈 忄腓漤�溧蜞",
			url: "e 礤忄腓溴�URL. 如桉赅忄 皴 镳弭桕�'http://' 桦�'https://')",
			nodefined : " �礤溴翳龛疣磬!",
			novalue : " 桤桉赈�怵囗�磬 耱铋眍耱!",
			customarray : "项蝠遽. 泽黻鲨�蝠�忄 溧 恸痦�爨耔�",
			customfcheck : "项蝠遽栩咫耜�趔黻鲨��玎潸腈栩咫磬 镳�蝾玷 蜩�咫屐屙�"
		}
	},
	view : {
	    caption: "橡邈脲�玎镨�,
	    bClose: "青蜮铕�
	},
	del : {
		caption: "如蝠桠囗�,
		msg: "泥 桤蝠� 腓 桤狃囗��玎镨�",
		bSubmit: "如蝠栝",
		bCancel: "悟赅�
	},
	nav : {
		edittext: " ",
		edittitle: "绣溧牿� 桤狃囗 玎镨�,
		addtext:" ",
		addtitle: "念徉�礤 眍�玎镨�,
		deltext: " ",
		deltitle: "如蝠桠囗�桤狃囗 玎镨�,
		searchtext: " ",
		searchtitle: "寅瘃屙�玎镨��",
		refreshtext: "",
		refreshtitle: "吾眍忤 蜞犭桷�,
		alertcap: "橡邃箫疱驿屙桢",
		alerttext: "填�, 桤徨疱蝈 玎镨�,
		viewtext: "",
		viewtitle: "橡邈脲�桤狃囗 玎镨�
	},
	col : {
		caption: "如犷�觐腩龛",
		bSubmit: "侮",
		bCancel: "如躅�	
	},
	errors : {
		errcap : "灭屮赅",
		nourl : "�爨 镱耦麇�url 噤疱�,
		norecords: "�爨 玎镨�玎 钺疣犷蜿�,
		model : "填溴豚 礤 聱铗忮蝰蜮�磬 桁屙囹�"	
	},
	formatter : {
		integer : {thousandsSeparator: " ", defaultValue: '0'},
		number : {decimalSeparator:".", thousandsSeparator: " ", decimalPlaces: 2, defaultValue: '0.00'},
		currency : {decimalSeparator:".", thousandsSeparator: " ", decimalPlaces: 2, prefix: "", suffix:" 脞.", defaultValue: '0.00'},
		date : {
			dayNames:   [
				"湾�, "项�, "买", "佯", "族�, "襄�, "漾�,
				"湾溴�", "项礤溴腠桕", "买铕龛�, "佯��, "族蜮蝥�, "襄蝥�, "漾犷蜞"
			],
			monthNames: [
				"唔�, "藻�, "锑�, "里�, "锑�, "揄�, "揠�, "棱�, "彦�, "侮�, "皖�, "腻�,
				"唔筻痂", "藻怵筻痂", "锑痱", "里痂�, "锑�, "揄�, "揠�, "棱泱耱", "彦矧屐怵�, "侮蝾焘痂", "皖屐怵�, "腻赍焘痂"
			],
			AmPm : ["","","",""],
			S: function (j) {
				if(j==7 || j==8 || j== 27 || j== 28) {
					return '扈';
				}
				return ['忤', '痂', '蜩'][Math.min((j - 1) % 10, 2)];
			},
			srcformat: 'Y-m-d',
			newformat: 'd/m/Y',
			masks : {
		        ISO8601Long:"Y-m-d H:i:s",
		        ISO8601Short:"Y-m-d",
		        ShortDate: "n/j/Y",
		        LongDate: "l, F d, Y",
		        FullDateTime: "l, F d, Y g:i:s A",
		        MonthDay: "F d",
		        ShortTime: "g:i A",
		        LongTime: "g:i:s A",
		        SortableDateTime: "Y-m-d\\TH:i:s",
		        UniversalSortableDateTime: "Y-m-d H:i:sO",
		        YearMonth: "F, Y"
		    },
		    reformatAfterEdit : false
		},
		baseLinkUrl: '',
		showAction: '',
		target: '',
		checkbox : {disabled:true},
		idName : 'id'
	}
};
})(jQuery);
