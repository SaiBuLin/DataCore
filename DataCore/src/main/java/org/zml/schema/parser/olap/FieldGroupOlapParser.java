package org.zml.schema.parser.olap;
import org.zml.schema.bind.FieldGroup;
public class FieldGroupOlapParser extends OlapParser implements OlapParserAble
{
	public FieldGroupOlapParser( FieldGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldGroup))
		{
			throw new Exception(" FieldGroupOlapParser only parse FieldGroup");
		}
		result = true;
		return result;
	}
}