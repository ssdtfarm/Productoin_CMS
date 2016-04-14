/**
 * 
 */
package com.sinosoft.utility;

/**
 * @author wellhi
 */
public class F1ViewInfo
{

	private boolean _AllowSelections = false; // 打印显示界面不能选中
	private boolean _AllowObjectSelections = false; // 打印显示界面不能选中
	private boolean _ShowGridLines = false; // 去掉显示中的网格
	private boolean _ShowColHeading = false; // 去掉显示的列头
	private boolean _ShowRowHeading = false; // 去掉显示的行头
	private boolean _ShowEditBar = false; // 去掉显示的bar
	private boolean _ShowEditBarCellRef = false; // 去掉显示的bar
	// private boolean _ShowTabs(Constants.eTabsOff); //去掉显示的sheet

	// 不显示选中的区域，缺省会用黑色的边框将选中的区域标注出来。
	// private boolean _ShowSelections(Constants.eShowOff);
	// m_bmOutput.setShowVScrollBar(com.f1j.ss.BookModelImpl.eShowOff);
	// m_bmOutput.setShowHScrollBar(com.f1j.ss.BookModelImpl.eShowOff);

	private boolean _PrintGridLines = false; // 在打印时去掉网格
	private String _PrintHeader = ""; // 在打印时去掉头标题
	private String _PrintFooter = ""; // 在打印时去掉页码

	// 打印显示界面不能选中
	public void setAllowSelections(boolean val)
	{
		_AllowSelections = val;
	}

	// 打印显示界面不能选中
	public void setAllowObjectSelections(boolean val)
	{
		_AllowObjectSelections = val;
	}

	// 去掉显示中的网格
	public void setShowGridLines(boolean val)
	{
		_ShowGridLines = val;
	}

	// 去掉显示的列头
	public void setShowColHeading(boolean val)
	{
		_ShowColHeading = val;
	}

	// 去掉显示的行头
	public void setShowRowHeading(boolean val)
	{
		_ShowRowHeading = val;
	}

	// 去掉显示的bar
	public void setShowEditBar(boolean val)
	{
		_ShowEditBar = val;
	}

	// 去掉显示的bar
	public void setShowEditBarCellRef(boolean val)
	{
		_ShowEditBarCellRef = val;
	}

	// // 去掉显示的sheet
	// public void setShowTabs(Constants.eTabsOff)
	// {
	// }
	//
	// // 不显示选中的区域，缺省会用黑色的边框将选中的区域标注出来。
	// public void setShowSelections(Constants.eShowOff)
	// {
	// }
	// public void setShowVScrollBar(com.f1j.ss.BookModelImpl.eShowOff)

	// public void setShowHScrollBar(com.f1j.ss.BookModelImpl.eShowOff)

	// 在打印时去掉网格
	public void setPrintGridLines(boolean val)
	{
		_PrintGridLines = val;
	}

	// 在打印时去掉头标题
	public void setPrintHeader(String val)
	{
		_PrintHeader = val;
	}

	// 在打印时去掉页码
	public void setPrintFooter(String val)
	{
		_PrintFooter = val;
	}

	// 打印显示界面不能选中
	public boolean getAllowSelections()
	{
		return _AllowSelections;
	}

	// 打印显示界面不能选中
	public boolean getAllowObjectSelections()
	{
		return _AllowObjectSelections;
	}

	// 去掉显示中的网格
	public boolean getShowGridLines()
	{
		return _ShowGridLines;
	}

	// 去掉显示的列头
	public boolean getShowColHeading()
	{
		return _ShowColHeading;
	}

	// 去掉显示的行头
	public boolean getShowRowHeading()
	{
		return _ShowRowHeading;
	}

	// 去掉显示的bar
	public boolean getShowEditBar()
	{
		return _ShowEditBar;
	}

	// 去掉显示的bar
	public boolean getShowEditBarCellRef()
	{
		return _ShowEditBarCellRef;
	}

	// 去掉显示的sheet
	// public boolean getShowTabs(Constants.eTabsOff)
	// {
	// return _;
	// }

	// 不显示选中的区域，缺省会用黑色的边框将选中的区域标注出来。
	// public boolean getShowSelections(Constants.eShowOff)
	// {
	// return _;
	// }
	// private void setShowVScrollBar(com.f1j.ss.BookModelImpl.eShowOff)
	// {
	// return _;
	// }
	// private void setShowHScrollBar(com.f1j.ss.BookModelImpl.eShowOff)
	// {
	// return _;
	// }
	// 在打印时去掉网格
	public boolean getPrintGridLines()
	{
		return _PrintGridLines;
	}

	// 在打印时去掉头标题
	public String getPrintHeader()
	{
		return _PrintHeader;
	}

	// 在打印时去掉页码
	public String getPrintFooter()
	{
		return _PrintFooter;
	}

	/**
	 * @param args
	 */
//	public static void main(String[] args)
//	{
//		// TODO Auto-generated method stub
//
//	}

}
