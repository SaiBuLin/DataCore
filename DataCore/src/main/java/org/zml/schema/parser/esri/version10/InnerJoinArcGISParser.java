package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.InnerJoin;
public class InnerJoinArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public InnerJoinArcGISParser( InnerJoin element)
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
			throw new Exception(" InnerJoinArcGISParser only parse InnerJoin");
		}
		result = true;
		return result;
	}
}