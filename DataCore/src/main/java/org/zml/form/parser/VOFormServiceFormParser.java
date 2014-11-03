package org.zml.form.parser;
import org.zml.form.bind.VOFormService;
public class VOFormServiceFormParser extends FormParser implements FormParserAble
{
	public VOFormServiceFormParser( VOFormService element)
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
		if ( !(this.getQueryDefineElement() instanceof VOFormService))
		{
			throw new Exception(" VOFormServiceFormParser only parse VOFormService");
		}
		result = true;
		return result;
	}
}