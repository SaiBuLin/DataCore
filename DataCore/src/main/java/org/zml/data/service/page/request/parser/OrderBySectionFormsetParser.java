package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.OrderBySection;
public class OrderBySectionFormsetParser extends FormsetParser implements FormsetParserAble
{
	public OrderBySectionFormsetParser( OrderBySection element)
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
		if ( !(this.getQueryDefineElement() instanceof OrderBySection))
		{
			throw new Exception(" OrderBySectionFormsetParser only parse OrderBySection");
		}
		result = true;
		return result;
	}
}