package org.zml.data.vo.parser;
import org.zml.data.vo.bind.ServiceConnection;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.tools.connection.IConnectionAble;
public class ServiceConnectionSQLParser extends SQLParser implements SQLParserAble
{
	public ServiceConnectionSQLParser( ServiceConnection element)
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
		if ( !(this.getQueryDefineElement() instanceof ServiceConnection))
		{
			throw new Exception(" ServiceConnectionSQLParser only parse ServiceConnection");
		}
		result = true;
		return result;
	}
	
	@Override 
	public IConnectionAble parseConnection() throws DataServiceException{
		return null;
		
		
	}
}