package org.zml.schema.parser.olap;
import org.zml.schema.bind.AttributeGroup;
public class AttributeGroupOLapParser extends OLapParser implements OLapParserAble
{
	public AttributeGroupOLapParser( AttributeGroup element)
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
			throw new Exception(" AttributeGroupOLapParser only parse AttributeGroup");
		}
		result = true;
		return result;
	}
}