package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.VOSource;
public class VOSourceFormsetParser extends FormsetParser implements FormsetParserAble
{
	public VOSourceFormsetParser( VOSource element)
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
		if ( !(this.getQueryDefineElement() instanceof VOSource))
		{
			throw new Exception(" VOSourceFormsetParser only parse VOSource");
		}
		result = true;
		return result;
	}
}