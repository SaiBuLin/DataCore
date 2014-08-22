package org.zml.form.parser;
import org.zml.form.bind.Column;
public class ColumnFormParser extends FormParser implements FormParserAble
{
	public ColumnFormParser( Column element)
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
		if ( !(this.getQueryDefineElement() instanceof Column))
		{
			throw new Exception(" ColumnFormParser only parse Column");
		}
		result = true;
		return result;
	}
}