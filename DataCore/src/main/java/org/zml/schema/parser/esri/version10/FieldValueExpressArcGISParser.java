package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.FieldValueExpress;
public class FieldValueExpressArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public FieldValueExpressArcGISParser( FieldValueExpress element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldValueExpress))
		{
			throw new Exception(" FieldValueExpressArcGISParser only parse FieldValueExpress");
		}
		result = true;
		return result;
	}
}