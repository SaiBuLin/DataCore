package org.zml.schema.parser.olap;
import org.zml.schema.bind.ExpressGroup;
public class ExpressGroupOLapParser extends OLapParser implements OLapParserAble
{
	public ExpressGroupOLapParser( ExpressGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof ExpressGroup))
		{
			throw new Exception(" ExpressGroupOLapParser only parse ExpressGroup");
		}
		result = true;
		return result;
	}
}