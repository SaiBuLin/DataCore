package org.zml.form.parser;
import org.zml.form.bind.ColumnSection;
public class ColumnSectionFormParser extends FormParser implements FormParserAble
{
	public ColumnSectionFormParser( ColumnSection element)
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
		if ( !(this.getQueryDefineElement() instanceof ColumnSection))
		{
			throw new Exception(" ColumnSectionFormParser only parse ColumnSection");
		}
		result = true;
		return result;
	}
}