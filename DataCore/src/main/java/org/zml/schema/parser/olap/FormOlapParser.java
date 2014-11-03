package org.zml.schema.parser.olap;
import org.zml.schema.bind.Form;
public class FormOlapParser extends OlapParser implements OlapParserAble
{
	public FormOlapParser( Form element)
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
			throw new Exception(" FormOlapParser only parse Form");
		}
		result = true;
		return result;
	}
}