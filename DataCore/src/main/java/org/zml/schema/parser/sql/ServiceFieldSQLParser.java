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
	 * �ýӿ���Form ��ӦParser ʵ�֡���ö�Ӧ��SELECT ���� �ֶ��б�, �ýӿڱ�Field ʵ��
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
	 * �ýӿ���Form ��ӦParser ʵ�֡���ö�Ӧ��Where ���� �ֶ��б�
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
	 * �ýӿ���Form ��ӦParser ʵ�֡���ö�Ӧ��Order By ���� �ֶ��б�
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
	 * �ýӿ���Form ��ӦParser ʵ�֡���ö�Ӧ��Group by ���� �ֶ��б�
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