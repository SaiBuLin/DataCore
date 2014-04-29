package org.zml.data.vo.parser;
import org.zml.data.vo.bind.Validator;
public class ValidatorSQLParser extends SQLParser implements SQLParserAble
{
	public ValidatorSQLParser( Validator element)
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
		if ( !(this.getQueryDefineElement() instanceof Validator))
		{
			throw new Exception(" ValidatorSQLParser only parse Validator");
		}
		result = true;
		return result;
	}
}