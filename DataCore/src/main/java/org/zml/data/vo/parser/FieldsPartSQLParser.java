package org.zml.data.vo.parser;
import org.zml.data.vo.bind.FieldsPart;
import org.zml.data.vo.exception.DataServiceException;

public class FieldsPartSQLParser extends SQLParser implements SQLParserAble
{
	public FieldsPartSQLParser( FieldsPart element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldsPart))
		{
			throw new Exception(" FieldsPartSQLParser only parse FieldsPart");
		}
		result = true;
		return result;
	}
	
	@Override 
	public void loadFieldsProperties( FieldsConfig fieldProperties) throws DataServiceException{
		throw new DataServiceException("FieldsPart «≥ÈœÛ¿‡°£");
	}
}