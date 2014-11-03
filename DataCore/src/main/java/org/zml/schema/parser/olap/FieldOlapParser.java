package org.zml.schema.parser.olap;
import org.zml.schema.bind.Field;
public class FieldOlapParser extends OlapParser implements OlapParserAble
{
	public FieldOlapParser( Field element)
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
		if ( !(this.getQueryDefineElement() instanceof Field))
		{
			throw new Exception(" FieldOlapParser only parse Field");
		}
		result = true;
		return result;
	}
}