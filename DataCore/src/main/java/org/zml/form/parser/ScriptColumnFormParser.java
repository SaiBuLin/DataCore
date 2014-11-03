package org.zml.form.parser;
import org.zml.form.bind.ScriptColumn;
public class ScriptColumnFormParser extends FormParser implements FormParserAble
{
	public ScriptColumnFormParser( ScriptColumn element)
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
		if ( !(this.getQueryDefineElement() instanceof ScriptColumn))
		{
			throw new Exception(" ScriptColumnFormParser only parse ScriptColumn");
		}
		result = true;
		return result;
	}
}