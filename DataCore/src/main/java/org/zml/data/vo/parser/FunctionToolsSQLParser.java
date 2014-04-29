package org.zml.data.vo.parser;
import org.zml.data.vo.bind.FunctionTools;

public class FunctionToolsSQLParser extends SQLParser implements SQLParserAble
{
	public FunctionToolsSQLParser( FunctionTools element)
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
		if ( !(this.getQueryDefineElement() instanceof FunctionTools))
		{
			throw new Exception(" FunctionToolsSQLParser only parse FunctionTools");
		}
		result = true;
		return result;
	}
}