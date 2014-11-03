package org.zml.schema.parser.olap;
import org.zml.schema.bind.SchemaGroup;
public class SchemaGroupOlapParser extends OlapParser implements OlapParserAble
{
	public SchemaGroupOlapParser( SchemaGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof SchemaGroup))
		{
			throw new Exception(" SchemaGroupOlapParser only parse SchemaGroup");
		}
		result = true;
		return result;
	}
}