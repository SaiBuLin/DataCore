package org.zml.schema.parser.olap;
import org.zml.schema.bind.PageFactory;
public class PageFactoryOlapParser extends OlapParser implements OlapParserAble
{
	public PageFactoryOlapParser( PageFactory element)
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
		if ( !(this.getQueryDefineElement() instanceof PageFactory))
		{
			throw new Exception(" PageFactoryOlapParser only parse PageFactory");
		}
		result = true;
		return result;
	}
}