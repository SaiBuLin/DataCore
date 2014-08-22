package org.zml.schema.parser.sql;
import org.zml.schema.bind.FieldsExpress;
public class FieldsExpressSQLParser extends SQLParser implements SQLParserAble
{
	public FieldsExpressSQLParser( FieldsExpress element)
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
			throw new Exception(" FieldsExpressSQLParser only parse FieldsExpress");
		}
		result = true;
		return result;
	}
}