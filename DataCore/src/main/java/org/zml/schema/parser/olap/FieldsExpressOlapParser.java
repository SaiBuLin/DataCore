package org.zml.schema.parser.olap;
import org.zml.schema.bind.FieldsExpress;
public class FieldsExpressOlapParser extends OlapParser implements OlapParserAble
{
	public FieldsExpressOlapParser( FieldsExpress element)
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
			throw new Exception(" FieldsExpressOlapParser only parse FieldsExpress");
		}
		result = true;
		return result;
	}
}