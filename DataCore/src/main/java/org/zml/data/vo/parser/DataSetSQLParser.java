package org.zml.data.vo.parser;
import org.zml.data.vo.bind.DataSet;
public class DataSetSQLParser extends SQLParser implements SQLParserAble
{
	public DataSetSQLParser( DataSet element)
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
		if ( !(this.getQueryDefineElement() instanceof DataSet))
		{
			throw new Exception(" DataSetSQLParser only parse DataSet");
		}
		result = true;
		return result;
	}
}