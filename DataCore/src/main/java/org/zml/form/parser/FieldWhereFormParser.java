package org.zml.form.parser;
import org.zml.form.bind.FieldWhere;
public class FieldWhereFormParser extends FormParser implements FormParserAble
{
	public FieldWhereFormParser( FieldWhere element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldWhere))
		{
			throw new Exception(" FieldWhereFormParser only parse FieldWhere");
		}
		result = true;
		return result;
	}
}