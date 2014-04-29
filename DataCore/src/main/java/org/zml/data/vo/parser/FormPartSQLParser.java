package org.zml.data.vo.parser;
import org.zml.data.vo.bind.FormPart;
import org.zml.data.vo.exception.DataServiceException;

public class FormPartSQLParser extends SQLParser implements SQLParserAble
{
	public FormPartSQLParser( FormPart element)
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
		if ( !(this.getQueryDefineElement() instanceof FormPart))
		{
			throw new Exception(" FormPartSQLParser only parse FormPart");
		}
		result = true;
		return result;
	}
	
	@Override 
	public void loadFieldsProperties( FieldsConfig fieldProperties) throws DataServiceException{
		throw new DataServiceException("FormPart «≥ÈœÛ¿‡°£");
	}
}