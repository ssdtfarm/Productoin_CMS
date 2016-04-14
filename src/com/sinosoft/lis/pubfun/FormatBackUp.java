package com.sinosoft.lis.pubfun;

import java.lang.reflect.Method;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.Resource.RequestFilter;
import com.sinosoft.lis.db.LAAgentDB;
import com.sinosoft.lis.schema.LAAgentBSchema;
import com.sinosoft.lis.schema.LAAgentSchema;
import com.sinosoft.lis.vschema.LAAgentBSet;
import com.sinosoft.lis.vschema.LAAgentSet;
import com.sinosoft.utility.Reflections;
import com.sinosoft.utility.Schema;
import com.sinosoft.utility.SchemaSet;

public class FormatBackUp {
	
	private GlobalInput tG;
    private Reflections tReflections = new Reflections();
	
	public FormatBackUp(){
		try{
			HttpServletRequest request = RequestFilter.threadLocalRequest.get();
			tG = (GlobalInput)request.getSession().getAttribute("GI");
		}catch(Exception e){
			if(tG==null){
				tG=new GlobalInput();
				tG.Operator="default";
			}
		}
	}

	/*
	 * 传入一个Schema，返回对应的BSchema
	 * 传入一个Set，返回对应的BSet
	 * 要求：必须为标准格式的B表，即在原表的基础上添加主键operator1,makedate1,maketime1生成的B表
	 * 使用：tLAAgentBSchema = (LAAgentBSchema)tFormatBackUp.getBackupDate(tLAAgentSchema);
	 */
	public Object getBackupDate(Object dt){
		String className;
		String classBName;
    	Class tClass = null;
    	Object obj;
    	Method method; 
		try{
	    	className = dt.getClass().getName();
			if(className.endsWith("Schema")){
				classBName = className.substring(0,className.length()-6)+"BSchema";
				tClass = Class.forName(classBName);
				obj = tClass.newInstance();
	        	tReflections.transFields((Schema)obj, (Schema)dt);
				method = tClass.getMethod("setOperator1", new Class[]{String.class}); 
				method.invoke(obj, new Object[]{tG.Operator});
				method = tClass.getMethod("setMakeDate1", new Class[]{String.class}); 
				method.invoke(obj, new Object[]{PubFun.getCurrentDate()});
				method = tClass.getMethod("setMakeTime1", new Class[]{String.class}); 
				method.invoke(obj, new Object[]{PubFun.getCurrentTime()});
				return obj;
			}else if(className.endsWith("Set")){
				SchemaSet tSchemaSet=(SchemaSet)dt;
	        	int tSize=tSchemaSet.size();
				classBName = className.substring(0,className.length()-3)+"BSet";
				tClass = Class.forName(classBName);
				obj = tClass.newInstance();
				for(int i=1;i<=tSize;i++){
					method = tClass.getMethod("add", new Class[]{Schema.class}); 
					method.invoke(obj, new Object[]{(Schema)getBackupDate(tSchemaSet.getObj(i))});
				}
				return obj;
			}else{
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
//	public void main(String[] args) {
//		// TODO Auto-generated method stub
//		FormatBackUp tFormatBackUp=new FormatBackUp();
//		LAAgentDB TDB=new LAAgentDB();
//		
//		LAAgentSchema T=new LAAgentSchema();
//		T=TDB.executeQuery("select top 1 * from laagent").get(1);
//		LAAgentBSchema TB=new LAAgentBSchema();
//		TB=(LAAgentBSchema)tFormatBackUp.getBackupDate(T);
//		System.out.println(TB.getMakeDate1());
//		
//		LAAgentSet tSet=new LAAgentSet();
//		tSet=TDB.executeQuery("select * from laagent");
//		LAAgentBSet tBSet=new LAAgentBSet();
//		tBSet=(LAAgentBSet)tFormatBackUp.getBackupDate(tSet);
//		System.out.println(tBSet.size());
//	}

}
