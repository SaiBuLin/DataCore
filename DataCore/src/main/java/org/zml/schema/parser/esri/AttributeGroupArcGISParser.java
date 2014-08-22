package org.zml.schema.parser.ersi;
import org.zml.schema.bind.AttributeGroup;
public class AttributeGroupArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public AttributeGroupArcGISParser( AttributeGroup element)
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
			throw new Exception(" AttributeGroupArcGISParser only parse AttributeGroup");
		}
		result = true;
		return result;
	}
}