package org.zml.form.parser;
import org.zml.form.bind.OrderByColumn;
public class OrderByColumnFormParser extends FormParser implements FormParserAble
{
	public OrderByColumnFormParser( OrderByColumn element)
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
		if ( !(this.getQueryDefineElement() instanceof OrderByColumn))
		{
			throw new Exception(" OrderByColumnFormParser only parse OrderByColumn");
		}
		result = true;
		return result;
	}
}