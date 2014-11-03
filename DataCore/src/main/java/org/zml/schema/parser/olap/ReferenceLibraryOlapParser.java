package org.zml.schema.parser.olap;
import org.zml.schema.bind.ReferenceLibrary;
public class ReferenceLibraryOlapParser extends OlapParser implements OlapParserAble
{
	public ReferenceLibraryOlapParser( ReferenceLibrary element)
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
			throw new Exception(" ReferenceLibraryOlapParser only parse ReferenceLibrary");
		}
		result = true;
		return result;
	}
}