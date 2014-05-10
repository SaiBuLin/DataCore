package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.ColumnGroup;
public class ColumnGroupFormsetParser extends FormsetParser implements FormsetParserAble
{
	public ColumnGroupFormsetParser( ColumnGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof ColumnGroup))
		{
			throw new Exception(" ColumnGroupFormsetParser only parse ColumnGroup");
		}
		result = true;
		return result;
	}
}