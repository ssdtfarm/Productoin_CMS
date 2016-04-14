/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.vschema;

import com.sinosoft.lis.schema.Msg_InfoSchema;
import com.sinosoft.utility.*;

/*
 * <p>ClassName: Msg_InfoSet </p>
 * <p>Description: Msg_InfoSchemaSet类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class Msg_InfoSet extends SchemaSet
{
	// @Method
	public boolean add(Msg_InfoSchema aSchema)
	{
		return super.add(aSchema);
	}

	public boolean add(Msg_InfoSet aSet)
	{
		return super.add(aSet);
	}

	public boolean remove(Msg_InfoSchema aSchema)
	{
		return super.remove(aSchema);
	}

	public Msg_InfoSchema get(int index)
	{
		Msg_InfoSchema tSchema = (Msg_InfoSchema)super.getObj(index);
		return tSchema;
	}

	public boolean set(int index, Msg_InfoSchema aSchema)
	{
		return super.set(index,aSchema);
	}

	public boolean set(Msg_InfoSet aSet)
	{
		return super.set(aSet);
	}

	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpMsg_Info描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer("");
		int n = this.size();
		for (int i = 1; i <= n; i++)
		{
			Msg_InfoSchema aSchema = this.get(i);
			strReturn.append(aSchema.encode());
			if( i != n ) strReturn.append(SysConst.RECORDSPLITER);
		}

		return strReturn.toString();
	}

	/**
	* 数据解包
	* @param: str String 打包后字符串
	* @return: boolean
	**/
	public boolean decode( String str )
	{
		int nBeginPos = 0;
		int nEndPos = str.indexOf('^');
		this.clear();

		while( nEndPos != -1 )
		{
			Msg_InfoSchema aSchema = new Msg_InfoSchema();
			if(aSchema.decode(str.substring(nBeginPos, nEndPos)))
			{
			this.add(aSchema);
			nBeginPos = nEndPos + 1;
			nEndPos = str.indexOf('^', nEndPos + 1);
			}
			else
			{
				// @@错误处理
				this.mErrors.copyAllErrors( aSchema.mErrors );
				return false;
			}
		}
		Msg_InfoSchema tSchema = new Msg_InfoSchema();
		if(tSchema.decode(str.substring(nBeginPos)))
		{
		this.add(tSchema);
		return true;
		}
		else
		{
			// @@错误处理
			this.mErrors.copyAllErrors( tSchema.mErrors );
			return false;
		}
	}

}
