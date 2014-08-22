package org.zml.schema.parser.olap;
import org.zml.schema.bind.FieldsExpress;
public class FieldsExpressOLapParser extends OLapParser implements OLapParserAble
{
	public FieldsExpressOLapParser( FieldsExpress element)
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
			throw new Exception(" FieldsExpressOLapParser only parse FieldsExpress");
		}
		result = true;
		return result;
	}
}