package org.zml.data.vo.parser;
import org.zml.data.vo.bind.FieldsBoundary;
public class FieldsBoundarySQLParser extends SQLParser implements SQLParserAble
{
	public FieldsBoundarySQLParser( FieldsBoundary element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldsBoundary))
		{
			throw new Exception(" FieldsBoundarySQLParser only parse FieldsBoundary");
		}
		result = true;
		return result;
	}
}