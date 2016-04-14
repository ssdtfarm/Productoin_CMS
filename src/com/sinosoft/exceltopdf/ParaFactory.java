package com.sinosoft.exceltopdf;

import java.io.IOException;

import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.sinosoft.lis.excel.Config;

public class ParaFactory {
	private static Font defFont(){
		String path = null;
		try {
			// path = Config.getFullPathRelateClass("../../../../../../ui/common/font/calibri.ttf", ParaFactory.class);
			path = Config.getFullPathRelateClass("../../../../../common/font/calibri.ttf", ParaFactory.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return FontFactory.getFont(path, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
	}
	public static Paragraph size10(String content){
		Paragraph p = new Paragraph(content, defFont());
		p.getFont().setSize(10f);
		return p;
	}
	public static Paragraph size8(String content){
		Paragraph p = new Paragraph(content, defFont());
		p.getFont().setSize(8f);
		return p;
	}
	// 作为备份的处理
	public static Paragraph size8_B(String content){
		Paragraph p = new Paragraph(content, defFontBak());
		p.getFont().setSize(2);
		return p;
	}
	// 新添加
	private static Font defFontBak(){
		return FontFactory.getFont("STSong-Light", "UniGB-UCS2-H");
	}
}
