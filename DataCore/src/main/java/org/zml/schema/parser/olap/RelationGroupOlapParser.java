package org.zml.schema.parser.olap;
import org.zml.schema.bind.RelationGroup;
public class RelationGroupOlapParser extends OlapParser implements OlapParserAble
{
	public RelationGroupOlapParser( RelationGroup element)
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
			throw new Exception(" RelationGroupOlapParser only parse RelationGroup");
		}
		result = true;
		return result;
	}
}