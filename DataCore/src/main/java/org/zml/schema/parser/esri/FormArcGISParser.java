package org.zml.schema.parser.ersi;
import org.zml.schema.bind.Form;
public class FormArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public FormArcGISParser( Form element)
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
			throw new Exception(" FormArcGISParser only parse Form");
		}
		result = true;
		return result;
	}
}