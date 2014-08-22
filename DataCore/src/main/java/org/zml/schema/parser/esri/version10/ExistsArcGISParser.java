package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.Exists;
public class ExistsArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public ExistsArcGISParser( Exists element)
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
		if ( !(this.getQueryDefineElement() instanceof Exists))
		{
			throw new Exception(" ExistsArcGISParser only parse Exists");
		}
		result = true;
		return result;
	}
}