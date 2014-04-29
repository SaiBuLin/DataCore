package org.zml.data.vo.parser;
import org.zml.data.vo.bind.TemplateSet;
public class TemplateSetSQLParser extends SQLParser implements SQLParserAble
{
	public TemplateSetSQLParser( TemplateSet element)
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
		if ( !(this.getQueryDefineElement() instanceof TemplateSet))
		{
			throw new Exception(" TemplateSetSQLParser only parse TemplateSet");
		}
		result = true;
		return result;
	}
}