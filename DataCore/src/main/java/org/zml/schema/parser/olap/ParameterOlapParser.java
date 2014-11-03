package org.zml.schema.parser.olap;
import org.zml.schema.bind.Parameter;
public class ParameterOlapParser extends OlapParser implements OlapParserAble
{
	public ParameterOlapParser( Parameter element)
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
			throw new Exception(" ParameterOlapParser only parse Parameter");
		}
		result = true;
		return result;
	}
}