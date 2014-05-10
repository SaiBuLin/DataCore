package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.FieldWhere;
public class FieldWhereFormsetParser extends FormsetParser implements FormsetParserAble
{
	public FieldWhereFormsetParser( FieldWhere element)
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
			throw new Exception(" FieldWhereFormsetParser only parse FieldWhere");
		}
		result = true;
		return result;
	}
}