package org.zml.data.vo.parser;
import org.zml.data.vo.bind.OperationLogical;
import org.zml.data.vo.bind.RelationGroup;
import org.zml.data.vo.bind.TableRelation;
import org.zml.data.vo.bind.Relation;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.command.parser.SQLCommandAble;
import org.zml.data.vo.command.parser.SQLCommandFactory;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.util.UtilTools;

public class RelationGroupSQLParser extends SQLParser implements SQLParserAble
{
	public RelationGroupSQLParser( RelationGroup element)
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
			throw new Exception(" RelationGroupSQLParser only parse RelationGroup");
		}
		result = true;
		return result;
	}
	
	
}