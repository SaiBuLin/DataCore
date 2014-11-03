package org.zml.schema.parser.olap;
import org.zml.schema.bind.ViewRelation;
public class ViewRelationOlapParser extends OlapParser implements OlapParserAble
{
	public ViewRelationOlapParser( ViewRelation element)
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
			throw new Exception(" ViewRelationOlapParser only parse ViewRelation");
		}
		result = true;
		return result;
	}
}