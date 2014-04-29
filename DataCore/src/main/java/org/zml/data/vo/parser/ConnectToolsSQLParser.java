package org.zml.data.vo.parser;
import org.zml.data.vo.bind.ConnectTools;

public class ConnectToolsSQLParser extends SQLParser implements SQLParserAble
{
	public ConnectToolsSQLParser( ConnectTools element)
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
		if ( !(this.getQueryDefineElement() instanceof ConnectTools))
		{
			throw new Exception(" ConnectToolsSQLParser only parse ConnectTools");
		}
		
		result = true;
		return result;
	}

	
}