package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.RightOuterJoin;
public class RightOuterJoinArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public RightOuterJoinArcGISParser( RightOuterJoin element)
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
			throw new Exception(" RightOuterJoinArcGISParser only parse RightOuterJoin");
		}
		result = true;
		return result;
	}
}