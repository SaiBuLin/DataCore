package org.zml.form.parser;
import org.zml.form.bind.GroupbyColumn;
public class GroupbyColumnFormParser extends FormParser implements FormParserAble
{
	public GroupbyColumnFormParser( GroupbyColumn element)
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
		if ( !(this.getQueryDefineElement() instanceof GroupbyColumn))
		{
			throw new Exception(" GroupbyColumnFormParser only parse GroupbyColumn");
		}
		result = true;
		return result;
	}
}