package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.Insert;
public class InsertArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public InsertArcGISParser( Insert element)
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
		if ( !(this.getQueryDefineElement() instanceof Insert))
		{
			throw new Exception(" InsertArcGISParser only parse Insert");
		}
		result = true;
		return result;
	}
}