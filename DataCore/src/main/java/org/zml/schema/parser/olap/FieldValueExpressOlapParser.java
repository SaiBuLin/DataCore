package org.zml.schema.parser.olap;
import org.zml.schema.bind.FieldValueExpress;
public class FieldValueExpressOlapParser extends OlapParser implements OlapParserAble
{
	public FieldValueExpressOlapParser( FieldValueExpress element)
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
			throw new Exception(" FieldValueExpressOlapParser only parse FieldValueExpress");
		}
		result = true;
		return result;
	}
}