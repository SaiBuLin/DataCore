package org.zml.schema.parser.olap;
import org.zml.schema.bind.SchemaDefine;
public class SchemaDefineOlapParser extends OlapParser implements OlapParserAble
{
	public SchemaDefineOlapParser( SchemaDefine element)
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
		if ( !(this.getQueryDefineElement() instanceof SchemaDefine))
		{
			throw new Exception(" SchemaDefineOlapParser only parse SchemaDefine");
		}
		result = true;
		return result;
	}
}