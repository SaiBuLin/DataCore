package org.zml.schema.parser.olap;
import org.zml.schema.bind.LeftOuterJoin;
public class LeftOuterJoinOLapParser extends OLapParser implements OLapParserAble
{
	public LeftOuterJoinOLapParser( LeftOuterJoin element)
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
		if ( !(this.getQueryDefineElement() instanceof LeftOuterJoin))
		{
			throw new Exception(" LeftOuterJoinOLapParser only parse LeftOuterJoin");
		}
		result = true;
		return result;
	}
}