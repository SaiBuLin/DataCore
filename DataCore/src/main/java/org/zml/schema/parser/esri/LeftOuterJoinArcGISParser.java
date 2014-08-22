package org.zml.schema.parser.ersi;
import org.zml.schema.bind.LeftOuterJoin;
public class LeftOuterJoinArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public LeftOuterJoinArcGISParser( LeftOuterJoin element)
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
			throw new Exception(" LeftOuterJoinArcGISParser only parse LeftOuterJoin");
		}
		result = true;
		return result;
	}
}