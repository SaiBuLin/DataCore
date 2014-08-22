package org.zml.schema.parser.olap;
import org.zml.schema.bind.RelationGroup;
public class RelationGroupOLapParser extends OLapParser implements OLapParserAble
{
	public RelationGroupOLapParser( RelationGroup element)
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
			throw new Exception(" RelationGroupOLapParser only parse RelationGroup");
		}
		result = true;
		return result;
	}
}