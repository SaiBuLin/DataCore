package org.zml.form.parser;
import org.zml.form.bind.VOSource;
public class VOSourceFormParser extends FormParser implements FormParserAble
{
	public VOSourceFormParser( VOSource element)
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
			throw new Exception(" VOSourceFormParser only parse VOSource");
		}
		result = true;
		return result;
	}
}