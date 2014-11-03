package org.zml.form.parser;
import org.zml.form.bind.FieldColumn;
public class FieldColumnFormParser extends FormParser implements FormParserAble
{
	public FieldColumnFormParser( FieldColumn element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldColumn))
		{
			throw new Exception(" FieldColumnFormParser only parse FieldColumn");
		}
		result = true;
		return result;
	}
}