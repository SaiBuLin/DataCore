package org.zml.schema.parser.olap;
import org.zml.schema.bind.Relation;
public class RelationOLapParser extends OLapParser implements OLapParserAble
{
	public RelationOLapParser( Relation element)
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
			throw new Exception(" RelationOLapParser only parse Relation");
		}
		result = true;
		return result;
	}
}