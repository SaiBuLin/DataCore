package org.zml.form.parser;
import org.zml.form.bind.Form;
public class FormFormParser extends FormParser implements FormParserAble
{
	public FormFormParser( Form element)
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
		if ( !(this.getQueryDefineElement() instanceof Form))
		{
			throw new Exception(" FormFormParser only parse Form");
		}
		result = true;
		return result;
	}
}