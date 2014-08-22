package org.zml.form.parser;
import org.zml.form.bind.GroupBySection;
public class GroupBySectionFormParser extends FormParser implements FormParserAble
{
	public GroupBySectionFormParser( GroupBySection element)
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
		if ( !(this.getQueryDefineElement() instanceof GroupBySection))
		{
			throw new Exception(" GroupBySectionFormParser only parse GroupBySection");
		}
		result = true;
		return result;
	}
}