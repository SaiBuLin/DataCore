package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.Column;
public class ColumnFormsetParser extends FormsetParser implements FormsetParserAble
{
	public ColumnFormsetParser( Column element)
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
			throw new Exception(" ColumnFormsetParser only parse Column");
		}
		result = true;
		return result;
	}
}