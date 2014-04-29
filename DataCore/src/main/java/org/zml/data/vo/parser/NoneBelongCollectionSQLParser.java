package org.zml.data.vo.parser;
import org.zml.data.vo.bind.NoneBelongCollection;
public class NoneBelongCollectionSQLParser extends SQLParser implements SQLParserAble
{
	public NoneBelongCollectionSQLParser( NoneBelongCollection element)
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
		if ( !(this.getQueryDefineElement() instanceof NoneBelongCollection))
		{
			throw new Exception(" NoneBelongCollectionSQLParser only parse NoneBelongCollection");
		}
		result = true;
		return result;
	}
}