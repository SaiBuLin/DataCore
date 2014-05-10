package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.FieldColumn;
public class FieldColumnFormsetParser extends FormsetParser implements FormsetParserAble
{
	public FieldColumnFormsetParser( FieldColumn element)
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
			throw new Exception(" FieldColumnFormsetParser only parse FieldColumn");
		}
		result = true;
		return result;
	}
}