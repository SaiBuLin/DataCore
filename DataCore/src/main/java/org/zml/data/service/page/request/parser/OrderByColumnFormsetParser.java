package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.OrderByColumn;
public class OrderByColumnFormsetParser extends FormsetParser implements FormsetParserAble
{
	public OrderByColumnFormsetParser( OrderByColumn element)
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
			throw new Exception(" OrderByColumnFormsetParser only parse OrderByColumn");
		}
		result = true;
		return result;
	}
}