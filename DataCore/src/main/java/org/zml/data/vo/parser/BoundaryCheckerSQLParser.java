package org.zml.data.vo.parser;
import org.zml.data.vo.bind.BoundaryChecker;
public class BoundaryCheckerSQLParser extends SQLParser implements SQLParserAble
{
	public BoundaryCheckerSQLParser( BoundaryChecker element)
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
		if ( !(this.getQueryDefineElement() instanceof BoundaryChecker))
		{
			throw new Exception(" BoundaryCheckerSQLParser only parse BoundaryChecker");
		}
		result = true;
		return result;
	}
}