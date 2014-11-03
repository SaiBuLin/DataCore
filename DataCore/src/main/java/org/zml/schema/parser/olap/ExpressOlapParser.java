package org.zml.schema.parser.olap;
import org.zml.schema.bind.Express;
public class ExpressOlapParser extends OlapParser implements OlapParserAble
{
	public ExpressOlapParser( Express element)
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
		if ( !(this.getQueryDefineElement() instanceof Express))
		{
			throw new Exception(" ExpressOlapParser only parse Express");
		}
		result = true;
		return result;
	}
}