package org.zml.schema.parser.olap;
import org.zml.schema.bind.ViewRelation;
public class ViewRelationOLapParser extends OLapParser implements OLapParserAble
{
	public ViewRelationOLapParser( ViewRelation element)
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
			throw new Exception(" ViewRelationOLapParser only parse ViewRelation");
		}
		result = true;
		return result;
	}
}