package com.sinosoft.lis.excel;

import com.sinosoft.Resource.bundle;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jxl.Cell;
import jxl.Range;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.biff.DisplayFormat;
import jxl.biff.FontRecord;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.read.biff.BiffException;
import jxl.write.Blank;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.lis.pubfun.PubFun1;
import com.sinosoft.report.f1report.BarCode;
import com.sinosoft.report.f1report.Code39;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.ListTable;
import com.sinosoft.utility.SSRS;

/**
 * 
 * @version 1.0 2008-3-25
 * @author WangWei
 * @author Evan1
 * 
 */
public class SimpleWorkbook {
	private WritableWorkbook workbook = null;

	private static CellFormat default1Format = null;

	private int size = 0;

	private WritableCellFormat defaultFormat = null;

	// --------------------------------------------

	private Map colFormat = new HashMap();

	private Map rowFormat = new HashMap();

	private CellFormat bothFormat = null;

	// 存储数字类型的列(列，小数位数)
	private Map numberCols = new HashMap();

	private Map numberColFormat = new HashMap();

	private Set mergeCol = new HashSet();

	private Set downNullMergeCol = new HashSet();

	private Set mergerAllCol = new HashSet();

	// (模板中的列，数组中的列)
	private Map arrayCol = new HashMap();

	// 添加数组时的开始位置
	private int startCol = 0;

	private int startRow = 0;

	private int endCol = -1;

	private int templetRow = 0;

	private int templetCol = 0;

	// ---------------------------------------------

	private static final String ROW = "#row#";

	private static final String COL = "#col#";

	private static final String BOTH = "#default#";

	private static final String CELL = "#cell#";

	private static final String MERGE = "#merge#";

	private static final String DOWN_NULL_MERGE = "dmerge";

	private static final String TRAIL = "#trail#";

	private static final String END = "#end#";

	// private static final String REDIRECTION = "#5#";

	// private static final String NUMBER = "#number#";

	// ==================== constructors =====================================

	/**
	 * 
	 * @param templetPath
	 *            Excel 模板的绝对路经
	 * @param resultPath
	 *            要生成的Excel报表的绝对路经
	 * @throws ExcelException
	 * @throws IOException
	 * @throws BiffException
	 * @throws WriteException
	 */
	public SimpleWorkbook(String resultPath, String templetPath)
			throws ExcelException {

		try {
			// modified by hanxl,2009年11月11日 14时32分44秒
			// 设置WorkBook设置的一些参数值，包括以下个方面的优化：
			// 1.禁用自动GC
			// 2.初始化Excel创建对象数组大小减小为2*10240=200K
			WorkbookSettings wks = new WorkbookSettings();
			wks.setGCDisabled(true);// 禁用自动GC设置
			wks.setInitialFileSize(204800); // 初始化Excel创建对象数组为200K
			wks.setArrayGrowSize(204800); // 对象数组不够用时，数组大小增长200K
			workbook = Workbook.createWorkbook(PubFun.createFile(resultPath),
					Workbook.getWorkbook(PubFun.createFile(templetPath), wks), wks);
		} catch (BiffException e) {
			throw new ExcelException(e);
		} catch (IOException e) {
			throw new ExcelException(e.getMessage());
		}
		// -------------------------------------------------
		// int
		// size=workbook.getSheet(0).getColumnFormat(1).getFont().getPointSize();
		WritableFont datawf = new WritableFont(WritableFont.ARIAL, 10,
				WritableFont.NO_BOLD, false);// 表格内数据的字体
		this.defaultFormat = new WritableCellFormat(datawf);
		try {
			defaultFormat.setWrap(true);
			defaultFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
			defaultFormat.setAlignment(jxl.format.Alignment.CENTRE);
			defaultFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		} catch (WriteException e) {
			e.printStackTrace();
		}
		collectFormat();
	}

	private void collectFormat() {
		WritableSheet sheet = workbook.getSheet(0);
		templetCol = sheet.getColumns();
		templetRow = sheet.getRows();
		// System.out.println("templetCol:" + templetCol + " templetRow:" +
		// templetRow);
		for (int i = 0; i < templetRow; i++)
			for (int j = 0; j < templetCol; j++) {
				Cell cell = sheet.getWritableCell(j, i);
				String c = cell.getContents();
				if (c == null && "".equals(c)) {
					continue;
				}
				String contents = c.trim();
				if ("".equals(contents)) {
					continue;
				}
				if (contents.equals(BOTH)) {
					bothFormat = cell.getCellFormat();
					startCol = j;
					startRow = i;
				} else if (contents.equals(ROW)) {
					rowFormat.put(new Integer(cell.getRow()),
							cell.getCellFormat());
				} else if (contents.equals(COL)) {
					colFormat.put(new Integer(cell.getColumn()),
							cell.getCellFormat());
				} else if (contents.startsWith("#.") && contents.endsWith("#")) {
					// number format
					int length = contents.trim().length();
					if (length < 3) {
						continue;
					}
					Integer i2 = null;
					try {
						i2 = new Integer(contents.substring(2, length - 1));
					} catch (Exception e) {
						continue;
					}
					numberCols.put(new Integer(cell.getColumn()), i2);
					colFormat.put(new Integer(cell.getColumn()),
							cell.getCellFormat());
				} else if (contents.equals(MERGE)) {
					mergeCol.add(new Integer(j));
				} else if (contents.startsWith("#$") && contents.endsWith("#")) {
					// redirection
					int k = contents.length();
					String str = contents.substring(2, k - 1);
					try {
						arrayCol.put(new Integer(cell.getColumn()),
								new Integer(str));
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (contents.equalsIgnoreCase(DOWN_NULL_MERGE)) {
					downNullMergeCol.add(new Integer(j));
				} else if (contents.equals(END)) {
					endCol = cell.getColumn();
				}
			}
	}

	/**
	 * 
	 * @param row
	 * @param column
	 * @param contents
	 * @param sign
	 *            AUTO-数字或文本自适应 TEXT-文本 NUMBER-数字
	 * @return
	 * @throws ExcelException
	 */
	private SimpleWorkbook add(int row, int column, String contents, String sign)
			throws ExcelException {
		WritableSheet sheet = (WritableSheet) workbook.getSheet(0);
		Cell oldCell = sheet.getCell(column, row);
		CellFormat format = getFormat(oldCell);

		try {
			if ((sign.equals("AUTO") || sign.equals("NUMBER"))
					&& isNumber(oldCell)) {
				if (contents == null || contents.equals("")
						|| contents.trim().equals("")) {
					contents = "0";
				}
				WritableCellFormat wcf = getNumberFormat(oldCell);
				Number number = new Number(column, row, new Double(
						contents.toString()).doubleValue(), wcf);
				sheet.addCell(number);

			} else if (sign.equals("DEFAULT1") && isNumber(oldCell)) {
				if (contents == null || contents.equals("")
						|| contents.trim().equals("")) {
					contents = "0";
				}
				WritableCellFormat wcf = (WritableCellFormat) default1Format;
				Number number = new Number(column, row, new Double(
						contents.toString()).doubleValue(), wcf);
				sheet.addCell(number);
			} else {
				if (sign.equals("DEFAULT1")) {
					Label label = new Label(column, row, contents,
							default1Format);
					sheet.addCell(label);
				} else {
					Label label = new Label(column, row, contents, format);
					sheet.addCell(label);
				}
			}
		} catch (RowsExceededException e1) {
			e1.printStackTrace();
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (WriteException e1) {
			e1.printStackTrace();
		}
		return this;
	}
	
	//copy by mqy
	private SimpleWorkbook add(int row, int column, String contents, String sign, int num)
			throws ExcelException {
		WritableSheet sheet = (WritableSheet) workbook.getSheet(num);
		Cell oldCell = sheet.getCell(column, row);
		CellFormat format = getFormat(oldCell);

		try {
			if ((sign.equals("AUTO") || sign.equals("NUMBER"))
					&& isNumber(oldCell)) {
				if (contents == null || contents.equals("")
						|| contents.trim().equals("")) {
					contents = "0";
				}
				WritableCellFormat wcf = getNumberFormat(oldCell);
				Number number = new Number(column, row, new Double(
						contents.toString()).doubleValue(), wcf);
				sheet.addCell(number);

			} else if (sign.equals("DEFAULT1") && isNumber(oldCell)) {
				if (contents == null || contents.equals("")
						|| contents.trim().equals("")) {
					contents = "0";
				}
				WritableCellFormat wcf = (WritableCellFormat) default1Format;
				Number number = new Number(column, row, new Double(
						contents.toString()).doubleValue(), wcf);
				sheet.addCell(number);
			} else {
				if (sign.equals("DEFAULT1")) {
					Label label = new Label(column, row, contents,
							default1Format);
					sheet.addCell(label);
				} else {
					Label label = new Label(column, row, contents, format);
					sheet.addCell(label);
				}
			}
		} catch (RowsExceededException e1) {
			e1.printStackTrace();
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (WriteException e1) {
			e1.printStackTrace();
		}
		return this;
	}

	private WritableCellFormat getNumberFormat(Cell oldCell) {
		WritableCellFormat wcf = (WritableCellFormat) numberColFormat
				.get(new Integer(oldCell.getColumn()));
		if (wcf == null) {
			if (getFrac(oldCell) == 0) {
				// wcf = new WritableCellFormat(NumberFormats.INTEGER);
				wcf = new WritableCellFormat(new NumberFormat("0"));
			} else if (getFrac(oldCell) == -1) {
				wcf = new WritableCellFormat();
			} else {
				StringBuffer sb = new StringBuffer("0.");
				for (int i = 0; i < getFrac(oldCell); i++) {
					sb.append("0");
				}
				NumberFormat nf = new NumberFormat(sb.toString());
				wcf = new WritableCellFormat(nf);
			}

			CellFormat format = (CellFormat) colFormat.get(new Integer(oldCell
					.getColumn()));
			if (format == null) {
				format = bothFormat;
			}
			copy(format, wcf);
			// copy(bothFormat, wcf);
			numberColFormat.put(new Integer(oldCell.getColumn()), wcf);
		}
		return wcf;
	}

	private Integer redirect(int col) {
		return (Integer) arrayCol.get(new Integer(col));
	}

	public void add(String[][] data) {
		size = data.length;
		int col = startCol;
		int colt = startCol;
		int row = startRow;

		for (int i = 0; i < size; i++) {
			String[] strArr = data[i];
			for (int j = 0; j < strArr.length; j++) {
				Integer colTmp = redirect(col);
				try {
					String Content = "";
					if (colTmp != null) {
						Content = strArr[colTmp.intValue()];
					} else {
						Content = strArr[j];
					}
					add(row, col, Content, "AUTO");
					// add_z(row, col, Content, "AUTO");

				} catch (Exception e) {
					e.printStackTrace();
				}
				col++;
				if (col >= (strArr.length + colt))
					col = colt;
				if (col == endCol) {
					col = colt;
					break;
				}
			}
			row++;
		}
		clearSign();
		merge();
		try {
			write();
			close();
		} catch (ExcelException e) {
			e.printStackTrace();
		}
	}
	//copy by mqy
	public void add(ArrayList<String [][]> list) {
		System.out.println("here add======");
		if(list.size() == 0){
			System.out.println("list.size()======"+list.size());
			return;
		}
		for(int k=0; k<list.size(); k++){
			String[][] data = list.get(k);
			System.out.println("list.get(k)======"+k);
			size = data.length;
			int col = startCol;
			int colt = startCol;
			int row = startRow;

			for (int i = 0; i < size; i++) {
				String[] strArr = data[i];
				for (int j = 0; j < strArr.length; j++) {
					Integer colTmp = redirect(col);
					try {
						String Content = "";
						if (colTmp != null) {
							Content = strArr[colTmp.intValue()];
						} else {
							Content = strArr[j];
						}
						add(row, col, Content, "AUTO", k);
						// add_z(row, col, Content, "AUTO");

					} catch (Exception e) {
						e.printStackTrace();
					}
					col++;
					if (col >= (strArr.length + colt))
						col = colt;
					if (col == endCol) {
						col = colt;
						break;
					}
				}
				row++;
			}
			clearSign(k);
			merge(k);
			
		}
		try {
			write();
			close();
		} catch (ExcelException e) {
			e.printStackTrace();
		}
		
	}

	public void add(SSRS data) {
		add(data.getAllData());
	}

	public void add(ListTable listTable) {

		this.addTrail(listTable.size() + this.startRow + 1);

		size = listTable.size();
		int col = startCol;
		int colt = startCol;
		int row = startRow;

		for (int i = 0; i < listTable.size(); i++) {
			String[] strArr = listTable.get(i);
			for (int j = 0; j < strArr.length; j++) {
				Integer colTmp = redirect(col);
				try {
					// if (colTmp != null) {
					// add(row, col, strArr[colTmp.intValue()], "AUTO");
					// } else {
					// add(row, col, strArr[j], "AUTO");
					// }
					String Content = "";
					if (colTmp != null) {
						Content = strArr[colTmp.intValue()];
					} else {
						Content = strArr[j];
					}

					// modified by
					// hanxl,如果内容为空，则仅添加一个只复制了格式的单元格，否则的话就添加包括了内容的单元格
					// if ("".equals(Content)) {
					// Blank b = new Blank(col,row);
					// b.setCellFormat(default1Format);
					// workbook.getSheet(0).addCell(b);
					// }else {
					add(row, col, Content, "AUTO");
					// }
					// modified by zhoull 去掉上述内容为空的处理

				} catch (Exception e) {
					e.printStackTrace();
				}
				col++;
				if (col >= (strArr.length + colt))
					col = colt;
				if (col == endCol) {
					col = colt;
					break;
				}
			}
			row++;
		}
		clearSign();
		merge();
		try {
			write();
			close();
		} catch (ExcelException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加载一个新的方法，控制多个列表的显示 add by zhoull 20091201 for 渠道各类对账单打印使用 其他无特殊情况，慎用此方法
	 */
	public void _addListTable(ListTable listTable) {
		// 获得模板中定义列表名
		String lisName = listTable.getName();
		WritableSheet tSheet = workbook.getSheet(0);
		// 根据列表名定位列表起始位置
		Cell c = tSheet.findCell(lisName);
		size = listTable.size();
		// 起始位置所在列（变量）
		int col = c.getColumn();
		// 起始位置所在列（在此方法中为常量）
		int colt = c.getColumn();
		// 起始位置所在行（变量）
		int row = c.getRow();
		// 起始位置所在行（在此方法中为常量）
		int _row = c.getRow();// 获得定义格式的行，主要用于查询模板中定义的行的每一个单元格的格式
		CellFormat format;// 单元格格式
		this.addTrail(listTable.size() + row + 1);
		int rown = row + 1;
		for (int i = 0; i < listTable.size(); i++) {
			String[] strArr = listTable.get(i);
			if (i > 0) {
				// 根据数据量往文件的sheet中插入新的一行，不带任何格式和内容的空行
				workbook.getSheet(0).insertRow(rown);
				++rown;
			}
			for (int j = 0; j < strArr.length; j++) {
				Integer colTmp = redirect(col);
				// 获得模板定义了格式的行中的单元格
				Cell oldCell = tSheet.getCell(col, _row);
				try {
					// 获得待写入的内容
					String Content = "";
					if (colTmp != null) {
						Content = strArr[colTmp.intValue()];
					} else {
						Content = strArr[j];
					}
					format = oldCell.getCellFormat();// 获得定义格式的行每一个单元格的格式
					// 当待写入的内容为空时，直接按格式写入一个空单元格，以达到前面单元格的内容可以从表象上覆盖空单元格内容的效果
					if ("".equals(Content)) {
						Blank b = new Blank(col, row);
						b.setCellFormat(format);
						tSheet.addCell(b);
					} else {
						// 待写入的内容非空时，按模板定义的单元格格式，写入sheet页中
						Label label = new Label(col, row, Content, format);
						tSheet.addCell(label);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				col++;
				if (col >= (strArr.length + colt))
					col = colt;
				if (col == endCol) {
					col = colt;
					break;
				}
			}
			row++;
		}
	}

	/**
	 * 加载一个新的方法，控制多个列表的显示 add by zhulin
	 */
	public void addListTable(ListTable listTable) {
		// WritableSheet sheet = workbook.getSheet(0);
		// for (int i = 0; i < sheet.getColumns(); i++)
		// for (int j = 0; j < sheet.getRows(); j++) {
		// Cell cell2 = sheet.getCell(i, j);
		// String contents = cell2.getContents().trim();
		//
		// // 开始添加数据的位置
		// if (contents.equals(BOTH)) {
		// startCol = i;
		// startRow = j;
		// }
		// }
		String lisName = listTable.getName();
		Cell c = workbook.getSheet(0).findCell(lisName);

		default1Format = c.getCellFormat();

		// int[] pos = (int[])listTableD.get(lisName);
		size = listTable.size();

		int col = c.getColumn();
		int colt = c.getColumn();
		int row = c.getRow();
		this.addTrail(listTable.size() + row + 1);
		int rown = row + 1;
		for (int i = 0; i < listTable.size(); i++) {
			String[] strArr = listTable.get(i);
			if (i > 0) {
				workbook.getSheet(0).insertRow(rown);
				++rown;
			}
			for (int j = 0; j < strArr.length; j++) {
				Integer colTmp = redirect(col);
				try {
					String Content = "";
					if (colTmp != null) {
						Content = strArr[colTmp.intValue()];
					} else {
						Content = strArr[j];
					}

					// modified by
					// hanxl,如果内容为空，则仅添加一个只复制了格式的单元格，否则的话就添加包括了内容的单元格
					// if ("".equals(Content)) {
					// Blank b = new Blank(col,row);
					// b.setCellFormat(default1Format);
					// workbook.getSheet(0).addCell(b);
					// }else {
					add(row, col, Content, "DEFAULT1");
					// }
					// modified by zhoull 去掉上述内容为空的处理
				} catch (Exception e) {
					e.printStackTrace();
				}
				col++;
				if (col >= (strArr.length + colt))
					col = colt;
				if (col == endCol) {
					col = colt;
					break;
				}
			}
			row++;
		}
		// clearSign();
		// merge();
		// try {
		// write();
		// close();
		// } catch (ExcelException e) {
		// e.printStackTrace();
		// }
	}

	/**
	 * 增加一个控制某个特定区域是否显示的方法。 add by zhoulihong
	 * 
	 * @param lableName
	 *            区域标签名
	 * @param isVisible
	 *            是否显示
	 * @return
	 */
	public boolean setVisible(String lableName, boolean isVisible) {
		String startLable = "<" + lableName + ">";
		String endLable = "</" + lableName + ">";
		System.out.println(startLable + endLable);
		try {
			/* 取标签开始标记对应的单元格 */
			Cell cstart = workbook.getSheet(0).findCell(startLable);
			/* 取标签结束标记对应的单元格 */
			Cell cend = workbook.getSheet(0).findCell(endLable);
			int startPos = cstart.getRow();
			int endPos = cend.getRow();
			int i = startPos;
			/* 第一种实现，删除不需要的 */
			if (isVisible)
				while (i < endPos + 1) {
					workbook.getSheet(0).removeRow(startPos);
					++i;
				}
			else {
				workbook.getSheet(0).removeRow(startPos);
				workbook.getSheet(0).removeRow(endPos - 1);
			}

			/* 第二种实现，隐藏不需要的 */
			// if(isVisible)
			// while(i<endPos+1){
			// workbook.getSheet(0).getRowView(i).setHidden(true);
			// ++ i ;
			// }
			// else{
			// workbook.getSheet(0).getRowView(startPos).setHidden(true);
			// workbook.getSheet(0).getRowView(endPos).setHidden(true);
			// }
		} catch (Exception e) {
			System.out.println("删除多余标记失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void addPageBreak(int rownum) {
		WritableSheet sheet = workbook.getSheet(0);
		sheet.addRowPageBreak(rownum);
	}

	private void addTrail(int trailStartRow) {
		WritableSheet sheet = workbook.getSheet(0);
		int r = sheet.getRows();
		int c = sheet.getColumns();
		Vector cells = new Vector();
		Vector trailRanges = new Vector();
		int startR = 0;
		int trailH = 0;

		// find trail
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				Cell cell = sheet.getCell(j, i);
				String contents = cell.getContents();
				if (contents != null &&  !"".equals(contents.trim())) {
					if (contents.trim().equalsIgnoreCase(TRAIL)) {
						startR = i + 1;
					}
				}
			}
		}

		trailH = sheet.getRows() - startR + 1;

		// copy trail
		if (startR > 0) {
			for (int i2 = startR; i2 <= r; i2++) {
				// Cell[] cell2s = new Cell[c];
				Cell[] cell2s = sheet.getRow(i2);
				cells.add(cell2s);
				Range[] ranges = sheet.getMergedCells();
				for (int range = 0; range < ranges.length; range++) {
					if (ranges[range].getTopLeft().getRow() < startR
							|| ranges[range].getBottomRight().getRow() > r)
						continue;
					trailRanges.add(ranges[range]);
				}
			}

			// add trail
			for (int i3 = 0; i3 < cells.size(); i3++) {
				Cell[] cs = (Cell[]) cells.get(i3);
				for (int j3 = 0; j3 < cs.length; j3++) {
					CellFormat format = cs[j3].getCellFormat();
					Label label = null;
					if (format != null) {
						label = new Label(j3, i3 + trailStartRow,
								cs[j3].getContents(), format);
					} else {
						label = new Label(j3, i3 + trailStartRow,
								cs[j3].getContents());
					}
					try {
						// cs[j3].get
						sheet.addCell(label);
					} catch (RowsExceededException e) {
						e.printStackTrace();
					} catch (WriteException e) {
						e.printStackTrace();
					}
				}
			}

			// merge trail
			for (int t = 0; t < trailRanges.size(); t++) {
				Range range = (Range) trailRanges.get(t);
				Cell topLeft = range.getTopLeft();
				Cell bottomRight = range.getBottomRight();
				int row2 = topLeft.getRow();
				// System.out.println(topLeft.getRow() + trailStartRow + offset
				// + " row" + topLeft.getColumn() + " column ---> "
				// + bottomRight.getRow() + trailStartRow + offset
				// + " row" + bottomRight.getColumn() + " column");
				try {
					sheet.mergeCells(topLeft.getColumn(), topLeft.getRow()
							- startR + trailStartRow, bottomRight.getColumn(),
							bottomRight.getRow() - startR + trailStartRow);
				} catch (RowsExceededException e) {
					e.printStackTrace();
				} catch (WriteException e) {
					e.printStackTrace();
				}
				// System.out.println("topLeft.getRow():" + topLeft.getRow());
				// System.out.println("topLeft.getRow():" + topLeft.getRow());
			}

			// clear old trail

			for (int i4 = 0; i4 <= trailH; i4++) {
				for (int j4 = 0; j4 < trailRanges.size(); j4++) {
					sheet.unmergeCells((Range) trailRanges.get(j4));
				}
			}
		}

	}

	private void merge() {
		contentsMerge();
		downNullMerge();
	}
	//copy by mqy
	private void merge(int num) {
		contentsMerge(num);
		downNullMerge(num);
	}

	private void contentsMerge() {
		WritableSheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		Iterator it = mergeCol.iterator();
		while (it.hasNext()) {
			Integer col = (Integer) it.next();
			Map map = new HashMap();
			String last = null;
			int count = 0;
			for (int i = startRow; i <= rows; i++) {
				Cell cell = sheet.getCell(col.intValue(), i);
				String contents = cell.getContents();
				if (last == null || "".equals(last)) {
					last = contents;
					continue;
				}
				if (contents.equals(last)) {
					count++;
				} else {
					if (count > 0) {
						map.put(new Integer(i - count - 1), new Integer(i - 1));
						count = 0;
					}
					last = contents;
				}
			}
			if (count > 0) {
				map.put(new Integer(rows - count), new Integer(rows));
				count = 0;
			}

			// ------------------------------

			Set set = map.keySet();
			Iterator it2 = set.iterator();
			while (it2.hasNext()) {
				Integer row = (Integer) it2.next();
				Integer row2 = (Integer) map.get(row);
				try {
					sheet.mergeCells(col.intValue(), row.intValue(),
							col.intValue(), row2.intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		// WritableSheet sheet = workbook.getSheet(0);
		// int rows = sheet.getRows();
		// Iterator it = mergeCol.iterator();
		// while (it.hasNext()) {
		// Integer col = (Integer) it.next();
		// String conTmp = null;
		// int rowSTmp = startRow;
		// int rowETmp = startRow;
		// for (int i = startRow; i <= rows; i++) {
		// Cell cell = sheet.getCell(col.intValue(), i);
		// String contents = cell.getContents();
		// if (contents == null || contents == "") {
		// conTmp = null;
		// rowSTmp = i + 1;
		// continue;
		// }
		// if (conTmp == null) {
		// conTmp = contents;
		// } else {
		// if (contents.equals(conTmp)) {
		// rowETmp = i;
		//
		// } else {
		// System.out.println(i + "===" + rows + " contents=" + contents + "
		// conTmp="+ conTmp);
		//
		// if (rowSTmp < rowETmp) {
		// try {
		// sheet.mergeCells(col.intValue(), rowSTmp, col.intValue(), rowETmp);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// rowSTmp = i;
		// conTmp = null;
		// } else {
		// conTmp = contents;
		// }
		// }
		// }
		// }
		// }
	}
	
	//copy by mqy
	private void contentsMerge(int num) {
		System.out.println("contentsMerge=="+num);
		WritableSheet sheet = workbook.getSheet(num);
		int rows = sheet.getRows();
		Iterator it = mergeCol.iterator();
		while (it.hasNext()) {
			Integer col = (Integer) it.next();
			Map map = new HashMap();
			String last = null;
			int count = 0;
			for (int i = startRow; i <= rows; i++) {
				Cell cell = sheet.getCell(col.intValue(), i);
				String contents = cell.getContents();
				if (last == null || "".equals(last)) {
					last = contents;
					continue;
				}
				if (contents.equals(last)) {
					count++;
				} else {
					if (count > 0) {
						map.put(new Integer(i - count - 1), new Integer(i - 1));
						count = 0;
					}
					last = contents;
				}
			}
			if (count > 0) {
				map.put(new Integer(rows - count), new Integer(rows));
				count = 0;
			}

			Set set = map.keySet();
			Iterator it2 = set.iterator();
			while (it2.hasNext()) {
				Integer row = (Integer) it2.next();
				Integer row2 = (Integer) map.get(row);
				try {
					sheet.mergeCells(col.intValue(), row.intValue(),
							col.intValue(), row2.intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	private void downNullMerge() {
		WritableSheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		Iterator it = downNullMergeCol.iterator();
		while (it.hasNext()) {
			Integer col = (Integer) it.next();
			Map map = new HashMap();
			String last = null;
			int count = 0;
			for (int i = startRow; i <= rows; i++) {
				Cell cell = sheet.getCell(col.intValue(), i);
				String contents = cell.getContents();
				if (contents == null || contents.trim().equals("")) {
					count++;
					continue;
				} else {
					if (count > 0 && last != null) {
						map.put(new Integer(i - count - 1), new Integer(i - 1));
						count = 0;
					}
					last = contents;
				}
			}
			if (count > 0) {
				map.put(new Integer(rows - count), new Integer(rows));
				count = 0;
			}

			// ------------------------------

			Set set = map.keySet();
			Iterator it2 = set.iterator();
			while (it2.hasNext()) {
				Integer row = (Integer) it2.next();
				Integer row2 = (Integer) map.get(row);
				try {
					sheet.mergeCells(col.intValue(), row.intValue(),
							col.intValue(), row2.intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	//copy by mqy
	private void downNullMerge(int num) {
		System.out.println("downNullMerge=="+num);
		WritableSheet sheet = workbook.getSheet(num);
		int rows = sheet.getRows();
		Iterator it = downNullMergeCol.iterator();
		while (it.hasNext()) {
			Integer col = (Integer) it.next();
			Map map = new HashMap();
			String last = null;
			int count = 0;
			for (int i = startRow; i <= rows; i++) {
				Cell cell = sheet.getCell(col.intValue(), i);
				String contents = cell.getContents();
				if (contents == null || contents.trim().equals("")) {
					count++;
					continue;
				} else {
					if (count > 0 && last != null) {
						map.put(new Integer(i - count - 1), new Integer(i - 1));
						count = 0;
					}
					last = contents;
				}
			}
			if (count > 0) {
				map.put(new Integer(rows - count), new Integer(rows));
				count = 0;
			}

			// ------------------------------

			Set set = map.keySet();
			Iterator it2 = set.iterator();
			while (it2.hasNext()) {
				Integer row = (Integer) it2.next();
				Integer row2 = (Integer) map.get(row);
				try {
					sheet.mergeCells(col.intValue(), row.intValue(),
							col.intValue(), row2.intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	// add by zhoulihong,在Excel模板中增加条码显示功能
	/**
	 * code 要编码的数据
	 */
	public void setBarCode(String code) {

		WritableSheet sheet = workbook.getSheet(0);
		System.out.println(Code39.transferCode(code));
		BarCode barcode = new BarCode(code);
		barcode.setFormatType(BarCode.FORMAT_JPEG);
		barcode.setTextVisable(false);
		try {
			// barcode.writeToFile("F:\\1.gif");
			System.out.println(barcode.getBytes().length);
			WritableImage wi = sheet.getImage(0);// 取得模板路径的图像
			WritableImage wn = new WritableImage(wi.getX(), wi.getY(),
					wi.getWidth(), wi.getHeight(), barcode.getBytes());
			sheet.addImage(wn);
		} catch (IOException ex) {
			System.out.println("条形码工具BarCode:写文件错误");
		}
	}

	public void set(String name, String value) {
		WritableSheet sheet = workbook.getSheet(0);

		for (int i = 0; i < sheet.getRows(); i++) {
			for (int j = 0; j < sheet.getColumns(); j++) {
				Cell cell2 = sheet.getCell(j, i);
				String cont = cell2.getContents().trim();
				// /////////////////////////////////////////
				if (!contains(cont, name))
					continue;
				cont = replace(cont, name, value);
				// /////////////////////////////////////////
				// if (cont.startsWith("#=")) {
				// String t = cont.substring(2);
				// int t2 = t.indexOf("#");
				// String var = t.substring(0, t2);
				// if (var.equalsIgnoreCase(name)) {
				try {
					this.add(i, j, cont, "TEXT");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//copy by mqy
	public void set(String name, String value, int num) {
		for(int k=0; k<num; k++){
			WritableSheet sheet = workbook.getSheet(k);

			for (int i = 0; i < sheet.getRows(); i++) {
				for (int j = 0; j < sheet.getColumns(); j++) {
					Cell cell2 = sheet.getCell(j, i);
					String cont = cell2.getContents().trim();
					if (!contains(cont, name))
						continue;
					cont = replace(cont, name, value);
					try {
						this.add(i, j, cont, "TEXT", k);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
	

	private static String replace(String str, String name, String value) {
		if (str == null || str.trim().equals(""))
			return "";
		int index = str.indexOf(name);
		if (index == -1)
			return str;

		if (str.substring(index - 2, index).equals("#=")
				&& str.substring(index + name.length()).startsWith("#")) {
			StringBuffer sb = new StringBuffer(str.substring(0, index - 2));
			sb.append(value);
			sb.append(str.substring(index + name.length() + 1));
			return replace(sb.toString(), name, value);
		} else
			return str;
	}

	// private String replace(String cont, String var, String value) {
	// while (contains(cont, var)) {
	// cont = replaceFrist(cont, var, value);
	// }
	// return cont;
	// }

	private void copy(CellFormat format, WritableCellFormat wcf) {
		try {
			// wcf.setShrinkToFit(false);
			wcf.setAlignment(format.getAlignment());
			wcf.setBackground(format.getBackgroundColour(), format.getPattern());
			// System.out.println(format.getB.getDescription();
			wcf.setFont((FontRecord) format.getFont());
			wcf.setOrientation(format.getOrientation());
			// wcf.setBorder(Border.ALL, format.getBorder(Border.ALL));
			wcf.setBorder(Border.TOP, format.getBorder(Border.TOP));
			wcf.setBorder(Border.LEFT, format.getBorder(Border.LEFT));
			// wcf.setBorder(Border.NONE, format.getBorder(Border.NONE));
			wcf.setBorder(Border.RIGHT, format.getBorder(Border.RIGHT));
			wcf.setBorder(Border.BOTTOM, format.getBorder(Border.BOTTOM));
			// wcf.setShrinkToFit(format.get)
			wcf.setVerticalAlignment(format.getVerticalAlignment());
			wcf.setWrap(format.getWrap());
		} catch (WriteException e) {
			e.printStackTrace();
		}

	}

	private int getFrac(Cell oldCell) {
		int column = oldCell.getColumn();
		Integer i = (Integer) numberCols.get(new Integer(column));
		return i.intValue();
	}

	private boolean isNumber(Cell cell) {
		int column = cell.getColumn();
		return numberCols.containsKey(new Integer(column));
	}

	private CellFormat getFormat(Cell cell) {
		CellFormat format = null;
		String contents = cell.getContents();
		if (contents != null && !"".equals(contents)) {
			int s = contents.indexOf("#=");
			if (contents.trim().equals(CELL) || s != -1) {
				format = cell.getCellFormat();
				return format;
			}
		}

		Integer row = new Integer(cell.getRow());
		Integer col = new Integer(cell.getColumn());
		if (rowFormat.containsKey(row)) {
			format = (CellFormat) rowFormat.get(row);
			return format;
		} else if (colFormat.containsKey(col)) {

			format = (CellFormat) colFormat.get(col);
			return format;
		} else if (bothFormat != null) {
			format = bothFormat;
			return format;
		}
		return defaultFormat;
	}

	public void write() throws ExcelException {
		try {
			workbook.write();
		} catch (IOException e) {
			throw new ExcelException(e);
		}
	}

	/**
	 * 如果没有调用add方法，则必须调用该方法
	 * 
	 * @throws ExcelException
	 */
	public void close() throws ExcelException {
		try {
			workbook.close();
		} catch (WriteException e) {
			throw new ExcelException(e);
		} catch (IOException e) {
			throw new ExcelException(e);
		}
	}

	private void clearSign() {
		WritableSheet sheet = workbook.getSheet(0);
		for (int i = 0; i < templetRow; i++) {
			for (int j = 0; j < templetCol; j++) {
				Cell cell2 = sheet.getWritableCell(j, i);
				String contents = cell2.getContents();
				if (isSign(contents)) {
					try {
						Label label = new Label(j, i, "");
						sheet.addCell(label);
						// add(j, i, "", "TEXT");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	//copy by mqy
	private void clearSign(int num) {
		System.out.println("clearSign=="+num);
		WritableSheet sheet = workbook.getSheet(num);
		for (int i = 0; i < templetRow; i++) {
			for (int j = 0; j < templetCol; j++) {
				Cell cell2 = sheet.getWritableCell(j, i);
				String contents = cell2.getContents();
				if (isSign(contents)) {
					try {
						Label label = new Label(j, i, "");
						sheet.addCell(label);
						// add(j, i, "", "TEXT");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private boolean isSign(String str) {
		String cont = str.trim();
		if (cont.startsWith("#")) {
			return true;
		}
		return false;
	}

	private boolean contains(String str, String var) {
		int s = str.indexOf("#=");
		if (s == -1 || s >= str.length() - 2) {
			return false;
		}
		StringBuffer sb = new StringBuffer();
		sb.append(str.substring(0, s));
		// System.out.println("sb start--- " + sb.toString());
		String tmp = str.substring(s + 2);
		// System.out.println("tmp--------" + tmp);
		int e = tmp.indexOf("#");
		if (e == -1) {
			return false;
		}
		String v = tmp.substring(0, e);
		if (v.equalsIgnoreCase(var)) {
			return true;
		}
		return false;
	}

	// private String replaceFrist(String str, String var, String value) {
	// // System.out.println("====================" + str);
	// int s = str.indexOf("#=");
	// if (s == -1 || s >= str.length() - 2) {
	// return str;
	// }
	// StringBuffer sb = new StringBuffer();
	// sb.append(str.substring(0, s));
	// // System.out.println("sb start--- " + sb.toString());
	// String tmp = str.substring(s + 2);
	// // System.out.println("tmp--------" + tmp);
	// int e = tmp.indexOf("#");
	// if (e == -1) {
	// sb.append(tmp);
	// } else {
	// String v = tmp.substring(0, e);
	// if (v.equalsIgnoreCase(var)) {
	// System.out.println("匹配");
	// sb.append(value);
	// sb.append(tmp.substring(e + 1));
	// } else {
	// System.out.println("不匹配");
	// sb.append("#=");
	// sb.append(v);
	// sb.append("#");
	// sb.append(tmp.substring(e + 1));
	// }
	// }
	//
	// return sb.toString();
	// }

	// private static String splitString2(String str, String var, String value)
	// {
	// // System.out.println("====================" + str);
	// int s = str.indexOf("#=");
	// if (s == -1 || s >= str.length() - 2) {
	// System.out.println("god");
	// return str;
	// }
	// StringBuffer sb = new StringBuffer();
	// sb.append(str.substring(0, s));
	// // System.out.println("sb start--- " + sb.toString());
	// String tmp = str.substring(s + 2);
	// // System.out.println("tmp--------" + tmp);
	// int e = tmp.indexOf("#");
	// if (e == -1) {
	// System.out.println("啊");
	// sb.append(tmp);
	// } else {
	// String v = tmp.substring(0, e);
	// if (v.equalsIgnoreCase(var)) {
	// System.out.println("匹配");
	// sb.append(value);
	// sb.append(tmp.substring(e + 1));
	// } else {
	// System.out.println("不匹配");
	// sb.append("#=");
	// sb.append(v);
	// sb.append("#");
	// sb.append(tmp.substring(e + 1));
	// }
	// if (e < tmp.length() - 1)
	// splitString2(tmp.substring(e + 1), var, value);
	// }
	//
	// return sb.toString();
	// }

	/**
	 * 向指定单元格中写入指定内容，该方法会直接覆盖指定单元格中的内容
	 * 
	 * @param rowIndex
	 *            　行号
	 * @param colIndex
	 *            　列号
	 * @param Content
	 *            　 内容
	 * @author hanxl 2009年5月15日 15时12分07秒
	 */
	public void setCellContent(int rowIndex, int colIndex, String Content) {
		try {
			workbook.getSheet(0).insertRow(rowIndex);
			Label cell = new Label(colIndex, rowIndex, Content);
			WritableCellFormat cellFormat = new WritableCellFormat();
			cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			cellFormat.setWrap(true);
			cellFormat.setShrinkToFit(true);
			cell.setCellFormat(cellFormat);
			workbook.getSheet(0).addCell(cell);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 当指定标签所在的行内容为空时，删除该标签所在的行
	 * 
	 * @param Label
	 *            标签
	 * @author hanxl 2009年6月30日 15时12分17秒
	 */
	public void removeRow(String Label) {
		WritableSheet sheet = workbook.getSheet(0);
		for (int i = 0; i < sheet.getRows(); i++) {
			for (int j = 0; j < sheet.getColumns(); j++) {
				Cell cell2 = sheet.getCell(j, i);
				String cont = cell2.getContents().trim();
				if (!contains(cont, Label))
					continue;
				else {
					sheet.removeRow(i);
					break;
				}
			}
		}
	}

	/**
	 * 向指定行中插入内容 写入之后的格式默认为　固定边框、边框宽度为1px、字体大小为10px
	 * 
	 * @param rowIndex
	 *            　行号
	 * @param Content
	 *            　 内容
	 * @author hanxl 2009年5月15日 15时12分17秒
	 */
	public void setRowContent(int rowIndex, String Content[]) {
		try {
			workbook.getSheet(0).insertRow(rowIndex);
			int ArraySize = Content.length;
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 9,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE); // 粗体10号字
			WritableCellFormat cellFormat = new WritableCellFormat(wf);
			cellFormat.setWrap(true);
			cellFormat.setShrinkToFit(true);
			cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			for (int j = 0; j < ArraySize; j++) {
				Label cell = new Label(j, rowIndex, Content[j]);
				cell.setCellFormat(cellFormat);
				workbook.getSheet(0).addCell(cell);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 向指定行中插入内容，设定该行中单元格的格式
	 * 
	 * @param rowIndex
	 *            　行号
	 * @param Content
	 *            []　该行中的列数据的数组
	 * @param cellFromat
	 *            该单元格的样式
	 * @author hanxl 2009年5月15日 15时12分17秒
	 */
	public void setRowContent(int rowIndex, String Content[],
			WritableCellFormat cellFormat) {
		try {
			workbook.getSheet(0).insertRow(rowIndex);
			int ArraySize = Content.length;
			for (int j = 0; j < ArraySize; j++) {
				Label cell = new Label(j, rowIndex, Content[j]);
				cell.setCellFormat(cellFormat);
				workbook.getSheet(0).addCell(cell);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 设置多个 格式为 #=XXXX#的值
	 */
	public void setContents(List<ExcelTransferParam> contents) {
		for (ExcelTransferParam tEntry : contents) {
			this.set(tEntry.getContentKey(), tEntry.getContentValue());
		}
	}

	/**
	 * 生成ListTable
	 * 
	 * @param tListTableName
	 *            listtable的标识位置
	 * @param sql
	 *            生成ListTable数据的SQL语句
	 * @param column_num
	 *            列数包括序号列 及SQL查询列数加1
	 * @return ListTable
	 * @throws Exception
	 */
	public ListTable genListTable(String tListTableName, String sql,
			int column_num) throws Exception {
		ListTable tListTable = new ListTable();
		tListTable.setName(tListTableName);
		SSRS tSSRS = new SSRS();
		ExeSQL tExeSQL = new ExeSQL();
		tSSRS = tExeSQL.execSQL(sql);
		for (int i = 1; i <= tSSRS.getMaxRow(); i++) {
			String[] strArr = new String[column_num];
			strArr[0] = i + "";
			for (int j = 1; j < column_num; j++) {
				strArr[j] = tSSRS.GetText(i, j);
			}
			tListTable.add(strArr);
		}
		return tListTable;
	}

	// =========================================================================================//
	// 新增加方法,使用前要注意
	// 说明:此方法主要用于处理带浮点数的报表
	public void _addListTable_zy(ListTable listTable,
			Map<String, String> tableMap) {
		// 获得模板中定义列表名
		String lisName = listTable.getName();
		WritableSheet tSheet = workbook.getSheet(0);
		// 根据列表名定位列表起始位置
		Cell c = tSheet.findCell(lisName);
		size = listTable.size();
		// 起始位置所在列（变量）
		int col = c.getColumn();
		// 起始位置所在列（在此方法中为常量）
		int colt = c.getColumn();
		// 起始位置所在行（变量）
		int row = c.getRow();
		// 起始位置所在行（在此方法中为常量）
		int _row = c.getRow();// 获得定义格式的行，主要用于查询模板中定义的行的每一个单元格的格式
		CellFormat format;// 单元格格式
		this.addTrail(listTable.size() + row + 1);
		int rown = row + 1;
		for (int i = 0; i < listTable.size(); i++) {
			String[] strArr = listTable.get(i);
			if (i > 0) {
				// 根据数据量往文件的sheet中插入新的一行，不带任何格式和内容的空行
				workbook.getSheet(0).insertRow(rown);
				++rown;
			}
			for (int j = 0; j < strArr.length; j++) {
				Integer colTmp = redirect(col);
				// 获得模板定义了格式的行中的单元格
				Cell oldCell = tSheet.getCell(col, _row);
				try {
					// 获得待写入的内容
					String Content = "";
					if (colTmp != null) {
						Content = strArr[colTmp.intValue()];
					} else {
						Content = strArr[j];
					}
					format = oldCell.getCellFormat();// 获得定义格式的行每一个单元格的格式
					// 当待写入的内容为空时，直接按格式写入一个空单元格，以达到前面单元格的内容可以从表象上覆盖空单元格内容的效果
					if (" ".equals(Content) || "".equals(Content)) {
						Blank b = new Blank(col, row);
						b.setCellFormat(format);
						tSheet.addCell(b);
					} else if ("Total:".equals(Content)) {
						WritableFont itxxz_table = new WritableFont(
								WritableFont.createFont("Calibri"), 10,
								WritableFont.NO_BOLD, false,
								UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
						WritableCellFormat perFormat = new WritableCellFormat(
								itxxz_table, NumberFormats.PERCENT_FLOAT);
						perFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
						perFormat.setAlignment(Alignment.RIGHT);
						perFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
						Label label = new Label(col, row, Content, perFormat);
						tSheet.addCell(label);
					} else {
						// 待写入的内容非空时，按模板定义的单元格格式，写入sheet页中
						// 需要动态的判断下数据是否为数值,如果是数值,写成数值格式
						// 用正则表达式判断是否为有效数值,如果是有效整数就转换为数值
						String DataFlag = tableMap.get(j + "");
						Label label = new Label(col, row, Content, format);
						jxl.write.Number cNumber = null;
						if ("TEXT".equals(DataFlag)) {
							// 用Lable类型存入
							tSheet.addCell(label);
						} else if (DataFlag.startsWith("FN")) {
							// 说明是浮点数;这里的浮点数指的是可以有至少0个小数为的数值
							// 截取FN后面的字符数值,动态判断浮点的位数
							int fValue = Integer
									.parseInt(DataFlag.substring(2));
							// 浮点数格式
							String floatFormat = "#";
							for (int k = 0; k < fValue; k++) {
								// 每循环一次就多一位浮点数
								if (k == 0) {
									floatFormat = floatFormat + ".#";
								}
								if (k >= 1) {
									floatFormat = floatFormat + "#";
								}
							}
							// 把数值转换为浮点数
							// 动态处理浮点数的格式
							DecimalFormat df = new DecimalFormat(floatFormat);
							cNumber = new jxl.write.Number(col,row,Double.parseDouble(df.format(Double.parseDouble(Content)).trim()),format);
							tSheet.addCell(cNumber);
						} else if ("PERCENT".equals(DataFlag)) {
							// 说明存入的是百分比
							WritableFont itxxz_table = new WritableFont(
									WritableFont.createFont("Calibri"), 10,
									WritableFont.NO_BOLD, false,
									UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
							WritableCellFormat perFormat = new WritableCellFormat(itxxz_table, NumberFormats.PERCENT_FLOAT);
							perFormat.setBorder(Border.ALL,BorderLineStyle.THIN);
							perFormat.setAlignment(Alignment.RIGHT);
							perFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
							Number preNum = new Number(col, row,Double.parseDouble(Content.substring(0,Content.length() - 1)), perFormat);
							tSheet.addCell(preNum);
						} else {
							// 说明是其他类型用Lable类型写入
							tSheet.addCell(label);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				col++;
				if (col >= (strArr.length + colt))
					col = colt;
				if (col == endCol) {
					col = colt;
					break;
				}
			}
			row++;
		}
	}

	// ================自定义报表使用==================
	public void _addListTable_zr(ListTable listTable) {
		// 获得模板中定义列表名
		String lisName = listTable.getName();
		WritableSheet tSheet = workbook.getSheet(0);
		// 根据列表名定位列表起始位置
		Cell c = tSheet.findCell(lisName);
		size = listTable.size();
		// 起始位置所在列（变量）
		int col = c.getColumn();
		// 起始位置所在列（在此方法中为常量）
		int colt = c.getColumn();
		// 起始位置所在行（变量）
		int row = c.getRow();
		// 起始位置所在行（在此方法中为常量）
		int _row = c.getRow();// 获得定义格式的行，主要用于查询模板中定义的行的每一个单元格的格式
		CellFormat format;// 单元格格式
		this.addTrail(listTable.size() + row + 1);
		int rown = row + 1;
		for (int i = 0; i < listTable.size(); i++) {
			String[] strArr = listTable.get(i);
			if (i > 0) {
				// 根据数据量往文件的sheet中插入新的一行，不带任何格式和内容的空行
				workbook.getSheet(0).insertRow(rown);
				++rown;
			}
			for (int j = 0; j < strArr.length; j++) {
				Integer colTmp = redirect(col);
				// 获得模板定义了格式的行中的单元格
				Cell oldCell = tSheet.getCell(col, _row);
				try {
					// 获得待写入的内容
					String Content = "";
					if (colTmp != null) {
						Content = strArr[colTmp.intValue()];
					} else {
						Content = strArr[j];
					}
					int len = 0;
					// 自动判断报表列标题宽度
					if (i == 0) {
						if (0 < Content.length() && Content.length() <= 15) {
							// 0 - 15
							len = 16;
						} else if (15 < Content.length()&& Content.length() <= 20) {
							// 15 - 20
							len = 20;
						} else if (20 < Content.length() && Content.length() <= 25) {
							// 20 - 25
							len = 26;
						} else if (25 < Content.length() && Content.length() <= 30) {
							// 25 - 30
							len = 32;
						} else if (30 < Content.length() && Content.length() <= 35) {
							// 30 - 35
							len = 35;
						} else if (35 < Content.length() && Content.length() <= 40) {
							// 35 - 40
							len = 43;
						} else {
							// 其他
							len = 50;
						}
						// 设置列宽
						len = 18;
						tSheet.setColumnView(j, len);
						if(Content.length() >= 24 ){
							tSheet.setRowView(0, 650);
						}
					}
					// 获得定义格式的行每一个单元格的格式
					format = oldCell.getCellFormat();
					// ==============================
					WritableFont font1 = new WritableFont(
							WritableFont.createFont("Calibri"), 11,
							WritableFont.BOLD, false,
							UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
					WritableCellFormat cellFormat1 = new WritableCellFormat(font1);
					// cellFormat1.setBackground(Colour.ICE_BLUE);
					// 设置边框;
					cellFormat1.setBorder(Border.ALL, BorderLineStyle.THIN);
					// 设置自动换行;
					cellFormat1.setWrap(true);
					// 设置文字居中对齐方式;
					cellFormat1.setAlignment(Alignment.CENTRE);
					// 设置垂直居中;
					cellFormat1.setVerticalAlignment(VerticalAlignment.CENTRE);
					// =============================
					WritableFont font2 = new WritableFont(
							WritableFont.createFont("Calibri"), 10,
							WritableFont.NO_BOLD, false,
							UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
					WritableCellFormat cellFormat2 = new WritableCellFormat(font2);
					// 设置数值格式
					NumberFormat doubleFormat=new NumberFormat("0.00");
					WritableCellFormat cellFormat3 = new WritableCellFormat(font2,doubleFormat);
					// 设置边框;
					cellFormat2.setBorder(Border.ALL, BorderLineStyle.THIN);
					cellFormat3.setBorder(Border.ALL, BorderLineStyle.THIN);
					// 设置自动换行;
					cellFormat2.setWrap(true);
					// 设置文字居中对齐方式;
					// 对内容进行判断
					if(Content.endsWith("L")){
						cellFormat2.setAlignment(Alignment.LEFT);
					}else if(Content.endsWith("C")){
						cellFormat2.setAlignment(Alignment.CENTRE);
					}else if(Content.endsWith("R")){
						cellFormat2.setAlignment(Alignment.RIGHT);
					}else{
						cellFormat2.setAlignment(Alignment.CENTRE);
					}
					// 设置垂直居中;
					cellFormat2.setVerticalAlignment(VerticalAlignment.CENTRE);
					// 当待写入的内容为空时，直接按格式写入一个空单元格，以达到前面单元格的内容可以从表象上覆盖空单元格内容的效果
					if (" ".equals(Content) || "".equals(Content)) {
						Blank b = new Blank(col, row);
						b.setCellFormat(format);
						if (i == 0) {
							b.setCellFormat(cellFormat1);
						} else {
							b.setCellFormat(cellFormat2);
						}
						tSheet.addCell(b);
					} else {
						// 待写入的内容非空时，按模板定义的单元格格式，写入sheet页中
						// Label label = new Label(col, row, Content, format);
						Label label = null;
						jxl.write.Number cNumber = null;
						if (i == 0) {
							label = new Label(col, row, Content, cellFormat1);
							tSheet.addCell(label);
						} else {
							// 根据不同类型进行写入
							if(Content.endsWith("R")){
								if("R".equals(Content)){
									Content = "0.00R";
								}
								DecimalFormat df = new DecimalFormat("#.##");
								Content = Content.substring(0, Content.length() - 1);
								cNumber = new jxl.write.Number(col,row,Double.parseDouble(df.format(Double.parseDouble(Content)).trim()),cellFormat3);
								tSheet.addCell(cNumber);
							}else{
								Content = Content.substring(0, Content.length() - 1);
								label = new Label(col, row, Content, cellFormat2);
								tSheet.addCell(label);
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				col++;
				if (col >= (strArr.length + colt))
					col = colt;
				if (col == endCol) {
					col = colt;
					break;
				}
			}
			row++;
		}
	}

	// ===========特殊处理使用,一般不建议使用==============
	// 下面的两个方法是做特殊处理使用的,一般不建议使用
	public void add_z(String[][] data) {
		size = data.length;
		int col = startCol;
		int colt = startCol;
		int row = startRow;

		for (int i = 0; i < size; i++) {
			String[] strArr = data[i];
			for (int j = 0; j < strArr.length; j++) {
				Integer colTmp = redirect(col);
				try {
					String Content = "";
					if (colTmp != null) {
						Content = strArr[colTmp.intValue()];
					} else {
						Content = strArr[j];
					}
					// add(row, col, Content, "AUTO");
					add_z(row, col, Content, "AUTO");

				} catch (Exception e) {
					e.printStackTrace();
				}
				col++;
				if (col >= (strArr.length + colt))
					col = colt;
				if (col == endCol) {
					col = colt;
					break;
				}
			}
			row++;
		}
		clearSign();
		merge();
		try {
			write();
			close();
		} catch (ExcelException e) {
			e.printStackTrace();
		}
	}

	// Modify By 2015-03-20
	private SimpleWorkbook add_z(int row, int column, String contents,
			String sign) throws ExcelException {
		WritableSheet sheet = (WritableSheet) workbook.getSheet(0);
		Cell oldCell = sheet.getCell(column, row);
		CellFormat format = getFormat(oldCell);

		try {
			// 特殊处理,报表写入百分数
			if (contents.endsWith("P")
					&& PubFun.isNumeric(contents.substring(0,
							contents.length() - 1))) {
				WritableFont itxxz_table = new WritableFont(
						WritableFont.createFont("Calibri"), 10,
						WritableFont.NO_BOLD, false,
						UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
				WritableCellFormat perFormat = new WritableCellFormat(
						itxxz_table, NumberFormats.PERCENT_FLOAT);
				perFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
				perFormat.setAlignment(Alignment.RIGHT);
				perFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
				Number preNum = new Number(column, row,
						Double.parseDouble(contents.substring(0,
								contents.length() - 1)), perFormat);
				sheet.addCell(preNum);
			} else if("Total:".equals(contents)){
				WritableFont itxxz_table = new WritableFont(
						WritableFont.createFont("Calibri"), 10,
						WritableFont.NO_BOLD, false,
						UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
				WritableCellFormat perFormat = new WritableCellFormat(
						itxxz_table);
				perFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
				perFormat.setAlignment(Alignment.RIGHT);
				perFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
				Label label = new Label(column, row, contents, perFormat);
				sheet.addCell(label);
			} else {
				if ((sign.equals("AUTO") || sign.equals("NUMBER"))
						&& isNumber(oldCell)) {
					if (contents == null || "".equals(contents)
							|| "".trim().equals(contents)) {
						contents = " ";
						Label label = new Label(column, row, contents, format);
						sheet.addCell(label);
					}else{
						WritableCellFormat wcf = getNumberFormat(oldCell);
						Number number = new Number(column, row, new Double(
								contents.toString()).doubleValue(), wcf);
						sheet.addCell(number);
					}
				} else if (sign.equals("DEFAULT1") && isNumber(oldCell)) {
					if (contents == null || contents.equals("")
							|| contents.trim().equals("")) {
						contents = "0";
					}
					WritableCellFormat wcf = (WritableCellFormat) default1Format;
					Number number = new Number(column, row, new Double(
							contents.toString()).doubleValue(), wcf);
					sheet.addCell(number);
				} else {
					if (sign.equals("DEFAULT1")) {
						Label label = new Label(column, row, contents,
								default1Format);
						sheet.addCell(label);
					} else {
						Label label = new Label(column, row, contents, format);
						sheet.addCell(label);
					}
				}
			}
		} catch (RowsExceededException e1) {
			e1.printStackTrace();
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (WriteException e1) {
			e1.printStackTrace();
		}
		return this;
	}

	// =================代理人机构报表使用AgencyHieracyReport=================
	public void _addListTable_AHR(ListTable listTable) {
		// 获得模板中定义列表名
		String lisName = listTable.getName();
		WritableSheet tSheet = workbook.getSheet(0);
		// 根据列表名定位列表起始位置
		Cell c = tSheet.findCell(lisName);
		size = listTable.size();
		// 起始位置所在列（变量）
		int col = c.getColumn();
		// 起始位置所在列（在此方法中为常量）
		int colt = c.getColumn();
		// 起始位置所在行（变量）
		int row = c.getRow();
		// 起始位置所在行（在此方法中为常量）
		int _row = c.getRow();// 获得定义格式的行，主要用于查询模板中定义的行的每一个单元格的格式
		CellFormat format;// 单元格格式
		this.addTrail(listTable.size() + row + 1);
		int rown = row + 1;
		for (int i = 0; i < listTable.size(); i++) {
			String[] strArr = listTable.get(i);
			if (i > 0) {
				// 根据数据量往文件的sheet中插入新的一行，不带任何格式和内容的空行
				workbook.getSheet(0).insertRow(rown);
				++rown;
			}
			for (int j = 0; j < strArr.length; j++) {
				Integer colTmp = redirect(col);
				// 获得模板定义了格式的行中的单元格
				Cell oldCell = tSheet.getCell(col, _row);
				try {
					// 获得待写入的内容
					String Content = "";
					if (colTmp != null) {
						Content = strArr[colTmp.intValue()];
					} else {
						Content = strArr[j];
					}
					int len = 21;
					tSheet.setColumnView(j, len);
					// 获得定义格式的行每一个单元格的格式
					format = oldCell.getCellFormat();
					// ==============================
					WritableFont font1 = new WritableFont(
							WritableFont.createFont("Calibri"), 11,
							WritableFont.BOLD, false,
							UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
					WritableCellFormat cellFormat1 = new WritableCellFormat(font1);
					// cellFormat1.setBackground(Colour.ICE_BLUE);
					// 设置边框;
					cellFormat1.setBorder(Border.ALL, BorderLineStyle.THIN);
					// 设置自动换行;
					cellFormat1.setWrap(true);
					// 设置文字居中对齐方式;
					cellFormat1.setAlignment(Alignment.CENTRE);
					// 设置垂直居中;
					cellFormat1.setVerticalAlignment(VerticalAlignment.CENTRE);
					// =============================
					WritableFont font2 = new WritableFont(
							WritableFont.createFont("Calibri"), 10,
							WritableFont.NO_BOLD, false,
							UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
					WritableCellFormat cellFormat2 = new WritableCellFormat(font2);
					// 设置边框;
					cellFormat2.setBorder(Border.ALL, BorderLineStyle.THIN);
					// 设置自动换行;
					cellFormat2.setWrap(true);
					// 设置文字居中对齐方式;
					// 需要根据文本内容进行判断
					if(Content.startsWith("LEFTAPUS")){
						cellFormat2.setAlignment(Alignment.LEFT);
						Content = Content.replace("LEFTAPUS", "");
					}else{
						cellFormat2.setAlignment(Alignment.CENTRE);
					}
					
					// 设置垂直居中;
					cellFormat2.setVerticalAlignment(VerticalAlignment.CENTRE);
					// 当待写入的内容为空时，直接按格式写入一个空单元格，以达到前面单元格的内容可以从表象上覆盖空单元格内容的效果
					if (" ".equals(Content) || "".equals(Content)) {
						Blank b = new Blank(col, row);
						b.setCellFormat(format);
						if (i == 0) {
							b.setCellFormat(cellFormat1);
						} else {
							b.setCellFormat(cellFormat2);
						}
						tSheet.addCell(b);
					} else {
						// 待写入的内容非空时，按模板定义的单元格格式，写入sheet页中
						// Label label = new Label(col, row, Content, format);
						Label label = null;
						if (Content.startsWith("APUS")) {
							if (Content.substring(4, Content.length()).length() == 0 || "".equals(Content.substring(4,Content.length()).trim())) {
								label = new Label(col, row, Content.substring(4, Content.length()), cellFormat2);
							} else {
								label = new Label(col, row, Content.substring(4, Content.length()), cellFormat1);
							}
						} else {
							label = new Label(col, row, Content, cellFormat2);
						}
						tSheet.addCell(label);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				col++;
				if (col >= (strArr.length + colt))
					col = colt;
				if (col == endCol) {
					col = colt;
					break;
				}
			}
			row++;
		}
	}

	// ===============该方法用于处理生成5个sheet的特殊方法使用,一般不建议使用,该方法不具有共性===================
	/*
	 * 生成薪金报表按钮操作处理类
	 * 
	 * @params listTable 传入的数据
	 * 
	 * @params SheetOrder 需要写入的是第几个sheet(从0开始)
	 */
	public void _addListTable_Compensation(ListTable listTable, int SheetOrder,
			String InsertFlag, Map<String, String> tableMap) {
		// 获得模板中定义列表名
		String lisName = listTable.getName();
		WritableSheet tSheet = null;
		// 判断SheetOrder分别依次处理
		if (SheetOrder == 0) {
			// 第1个sheet
			tSheet = workbook.getSheet(0);
		} else if (SheetOrder == 1) {
			// 第2个sheet
			tSheet = workbook.getSheet(1);
		} else if (SheetOrder == 2) {
			// 第2个sheet
			tSheet = workbook.getSheet(2);
		} else if (SheetOrder == 3) {
			// 第4个sheet
			tSheet = workbook.getSheet(3);
		} else if (SheetOrder == 4) {
			// 第5个sheet
			tSheet = workbook.getSheet(4);
		}
		// 根据列表名定位列表起始位置
		Cell c = tSheet.findCell(lisName);
		size = listTable.size();
		// 起始位置所在列（变量）
		int col = c.getColumn();
		// 起始位置所在列（在此方法中为常量）
		int colt = c.getColumn();
		// 起始位置所在行（变量）
		int row = c.getRow();
		int rowBak = row;
		// 起始位置所在行（在此方法中为常量）
		int _row = c.getRow();// 获得定义格式的行，主要用于查询模板中定义的行的每一个单元格的格式
		CellFormat format;// 单元格格式
		this.addTrail_Compensation(listTable.size() + row + 1, SheetOrder);
		int rown = row + 1;
		for (int i = 0; i < listTable.size(); i++) {
			String[] strArr = listTable.get(i);
			if (i > 0) {
				// 根据数据量往文件的sheet中插入新的一行，不带任何格式和内容的空行
				// 插入一行有时候不需要,因此这个方法传递进来一个参数用来判断控制,当不需要的时候就不插入
				if ("Y".equals(InsertFlag)) {
					workbook.getSheet(SheetOrder).insertRow(rown);
					++rown;
				}
			}
			for (int j = 0; j < strArr.length; j++) {
				Integer colTmp = redirect(col);
				// 获得模板定义了格式的行中的单元格
				Cell oldCell = tSheet.getCell(col, _row);
				try {
					// 获得待写入的内容
					String Content = "";
					if (colTmp != null) {
						Content = strArr[colTmp.intValue()];
					} else {
						Content = strArr[j];
					}
					format = oldCell.getCellFormat();// 获得定义格式的行每一个单元格的格式
					// 当待写入的内容为空时，直接按格式写入一个空单元格，以达到前面单元格的内容可以从表象上覆盖空单元格内容的效果
					if ("NeedDelete".equals(Content)) {
						// 说明需要删除这一部分
						// 注意这个只属于这里使用, 使用前请查看方法说明
						for (int k = 0; k < 6; k++) {
							// 需要连续删除六次
							tSheet.removeRow(rowBak - 2);
						}
						// 结束外层的循环
						strArr = new String[1];
						listTable = new ListTable();
					}else if (" ".equals(Content) || "".equals(Content)) {
						Blank b = new Blank(col, row);
						b.setCellFormat(format);
						tSheet.addCell(b);
					} else if ("Total:".equals(Content)) {
						WritableFont itxxz_table = new WritableFont(
								WritableFont.createFont("Calibri"), 10,
								WritableFont.NO_BOLD, false,
								UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
						WritableCellFormat perFormat = new WritableCellFormat(
								itxxz_table, NumberFormats.PERCENT_FLOAT);
						perFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
						perFormat.setAlignment(Alignment.RIGHT);
						perFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
						Label label = new Label(col, row, Content, perFormat);
						tSheet.addCell(label);
					} else {
						// 待写入的内容非空时，按模板定义的单元格格式，写入sheet页中
						// 需要动态的判断下数据是否为数值,如果是数值,写成数值格式
						// 用正则表达式判断是否为有效数值,如果是有效整数就转换为数值
						String DataFlag = tableMap.get(j + "");
						Label label = new Label(col, row, Content, format);
						jxl.write.Number cNumber = null;
						if ("TEXT".equals(DataFlag)) {
							// 用Lable类型存入
							tSheet.addCell(label);
						} else if (DataFlag.startsWith("FN")) {
							// 说明是浮点数;这里的浮点数指的是可以有至少0个小数为的数值
							// 截取FN后面的字符数值,动态判断浮点的位数
							int fValue = Integer
									.parseInt(DataFlag.substring(2));
							// 浮点数格式
							String floatFormat = "#";
							for (int k = 0; k < fValue; k++) {
								// 每循环一次就多一位浮点数
								if (k == 0) {
									floatFormat = floatFormat + ".#";
								}
								if (k >= 1) {
									floatFormat = floatFormat + "#";
								}
							}
							// 把数值转换为浮点数
							// 动态处理浮点数的格式
							DecimalFormat df = new DecimalFormat(floatFormat);
							cNumber = new jxl.write.Number(
									col,
									row,
									Double.parseDouble(df.format(
											Double.parseDouble(Content)).trim()),
									format);
							tSheet.addCell(cNumber);
						} else if ("PERCENT".equals(DataFlag)) {
							// 说明存入的是百分比
							WritableFont itxxz_table = new WritableFont(
									WritableFont.createFont("Calibri"), 10,
									WritableFont.NO_BOLD, false,
									UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
							WritableCellFormat perFormat = new WritableCellFormat(
									itxxz_table, NumberFormats.PERCENT_FLOAT);
							perFormat.setBorder(Border.ALL,
									BorderLineStyle.THIN);
							perFormat.setAlignment(Alignment.RIGHT);
							perFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
							Number preNum = new Number(col, row,
									Double.parseDouble(Content.substring(0,
											Content.length() - 1)), perFormat);
							tSheet.addCell(preNum);
						} else {
							// 说明是其他类型用Lable类型写入
							tSheet.addCell(label);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				col++;
				if (col >= (strArr.length + colt))
					col = colt;
				if (col == endCol) {
					col = colt;
					break;
				}
			}
			row++;
		}
	}

	/*************************************** Start ********************************************************************/
	// ===============该方法用于处理生成5个sheet的特殊方法使用,一般不建议使用,该方法不具有共性Start===================
	// 和addTrail方法类似, 这里接入了一个参数用于控制要写入的sheet的位数
	private void addTrail_Compensation(int trailStartRow, int SheetOrder) {
		WritableSheet sheet = workbook.getSheet(SheetOrder);
		int r = sheet.getRows();
		int c = sheet.getColumns();
		Vector cells = new Vector();
		Vector trailRanges = new Vector();
		int startR = 0;
		int trailH = 0;

		// find trail
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				Cell cell = sheet.getCell(j, i);
				String contents = cell.getContents();
				if (contents != null &&  !"".equals(contents.trim())) {
					if (contents.trim().equalsIgnoreCase(TRAIL)) {
						startR = i + 1;
					}
				}
			}
		}

		trailH = sheet.getRows() - startR + 1;

		// copy trail
		if (startR > 0) {
			for (int i2 = startR; i2 <= r; i2++) {
				// Cell[] cell2s = new Cell[c];
				Cell[] cell2s = sheet.getRow(i2);
				cells.add(cell2s);
				Range[] ranges = sheet.getMergedCells();
				for (int range = 0; range < ranges.length; range++) {
					if (ranges[range].getTopLeft().getRow() < startR
							|| ranges[range].getBottomRight().getRow() > r)
						continue;
					trailRanges.add(ranges[range]);
				}
			}

			// add trail
			for (int i3 = 0; i3 < cells.size(); i3++) {
				Cell[] cs = (Cell[]) cells.get(i3);
				for (int j3 = 0; j3 < cs.length; j3++) {
					CellFormat format = cs[j3].getCellFormat();
					Label label = null;
					if (format != null) {
						label = new Label(j3, i3 + trailStartRow,
								cs[j3].getContents(), format);
					} else {
						label = new Label(j3, i3 + trailStartRow,
								cs[j3].getContents());
					}
					try {
						// cs[j3].get
						sheet.addCell(label);
					} catch (RowsExceededException e) {
						e.printStackTrace();
					} catch (WriteException e) {
						e.printStackTrace();
					}
				}
			}

			// merge trail
			for (int t = 0; t < trailRanges.size(); t++) {
				Range range = (Range) trailRanges.get(t);
				Cell topLeft = range.getTopLeft();
				Cell bottomRight = range.getBottomRight();
				int row2 = topLeft.getRow();
				// System.out.println(topLeft.getRow() + trailStartRow + offset
				// + " row" + topLeft.getColumn() + " column ---> "
				// + bottomRight.getRow() + trailStartRow + offset
				// + " row" + bottomRight.getColumn() + " column");
				try {
					sheet.mergeCells(topLeft.getColumn(), topLeft.getRow()
							- startR + trailStartRow, bottomRight.getColumn(),
							bottomRight.getRow() - startR + trailStartRow);
				} catch (RowsExceededException e) {
					e.printStackTrace();
				} catch (WriteException e) {
					e.printStackTrace();
				}
				// System.out.println("topLeft.getRow():" + topLeft.getRow());
				// System.out.println("topLeft.getRow():" + topLeft.getRow());
			}

			// clear old trail

			for (int i4 = 0; i4 <= trailH; i4++) {
				for (int j4 = 0; j4 < trailRanges.size(); j4++) {
					sheet.unmergeCells((Range) trailRanges.get(j4));
				}
			}
		}

	}

	// ===============该方法用于处理生成5个sheet的特殊方法使用,一般不建议使用,该方法不具有共性===================
	// 和set方法类似, 这里接入了一个参数用于控制要写入的sheet的位数
	public void set_Compensation(String name, String value, int SheetOrder,
			String Flags) {
		WritableSheet sheet = workbook.getSheet(SheetOrder);

		for (int i = 0; i < sheet.getRows(); i++) {
			for (int j = 0; j < sheet.getColumns(); j++) {
				Cell cell2 = sheet.getCell(j, i);
				String cont = cell2.getContents().trim();
				// /////////////////////////////////////////
				if (!contains(cont, name))
					continue;
				cont = replace(cont, name, value);
				try {
					if (Flags.startsWith("FN")) {
						this.add_Compensation(i, j, cont, Flags, SheetOrder);
					} else {
						this.add_Compensation(i, j, cont, "TEXT", SheetOrder);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	// ===============该方法用于处理生成5个sheet的特殊方法使用,一般不建议使用,该方法不具有共性===================
	// 和add方法类似, 这里接入了一个参数用于控制要写入的sheet的位数
	private SimpleWorkbook add_Compensation(int row, int column,
			String contents, String sign, int SheetOrder) throws ExcelException {
		WritableSheet sheet = (WritableSheet) workbook.getSheet(SheetOrder);
		Cell oldCell = sheet.getCell(column, row);
		CellFormat format = getFormat(oldCell);

		try {
			if ((sign.equals("AUTO") || sign.equals("NUMBER"))
					&& isNumber(oldCell)) {
				if (contents == null || contents.equals("")
						|| contents.trim().equals("")) {
					contents = "0";
				}
				WritableCellFormat wcf = getNumberFormat(oldCell);
				Number number = new Number(column, row, new Double(
						contents.toString()).doubleValue(), wcf);
				sheet.addCell(number);

			} else if (sign.equals("DEFAULT1") && isNumber(oldCell)) {
				if (contents == null || contents.equals("")
						|| contents.trim().equals("")) {
					contents = "0";
				}
				WritableCellFormat wcf = (WritableCellFormat) default1Format;
				Number number = new Number(column, row, new Double(
						contents.toString()).doubleValue(), wcf);
				sheet.addCell(number);
			} else if (sign.startsWith("FN2")) {
				// 新添加方法
				// 说明是浮点数;这里的浮点数指的是可以有至少0个小数为的数值
				// 截取FN后面的字符数值,动态判断浮点的位数
				int fValue = Integer.parseInt(sign.substring(2));
				// 浮点数格式
				String floatFormat = "#";
				for (int k = 0; k < fValue; k++) {
					// 每循环一次就多一位浮点数
					if (k == 0) {
						floatFormat = floatFormat + ".#";
					}
					if (k >= 1) {
						floatFormat = floatFormat + "#";
					}
				}
				// 把数值转换为浮点数
				// 动态处理浮点数的格式
				DecimalFormat df = new DecimalFormat(floatFormat);
				jxl.write.Number cNumber = new jxl.write.Number(column, row,
						Double.parseDouble(df.format(
								Double.parseDouble(contents)).trim()), format);
				sheet.addCell(cNumber);
			} else {
				if (sign.equals("DEFAULT1")) {
					Label label = new Label(column, row, contents,
							default1Format);
					sheet.addCell(label);
				} else {
					Label label = new Label(column, row, contents, format);
					sheet.addCell(label);
				}
			}
		} catch (RowsExceededException e1) {
			e1.printStackTrace();
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (WriteException e1) {
			e1.printStackTrace();
		}
		return this;
	}
	// ===============该方法用于处理生成5个sheet的特殊方法使用,一般不建议使用,该方法不具有共性End===================
	/************************************** End *********************************************************************/
}
