package org.zml.schema.parser.olap;
import org.zml.schema.bind.Define;
public class DefineOlapParser extends OlapParser implements OlapParserAble
{
	public DefineOlapParser( Define element)
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
		if ( !(this.getQueryDefineElement() instanceof Define))
		{
			throw new Exception(" DefineOlapParser only parse Define");
		}
		result = true;
		return result;
	}
}