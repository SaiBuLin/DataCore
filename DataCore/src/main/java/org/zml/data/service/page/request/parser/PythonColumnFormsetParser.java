package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.PythonColumn;
public class PythonColumnFormsetParser extends FormsetParser implements FormsetParserAble
{
	public PythonColumnFormsetParser( PythonColumn element)
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
		if ( !(this.getQueryDefineElement() instanceof PythonColumn))
		{
			throw new Exception(" PythonColumnFormsetParser only parse PythonColumn");
		}
		result = true;
		return result;
	}
}