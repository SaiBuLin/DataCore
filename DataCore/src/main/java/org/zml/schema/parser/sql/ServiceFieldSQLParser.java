package org.zml.schema.parser.sql;
import java.util.List;

import org.zml.form.bind.FormNode;
import org.zml.schema.bind.ServiceField;

public class ServiceFieldSQLParser extends SQLParser implements SQLParserAble
{
	public ServiceFieldSQLParser( ServiceField element)
	{
		setQueryDefineElement(element);
	}

	public boolean checkQueryElementComfort() throws Exception
	{
		boolean result = false;
		if ( this.getQueryDefineElement()  == null )
		{
			throw new Exception(" queryDefineElement cannot be null. ");
		}
		if ( !(this.getQueryDefineElement() instanceof ServiceField))
		{
			throw new Exception(" ServiceFieldSQLParser only parse ServiceField");
		}
		result = true;
		return result;
	}
	
	/**
	 * 该接口由Form 对应Parser 实现。获得对应的SELECT 部分 字段列表, 该接口被Field 实现
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getSelectFields(FormNode formrequest) throws Exception{
		 List<FieldInfo> result = null;
		 
		 return result;
	}
	
	/**
	 * 该接口由Form 对应Parser 实现。获得对应的Where 部分 字段列表
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getConditionFields(FormNode formrequest) throws Exception{
		 List<FieldInfo> result = null;
		 
		 return result;
	}
	
	/**
	 * 该接口由Form 对应Parser 实现。获得对应的Order By 部分 字段列表
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getOrderByFields(FormNode formrequest) throws Exception{
		 List<FieldInfo> result = null;
		 
		 return result;
	}
	
	/**
	 * 该接口由Form 对应Parser 实现。获得对应的Group by 部分 字段列表
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getGroupByFields(FormNode formrequest) throws Exception{
		 List<FieldInfo> result = null;
		 
		 return result;
	}
	
}