package org.zml.data.vo.parser;
import org.zml.data.vo.bind.BoundaryRelation;
public class BoundaryRelationSQLParser extends SQLParser implements SQLParserAble
{
	public BoundaryRelationSQLParser( BoundaryRelation element)
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
		if ( !(this.getQueryDefineElement() instanceof BoundaryRelation))
		{
			throw new Exception(" BoundaryRelationSQLParser only parse BoundaryRelation");
		}
		result = true;
		return result;
	}
}