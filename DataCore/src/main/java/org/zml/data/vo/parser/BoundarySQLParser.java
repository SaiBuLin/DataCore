package org.zml.data.vo.parser;
import org.zml.data.vo.bind.Boundary;
public class BoundarySQLParser extends SQLParser implements SQLParserAble
{
	public BoundarySQLParser( Boundary element)
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
		if ( !(this.getQueryDefineElement() instanceof Boundary))
		{
			throw new Exception(" BoundarySQLParser only parse Boundary");
		}
		result = true;
		return result;
	}
}