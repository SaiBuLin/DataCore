package org.zml.form.parser;
import org.zml.form.bind.FormSetGroup;
public class FormSetGroupFormParser extends FormParser implements FormParserAble
{
	public FormSetGroupFormParser( FormSetGroup element)
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
			throw new Exception(" FormSetGroupFormParser only parse FormSetGroup");
		}
		result = true;
		return result;
	}
}