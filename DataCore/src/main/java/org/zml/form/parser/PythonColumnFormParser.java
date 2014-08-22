package org.zml.form.parser;
import org.zml.form.bind.PythonColumn;
public class PythonColumnFormParser extends FormParser implements FormParserAble
{
	public PythonColumnFormParser( PythonColumn element)
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
			throw new Exception(" PythonColumnFormParser only parse PythonColumn");
		}
		result = true;
		return result;
	}
}