package org.zml.data.vo.parser;
import org.zml.data.vo.bind.BelongCollection;
public class BelongCollectionSQLParser extends SQLParser implements SQLParserAble
{
	public BelongCollectionSQLParser( BelongCollection element)
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
		if ( !(this.getQueryDefineElement() instanceof BelongCollection))
		{
			throw new Exception(" BelongCollectionSQLParser only parse BelongCollection");
		}
		result = true;
		return result;
	}
}