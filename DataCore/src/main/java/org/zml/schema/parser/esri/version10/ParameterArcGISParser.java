package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.Parameter;
public class ParameterArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public ParameterArcGISParser( Parameter element)
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
		if ( !(this.getQueryDefineElement() instanceof Parameter))
		{
			throw new Exception(" ParameterArcGISParser only parse Parameter");
		}
		result = true;
		return result;
	}
}