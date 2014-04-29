package org.zml.data.vo.parser;
import org.zml.data.vo.bind.DataTypeChecker;
public class DataTypeCheckerSQLParser extends SQLParser implements SQLParserAble
{
	public DataTypeCheckerSQLParser( DataTypeChecker element)
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
		if ( !(this.getQueryDefineElement() instanceof DataTypeChecker))
		{
			throw new Exception(" DataTypeCheckerSQLParser only parse DataTypeChecker");
		}
		result = true;
		return result;
	}
}