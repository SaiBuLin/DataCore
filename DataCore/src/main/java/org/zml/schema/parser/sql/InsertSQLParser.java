package org.zml.schema.parser.sql;
import org.zml.form.bind.FormNode;
import org.zml.schema.bind.Field;
import org.zml.schema.bind.Insert;

public class InsertSQLParser extends SQLParser implements SQLParserAble
{
	public InsertSQLParser( Insert element)
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
		if ( !(this.getQueryDefineElement() instanceof Insert))
		{
			throw new Exception(" InsertSQLParser only parse Insert");
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