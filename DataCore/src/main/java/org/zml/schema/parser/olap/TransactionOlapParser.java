package org.zml.schema.parser.olap;
import org.zml.schema.bind.Transaction;
public class TransactionOlapParser extends OlapParser implements OlapParserAble
{
	public TransactionOlapParser( Transaction element)
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
			throw new Exception(" TransactionOlapParser only parse Transaction");
		}
		result = true;
		return result;
	}
}