package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.ViewRelation;
public class ViewRelationArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public ViewRelationArcGISParser( ViewRelation element)
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
		if ( !(this.getQueryDefineElement() instanceof ViewRelation))
		{
			throw new Exception(" ViewRelationArcGISParser only parse ViewRelation");
		}
		result = true;
		return result;
	}
}