package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.AnalystColumn;
public class AnalystColumnFormsetParser extends FormsetParser implements FormsetParserAble
{
	public AnalystColumnFormsetParser( AnalystColumn element)
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
		if ( !(this.getQueryDefineElement() instanceof AnalystColumn))
		{
			throw new Exception(" AnalystColumnFormsetParser only parse AnalystColumn");
		}
		result = true;
		return result;
	}
}