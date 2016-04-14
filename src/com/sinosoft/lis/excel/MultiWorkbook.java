package com.sinosoft.lis.excel;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import jxl.Cell;
import jxl.Range;
import jxl.Workbook;
import jxl.biff.FontRecord;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.CellFormat;
import jxl.format.VerticalAlignment;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.sinosoft.utility.ListTable;
import com.sinosoft.utility.SSRS;

/**
 * 
 * @version 1.0 2008-3-25
 * @author WangWei
 * @author Evan
 * 
 */
public class MultiWorkbook {
	private WritableWorkbook workbook = null;

	private static CellFormat default1Format = null;
	
	private int size = 0;

	private/* static */int sheetNum = 0;

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

	//

	private int templetRow = 0;

	private int templetCol = 0;

	// ---------------------------------------------

	private/* static final */String ROW = "#row#";

	private/* static final */String COL = "#col#";

	private/* static final */String BOTH = "#default#";

	private/* static final */String CELL = "#cell#";

	private/* static final */String MERGE = "#merge#";

	private/* static final */String DOWN_NULL_MERGE = "dmerge";

	private/* static final */String TRAIL = "#trail#";

	private/* static final */String END = "#end#";

	private CellFormat unitCellFormat;

	private int index = 0;

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
	public MultiWorkbook(String resultPath, String templetPath)
			throws ExcelException {

		try {
			workbook = Workbook.createWorkbook(new File(resultPath), Workbook
					.getWorkbook(new File(templetPath)));
		} catch (BiffException e) {
			throw new ExcelException(e);
		} catch (IOException e) {
			throw new ExcelException(e.getMessage());
		}
		// -------------------------------------------------

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
		WritableSheet sheet = workbook.getSheet(sheetNum);
		templetCol = sheet.getColumns();
		templetRow = sheet.getRows();
		for (int i = 0; i < templetRow; i++)
			for (int j = 0; j < templetCol; j++) {
				Cell cell = sheet.getWritableCell(j, i);
				String c = cell.getContents();
				if (c == null && c == "") {
					continue;
				}
				String contents = c.trim();
				// System.out.println("=========contents============:"+contents);
				if (contents == "") {
					continue;
				}
				if (contents.equals(BOTH)) {
					bothFormat = cell.getCellFormat();
					startCol = j;
					startRow = i;
				} else if (contents.equals(ROW)) {
					rowFormat.put(new Integer(cell.getRow()), cell
							.getCellFormat());
				} else if (contents.equals(COL)) {
					colFormat.put(new Integer(cell.getColumn()), cell
							.getCellFormat());
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
					colFormat.put(new Integer(cell.getColumn()), cell
							.getCellFormat());
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
	private MultiWorkbook add(int row, int column, String contents,
			String sign, int size, String bordFlag) throws ExcelException {
		WritableSheet sheet = (WritableSheet) workbook.getSheet(sheetNum);
		Cell oldCell = sheet.getCell(column, row);
		CellFormat format = getFormat(oldCell);
		if (index == 0) {
			if ("#=".equals(bordFlag)) {
				this.unitCellFormat = format;
				this.index = this.index + 1;
			}
		}
		if ("$=".equals(bordFlag)) {
			format = unitCellFormat;
		}

		try {
			if ((sign.equals("AUTO") || sign.equals("NUMBER"))
					&& isNumber(oldCell)) {
				if (contents == null || contents.equals("")
						|| contents.trim().equals("")) {
					contents = "0";
				}
				WritableCellFormat wcf = getNumberFormat(oldCell);
				Number number = new Number(column, row + size, new Double(
						contents.toString()).doubleValue(), wcf);
				sheet.addCell(number);

			} else if (sign.equals("default") && isNumber(oldCell)) {
				if (contents == null || contents.equals("")
						|| contents.trim().equals("")) {
					contents = "0";
				}
				WritableCellFormat wcf = (WritableCellFormat) default1Format;
				Number number = new Number(column, row, new Double(contents
						.toString()).doubleValue(), wcf);
				sheet.addCell(number);
			}else {
				if (sign.equals("DEFAULT1")) {
					Label label = new Label(column, row, contents, default1Format);
					sheet.addCell(label);
				}else{
				Label label = new Label(column, row + size, contents, format);
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

	public void add(String[][] strArr) {
		addTrail(strArr.length + startRow + 1);

		size = strArr.length;
		int col = startCol;
		int colt = startCol;
		int row = startRow;
		for (int i = 0; i < strArr.length; i++) {
			for (int j = 0; j < strArr[i].length; j++) {
				Integer colTmp = redirect(col);
				try {
					if (colTmp != null) {
						add(row, col, strArr[i][colTmp.intValue()], "AUTO", 0,
								"none");
					} else {
						add(row, col, strArr[i][j], "AUTO", 0, "none");
					}
				} catch (ExcelException e) {
					e.printStackTrace();
				}
				col++;
				if (col >= (strArr[i].length + colt))
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

	}

	private Integer redirect(int col) {
		return (Integer) arrayCol.get(new Integer(col));
	}

	public void add(SSRS sSRS) {

		addTrail(sSRS.getMaxRow() + startRow + 1);

		size = sSRS.getMaxRow();
		int col = startCol;
		int colt = startCol;
		int row = startRow;
		for (int i = 0; i < sSRS.getMaxRow(); i++) {
			for (int j = 0; j < sSRS.getMaxCol(); j++) {
				Integer colTmp = redirect(col);
				try {
					if (colTmp != null) {
						add(row, col, sSRS.GetText(i + 1, colTmp.intValue()),
								"AUTO", 0, "none");
					} else {
						add(row, col, sSRS.GetText(i + 1, j + 1), "AUTO", 0,
								"none");
					}
				} catch (ExcelException e) {
					e.printStackTrace();
				}
				col++;
				if (col >= (sSRS.getMaxCol() + colt))
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
					if (colTmp != null) {
						add(row, col, strArr[colTmp.intValue()], "AUTO", 0,
								"none");
					} else {
						add(row, col, strArr[j], "AUTO", 0, "none");
					}

				} catch (ExcelException e) {
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

	}
	
	public void addListTable(ListTable listTable,int sheetnum) {
		
		String lisName = listTable.getName();
		Cell c = workbook.getSheet(sheetnum).findCell(lisName);
		System.out.println(c.getContents().trim());
				
		default1Format = c.getCellFormat();

		int col = c.getColumn();
		int colt = c.getColumn();
		int row = c.getRow();

		this.addTrail(listTable.size() + this.startRow + 1);

		size = listTable.size();
		int rown = row + 1;

		for (int i = 0; i < listTable.size(); i++) {
			String[] strArr = listTable.get(i);
			if (i > 0) {
				workbook.getSheet(sheetnum).insertRow(rown);
				++rown;
			}
			for (int j = 0; j < strArr.length; j++) {
				Integer colTmp = redirect(col);
				try {
					if (colTmp != null) {
						add(row, col, strArr[colTmp.intValue()], "default", 0,
								"none");
					} else {
						add(row, col, strArr[j], "default", 0, "none");
					}

				} catch (ExcelException e) {
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

	}

	private void addTrail(int trailStartRow) {
		WritableSheet sheet = workbook.getSheet(sheetNum);
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
				if (contents != null && contents.trim() != "") {
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
						label = new Label(j3, i3 + trailStartRow, cs[j3]
								.getContents(), format);
					} else {
						label = new Label(j3, i3 + trailStartRow, cs[j3]
								.getContents());
					}
					try {
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
				try {
					sheet.mergeCells(topLeft.getColumn(), topLeft.getRow()
							- startR + trailStartRow, bottomRight.getColumn(),
							bottomRight.getRow() - startR + trailStartRow);
				} catch (RowsExceededException e) {
					e.printStackTrace();
				} catch (WriteException e) {
					e.printStackTrace();
				}
			}

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

	private void contentsMerge() {
		WritableSheet sheet = workbook.getSheet(sheetNum);
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
				if (last == null || last == "") {
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
					sheet.mergeCells(col.intValue(), row.intValue(), col
							.intValue(), row2.intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void downNullMerge() {
		WritableSheet sheet = workbook.getSheet(sheetNum);
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

			Set set = map.keySet();
			Iterator it2 = set.iterator();
			while (it2.hasNext()) {
				Integer row = (Integer) it2.next();
				Integer row2 = (Integer) map.get(row);
				try {
					sheet.mergeCells(col.intValue(), row.intValue(), col
							.intValue(), row2.intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void set(String name, String value) {
		WritableSheet sheet = workbook.getSheet(sheetNum);
		for (int i = 0; i < sheet.getRows(); i++) {
			for (int j = 0; j < sheet.getColumns(); j++) {
				Cell cell2 = sheet.getCell(j, i);
				String cont = cell2.getContents().trim();
				if (!contains(cont, name))
					continue;
				cont = replace(cont, name, value);
				try {
					this.add(i, j, cont, "TEXT", 0, "none");
				} catch (ExcelException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void set(Map map, int size) {
		try {
			Set keys = map.keySet();
			Object[] keyArr = keys.toArray();
			for (int k = 0; k < keyArr.length; k++) {
				String name = (String) keyArr[k];
				String value = (String) map.get(keyArr[k]);
				WritableSheet sheet = workbook.getSheet(sheetNum);
				for (int i = 0; i < sheet.getRows(); i++) {
					for (int j = 0; j < sheet.getColumns(); j++) {
						Cell cell2 = sheet.getCell(j, i);
						String cont = cell2.getContents().trim();
						if (cont.contains("#=")) {
							if (!contains(cont, name)) {
								continue;
							}
							cont = replace(cont, name, value);
							this.add(i, j, cont, "TEXT", 0, "#=");
						} else if (cont.contains("$=")) {
							if (!contains(cont, name, "$=")) {
								continue;
							}
							cont = replace(cont, name, value, "$=");
							this.add(i, j, "", "TEXT", 0, "$=");
							this.add(i, j, cont, "TEXT", size, "$=");

						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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

	private static String replace(String str, String name, String value,
			String sign) {
		if (str == null || str.trim().equals(""))
			return "";
		int index = str.indexOf(name);
		if (index == -1)
			return str;

		if (str.substring(index - 2, index).equals("$=")
				&& str.substring(index + name.length()).startsWith("$")) {
			StringBuffer sb = new StringBuffer(str.substring(0, index - 2));
			sb.append(value);
			sb.append(str.substring(index + name.length() + 1));
			return replace(sb.toString(), name, value);
		} else
			return str;
	}

	private void copy(CellFormat format, WritableCellFormat wcf) {
		try {
			wcf.setAlignment(format.getAlignment());
			wcf
					.setBackground(format.getBackgroundColour(), format
							.getPattern());
			wcf.setFont((FontRecord) format.getFont());
			wcf.setOrientation(format.getOrientation());
			wcf.setBorder(Border.TOP, format.getBorder(Border.TOP));
			wcf.setBorder(Border.LEFT, format.getBorder(Border.LEFT));
			wcf.setBorder(Border.RIGHT, format.getBorder(Border.RIGHT));
			wcf.setBorder(Border.BOTTOM, format.getBorder(Border.BOTTOM));
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
		if (contents != null && contents != "") {
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
		WritableSheet sheet = workbook.getSheet(sheetNum);
		for (int i = 0; i < templetRow; i++) {
			for (int j = 0; j < templetCol; j++) {
				Cell cell2 = sheet.getWritableCell(j, i);
				String contents = cell2.getContents();
				if (isSign(contents)) {
					try {
						Label label = new Label(j, i, "");
						sheet.addCell(label);
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
		String tmp = str.substring(s + 2);
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

	private boolean contains(String str, String var, String sign) {
		int s = str.indexOf(sign);
		if (s == -1 || s >= str.length() - 2) {
			return false;
		}
		StringBuffer sb = new StringBuffer();
		sb.append(str.substring(0, s));
		String tmp = str.substring(s + 2);
		int e = tmp.indexOf(sign.charAt(0));
		if (e == -1) {
			return false;
		}
		String v = tmp.substring(0, e);
		if (v.equalsIgnoreCase(var)) {
			return true;
		}
		return false;
	}

	public void add(ListTable[] lt) {
		for (int i = 0; i < lt.length; i++) {
			sheetNum = i;
			if (i == 0) {
				add(lt[0]);
			} else {
				this.collectFormat();
				add(lt[i]);
			}
		}
	}

	public void add(ListTable lt, Map map, int sheetNum) {
		this.sheetNum = sheetNum;
		if (sheetNum >= 1) {
			this.collectFormat();
		}
		this.set(map, lt.size());
		add(lt);
	}
	
	public void addListTable(ListTable lt, Map map, int sheetNum){
		this.sheetNum = sheetNum;
		if (sheetNum >= 1) {
			this.collectFormat();
		}
		this.set(map, lt.size());
		addListTable(lt,sheetNum);
	}

//	public static void main(String[] args) throws Exception {
//		// MultiWorkbook tMultiWorkbook = new MultiWorkbook("E:/test.xls",
//		// "E:/test1.xls");
//		// Map map1 = new HashMap();
//		// map1.put("name", "Bobby");
//		// map1.put("time", "14:42:35");
//		// map1.put("managecom", "中科软");
//		// tMultiWorkbook.set(map1);
//		//
//		// System.out.println(" ".trim().equals(""));
//		System.out.println("$=".substring(0, 1));
//	}

}
