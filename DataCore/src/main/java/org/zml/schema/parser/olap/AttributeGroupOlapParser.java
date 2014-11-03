package org.zml.schema.parser.olap;
import org.zml.schema.bind.AttributeGroup;
public class AttributeGroupOlapParser extends OlapParser implements OlapParserAble
{
	public AttributeGroupOlapParser( AttributeGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof AttributeGroup))
		{
			throw new Exception(" AttributeGroupOlapParser only parse AttributeGroup");
		}
		result = true;
		return result;
	}
}