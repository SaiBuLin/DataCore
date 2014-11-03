package org.zml.form.parser;
import org.zml.form.bind.OrderColumn;
public class OrderColumnFormParser extends FormParser implements FormParserAble
{
	public OrderColumnFormParser( OrderColumn element)
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
		if ( !(this.getQueryDefineElement() instanceof OrderColumn))
		{
			throw new Exception(" OrderColumnFormParser only parse OrderColumn");
		}
		result = true;
		return result;
	}
}