package org.zml.data.vo.parser;
import org.zml.data.vo.bind.Relation;
import org.zml.data.vo.bind.TableRelation;
import org.zml.data.vo.exception.DataServiceException;


public class RelationSQLParser extends SQLParser implements SQLParserAble
{
	public RelationSQLParser( Relation element)
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
			throw new Exception(" RelationSQLParser only parse Relation");
		}
		result = true;
		return result;
	}
	
	
	
	
}