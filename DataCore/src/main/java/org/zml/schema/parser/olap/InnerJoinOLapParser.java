package org.zml.schema.parser.olap;
import org.zml.schema.bind.InnerJoin;
public class InnerJoinOLapParser extends OLapParser implements OLapParserAble
{
	public InnerJoinOLapParser( InnerJoin element)
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
		if ( !(this.getQueryDefineElement() instanceof InnerJoin))
		{
			throw new Exception(" InnerJoinOLapParser only parse InnerJoin");
		}
		result = true;
		return result;
	}
}