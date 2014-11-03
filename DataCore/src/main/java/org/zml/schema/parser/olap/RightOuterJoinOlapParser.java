package org.zml.schema.parser.olap;
import org.zml.schema.bind.RightOuterJoin;
public class RightOuterJoinOlapParser extends OlapParser implements OlapParserAble
{
	public RightOuterJoinOlapParser( RightOuterJoin element)
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
			throw new Exception(" RightOuterJoinOlapParser only parse RightOuterJoin");
		}
		result = true;
		return result;
	}
}