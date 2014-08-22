package org.zml.schema.parser.sql;
import org.zml.schema.bind.AttributeGroup;
public class AttributeGroupSQLParser extends SQLParser implements SQLParserAble
{
	public AttributeGroupSQLParser( AttributeGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof AttributeGroup))
		{
			throw new Exception(" AttributeGroupSQLParser only parse AttributeGroup");
		}
		result = true;
		return result;
	}
}