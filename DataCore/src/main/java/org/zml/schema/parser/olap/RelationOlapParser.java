package org.zml.schema.parser.olap;
import org.zml.schema.bind.Relation;
public class RelationOlapParser extends OlapParser implements OlapParserAble
{
	public RelationOlapParser( Relation element)
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
			throw new Exception(" RelationOlapParser only parse Relation");
		}
		result = true;
		return result;
	}
}