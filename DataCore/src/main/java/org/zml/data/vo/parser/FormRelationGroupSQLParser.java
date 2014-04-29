package org.zml.data.vo.parser;
import org.zml.data.vo.bind.FormRelationGroup;
public class FormRelationGroupSQLParser extends SQLParser implements SQLParserAble
{
	public FormRelationGroupSQLParser( FormRelationGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof FormRelationGroup))
		{
			throw new Exception(" FormRelationGroupSQLParser only parse FormRelationGroup");
		}
		result = true;
		return result;
	}
}