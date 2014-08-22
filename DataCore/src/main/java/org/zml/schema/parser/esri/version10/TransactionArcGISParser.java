package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.Transaction;
public class TransactionArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public TransactionArcGISParser( Transaction element)
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
			throw new Exception(" TransactionArcGISParser only parse Transaction");
		}
		result = true;
		return result;
	}
}