package org.zml.data.vo.parser;
import org.zml.data.vo.bind.ValidatorGroup;
public class ValidatorGroupSQLParser extends SQLParser implements SQLParserAble
{
	public ValidatorGroupSQLParser( ValidatorGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof ValidatorGroup))
		{
			throw new Exception(" ValidatorGroupSQLParser only parse ValidatorGroup");
		}
		result = true;
		return result;
	}
}