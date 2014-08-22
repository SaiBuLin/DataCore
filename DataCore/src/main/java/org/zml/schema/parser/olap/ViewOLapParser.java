package org.zml.schema.parser.olap;
import org.zml.schema.bind.View;
public class ViewOLapParser extends OLapParser implements OLapParserAble
{
	public ViewOLapParser( View element)
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
		if ( !(this.getQueryDefineElement() instanceof View))
		{
			throw new Exception(" ViewOLapParser only parse View");
		}
		result = true;
		return result;
	}
}