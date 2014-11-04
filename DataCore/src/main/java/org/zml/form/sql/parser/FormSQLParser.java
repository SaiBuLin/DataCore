package org.zml.form.sql.parser;
import java.util.List;

import org.zml.data.DataServiceTools;
import org.zml.data.FieldDefine;
import org.zml.data.FieldInfo;
import org.zml.data.SQLString;
import org.zml.tools.xml.parser.CTXMLElement;

public abstract class FormSQLParser  extends DataServiceTools  implements FormSQLParserAble
{
	protected CTXMLElement queryDefineElement = null;
	public CTXMLElement getQueryDefineElement()
	{
		return queryDefineElement;
	}
	
	public void setQueryDefineElement(CTXMLElement queryDefineElement)
	{
		this.queryDefineElement = queryDefineElement;
	}
	
	@Override
	public FieldInfo getSelectField( FieldDefine field ) throws Exception{
		logger.debug("FormParser ����Ҫʵ��getSelectField.");
		return null;
	}
	
	@Override
	public FieldInfo getOrderField( FieldDefine field ) throws Exception{
		logger.debug("FormParser ����Ҫʵ��getOrderField.");
		return null;
	}
	
	@Override
	public FieldInfo getGroupField( FieldDefine field ) throws Exception{
		logger.debug("FormParser ����Ҫʵ��getGroupField.");
		return null;
	}
	
	@Override
	public SQLString parserWhereString(  List<FieldDefine> fields  ) throws Exception{
		logger.debug("FormParser ����Ҫʵ��parserWhereString.");
		return null;
	}	
}