package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.FormSetGroup;
public class FormSetGroupFormsetParser extends FormsetParser implements FormsetParserAble
{
	public FormSetGroupFormsetParser( FormSetGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof FormSetGroup))
		{
			throw new Exception(" FormSetGroupFormsetParser only parse FormSetGroup");
		}
		result = true;
		return result;
	}
}