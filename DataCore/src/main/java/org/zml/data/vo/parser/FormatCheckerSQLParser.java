package org.zml.data.vo.parser;
import org.zml.data.vo.bind.FormatChecker;
public class FormatCheckerSQLParser extends SQLParser implements SQLParserAble
{
	public FormatCheckerSQLParser( FormatChecker element)
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
		if ( !(this.getQueryDefineElement() instanceof FormatChecker))
		{
			throw new Exception(" FormatCheckerSQLParser only parse FormatChecker");
		}
		result = true;
		return result;
	}
}