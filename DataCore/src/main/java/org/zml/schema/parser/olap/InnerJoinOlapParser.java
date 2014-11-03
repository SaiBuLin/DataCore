package org.zml.schema.parser.olap;
import org.zml.schema.bind.InnerJoin;
public class InnerJoinOlapParser extends OlapParser implements OlapParserAble
{
	public InnerJoinOlapParser( InnerJoin element)
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
			throw new Exception(" InnerJoinOlapParser only parse InnerJoin");
		}
		result = true;
		return result;
	}
}