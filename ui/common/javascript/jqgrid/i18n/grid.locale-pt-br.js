;(function($){
/**
 * jqGrid Brazilian-Portuguese Translation
 * Sergio Righi sergio.righi@gmail.com
 * http://curve.com.br
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl.html
**/
$.jgrid = {
	defaults : {
		recordtext: "Ver {0} - {1} of {2}",
	    emptyrecords: "Nenhum registro para visualizar",
		loadtext: "Carregando...",
		pgtext : "P谩gina {0} de {1}"
	},
	search : {
	    caption: "Procurar...",
	    Find: "Procurar",
	    Reset: "Resetar",
	    odata : ['equal', 'not equal', 'less', 'less or equal','greater','greater or equal', 'begins with','does not begin with','is in','is not in','ends with','does not end with','contains','does not contain'],
	    groupOps: [	{ op: "AND", text: "all" },	{ op: "OR",  text: "any" }	],
		matchText: " iguala",
		rulesText: " regras"
	},
	edit : {
	    addCaption: "Incluir",
	    editCaption: "Alterar",
	    bSubmit: "Enviar",
	    bCancel: "Cancelar",
		bClose: "Fechar",
		saveData: "Os dados foram alterados! Salvar altera莽玫es?",
		bYes : "Sim",
		bNo : "N茫o",
		bExit : "Cancelar",
	    msg: {
	        required:"Campo obrigat贸rio",
	        number:"Por favor, informe um n煤mero v谩lido",
	        minValue:"valor deve ser igual ou maior que ",
	        maxValue:"valor deve ser menor ou igual a",
	        email: "este e-mail n茫o 茅 v谩lido",
	        integer: "Por favor, informe um valor inteiro",
			date: "Por favor, informe uma data v谩lida",
			url: "n茫o 茅 uma URL v谩lida. Prefixo obrigat贸rio ('http://' or 'https://')",
			nodefined : " n茫o est谩 definido!",
			novalue : " um valor de retorno 茅 obrigat贸rio!",
			customarray : "Fun莽茫o customizada deve retornar um array!",
			customfcheck : "Fun莽茫o customizada deve estar presente em caso de valida莽茫o customizada!"
		}
	},
	view : {
	    caption: "Ver Registro",
	    bClose: "Fechar"
	},
	del : {
    caption: "Apagar",
	    msg: "Apagar registros selecionado(s)?",
	    bSubmit: "Apagar",
	    bCancel: "Cancelar"
	},
	nav : {
		edittext: " ",
	    edittitle: "Alterar registro selecionado",
		addtext:" ",
	    addtitle: "Incluir novo registro",
	    deltext: " ",
	    deltitle: "Apagar registro selecionado",
	    searchtext: " ",
	    searchtitle: "Procurar registros",
	    refreshtext: "",
	    refreshtitle: "Recarrgando Tabela",
	    alertcap: "Aviso",
	    alerttext: "Por favor, selecione um registro",
		viewtext: "",
		viewtitle: "Ver linha selecionada"
	},
	col : {
	    caption: "Mostrar/Esconder Colunas",
	    bSubmit: "Enviar",
	    bCancel: "Cancelar"
	},
	errors : {
		errcap : "Erro",
		nourl : "Nenhuma URL defenida",
		norecords: "Sem registros para exibir",
	    model : "Comprimento de colNames <> colModel!"
	},
	formatter : {
		integer : {thousandsSeparator: " ", defaultValue: '0'},
		number : {decimalSeparator:",", thousandsSeparator: " ", decimalPlaces: 2, defaultValue: '0,00'},
		currency : {decimalSeparator:",", thousandsSeparator: ".", decimalPlaces: 2, prefix: "R$ ", suffix:"", defaultValue: '0,00'},
		date : {
			dayNames:   [
				"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "S谩b",
				"Domingo", "Segunda", "Ter莽a", "Quarta", "Quinta", "Sexta", "S谩bado"
			],
			monthNames: [
				"Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez",
				"Janeiro", "Fevereiro", "Mar莽o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
			],
			AmPm : ["am","pm","AM","PM"],
			S: function (j) {return j < 11 || j > 13 ? ['潞', '潞', '潞', '潞'][Math.min((j - 1) % 10, 3)] : '潞'},
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
