package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.FieldsExpress;
public class FieldsExpressArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public FieldsExpressArcGISParser( FieldsExpress element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldsExpress))
		{
			throw new Exception(" FieldsExpressArcGISParser only parse FieldsExpress");
		}
		result = true;
		return result;
	}
}