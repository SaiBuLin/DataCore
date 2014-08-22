package org.zml.schema.parser.olap;
import org.zml.schema.bind.Express;
public class ExpressOLapParser extends OLapParser implements OLapParserAble
{
	public ExpressOLapParser( Express element)
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
		if ( !(this.getQueryDefineElement() instanceof Express))
		{
			throw new Exception(" ExpressOLapParser only parse Express");
		}
		result = true;
		return result;
	}
}