package org.zml.schema.parser.ersi;
import org.zml.schema.bind.Filter;
public class FilterArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public FilterArcGISParser( Filter element)
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
		if ( !(this.getQueryDefineElement() instanceof Filter))
		{
			throw new Exception(" FilterArcGISParser only parse Filter");
		}
		result = true;
		return result;
	}
}