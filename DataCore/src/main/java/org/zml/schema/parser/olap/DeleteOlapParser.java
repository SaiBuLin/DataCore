package org.zml.schema.parser.olap;
import org.zml.schema.bind.Delete;
public class DeleteOlapParser extends OlapParser implements OlapParserAble
{
	public DeleteOlapParser( Delete element)
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
		if ( !(this.getQueryDefineElement() instanceof Delete))
		{
			throw new Exception(" DeleteOlapParser only parse Delete");
		}
		result = true;
		return result;
	}
}