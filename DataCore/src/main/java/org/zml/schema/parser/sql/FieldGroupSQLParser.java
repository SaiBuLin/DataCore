package org.zml.schema.parser.sql;
import org.zml.schema.bind.FieldGroup;
public class FieldGroupSQLParser extends SQLParser implements SQLParserAble
{
	public FieldGroupSQLParser( FieldGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldGroup))
		{
			throw new Exception(" FieldGroupSQLParser only parse FieldGroup");
		}
		result = true;
		return result;
	}
}