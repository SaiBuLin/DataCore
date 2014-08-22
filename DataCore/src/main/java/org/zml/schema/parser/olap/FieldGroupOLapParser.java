package org.zml.schema.parser.olap;
import org.zml.schema.bind.FieldGroup;
public class FieldGroupOLapParser extends OLapParser implements OLapParserAble
{
	public FieldGroupOLapParser( FieldGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldGroup))
		{
			throw new Exception(" FieldGroupOLapParser only parse FieldGroup");
		}
		result = true;
		return result;
	}
}