package org.zml.data.vo.parser;
import org.zml.data.vo.bind.Define;
public class DefineSQLParser extends SQLParser implements SQLParserAble
{
	public DefineSQLParser( Define element)
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
		if ( !(this.getQueryDefineElement() instanceof Define))
		{
			throw new Exception(" DefineSQLParser only parse Define");
		}
		result = true;
		return result;
	}
}