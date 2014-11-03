package org.zml.schema.parser.sql;
import org.zml.form.bind.FormNode;
import org.zml.schema.bind.Delete;
import org.zml.schema.bind.Field;

public class DeleteSQLParser extends SQLParser implements SQLParserAble
{
	public DeleteSQLParser( Delete element)
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
		if ( !(this.getQueryDefineElement() instanceof Delete))
		{
			throw new Exception(" DeleteSQLParser only parse Delete");
		}
		result = true;
		return result;
	}
	
	/**
	 * 该接口由command 实现
	 * @param field
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public SQLString parserSQLString( Field field,  String alias, String content, FormNode formrequest) throws Exception{
		logger.debug("SQLParser 不需要实现parserSQLString.");
		return null;
	}
}