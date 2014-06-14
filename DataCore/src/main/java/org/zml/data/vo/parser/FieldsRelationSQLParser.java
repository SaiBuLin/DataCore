package org.zml.data.vo.parser;
import org.zml.data.vo.bind.FieldsRelation;
import org.zml.data.vo.bind.TableRelation;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.command.parser.SQLCommandAble;
import org.zml.data.vo.command.parser.SQLCommandFactory;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.util.UtilTools;

public class FieldsRelationSQLParser extends SQLParser implements SQLParserAble
{
	public FieldsRelationSQLParser( FieldsRelation element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldsRelation))
		{
			throw new Exception(" FieldsRelationSQLParser only parse FieldsRelation");
		}
		result = true;
		return result;
	}
	
	
}