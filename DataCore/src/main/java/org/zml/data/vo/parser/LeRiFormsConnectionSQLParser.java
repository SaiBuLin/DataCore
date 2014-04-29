package org.zml.data.vo.parser;
import org.zml.data.vo.bind.LeRiFormsConnection;
public class LeRiFormsConnectionSQLParser extends SQLParser implements SQLParserAble
{
	public LeRiFormsConnectionSQLParser( LeRiFormsConnection element)
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
		if ( !(this.getQueryDefineElement() instanceof LeRiFormsConnection))
		{
			throw new Exception(" LeRiFormsConnectionSQLParser only parse LeRiFormsConnection");
		}
		result = true;
		return result;
	}
}