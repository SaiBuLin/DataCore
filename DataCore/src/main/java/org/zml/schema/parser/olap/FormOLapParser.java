package org.zml.schema.parser.olap;
import org.zml.schema.bind.Form;
public class FormOLapParser extends OLapParser implements OLapParserAble
{
	public FormOLapParser( Form element)
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
		if ( !(this.getQueryDefineElement() instanceof Form))
		{
			throw new Exception(" FormOLapParser only parse Form");
		}
		result = true;
		return result;
	}
}