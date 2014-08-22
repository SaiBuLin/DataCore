package org.zml.schema.parser.olap;
import org.zml.schema.bind.Define;
public class DefineOLapParser extends OLapParser implements OLapParserAble
{
	public DefineOLapParser( Define element)
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
			throw new Exception(" DefineOLapParser only parse Define");
		}
		result = true;
		return result;
	}
}