package org.zml.schema.parser.olap;
import org.zml.schema.bind.RightOuterJoin;
public class RightOuterJoinOLapParser extends OLapParser implements OLapParserAble
{
	public RightOuterJoinOLapParser( RightOuterJoin element)
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
		if ( !(this.getQueryDefineElement() instanceof RightOuterJoin))
		{
			throw new Exception(" RightOuterJoinOLapParser only parse RightOuterJoin");
		}
		result = true;
		return result;
	}
}