package org.zml.schema.parser.olap;
import org.zml.schema.bind.AttributeLibrary;
public class AttributeLibraryOlapParser extends OlapParser implements OlapParserAble
{
	public AttributeLibraryOlapParser( AttributeLibrary element)
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
		if ( !(this.getQueryDefineElement() instanceof AttributeLibrary))
		{
			throw new Exception(" AttributeLibraryOlapParser only parse AttributeLibrary");
		}
		result = true;
		return result;
	}
}