package org.zml.form.parser;
import org.zml.form.bind.ComplexWhere;
public class ComplexWhereFormParser extends FormParser implements FormParserAble
{
	public ComplexWhereFormParser( ComplexWhere element)
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
		if ( !(this.getQueryDefineElement() instanceof ComplexWhere))
		{
			throw new Exception(" ComplexWhereFormParser only parse ComplexWhere");
		}
		result = true;
		return result;
	}
}