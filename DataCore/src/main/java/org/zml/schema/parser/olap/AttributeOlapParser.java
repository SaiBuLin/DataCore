package org.zml.schema.parser.olap;
import org.zml.schema.bind.Attribute;
public class AttributeOlapParser extends OlapParser implements OlapParserAble
{
	public AttributeOlapParser( Attribute element)
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
			throw new Exception(" AttributeOlapParser only parse Attribute");
		}
		result = true;
		return result;
	}
}