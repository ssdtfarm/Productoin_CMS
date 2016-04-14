/*******************************************************************************
 * <p>Title: Lis 6.0</p>
 * <p>Description: 中科软人寿保险核心业务管理系统</p>
 * <p>Copyright: Copyright (c) 2005 Sinosoft, Co.,Ltd. All Rights Reserved</p>
 * <p>Company: 中科软科技股份有限公司</p>
 * <p>WebSite: http://www.sinosoft.com.cn</p>
 *
 * @author   : 辛玉强 <XinYQ@sinosoft.com.cn>
 * @version  : 1.00, 1.01
 * @date     : 2007-12-22, 2007-12-26
 * @direction: 通用消息反馈页面主脚本
 ******************************************************************************/

//<!-- JavaScript Document BGN -->


/*============================================================================*/

var oThisMsgOpener = null;                  //打开此窗口的父窗口对象
var sGrayLayerName = "divNowProcessing";    //父窗口对象的灰色层名称

/*============================================================================*/

/**
 * 界面初始化总函数
 */
function initForm()
{
    makeOpenerGray();
    window.focus();
}

/*============================================================================*/

/**
 * 恢复主窗口显示效果
 */
function unloadForm()
{
    makeOpenerWhite();
}

/*============================================================================*/

/**
 * 使主窗口显示灰色层
 */
function makeOpenerGray()
{
    try
    {
        oThisMsgOpener = top.window.dialogArguments;
    }
    catch (ex) {}
    if (oThisMsgOpener != null && typeof(oThisMsgOpener) != "undefined")
    {
        createGrayBgLayer(oThisMsgOpener, sGrayLayerName);
        //针对首页菜单页面特殊处理
        var oIndexMenuTitle, oIndexMainMenu;
        try
        {
            oIndexMenuTitle = oThisMsgOpener.top.window.frames["fraMenuTop"];
            oIndexMainMenu = oThisMsgOpener.top.window.frames["fraMenu"];
        }
        catch (ex) {}
        if (oIndexMenuTitle != null && typeof(oIndexMenuTitle) != "undefined")
        {
            createGrayBgLayer(oIndexMenuTitle, sGrayLayerName);
        }
        if (oIndexMainMenu != null && typeof(oIndexMainMenu) != "undefined")
        {
            createGrayBgLayer(oIndexMainMenu, sGrayLayerName);
        }
        //针对首页登录信息特殊处理
        var oIndexLogonPage;
        try
        {
            oIndexLogonPage = oThisMsgOpener.top.window.frames["fraQuick"];
        }
        catch (ex) {}
        if (oIndexLogonPage != null && typeof(oIndexLogonPage) != "undefined")
        {
            createGrayBgLayer(oIndexLogonPage, sGrayLayerName);
        }
    }
}

/*============================================================================*/

/**
 * 使主窗口恢复显示颜色
 */
function makeOpenerWhite()
{
    if (oThisMsgOpener != null && typeof(oThisMsgOpener) != "undefined")
    {
        destoryGrayBgLayer(oThisMsgOpener, sGrayLayerName);
        //针对首页菜单页面特殊处理
        var oIndexMenuTitle, oIndexMainMenu;
        try
        {
            oIndexMenuTitle = oThisMsgOpener.top.window.frames["fraMenuTop"];
            oIndexMainMenu = oThisMsgOpener.top.window.frames["fraMenu"];
        }
        catch (ex) {}
        if (oIndexMenuTitle != null && typeof(oIndexMenuTitle) != "undefined")
        {
            destoryGrayBgLayer(oIndexMenuTitle, sGrayLayerName);
        }
        if (oIndexMainMenu != null && typeof(oIndexMainMenu) != "undefined")
        {
            destoryGrayBgLayer(oIndexMainMenu, sGrayLayerName);
        }
        //针对首页登录信息特殊处理
        var oIndexLogonPage;
        try
        {
            oIndexLogonPage = oThisMsgOpener.top.window.frames["fraQuick"];
        }
        catch (ex) {}
        if (oIndexLogonPage != null && typeof(oIndexLogonPage) != "undefined")
        {
            destoryGrayBgLayer(oIndexLogonPage, sGrayLayerName);
        }
    }
    oThisMsgOpener = null;
}

/*============================================================================*/

/**
 * 创建灰色的背景层
 */
function createGrayBgLayer(oParentWindow, sDivLayerName)
{
    if (oParentWindow != null && typeof(oParentWindow) != "undefined")
    {
        try
        {
            var oDivGrayBgLayer = oParentWindow.document.createElement("div");
            oDivGrayBgLayer.id = sDivLayerName;
            oDivGrayBgLayer.name = sDivLayerName;
            var oCssGrayBgLayer = oDivGrayBgLayer.style.setAttribute;
            oCssGrayBgLayer("position", "absolute");
            oCssGrayBgLayer("left", "0px");
            oCssGrayBgLayer("top", "0px");
            var nGrayBgLayerWidth = (oParentWindow.document.body.scrollWidth >= oParentWindow.document.body.clientWidth) ? oParentWindow.document.body.scrollWidth : oParentWindow.document.body.clientWidth;
            var nGrayBgLayerHeight = (oParentWindow.document.body.scrollHeight >= oParentWindow.document.body.clientHeight) ? oParentWindow.document.body.scrollHeight : oParentWindow.document.body.clientHeight;
            oCssGrayBgLayer("width", nGrayBgLayerWidth);
            oCssGrayBgLayer("height", nGrayBgLayerHeight);
            oCssGrayBgLayer("background", "gray");
            oCssGrayBgLayer("z-index", "1000");
            oCssGrayBgLayer("filter", "progid:DXImageTransform.Microsoft.Alpha(opacity=30)");
            oParentWindow.document.body.appendChild(oDivGrayBgLayer);
            oParentWindow.document.body.oncontextmenu = function(){return false;};
            //oParentWindow.document.body.style.overflow = "hidden";
        }
        catch (ex) {}
    }
}

/*============================================================================*/

/**
 * 销毁灰色的背景层
 */
function destoryGrayBgLayer(oParentWindow, sDivLayerName)
{
    try
    {
        var oDivGrayBgLayer = oParentWindow.document.getElementById(sDivLayerName);
        if (oDivGrayBgLayer != null && typeof(oDivGrayBgLayer) != "undefined")
        {
            oParentWindow.document.body.removeChild(oDivGrayBgLayer);
        }
        //oParentWindow.document.body.style.overflow = "auto";
    }
    catch (ex) {}
}

/*============================================================================*/

/**
 * 返回主界面
 */
function returnParent()
{
    try
    {
        top.window.close();
        top.window.dialogArguments.focus();
    }
    catch (ex) {}
}

/*============================================================================*/
