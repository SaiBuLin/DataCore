package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.PageFactory;
public class PageFactoryArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public PageFactoryArcGISParser( PageFactory element)
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
		if ( !(this.getQueryDefineElement() instanceof PageFactory))
		{
			throw new Exception(" PageFactoryArcGISParser only parse PageFactory");
		}
		result = true;
		return result;
	}
}