package org.zml.data.vo.parser;
import org.zml.data.vo.bind.DataType;
import org.zml.data.vo.bind.FieldValueRelation;
import org.zml.data.vo.bind.ServiceField;
import org.zml.data.vo.bind.TableRelation;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.util.UtilTools;

public class FieldValueRelationSQLParser extends SQLParser implements SQLParserAble
{
	public FieldValueRelationSQLParser( FieldValueRelation element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldValueRelation))
		{
			throw new Exception(" FieldValueRelationSQLParser only parse FieldValueRelation");
		}
		result = true;
		return result;
	}
	
	
}