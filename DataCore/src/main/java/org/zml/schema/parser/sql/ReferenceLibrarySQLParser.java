package org.zml.schema.parser.sql;
import org.zml.schema.bind.ReferenceLibrary;
public class ReferenceLibrarySQLParser extends SQLParser implements SQLParserAble
{
	public ReferenceLibrarySQLParser( ReferenceLibrary element)
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
		if ( !(this.getQueryDefineElement() instanceof ReferenceLibrary))
		{
			throw new Exception(" ReferenceLibrarySQLParser only parse ReferenceLibrary");
		}
		result = true;
		return result;
	}
}