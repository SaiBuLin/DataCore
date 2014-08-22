package org.zml.schema.parser.olap;
import org.zml.schema.bind.SchemaDefine;
public class SchemaDefineOLapParser extends OLapParser implements OLapParserAble
{
	public SchemaDefineOLapParser( SchemaDefine element)
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
		if ( !(this.getQueryDefineElement() instanceof SchemaDefine))
		{
			throw new Exception(" SchemaDefineOLapParser only parse SchemaDefine");
		}
		result = true;
		return result;
	}
}