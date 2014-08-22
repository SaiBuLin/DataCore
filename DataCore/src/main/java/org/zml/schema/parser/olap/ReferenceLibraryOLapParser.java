package org.zml.schema.parser.olap;
import org.zml.schema.bind.ReferenceLibrary;
public class ReferenceLibraryOLapParser extends OLapParser implements OLapParserAble
{
	public ReferenceLibraryOLapParser( ReferenceLibrary element)
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
		if ( !(this.getQueryDefineElement() instanceof ReferenceLibrary))
		{
			throw new Exception(" ReferenceLibraryOLapParser only parse ReferenceLibrary");
		}
		result = true;
		return result;
	}
}