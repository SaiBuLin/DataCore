package org.zml.schema.parser.olap;
import org.zml.schema.bind.NoneExists;
public class NoneExistsOLapParser extends OLapParser implements OLapParserAble
{
	public NoneExistsOLapParser( NoneExists element)
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
			throw new Exception(" NoneExistsOLapParser only parse NoneExists");
		}
		result = true;
		return result;
	}
}