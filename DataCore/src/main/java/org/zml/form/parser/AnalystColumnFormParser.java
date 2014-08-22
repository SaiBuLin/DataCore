package org.zml.form.parser;
import org.zml.form.bind.AnalystColumn;
public class AnalystColumnFormParser extends FormParser implements FormParserAble
{
	public AnalystColumnFormParser( AnalystColumn element)
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
			throw new Exception(" AnalystColumnFormParser only parse AnalystColumn");
		}
		result = true;
		return result;
	}
}