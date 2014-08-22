package org.zml.schema.parser.olap;
import org.zml.schema.bind.SchemaGroup;
public class SchemaGroupOLapParser extends OLapParser implements OLapParserAble
{
	public SchemaGroupOLapParser( SchemaGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof SchemaGroup))
		{
			throw new Exception(" SchemaGroupOLapParser only parse SchemaGroup");
		}
		result = true;
		return result;
	}
}