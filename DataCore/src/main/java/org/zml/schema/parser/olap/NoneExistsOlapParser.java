package org.zml.schema.parser.olap;
import org.zml.schema.bind.NoneExists;
public class NoneExistsOlapParser extends OlapParser implements OlapParserAble
{
	public NoneExistsOlapParser( NoneExists element)
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
		if ( !(this.getQueryDefineElement() instanceof NoneExists))
		{
			throw new Exception(" NoneExistsOlapParser only parse NoneExists");
		}
		result = true;
		return result;
	}
}