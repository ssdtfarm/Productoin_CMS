;(function($){
/**
 * jqGrid Polish Translation
 * 艁ukasz Schab
 * http://FreeTree.pl
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl.html
**/
$.jgrid = {
	defaults : {
		recordtext: "Poka偶 {0} - {1} z {2}",
	    emptyrecords: "Brak rekord贸w do pokazania",
		loadtext: "\u0142adowanie...",
		pgtext : "Strona {0} z {1}"
	},
	search : {
	    caption: "Wyszukiwanie...",
	    Find: "Szukaj",
	    Reset: "Czy艣膰",
	    odata : ['dok\u0142adnie', 'r贸偶ne od', 'mniejsze od', 'mniejsze lub r贸wne','wi臋ksze od','wi臋ksze lub r贸wne', 'zaczyna si臋 od','nie zaczyna si臋 od','zawiera','nie zawiera','ko艅czy si臋 na','nie ko艅czy si臋 na','zawiera','nie zawiera'],
	    groupOps: [	{ op: "ORAZ", text: "wszystkie" },	{ op: "LUB",  text: "ka偶dy" }	],
		matchText: " pasuje",
		rulesText: " regu\u0142y"
	},
	edit : {
	    addCaption: "Dodaj rekord",
	    editCaption: "Edytuj rekord",
	    bSubmit: "Zapisz",
	    bCancel: "Anuluj",
		bClose: "Zamknij",
		saveData: "Dane zosta\u0142y zmienione! Zapisa膰 zmiany?",
		bYes : "Tak",
		bNo : "Nie",
		bExit : "Anuluj",
	    msg: {
	        required:"Pole jest wymagane",
	        number:"Prosz臋 wpisa膰 poprawn膮 liczb臋",
	        minValue:"warto艣膰 musi by膰 wi臋ksza lub r贸wna",
	        maxValue:"warto艣膰 musi by膰 mniejsza od",
	        email: "nie jest adresem e-mail",
	        integer: "Prosz臋 wpisa膰 poprawn膮 liczb臋",
			date: "Prosz臋 podaj poprawn膮 dat臋",
			url: "jest niew\u0142a艣ciwym adresem URL. Pami臋taj o prefiksie ('http://' lub 'https://')",
			nodefined : " is not defined!",
			novalue : " return value is required!",
			customarray : "Custom function should return array!",
			customfcheck : "Custom function should be present in case of custom checking!"
		}
	},
	view : {
	    caption: "Poka偶 rekord",
	    bClose: "Zamknij"
	},
	del : {
	    caption: "Usuwanie",
	    msg: "Czy usun膮膰 wybrany rekord(y)?",
	    bSubmit: "Usu艅",
	    bCancel: "Anuluj"
	},
	nav : {
		edittext: " ",
	    edittitle: "Edytuj wybrany wiersz",
		addtext:" ",
	    addtitle: "Dodaj nowy wiersz",
	    deltext: " ",
	    deltitle: "Usu艅 wybrany wiersz",
	    searchtext: " ",
	    searchtitle: "Wyszukaj rekord",
	    refreshtext: "",
	    refreshtitle: "Prze\u0142aduj",
	    alertcap: "Uwaga",
	    alerttext: "Prosz臋 wybra膰 wiersz",
		viewtext: "",
		viewtitle: "View selected row"
	},
	col : {
	    caption: "Poka偶/Ukryj kolumny",
	    bSubmit: "Zatwierd藕",
	    bCancel: "Anuluj"	
	},
	errors : {
		errcap : "B\u0142膮d",
		nourl : "Brak adresu url",
		norecords: "Brak danych",
	    model : "D\u0142ugo艣膰 colNames <> colModel!"
	},
	formatter : {
		integer : {thousandsSeparator: " ", defaultValue: '0'},
		number : {decimalSeparator:".", thousandsSeparator: " ", decimalPlaces: 2, defaultValue: '0.00'},
		currency : {decimalSeparator:".", thousandsSeparator: " ", decimalPlaces: 2, prefix: "", suffix:"", defaultValue: '0.00'},
		date : {
			dayNames:   [
				"Nie", "Pon", "Wt", "艢r", "Cz", "Pi", "So",
				"Niedziela", "Poniedzia\u0142ek", "Wtorek", "艢roda", "Czwartek", "Pi膮tek", "Sobota"
			],
			monthNames: [
				"Sty", "Lu", "Mar", "Kwie", "Maj", "Cze", "Lip", "Sie", "Wrz", "Pa藕", "Lis", "Gru",
				"Stycze艅", "Luty", "Marzec", "Kwiecie艅", "Maj", "Czerwiec", "Lipiec", "Sierpie艅", "Wrzesie艅", "Pa藕dziernik", "Listopad", "Grudzie艅"
				],
			AmPm : ["am","pm","AM","PM"],
			S: function (j) {return j < 11 || j > 13 ? ['', '', '', ''][Math.min((j - 1) % 10, 3)] : ''},
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