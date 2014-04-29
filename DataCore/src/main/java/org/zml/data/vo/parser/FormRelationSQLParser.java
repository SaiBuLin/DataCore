package org.zml.data.vo.parser;
import org.zml.data.vo.bind.FormRelation;
public class FormRelationSQLParser extends SQLParser implements SQLParserAble
{
	public FormRelationSQLParser( FormRelation element)
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
		if ( !(this.getQueryDefineElement() instanceof FormRelation))
		{
			throw new Exception(" FormRelationSQLParser only parse FormRelation");
		}
		result = true;
		return result;
	}
}