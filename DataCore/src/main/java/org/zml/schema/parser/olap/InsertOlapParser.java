package org.zml.schema.parser.olap;
import org.zml.schema.bind.Insert;
public class InsertOlapParser extends OlapParser implements OlapParserAble
{
	public InsertOlapParser( Insert element)
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
		if ( !(this.getQueryDefineElement() instanceof Insert))
		{
			throw new Exception(" InsertOlapParser only parse Insert");
		}
		result = true;
		return result;
	}
}