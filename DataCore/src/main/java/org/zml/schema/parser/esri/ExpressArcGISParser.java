package org.zml.schema.parser.ersi;
import org.zml.schema.bind.Express;
public class ExpressArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public ExpressArcGISParser( Express element)
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
		if ( !(this.getQueryDefineElement() instanceof Express))
		{
			throw new Exception(" ExpressArcGISParser only parse Express");
		}
		result = true;
		return result;
	}
}