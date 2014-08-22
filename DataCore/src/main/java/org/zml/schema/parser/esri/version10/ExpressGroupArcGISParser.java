package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.ExpressGroup;
public class ExpressGroupArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public ExpressGroupArcGISParser( ExpressGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof ExpressGroup))
		{
			throw new Exception(" ExpressGroupArcGISParser only parse ExpressGroup");
		}
		result = true;
		return result;
	}
}