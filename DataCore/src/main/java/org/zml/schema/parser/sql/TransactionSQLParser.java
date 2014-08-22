package org.zml.schema.parser.sql;
import org.zml.schema.bind.Transaction;
public class TransactionSQLParser extends SQLParser implements SQLParserAble
{
	public TransactionSQLParser( Transaction element)
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
		if ( !(this.getQueryDefineElement() instanceof Transaction))
		{
			throw new Exception(" TransactionSQLParser only parse Transaction");
		}
		result = true;
		return result;
	}
}