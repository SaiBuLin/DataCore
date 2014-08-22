package org.zml.form.parser;
import org.zml.form.bind.ColumnGroup;
public class ColumnGroupFormParser extends FormParser implements FormParserAble
{
	public ColumnGroupFormParser( ColumnGroup element)
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
			throw new Exception(" ColumnGroupFormParser only parse ColumnGroup");
		}
		result = true;
		return result;
	}
}