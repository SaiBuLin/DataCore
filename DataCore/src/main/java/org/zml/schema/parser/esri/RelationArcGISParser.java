package org.zml.schema.parser.ersi;
import org.zml.schema.bind.Relation;
public class RelationArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public RelationArcGISParser( Relation element)
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
		if ( !(this.getQueryDefineElement() instanceof Relation))
		{
			throw new Exception(" RelationArcGISParser only parse Relation");
		}
		result = true;
		return result;
	}
}