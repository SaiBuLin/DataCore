package org.zml.schema.parser.olap;
import org.zml.schema.bind.LeftOuterJoin;
public class LeftOuterJoinOlapParser extends OlapParser implements OlapParserAble
{
	public LeftOuterJoinOlapParser( LeftOuterJoin element)
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
			throw new Exception(" LeftOuterJoinOlapParser only parse LeftOuterJoin");
		}
		result = true;
		return result;
	}
}