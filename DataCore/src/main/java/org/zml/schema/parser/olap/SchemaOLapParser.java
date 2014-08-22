package org.zml.schema.parser.olap;
import org.zml.schema.bind.Schema;
public class SchemaOLapParser extends OLapParser implements OLapParserAble
{
	public SchemaOLapParser( Schema element)
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
		if ( !(this.getQueryDefineElement() instanceof Schema))
		{
			throw new Exception(" SchemaOLapParser only parse Schema");
		}
		result = true;
		return result;
	}
}