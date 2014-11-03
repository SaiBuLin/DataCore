package org.zml.schema.parser.olap;
import org.zml.schema.bind.DataService;
public class DataServiceOlapParser extends OlapParser implements OlapParserAble
{
	public DataServiceOlapParser( DataService element)
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
		if ( !(this.getQueryDefineElement() instanceof DataService))
		{
			throw new Exception(" DataServiceOlapParser only parse DataService");
		}
		result = true;
		return result;
	}
}