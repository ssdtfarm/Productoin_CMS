package com.sinosoft.utility;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Cell;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
import com.sinosoft.lis.excel.Config;

/**
 * <p>说明: itext.jar生成pdf的工具方法, 具体方法参考其他方法实现.</p>
 * <p>继承PdfPageEventHelper是为了实现添加页码的操作.</p>
 * <p>添加时间: 2015-09-18 11:30</p>
 * @author zhangdongyang
 * @version 1.0
 */
public class ItextGNPDFUtil extends PdfPageEventHelper{
	/** PDF报表对象 */
	private Document document;
	/** 定义段落Paragraph后的间距 */
	private float spacingAfter = 10f;
	/** 是否设置表格Cell边框 */
	private boolean isSetBorder = false;
	/** 定义段落Paragraph前的间距 */
	private float spacingBefore = 0f;
	/** PDF报表中表格对象 */
	private Table table;
	/** 是否打开PDF,默认false */
	private boolean isInitPdf = false;
	/** 报表的纸张大小，默认为A4 */
	private Rectangle pageSize = PageSize.A4;
	/** 这个PdfTemplate实例用于保存总页数 */
	private PdfTemplate pdfTemplate;
	/** baseFont页码字体 */
	private BaseFont baseFont;
	/** 页码字体类型*/
	private static String FONT_TYPE = "";
	/** 页码字体大小*/
	private final static float PAGE_FONTSIZE = 9.5f;

	public ItextGNPDFUtil(String pdfFileName, float[] margins) throws DocumentException, IOException {
		// 初始化字体路径
		FONT_TYPE = Config.getFullPathRelateClass("../../../../../common/font/calibri.ttf", ItextGNPDFUtil.class);
		// 实例化Document
		// 纵向打印pdf
		// document = new Document(pageSize, margins[0], margins[1], margins[2], margins[3]);
		// 横向打印pdf
		document = new Document(pageSize.rotate(), margins[0], margins[1], margins[2], margins[3]);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfFileName));
		// 打开文档之前处理页码
		writer.setPageEvent(this);
		document.open();
		isInitPdf = true;
	}

	/**
	 * 设置table
	 * @param colWiths table每个列的宽度数组（百分比） * 
	 * @param borderSize 边框大小
	 * @param width 表格占可显示宽度的百分比 * 
	 * @throws Exception
	 */
	public Table initTable(int[] colWiths, int borderSize, int width) throws Exception {
		table = new Table(colWiths.length);
		table.setWidths(colWiths);
		table.setBorder(borderSize);
		table.setWidth(width);
		return table;
	}

	/**
	 * 中文字体, 处理中文
	 * @param size 字体大小 * 
	 * @throws Exception
	 */
	public Font getChineseFont(Float size) throws Exception {
		BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
		Font fontChinese = new Font(bfChinese, size, Font.NORMAL);
		return fontChinese;
	}

	/**
	 * 标题中文字体（加粗） * 
	 * @param size 字体大小 * 
	 * @throws Exception
	 */
	public Font getTitleChineseFont(Float size) throws Exception {
		BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
		Font fontChinese = new Font(bfChinese, size, Font.NORMAL);
		fontChinese.setStyle(Font.BOLD);
		return fontChinese;
	}
	
	/**
	 * 功能描述：获取普通字体（缺省字体为COURIER）
	 * @param normalFontName
	 *            普通字体名，可以使用以下参数
	 *            COURIER,COURIER_BOLD,COURIER_OBLIQUE,COURIER_BOLDOBLIQUE,
	 *            HELVETICA,HELVETICA_BOLD,HELVETICA_OBLIQUE,HELVETICA_BOLDOBLIQUE, 
	 *            SYMBOL,TIMES,TIMES_ROMAN,TIMES_BOLD,TIMES_ITALIC,TIMES_BOLDITALIC, 
	 *            ZAPFDINGBATS 
	 * @param fontSize 字体大小 
	 * @return Font
	 * @throws IOException 
	 * @throws DocumentException 
	 */
	public Font getBaseFont(String fontName, float fontSize, String fontType) throws DocumentException, IOException {
		if (fontName == null){
			fontName = FontFactory.TIMES_ROMAN;
		}else if ("".equals(fontName)){
			fontName = FontFactory.TIMES_ROMAN;
		}
		BaseFont baseFont = BaseFont.createFont(FONT_TYPE, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		Font font = new Font(baseFont, fontSize, Font.NORMAL);
		if("bold".equals(fontType)){
			font = new Font(baseFont, fontSize, Font.BOLD);
		}
		font.setSize(fontSize);
		return font;
	}

	/**
	 * 插入段落
	 * @param content 段落内容 * 
	 * @param font 字体 * 
	 * @param align 对齐方式 * 
	 * @throws Exception
	 */
	public void insertParagraph(String content, Font font, String align) throws Exception {
		Phrase phrase = new Phrase(content, font);
		Paragraph pg = new Paragraph(phrase);
		if (align != null && align.equalsIgnoreCase("left")) {
			pg.setAlignment(Paragraph.ALIGN_LEFT);
		} else if (align != null && align.equalsIgnoreCase("right")) {
			pg.setAlignment(Paragraph.ALIGN_RIGHT);
		} else {
			// 设置段落后的间距
			pg.setAlignment(Paragraph.ALIGN_CENTER); 
		}
		pg.setSpacingAfter(spacingAfter);
		// 设置段落前的间距
		pg.setSpacingBefore(spacingBefore);
		document.add(pg);
	}

	public void insertParagraph(Phrase phrase, String align) throws DocumentException {
		Paragraph pg = new Paragraph();
		pg.add(phrase);
		if (align != null && align.equalsIgnoreCase("left")) {
			pg.setAlignment(Paragraph.ALIGN_LEFT);
		} else if (align != null && align.equalsIgnoreCase("right")) {
			pg.setAlignment(Paragraph.ALIGN_RIGHT);
		} else {
			// 设置段落后的间距
			pg.setAlignment(Paragraph.ALIGN_CENTER); 
		}
		// 设置段落前的间距
		pg.setSpacingAfter(spacingAfter); 
		pg.setSpacingBefore(spacingBefore);
		document.add(pg);
	}

	public void addElement(Element element) throws DocumentException {
		document.add(element);
	}

	/**
	 * 向PDF添加table对象，需在initTable后使用 * 
	 * @throws DocumentException
	 */
	public void addTable() throws DocumentException {
		if (isInitPdf && table != null){
			document.add(table);
		}
	}

	/**
	 * 关闭，结束操作，必须调用
	 */
	public void close() {
		if (isInitPdf){
			document.close();
		}
	}
	
	/**
	 * 插入表格Cell
	 * @param content 表格内容 * 
	 * @param font 字体
	 * @param align 对齐方式 * 
	 * @return cell
	 * @throws Exception
	 */
	public void addCell(String content, Font font, String align) throws Exception {
		if (table != null) {
			if (content == null) {
				content = "";
			}
			Cell cell = new Cell(new Phrase(content, font));
			cell.setBorder(0);
			if ("left".equalsIgnoreCase(align)) {
				// 设置表格内容水平居左对齐
				cell.setHorizontalAlignment(Cell.ALIGN_LEFT);
			} else if ("center".equalsIgnoreCase(align)) {
				// 设置表格内容水平居中对齐
				cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
			} else {
				// 设置表格内容水平居右对齐
				cell.setHorizontalAlignment(Cell.ALIGN_RIGHT);
			}
			if (isSetBorder == true) {
				cell.setBorder(15);
				cell.setBorderColor(Color.black);
			}
			// 设置表格内容垂直居中
			// cell.setUseAscender(true);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE); 
			table.setPadding(1.2f);
			table.addCell(cell);
		}
	}

	/**
	 * 插入表格Cell,允许跨行跨列 * 
	 * @param content 表格内容 * 
	 * @param font 字体 * 
	 * @param align 对齐方式 * 
	 * @param rowspan 跨行数 * 
	 * @param colspan 跨列数 * 
	 * @return
	 * @throws Exception
	 */
	public void addCell(String content, Font font, String align, int rowspan, int colspan) throws Exception {
		if (table != null) {
			if (content == null) {
				content = "";
			}
			Cell cell = new Cell(new Phrase(content, font));
			cell.setBorder(0);
			if ("left".equalsIgnoreCase(align)) {
				cell.setHorizontalAlignment(Cell.ALIGN_LEFT);
			} else if ("center".equalsIgnoreCase(align)) {
				cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
			} else {
				cell.setHorizontalAlignment(Cell.ALIGN_RIGHT);
			}
			// cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
			if (isSetBorder == true) {
				cell.setBorder(15);
				cell.setBorderColor(Color.black);
			}
			if (rowspan > 1){
				cell.setRowspan(rowspan);
			}
			if (colspan > 1){
				cell.setColspan(colspan);
			}
			table.setPadding(1.2f);
			table.addCell(cell);
		}
	}
	
	/**
	 * 这个方法主要自动换页的时候添加表头使用.
	 * 插入表格Cell,允许跨行跨列 * 
	 * @param content 表格内容 * 
	 * @param font 字体 * 
	 * @param align 对齐方式 * 
	 * @param rowspan 跨行数 * 
	 * @param colspan 跨列数 * 
	 * @return
	 * @throws Exception
	 */
	public void addCell(String content, Font font, String align, int rowspan, int colspan, boolean headerFlag) throws Exception {
		if (table != null) {
			if (content == null) {
				content = "";
			}
			Cell cell = new Cell(new Phrase(content, font));
			// 添加固定表头
			if(headerFlag){
				cell.setHeader(true);
			}
			cell.setBorder(0);
			if ("left".equalsIgnoreCase(align)) {
				cell.setHorizontalAlignment(Cell.ALIGN_LEFT);
			} else if ("center".equalsIgnoreCase(align)) {
				cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
			} else {
				cell.setHorizontalAlignment(Cell.ALIGN_RIGHT);
			}
			// cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
			if (isSetBorder == true) {
				cell.setBorder(15);
				cell.setBorderColor(Color.black);
			}
			if (rowspan > 1){
				cell.setRowspan(rowspan);
			}
			if (colspan > 1){
				cell.setColspan(colspan);
			}
			table.setPadding(1.2f);
			table.addCell(cell);
		}
	}

	/**
	 * 插入表格Cell,允许跨行跨列 * 
	 * @param content 表格内容 * 
	 * @param font 字体 * 
	 * @param align 对齐方式 * 
	 * @param rowspan 跨行数 * 
	 * @param colspan 跨列数 * 
	 * @param height Cell高度 * 
	 * @throws Exception
	 */
	public void addCell(String content, Font font, String align, int rowspan, int colspan, float height) throws Exception {
		if (table != null) {
			if (content == null) {
				content = "";
			}
			Cell cell = new Cell(new Phrase(content, font));
			cell.setBorder(0);
			cell.setLeading(height);
			// 设置Cell的高度 if
			// ("left".equalsIgnoreCase(align)) {
			// cell.setHorizontalAlignment(Cell.ALIGN_LEFT);
			// } else if
			// ("center".equalsIgnoreCase(align)) {
			// cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
			// } else {
			// cell.setHorizontalAlignment(Cell.ALIGN_RIGHT);
			// }
			if (isSetBorder == true) {
				cell.setBorder(15);
				cell.setBorderColor(Color.black);
			}
			if (rowspan > 1){
				cell.setRowspan(rowspan);
			}
			if (colspan > 1){
				cell.setColspan(colspan);
			}
			table.setPadding(1.2f);
			table.addCell(cell);
		}
	}

	/**
	 * 插入表格Cell
	 * @param content 表格内容 * 
	 * @param font 字体 * 
	 * @param align 对齐方式 * 
	 * @param isHeader 是否表头
	 * @throws Exception
	 */
	public void addCell(String content, Font font, String align, Boolean isHeader) throws Exception {
		if (table != null) {
			if (content == null) {
				content = "";
			}
			Cell cell = new Cell(new Phrase(content, font));
			// 设置为表头 cell.setBorder(0);
			cell.setHeader(isHeader);
			if ("left".equalsIgnoreCase(align)) {
				cell.setHorizontalAlignment(Cell.ALIGN_LEFT);
			} else if ("center".equalsIgnoreCase(align)) {
				cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
			} else {
				cell.setHorizontalAlignment(Cell.ALIGN_RIGHT);
			}
			if (isSetBorder == true) {
				cell.setBorder(15);
				cell.setBorderColor(Color.black);
			}
			table.setPadding(1.2f);
			table.setAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell);
		}
	}

	/**
	 * 插入表格Cell,允许跨行跨列 * 
	 * @param content 表格内容 * 
	 * @param font 字体 * 
	 * @param align 对齐方式 * 
	 * @throws Exception
	 */
	public void addCell(String content, Font font, String align, int rowspan, int colspan, Boolean isHeader) throws Exception {
		if (table != null) {
			if (content == null) {
				content = "";
			}
			Cell cell = new Cell(new Phrase(content, font));
			// 设置为表头 cell.setBorder(0);
			cell.setHeader(isHeader);
			if ("left".equalsIgnoreCase(align)) {
				cell.setHorizontalAlignment(Cell.ALIGN_LEFT);
			} else if ("center".equalsIgnoreCase(align)) {
				cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
			} else {
				cell.setHorizontalAlignment(Cell.ALIGN_RIGHT);
			}
			if (isSetBorder == true) {
				cell.setBorder(15);
				cell.setBorderColor(Color.black);
			}
			if (rowspan > 1){
				cell.setRowspan(rowspan);
			}
			if (colspan > 1){
				cell.setColspan(colspan);
			}
			table.setPadding(1.2f);
			table.addCell(cell);
		}
	}

	/**
	 * 插入表格Cell
	 * @param content 表格内容 * 
	 * @param font 字体 * 
	 * @param align 对齐方式 * 
	 * @param height 表头高度
	 * @throws Exception
	 */
	public void addCell(String content, Font font, String align, Float height, Boolean isHeader) throws Exception {
		if (table != null) {
			if (content == null) {
				content = "";
			}
			Cell cell = new Cell(new Phrase(content, font));
			cell.setHeader(isHeader);
			cell.setLeading(height);
			cell.setBorder(0);
			if ("left".equalsIgnoreCase(align)) {
				cell.setHorizontalAlignment(Cell.ALIGN_LEFT);
			} else if ("center".equalsIgnoreCase(align)) {
				cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
			} else {
				cell.setHorizontalAlignment(Cell.ALIGN_RIGHT);
			}
			if (isSetBorder == true) {
				cell.setBorder(15);
				cell.setBorderColor(Color.black);
			}
			table.setPadding(1.2f);
			table.addCell(cell);
		}
	}

	/***
	 * 插入表格Cell * 
	 * @param content 表格内容 * 
	 * @param font 字体 * 
	 * @param align 对齐方式 * 
	 * @param height 表头高度 * 
	 * @throws Exception
	 */
	public void addCell(String content, Font font, String align, Float height) throws Exception {
		addCell(content, font, align, height, false);
	}

	/**
	 * 插入表格Cell,允许跨行跨列 * 
	 * @param content 表格内容 * 
	 * @param font 字体
	 * @param align 对齐方式 * 
	 * @param height Cell高度 * 
	 * @param isHeader 是否为表头 * 
	 * @throws Exception
	 */
	public void addCell(String content, Font font, String align, int rowspan, int colspan, Float height, Boolean isHeader) throws Exception {
		if (table != null) {
			if (content == null) {
				content = "";
			}
			Cell cell = new Cell(new Phrase(content, font));
			cell.setHeader(isHeader);
			cell.setLeading(height);
			cell.setBorder(0);
			if ("left".equalsIgnoreCase(align)) {
				cell.setHorizontalAlignment(Cell.ALIGN_LEFT);
			} else if ("center".equalsIgnoreCase(align)) {
				cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
			} else {
				cell.setHorizontalAlignment(Cell.ALIGN_RIGHT);
			}
			if (isSetBorder == true) {
				cell.setBorder(15);
				cell.setBorderColor(Color.black);
			}
			if (rowspan > 1){
				cell.setRowspan(rowspan);
			}
			if (colspan > 1){
				cell.setColspan(colspan);
			}
			table.setPadding(1.2f);
			table.addCell(cell);
		}

	}
	
	/**
	 * 这个同名方法可以插入图片
	 * 插入表格Cell,允许跨行跨列 * 
	 * @param content 表格内容 * 
	 * @param font 字体
	 * @param align 对齐方式 * 
	 * @param height Cell高度 * 
	 * @param isHeader 是否为表头 * 
	 * @throws Exception
	 */
	public void addCell(Chunk chunk, Font font, String align, int rowspan, int colspan, Float height, Boolean isHeader) throws Exception {
		if (table != null) {
			if (chunk == null) {
				chunk = new Chunk("");
			}
			Cell cell = new Cell(chunk);
			cell.setHeader(isHeader);
			cell.setLeading(height);
			cell.setBorder(0);
			if ("left".equalsIgnoreCase(align)) {
				cell.setHorizontalAlignment(Cell.ALIGN_LEFT);
			} else if ("center".equalsIgnoreCase(align)) {
				cell.setHorizontalAlignment(Cell.ALIGN_CENTER);
			} else {
				cell.setHorizontalAlignment(Cell.ALIGN_RIGHT);
			}
			if (isSetBorder == true) {
				cell.setBorder(15);
				cell.setBorderColor(Color.black);
			}
			if (rowspan > 1){
				cell.setRowspan(rowspan);
			}
			if (colspan > 1){
				cell.setColspan(colspan);
			}
			table.setPadding(1.2f);
			table.addCell(cell);
		}
	}

	/**
	 * 结束表头 * 
	 * @throws Exception
	 */
	public void endHeader() {
		table.endHeaders();
	}

	/**
	 * 设置段落后的间距
	 * @param spacingAfter 为空表示还原
	 */
	public void setSpacingAfter(Float spacingAfter) {
		if (spacingAfter == null) {
			spacingAfter = 10f;
		}
		this.spacingAfter = spacingAfter;
	}

	/**
	 * 设置段落前的间距
	 * @param spacingAfter 空表示还原
	 */
	public void setSpacingBefore(Float spacingBefore) {
		if (spacingBefore == null) {
			spacingBefore = 0f;
		}
		this.spacingBefore = spacingBefore;
	}

	/**
	 * 设置表格Border标记 * 
	 * @param isSetBorder
	 */
	public void setIsSetBorder(boolean isSetBorder) {
		this.isSetBorder = isSetBorder;
	}
	
	/**
	 * 设置页码的时候打开Document
	 */
	public void onOpenDocument(PdfWriter writer, com.lowagie.text.Document arg1) {
		System.out.println("=================Start onOpenDocument function=================");
		try {
			// 实例化
			pdfTemplate = writer.getDirectContent().createTemplate(100, 100);
			// 可以设置页码自定义的字体
			baseFont = BaseFont.createFont(FONT_TYPE, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		} catch (Exception e) {
			System.out.println("function onOpenDocument exception: " + e.toString());
			e.printStackTrace();
		}
		System.out.println("=================End onOpenDocument function=================");
	}
	
	/**
	 * 设置页码
	 */
	public void onEndPage(PdfWriter writer, com.lowagie.text.Document document) {
		System.out.println("=================Start onEndPage function=================");
		PdfContentByte cb = writer.getDirectContent();
		cb.saveState();

		String text = "Page " + writer.getPageNumber() + " / Total";
		float textSize = baseFont.getWidthPoint(text, 9.35f);
		float textBase = document.bottom() - 17;
		cb.beginText();
		cb.setFontAndSize(baseFont, PAGE_FONTSIZE);
		
		// cb.setTextMatrix(document.left(), textBase);
		// 用于控制在底部居中
		cb.setTextMatrix((document.left() + document.right() - textSize) / 2 , textBase);
		cb.showText(text);
		cb.endText();
		// cb.addTemplate(pdfTemplate, document.left() + textSize, textBase);
		// 用于控制在底部居中
		cb.addTemplate(pdfTemplate, (document.left() + document.right() + textSize + 6.3f) / 2, textBase);
		cb.saveState();
		System.out.println("=================End onEndPage function=================");
	}
	
	/**
	 * 设置页码的时候关闭Document
	 */
	public void onCloseDocument(PdfWriter writer, com.lowagie.text.Document arg1) {
		System.out.println("=================Start onCloseDocument function=================");
		pdfTemplate.beginText();
		pdfTemplate.setFontAndSize(baseFont, PAGE_FONTSIZE);
		pdfTemplate.setTextMatrix(0, 0);
		// 关闭的时候添加总页码
		pdfTemplate.showText("" + (writer.getPageNumber() - 1));
		pdfTemplate.endText();
		System.out.println("=================End onCloseDocument function=================");
	}
	
	/**
	 * 添加新的一页pdf
	 * @throws DocumentException
	 */
	public void addNewPage() throws DocumentException{
		document.newPage();
	}
	
}
