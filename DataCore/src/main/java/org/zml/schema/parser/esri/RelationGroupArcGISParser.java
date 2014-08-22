package org.zml.schema.parser.ersi;
import org.zml.schema.bind.RelationGroup;
public class RelationGroupArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public RelationGroupArcGISParser( RelationGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof RelationGroup))
		{
			throw new Exception(" RelationGroupArcGISParser only parse RelationGroup");
		}
		result = true;
		return result;
	}
}