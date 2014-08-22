package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.Query;
public class QueryArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public QueryArcGISParser( Query element)
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
		if ( !(this.getQueryDefineElement() instanceof Query))
		{
			throw new Exception(" QueryArcGISParser only parse Query");
		}
		result = true;
		return result;
	}
}