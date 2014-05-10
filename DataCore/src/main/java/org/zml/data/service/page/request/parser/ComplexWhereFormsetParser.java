package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.ComplexWhere;
public class ComplexWhereFormsetParser extends FormsetParser implements FormsetParserAble
{
	public ComplexWhereFormsetParser( ComplexWhere element)
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
			throw new Exception(" ComplexWhereFormsetParser only parse ComplexWhere");
		}
		result = true;
		return result;
	}
}