package org.zml.schema.parser.ersi;
import org.zml.schema.bind.NoneExists;
public class NoneExistsArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public NoneExistsArcGISParser( NoneExists element)
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
		if ( !(this.getQueryDefineElement() instanceof NoneExists))
		{
			throw new Exception(" NoneExistsArcGISParser only parse NoneExists");
		}
		result = true;
		return result;
	}
}