package org.zml.schema.parser.olap;
import org.zml.schema.bind.FormLibrary;
public class FormLibraryOlapParser extends OlapParser implements OlapParserAble
{
	public FormLibraryOlapParser( FormLibrary element)
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
			throw new Exception(" FormLibraryOlapParser only parse FormLibrary");
		}
		result = true;
		return result;
	}
}