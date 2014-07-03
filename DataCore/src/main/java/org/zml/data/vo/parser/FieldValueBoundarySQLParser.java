package org.zml.data.vo.parser;
import org.zml.data.vo.bind.FieldValueBoundary;
public class FieldValueBoundarySQLParser extends SQLParser implements SQLParserAble
{
	public FieldValueBoundarySQLParser( FieldValueBoundary element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldValueBoundary))
		{
			throw new Exception(" FieldValueBoundarySQLParser only parse FieldValueBoundary");
		}
		result = true;
		return result;
	}
}