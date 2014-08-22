package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.View;
public class ViewArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public ViewArcGISParser( View element)
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
		if ( !(this.getQueryDefineElement() instanceof View))
		{
			throw new Exception(" ViewArcGISParser only parse View");
		}
		result = true;
		return result;
	}
}