package org.zml.schema.parser.olap;
import org.zml.schema.bind.Parameter;
public class ParameterOLapParser extends OLapParser implements OLapParserAble
{
	public ParameterOLapParser( Parameter element)
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
			throw new Exception(" ParameterOLapParser only parse Parameter");
		}
		result = true;
		return result;
	}
}