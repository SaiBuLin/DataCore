package org.zml.form.parser;
import org.zml.form.bind.OrderBySection;
public class OrderBySectionFormParser extends FormParser implements FormParserAble
{
	public OrderBySectionFormParser( OrderBySection element)
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
			throw new Exception(" OrderBySectionFormParser only parse OrderBySection");
		}
		result = true;
		return result;
	}
}