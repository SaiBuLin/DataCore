package org.zml.form.parser;
import org.zml.form.bind.SQLFormService;
public class SQLFormServiceFormParser extends FormParser implements FormParserAble
{
	public SQLFormServiceFormParser( SQLFormService element)
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
		if ( !(this.getQueryDefineElement() instanceof SQLFormService))
		{
			throw new Exception(" SQLFormServiceFormParser only parse SQLFormService");
		}
		result = true;
		return result;
	}
}