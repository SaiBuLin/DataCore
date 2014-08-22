package org.zml.form.parser;
import org.zml.form.bind.FormSet;
public class FormSetFormParser extends FormParser implements FormParserAble
{
	public FormSetFormParser( FormSet element)
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
			throw new Exception(" FormSetFormParser only parse FormSet");
		}
		result = true;
		return result;
	}
}