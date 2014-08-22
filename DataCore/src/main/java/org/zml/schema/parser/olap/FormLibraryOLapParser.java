package org.zml.schema.parser.olap;
import org.zml.schema.bind.FormLibrary;
public class FormLibraryOLapParser extends OLapParser implements OLapParserAble
{
	public FormLibraryOLapParser( FormLibrary element)
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
		if ( !(this.getQueryDefineElement() instanceof FormLibrary))
		{
			throw new Exception(" FormLibraryOLapParser only parse FormLibrary");
		}
		result = true;
		return result;
	}
}