package org.zml.schema.parser.ersi;
import org.zml.schema.bind.Update;
public class UpdateArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public UpdateArcGISParser( Update element)
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
		if ( !(this.getQueryDefineElement() instanceof Update))
		{
			throw new Exception(" UpdateArcGISParser only parse Update");
		}
		result = true;
		return result;
	}
}