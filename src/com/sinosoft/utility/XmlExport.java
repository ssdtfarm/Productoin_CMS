/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */
package com.sinosoft.utility;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Attribute;
import org.jdom.output.XMLOutputter;

import com.sinosoft.lis.f1print.FileNameQueue;
import com.sinosoft.lis.pubfun.GlobalInput;

public class XmlExport
{
    private Document myDocument;
    private int col;
    private GlobalInput mGlobalInput = new GlobalInput();

    // @Method
    //初始化文件，参数为模板名，打印机名
    public Document createDocument(String templatename, String printername)
    {
        // Create the root element
        // TemplateName=templatename;
        Element DataSetElement = new Element("DATASET");
        //create the document
        this.myDocument = new Document(DataSetElement);
        //add some child elements

        //  Note that this is the first approach to adding an element and
        // textual content.  The second approach is commented out.

        Element CONTROL = new Element("CONTROL");
        DataSetElement.addContent(CONTROL);
        Element TEMPLATE = new Element("TEMPLATE");
        Element PRINTER = new Element("PRINTER");
        PRINTER.addContent(printername);
        TEMPLATE.addContent(templatename);
        CONTROL.addContent(TEMPLATE);
        CONTROL.addContent(PRINTER);

        CONTROL.addContent(new Element("DISPLAY"));
        return myDocument;
    }
    public Document createDocument(String rootName,String templatename, String printername)
        {
            // Create the root element
            // TemplateName=templatename;
            Element DataSetElement = new Element(rootName);
            //create the document
            this.myDocument = new Document(DataSetElement);
            //add some child elements

            //  Note that this is the first approach to adding an element and
            // textual content.  The second approach is commented out.

            Element CONTROL = new Element("CONTROL");
            DataSetElement.addContent(CONTROL);
            Element TEMPLATE = new Element("TEMPLATE");
            Element PRINTER = new Element("PRINTER");
            PRINTER.addContent(printername);
            TEMPLATE.addContent(templatename);
            CONTROL.addContent(TEMPLATE);
            CONTROL.addContent(PRINTER);

            CONTROL.addContent(new Element("DISPLAY"));
            return myDocument;
    }
    
    //add by zhoulihong  重载一个方法，专用于万能年报打印格式
    public Document createDocument()
    {
    	 Element DataSetElement = new Element("DATASET");
         //create the document
         this.myDocument = new Document(DataSetElement);
         //add some child elements
        return myDocument;
    }
    // @Method
    //初始化文件，参数为模板名，打印机名
    public Document createDocuments(String printername, GlobalInput mGlobalInput)
    {
        // Create the root element
        // TemplateName=templatename;
        Element DataSetElements = new Element("DATASETS");
        //create the document
        this.myDocument = new Document(DataSetElements);
        //add some child elements

        //  Note that this is the first approach to adding an element and
        // textual content.  The second approach is commented out.

        Element CONTROL = new Element("CONTROL");
        DataSetElements.addContent(CONTROL);
        Element PRINTER = new Element("PRINTER");
        Element OPERATOR = new Element("OPERATOR");
        Element REQUESTCOM = new Element("REQUESTCOM");
        Element OPERATECOM = new Element("OPERATECOM");
        Element TEMPLATE = new Element("TEMPLATE");
        OPERATOR.addContent(mGlobalInput.Operator);
        REQUESTCOM.addContent(mGlobalInput.ComCode);
        OPERATECOM.addContent(mGlobalInput.ManageCom);
        PRINTER.addContent(printername);
        CONTROL.addContent(OPERATOR);
        CONTROL.addContent(REQUESTCOM);
        CONTROL.addContent(OPERATECOM);
        CONTROL.addContent(TEMPLATE);
        CONTROL.addContent(PRINTER);
        return myDocument;
    }

    public Document getDocument()
    {
        return this.myDocument;
    }
    //输出xml文件，参数为路径，文件名
    public void outputDocumentToFile(String pathname, String filename)
    {
        outputDocumentToFile( pathname,  filename, true);
    }

//  输出xml文件，参数为路径，文件名,是否需要改名，文件名后缀
    public void outputDocumentToFile(String pathname, String filename,boolean isNeedRename)
    {
        XMLOutputter outputter=null;
        FileWriter writer=null;
        //setup this like outputDocument
        try
        {
             outputter = new XMLOutputter();
            //output to a file
            String str = pathname + filename;
            if(isNeedRename)str+=FileNameQueue.XML_PRE ;
            else str+= FileNameQueue.XML;
            writer = new FileWriter(str);
            outputter.output(myDocument, writer);

            writer.close();

        }
        catch (java.io.IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(isNeedRename)FileNameQueue.rename(pathname,filename);
        }

    }

    //添加一个列表，参数为ListTag和动态列表的表头数组
    public Document addListTableToEle(Element EleName,ListTable listtable, String[] colvalue)
    {
        this.col = colvalue.length;
        Element DataSetElement = EleName;
        Element table = new Element(listtable.getName());
        table.setAttribute("RowCount", String.valueOf(listtable.size()));
        table.setAttribute("ColCount", String.valueOf(colvalue.length));
        DataSetElement.addContent(table);
        Element head = new Element("HEAD");
        table.addContent(head);
        //建立表头名
        for (int m = 0; m < colvalue.length; m++)
        {
            int n = m + 1;
            String colnum = "COL" + n;
            head.addContent(new Element(colnum).addContent(colvalue[m]));
        }

        //遍历整个table

        int tablesize = listtable.size();

        for (int i = 0; i <= tablesize - 1; i++)
        {
            String[] temparray = new String[this.col];
            temparray = listtable.get(i);
            Element row = new Element("ROW");
            table.addContent(row);
            for (int m = 0; m < temparray.length; m++)
            {
                int n = m + 1;
                String colnum = "COL" + n;
                row.addContent(new Element(colnum).addContent(temparray[m]));
            }

        }
        return myDocument;
    }
    
    /**
     * @param listtable为ListTable对象，colNum为该列表每行需要显示列数
     * @return myDocument
     * @author liang
     * @since 20091013
     */
    public Document addListTable(ListTable listtable,int colNum){
    	this.col = colNum;
    	
    	Element DataSetElement = this.myDocument.getRootElement();
    	Element table = new Element(listtable.getName());
    	
    	table.setAttribute("RowCount",String.valueOf(listtable.size()));
    	table.setAttribute("ColCount",String.valueOf(colNum));
    	
    	DataSetElement.addContent(table);
    	
    	//遍历整个table
    	int tablesize = listtable.size();
    	
    	for(int i = 1;i <= tablesize;i++){
            String[] temparray = new String[this.col];
            temparray = listtable.get(i-1);
            Element row = new Element("ROW"+i);
            table.addContent(row);
            for (int m = 0; m < col; m++)
            {
                int n = m + 1;
                String colnum = "COL" + n;
                row.addContent(new Element(colnum).addContent(temparray[m]));
            }
    	}
    	
    	return myDocument;
    }

    //添加一个列表，参数为ListTag和动态列表的表头数组
    public Document addListTable(ListTable listtable, String[] colvalue)
    {
        this.col = colvalue.length;
        Element DataSetElement = this.myDocument.getRootElement();
        Element table = new Element(listtable.getName());
        table.setAttribute("RowCount",String.valueOf(listtable.size()));
        table.setAttribute("ColCount",String.valueOf(colvalue.length));
        DataSetElement.addContent(table);
        Element head = new Element("HEAD");
        table.addContent(head);
        //建立表头名
        for (int m = 0; m < colvalue.length; m++)
        {
            int n = m + 1;
            String colnum = "COL" + n;
            head.addContent(new Element(colnum).addContent(colvalue[m]));
        }

        //遍历整个table

        int tablesize = listtable.size();

        for (int i = 0; i <= tablesize - 1; i++)
        {
            String[] temparray = new String[this.col];
            temparray = listtable.get(i);
            Element row = new Element("ROW");
            table.addContent(row);
            for (int m = 0; m < temparray.length; m++)
            {
                int n = m + 1;
                String colnum = "COL" + n;
                row.addContent(new Element(colnum).addContent(temparray[m]));
            }

        }
        return myDocument;
    }

    /**
     * 在某个结点下添加一个列表
     * @param item
     * @param listtable
     * @param colvalue
     * @return
     */
    public Document addListTable(String item, ListTable listtable,
            String[] colvalue) {
        this.col = colvalue.length;
        Element DataSetElement = this.myDocument.getRootElement().getChild(
                item);
        Element table = new Element(listtable.getName());
        table.setAttribute("RowCount", String.valueOf(listtable.size()));
        table.setAttribute("ColCount", String.valueOf(colvalue.length));
        DataSetElement.addContent(table);
        Element head = new Element("HEAD");
        table.addContent(head);
        // 建立表头名
        for (int m = 0; m < colvalue.length; m++) {
            int n = m + 1;
            String colnum = "COL" + n;
            head.addContent(new Element(colnum).addContent(colvalue[m]));
        }

        // 遍历整个table
        int tablesize = listtable.size();

        for (int i = 0; i <= tablesize - 1; i++) {
            String[] temparray = new String[this.col];
            temparray = listtable.get(i);
            Element row = new Element("ROW");
            table.addContent(row);
            for (int m = 0; m < temparray.length; m++) {
                int n = m + 1;
                String colnum = "COL" + n;
                row.addContent(new Element(colnum).addContent(temparray[m]));
            }

        }
        return myDocument;
    }
    
    //添加一个列表，参数为ListTag和动态列表的表头数组
    public Document addListTables(ListTable listtable, String[] colvalue,TextTag texttag)
    {
        Element DataSetElements = this.myDocument.getRootElement();
        Element DataSetElement = new Element("DATASET");
        DataSetElements.addContent(DataSetElement);
        //添加动态文本标签的数组，参数为一个TextTag
        int tagsize = texttag.size();
        for (int i = 0; i <= tagsize - 1; i++)
        {
            String[] temparray = new String[2];
            temparray = (String[]) texttag.get(i);
            if (temparray[1].length() > 0)
            {
                DataSetElement.addContent(new Element(temparray[0]).addContent(
                        temparray[1]));
            }

            else
            {
                DataSetElement.addContent(new Element(temparray[0]).addContent(
                        " "));
            }

        }

        if(listtable!= null && listtable.size()>0)
        {
            this.col = colvalue.length;
            Element table = new Element(listtable.getName());
            DataSetElement.addContent(table);
            Element head = new Element("HEAD");
            table.addContent(head);
            //建立表头名
            for (int m = 0; m < colvalue.length; m++)
            {
                int n = m + 1;
                String colnum = "COL" + n;
                head.addContent(new Element(colnum).addContent(colvalue[m]));
            }

            //遍历整个table

            int tablesize = listtable.size();

            for (int i = 0; i <= tablesize - 1; i++)
            {
                String[] temparray = new String[this.col];
                temparray = listtable.get(i);
                Element row = new Element("ROW");
                table.addContent(row);
                for (int m = 0; m < temparray.length; m++)
                {
                    int n = m + 1;
                    String colnum = "COL" + n;
                    row.addContent(new Element(colnum).addContent(temparray[m]));
                }

            }
        }
        return myDocument;
    }



    //添加动态文本标签的数组，参数为一个TextTag
    public Document addTextTag(TextTag texttag)
    {
        Element DataSetElement = this.myDocument.getRootElement();
        int tagsize = texttag.size();
        for (int i = 0; i <= tagsize - 1; i++)
        {
            String[] temparray = new String[2];
            temparray = (String[]) texttag.get(i);
            if (temparray[1].length() > 0)
            {
                DataSetElement.addContent(new Element(temparray[0]).addContent(
                        temparray[1]));
            }

            else
            {
                DataSetElement.addContent(new Element(temparray[0]).addContent(
                        " "));
            }

        }
        return myDocument;
    }

    /*
     * 直接从文档中产生一个输入流对象，而不是生成一个临时文件
     * 输出：
     *     一个输入流对象
     */
    public InputStream getInputStream()
    {
        try
        {
            XMLOutputter outputter = new XMLOutputter();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            outputter.output(myDocument, baos);
            baos.close();

            return new ByteArrayInputStream(baos.toByteArray());
        }
        catch (java.io.IOException e)
        {
            e.printStackTrace();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
    /**
     * 2005-4-28
     * 往文档理添加文档，即：把DataSet添加到DataSets中.
     * @param parentElement Element
     * @param dataSet Element
     */
    public void addDataSet(Element parentElement,Element dataSet)
    {
        parentElement.addContent((Element)dataSet.clone());
//        List tElementList = dataSet.getChildren();
//
//        if (tElementList.size()==0)
//        {
//            Element tpElement = new Element(dataSet.getName());
//            tpElement.addContent(dataSet.getText());
//            parentElement.addContent(tpElement);
//        }
//        else
//        {
//            Element tDataSet = new Element(dataSet.getName());
//            parentElement.addContent(tDataSet);
//            for (int i = 0; i < tElementList.size(); i++)
//            {
//                Element tElement = (Element) tElementList.get(i);
//                //if(tElement.getName().equals("CONTROL")) continue;
//                addDataSet(tDataSet,tElement);
//            }
//        }
    }
    public void addDataSet(Element dataSet)
    {
        this.getDocument().getRootElement().addContent((Element) dataSet.clone());
    }
    public void setTemplateName(Element parentElement,Element dataSet)
    {
        myDocument.getRootElement().getChild("CONTROL").getChild("TEMPLATE").setText(dataSet.getChild("CONTROL").getChild("TEMPLATE").getText());
    }
    //设置模板名称
    public void setTemplateName(String templateName)
    {
        myDocument.getRootElement().getChild("CONTROL").getChild("TEMPLATE").setText(templateName);
    }
    
    //设置打印机名
    public void setPrinterName(String printerName)
    {
        myDocument.getRootElement().getChild("CONTROL").getChild("PRINTER").setText(printerName);
    }

    /**
     * 2002-11-11 kevin
     * 在数据xml文件中加入一个显示控制数据
     * @param strName String
     * @return Document
     */
    public Document addDisplayControl(String strName)
    {
        Element elementControl = this.myDocument.getRootElement().getChild(
                "CONTROL").getChild("DISPLAY");
        elementControl.addContent(new Element(strName).addContent("1"));

        return myDocument;
    }

    /**
     * 2002-11-11 kevin
     * 在数据xml文件的某一项中加入一个新项
     * @param strRiskNo String
     * @return Document
     */
    public Document addControlItem(String item,String name,String value)
    {
        Element elementControl = this.myDocument.getRootElement().getChild(item);
        if(value == null) value = "";
        elementControl.addContent(new Element(name).addContent(value));

        return myDocument;
    }

//    public static void main(String args[])throws Exception
//    {
//             XmlExport xe = new XmlExport();
//             Document doc = xe.createDocument("F:/xx.vts", "printer");
//             XMLOutputter output = new XMLOutputter();
//             output.output(doc, System.out);
//    }
}
