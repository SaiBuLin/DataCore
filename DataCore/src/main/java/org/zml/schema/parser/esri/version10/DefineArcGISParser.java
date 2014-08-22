package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.Define;
public class DefineArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public DefineArcGISParser( Define element)
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
		if ( !(this.getQueryDefineElement() instanceof Define))
		{
			throw new Exception(" DefineArcGISParser only parse Define");
		}
		result = true;
		return result;
	}
}