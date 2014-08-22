package org.zml.schema.parser.sql;
import org.zml.schema.bind.AttributeLibrary;
public class AttributeLibrarySQLParser extends SQLParser implements SQLParserAble
{
	public AttributeLibrarySQLParser( AttributeLibrary element)
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
		if ( !(this.getQueryDefineElement() instanceof AttributeLibrary))
		{
			throw new Exception(" AttributeLibrarySQLParser only parse AttributeLibrary");
		}
		result = true;
		return result;
	}
}