package com.sinosoft.utility;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Date;

import com.sinosoft.lis.pubfun.FDate;
import com.sinosoft.lis.pubfun.PubFun;
import com.sinosoft.utility.DBConnPool;
import com.sinosoft.utility.SSRS;

public class CalProcedure {
	
	CallableStatement cst = null;
	private FDate fDate = new FDate();
	public CErrors mErrors = new CErrors(); // 错误信息
	
	
	private String[] paramter;
	private String[] string;
	private Date[] date;
	private Integer[] integer;
	private Float[] flt;
	private int paraNum = 0;
	private String procedureName = "{call ";
	
	public CalProcedure(String proName){
		procedureName+=proName+"()}";
		
	}
	/**
	 * 构造函数
	 * @param tprocedureName  存储过程名称
	 * @param tparaNum        存储过程参数个数，默认最后一个为传出参数且为游标
	 * 
	 * 
	 */
	public CalProcedure(String tprocedureName,int tparaNum){
		paraNum=tparaNum;
		paramter= new String[tparaNum+1];
		string=new String[paraNum+1];
		date=new Date[paraNum+1];
		integer=new Integer[paraNum+1];
		flt=new Float[paraNum+1];
		
		if(paraNum==0)
			procedureName+=tprocedureName+"(";
		else 
			procedureName+=tprocedureName+"(?";
		for (int i=0;i<paraNum-1;i++){
			procedureName+=",?";
			
		}
		procedureName+=")}";
	}
	
//	public static void main(String[] args){
//		CalProcedure tp = new CalProcedure("wyh",3);
//		tp.setDate(1, "2009-06-06");
//		System.out.println(tp.procedureName);
//		System.out.println(tp.date[1]);
//	}
	/**
	 * 将表日期的String对象转换成Date型传入存储过程中
	 * 
	 * @param num 参数所在位置
	 * @param str 表示 "yyyy-mm-dd" 形式的日期的 String 对象
	 * 
	 */
	public void setDate(int num,String str){
		try{
			date[num]=Date.valueOf(str);
			paramter[num]="date";
		}catch(Exception e){
//			CError tErrors= new CError();
//			tErrors.moduleName="CalProcedure";
//			tErrors.functionName="setDate";
//			tErrors.errorMessage = e.toString();
//			mErrors.addOneError(tErrors);
			e.getStackTrace();
		}
		
		
	}
	
	
	public void setString(int num,String str){
		try{
			string[num]=str;
			paramter[num]="string";
		}catch(Exception e){
//			CError tErrors= new CError();
//			tErrors.moduleName="CalProcedure";
//			tErrors.functionName="setString";
//			tErrors.errorMessage = e.toString();
//			mErrors.addOneError(tErrors);
			
		}
	}
	public void setInt(int num,int i){
		try{
			integer[num]=i;
			paramter[num]="int";
		}catch(Exception e){CError tErrors= new CError();
//		tErrors.moduleName="CalProcedure";
//		tErrors.functionName="setInt";
//		tErrors.errorMessage = e.toString();
//		mErrors.addOneError(tErrors);
		e.getStackTrace();
		}
	}
	public void setFloat(int num,float j){
		try{
			flt[num]=j;
			paramter[num]="float";
		}catch(Exception e){
//			CError tErrors= new CError();
//			tErrors.moduleName="CalProcedure";
//			tErrors.functionName="setFloat";
//			tErrors.errorMessage = e.toString();
//			mErrors.addOneError(tErrors);
			e.getStackTrace();
			
		}
	}
	
//	public String getText(int num){
//		try{
//			return rs.getString(num);
//		}catch(SQLException se){
//			se.getStackTrace();
//		}
//	}
/**
 * 调用存储过程，最后一个参数必须是传出的游标
 * 
 * @return SSRS
 */	
	public SSRS calProcedure(){
		Connection con = null;
		ResultSet rs = null;
		SSRS tSSRS =null;
		ResultSetMetaData rsmd = null;
		
		con=DBConnPool.getConnection();
		try{
			cst = con.prepareCall(procedureName);
//			cst = con.prepareCall("{call prcedurename("+name1+","+"name2)}");
			//设置存储过程传入参数
			for (int n=1;n<paraNum;n++)
				setParamter(n);
//			cst.setString(1, "gettype");
			//注册传出参数，类型为游标
			cst.registerOutParameter(paraNum,oracle.jdbc.OracleTypes.CURSOR);
			cst.execute();
			rs = (ResultSet)cst.getObject(paraNum);
			rsmd=rs.getMetaData();
			
			int n = rsmd.getColumnCount();
			tSSRS = new SSRS(n);
			while(rs.next()){
				for(int j=1;j<=n;j++){
//					System.out.println(rs.getString(j));
					tSSRS.SetText(getDataValue(rsmd, rs, j));
				}
				
			}
			
				
			
		}
		catch(SQLException se){
//			CError tErrors= new CError();
//			tErrors.moduleName="CalProcedure";
//			tErrors.functionName="calProcedure";
//			tErrors.errorMessage = se.toString();
//			mErrors.addOneError(tErrors);
			se.printStackTrace();
		}
			
			
		finally{
			try{
				con.close();
				con = null;
				cst.close();
				cst = null;
				rs.close();
				rs = null;
			}
			catch(Exception e){
				
			}
		}
		return tSSRS;
	}
	 /**
     * 把ResultSet中取出的数据转换为相应的数据值字符串
     * 输出：如果成功执行，返回True，否则返回False，并且在Error中设置错误的详细信息
     * @param rsmd ResultSetMetaData
     * @param rs ResultSet
     * @param i int
     * @return String
     */
    private String getDataValue(ResultSetMetaData rsmd, ResultSet rs, int i)
    {
        String strValue = "";

        try
        {
            int dataType = rsmd.getColumnType(i);
            int dataScale = rsmd.getScale(i);
            int dataPrecision = rsmd.getPrecision(i);
            //数据类型为字符
            if ((dataType == Types.CHAR) || (dataType == Types.VARCHAR))
            {
                //由于存入数据库的数据是GBK模式，因此没有必要做一次unicodeToGBK
//                strValue = StrTool.unicodeToGBK(rs.getString(i));
                strValue = rs.getString(i);
            }
            //数据类型为日期、时间
            else if ((dataType == Types.TIMESTAMP) || (dataType == Types.DATE))
            {
                strValue = fDate.getString(rs.getDate(i));
            }
            //数据类型为浮点
            else if ((dataType == Types.DECIMAL) || (dataType == Types.FLOAT))
            {
                //strValue = String.valueOf(rs.getFloat(i));
                //采用下面的方法使得数据输出的时候不会产生科学计数法样式
                strValue = String.valueOf(rs.getBigDecimal(i));
                //去零处理
                strValue = PubFun.getInt(strValue);
            }
            //数据类型为整型
            else if ((dataType == Types.INTEGER) || (dataType == Types.SMALLINT))
            {
                strValue = String.valueOf(rs.getInt(i));
                strValue = PubFun.getInt(strValue);
            }
            //数据类型为浮点
            else if (dataType == Types.NUMERIC)
            {
                if (dataScale == 0)
                {
                    if (dataPrecision == 0)
                    {
                        //strValue = String.valueOf(rs.getDouble(i));
                        //采用下面的方法使得数据输出的时候不会产生科学计数法样式
                        strValue = String.valueOf(rs.getBigDecimal(i));
                    }
                    else
                    {
                        strValue = String.valueOf(rs.getLong(i));
                    }
                }
                else
                {
                    //strValue = String.valueOf(rs.getDouble(i));
                    //采用下面的方法使得数据输出的时候不会产生科学计数法样式
                    strValue = String.valueOf(rs.getBigDecimal(i));
                }
                strValue = PubFun.getInt(strValue);
            }

        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        return StrTool.cTrim(strValue);
    }
    
    private void setParamter(int num){
    	String paraType;
    	if(paramter[num]!=null)
    		paraType=paramter[num];
    	else paraType="string";
    	try{
    		if(paraType.equals("string"))
    			cst.setString(num, string[num]);
    		if(paraType.equals("date"))
    			cst.setDate(num, date[num]);
    	    if(paraType.equals("int"))
    			cst.setInt(num, integer[num]);
    		if(paraType.equals("float"))
    			cst.setFloat(num, flt[num]);
    			
    		}catch(SQLException e){
    			CError tErrors= new CError();
    			tErrors.moduleName="CalProcedure";
    			tErrors.functionName="setParamter";
    			tErrors.errorMessage = e.toString();
    			mErrors.addOneError(tErrors);
    		}
    
    }
}
