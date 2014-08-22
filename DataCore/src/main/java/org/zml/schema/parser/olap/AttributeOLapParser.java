package org.zml.schema.parser.olap;
import org.zml.schema.bind.Attribute;
public class AttributeOLapParser extends OLapParser implements OLapParserAble
{
	public AttributeOLapParser( Attribute element)
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
			throw new Exception(" AttributeOLapParser only parse Attribute");
		}
		result = true;
		return result;
	}
}