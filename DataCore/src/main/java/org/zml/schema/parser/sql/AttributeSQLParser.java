package org.zml.schema.parser.sql;
import org.zml.schema.bind.Attribute;
public class AttributeSQLParser extends SQLParser implements SQLParserAble
{
	public AttributeSQLParser( Attribute element)
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
		if ( !(this.getQueryDefineElement() instanceof Attribute))
		{
			throw new Exception(" AttributeSQLParser only parse Attribute");
		}
		result = true;
		return result;
	}
}