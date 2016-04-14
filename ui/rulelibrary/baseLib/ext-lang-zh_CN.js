/*
 * Simplified Chinese translation
 * By DavidHu
 * 09 April 2007
 */

Ext.UpdateManager.defaults.indicatorText = '<div class="loading-indicator">"+I18NMsg("G0000035621")+"</div>';

if(Ext.View){
   Ext.View.prototype.emptyText = "";
}

if(Ext.grid.Grid){
   Ext.grid.Grid.prototype.ddText = "{0} "+I18NMsg("G0000036069")+"";
}

if(Ext.TabPanelItem){
   Ext.TabPanelItem.prototype.closeText = ""+I18NMsg("M0000000015")+"";
}

if(Ext.form.Field){
   Ext.form.Field.prototype.invalidText = ""+I18NMsg("G0000036070")+"";
}

Date.monthNames = [
"Jan.",
"Feb.",
"Mar.",
"Apr.",
"May",
"Jun.",
"Jul.",
"Aug.",
"Sept.",
"Oct.",
"Nov.",
"Dec."
];

Date.dayNames = [
                 "Sun",
                 "Mon",
                 "Tue",
                 "Wed",
                 "Thu",
                 "Fri",
                 "Sat"
];

if(Ext.MessageBox){
   Ext.MessageBox.buttonText = {
      ok     : ""+I18NMsg("G0000028963")+"",
      cancel : ""+I18NMsg("G0000025804")+"",
      yes    :  ""+I18NMsg("ldcode_chooseflag_0")+"",
      no     : ""+I18NMsg("ldcode_chooseflag_1")+""
   };
}

if(Ext.util.Format){
   Ext.util.Format.date = function(v, format){
      if(!v) return "";
      if(!(v instanceof Date)) v = new Date(Date.parse(v));
      return v.dateFormat(format || ""+I18NMsg("G0000036071")+"");
   };
}

if(Ext.DatePicker){
   Ext.apply(Ext.DatePicker.prototype, {
      todayText         : "Today",
      minText           : ""+I18NMsg("G0000036072")+"",
      maxText           : ""+I18NMsg("G0000036073")+"",
      disabledDaysText  : "",
      disabledDatesText : "",
      monthNames        : Date.monthNames,
      dayNames          : Date.dayNames,
      nextText          : 'Next Month (Control+Right)',
      prevText          : 'Last Month (Control+Left)',
      monthYearText     : ''+I18NMsg("G0000036074")+'',
      todayTip          : "{0} "+I18NMsg("G0000036075")+"",
      format            :  ""+I18NMsg("G0000036071")+"",
      okText            :"OK",
      cancelText        : "CANCEL"
   });
}

if(Ext.PagingToolbar){
   Ext.apply(Ext.PagingToolbar.prototype, {
      beforePageText : "",
      afterPageText  : " {0} ",
      firstText      : ""+I18NMsg("G0000036076")+"",
      prevText       : ""+I18NMsg("G0000036077")+"",
      nextText       :""+I18NMsg("M0000045909")+"",
      lastText       : ""+I18NMsg("G0000036078")+"",
      refreshText    : ""+I18NMsg("G0000029381")+"",
      displayMsg     : ""+I18NMsg("G0000036079")+" {0} - "+I18NMsg("G0000036080")+" {2} "+I18NMsg("G0000036081")+"",
      emptyMsg       : ''+I18NMsg("G0000036082")+''
   });
}

if(Ext.form.TextField){
   Ext.apply(Ext.form.TextField.prototype, {
      minLengthText : ""+I18NMsg("G0000036083")+" {0}",
      maxLengthText : ""+I18NMsg("G0000036084")+" {0}",
      blankText     :""+I18NMsg("G0000036085")+"",
      regexText     : "",
      emptyText     : null
   });
}

if(Ext.form.NumberField){
   Ext.apply(Ext.form.NumberField.prototype, {
      minText : ""+I18NMsg("G0000036086")+" {0}",
      maxText : ""+I18NMsg("G0000036087")+" {0}",
      nanText : "{0} "+I18NMsg("G0000036088")+""
   });
}

if(Ext.form.DateField){
   Ext.apply(Ext.form.DateField.prototype, {
      disabledDaysText  : ""+I18NMsg("G0000036089")+"",
      disabledDatesText :""+I18NMsg("G0000036089")+"",
      minText           : ""+I18NMsg("G0000036090")+" {0} "+I18NMsg("G0000036091")+"",
      maxText           : ""+I18NMsg("G0000036090")+" {0} "+I18NMsg("G0000036092")+"",
      invalidText       : "{0} "+I18NMsg("G0000036093")+" - "+I18NMsg("G0000036094")+" {1}",
      format            : ""+I18NMsg("G0000036071")+""
   });
}

if(Ext.form.ComboBox){
   Ext.apply(Ext.form.ComboBox.prototype, {
      loadingText       : ""+I18NMsg("G0000036095")+"",
      valueNotFoundText : undefined
   });
}

if(Ext.form.VTypes){
   Ext.apply(Ext.form.VTypes, {
      emailText    : ''+I18NMsg("G0000036096")+'"user@domain.com"',
      urlText      : ''+I18NMsg("G0000036097")+'"http:/'+'/www.domain.com"',
      alphaText    : ''+I18NMsg("G0000036098")+'',
      alphanumText :  ''+I18NMsg("G0000036099")+''
   });
}

if(Ext.grid.GridView){
   Ext.apply(Ext.grid.GridView.prototype, {
      sortAscText  : ""+I18NMsg("G0000036100")+"",
      sortDescText : ""+I18NMsg("G0000036101")+"",
      lockText     : ""+I18NMsg("G0000036102")+"",
      unlockText   :  ""+I18NMsg("G0000036103")+"",
      columnsText  : ""+I18NMsg("G0000036104")+""
   });
}

if(Ext.grid.PropertyColumnModel){
   Ext.apply(Ext.grid.PropertyColumnModel.prototype, {
      nameText   : ""+I18NMsg("G0000028875")+"",
      valueText  :""+I18NMsg("G0000036105")+"",
      dateFormat : ""+I18NMsg("G0000036071")+""
   });
}

if(Ext.layout.BorderLayout.SplitRegion){
   Ext.apply(Ext.layout.BorderLayout.SplitRegion.prototype, {
      splitTip            : ""+I18NMsg("G0000036106")+"",
      collapsibleSplitTip : ""+I18NMsg("G0000036106")+" "+I18NMsg("G0000036107")+""
   });
}
