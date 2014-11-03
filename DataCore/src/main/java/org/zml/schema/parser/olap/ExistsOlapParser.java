package org.zml.schema.parser.olap;
import org.zml.schema.bind.Exists;
public class ExistsOlapParser extends OlapParser implements OlapParserAble
{
	public ExistsOlapParser( Exists element)
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
		if ( !(this.getQueryDefineElement() instanceof Exists))
		{
			throw new Exception(" ExistsOlapParser only parse Exists");
		}
		result = true;
		return result;
	}
}