package org.zml.data.vo.parser;
import org.zml.data.vo.bind.ExtendMethodChecker;
public class ExtendMethodCheckerSQLParser extends SQLParser implements SQLParserAble
{
	public ExtendMethodCheckerSQLParser( ExtendMethodChecker element)
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
		if ( !(this.getQueryDefineElement() instanceof ExtendMethodChecker))
		{
			throw new Exception(" ExtendMethodCheckerSQLParser only parse ExtendMethodChecker");
		}
		result = true;
		return result;
	}
}