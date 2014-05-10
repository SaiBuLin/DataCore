package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.FormSet;
public class FormSetFormsetParser extends FormsetParser implements FormsetParserAble
{
	public FormSetFormsetParser( FormSet element)
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
		if ( !(this.getQueryDefineElement() instanceof FormSet))
		{
			throw new Exception(" FormSetFormsetParser only parse FormSet");
		}
		result = true;
		return result;
	}
}