package org.zml.schema.parser.ersi;
import org.zml.schema.bind.Factory;
public class FactoryArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public FactoryArcGISParser( Factory element)
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
		if ( !(this.getQueryDefineElement() instanceof Factory))
		{
			throw new Exception(" FactoryArcGISParser only parse Factory");
		}
		result = true;
		return result;
	}
}