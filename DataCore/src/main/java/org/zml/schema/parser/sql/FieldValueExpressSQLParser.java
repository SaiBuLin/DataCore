package org.zml.schema.parser.sql;
import org.zml.schema.bind.FieldValueExpress;
public class FieldValueExpressSQLParser extends SQLParser implements SQLParserAble
{
	public FieldValueExpressSQLParser( FieldValueExpress element)
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
			throw new Exception(" FieldValueExpressSQLParser only parse FieldValueExpress");
		}
		result = true;
		return result;
	}
}