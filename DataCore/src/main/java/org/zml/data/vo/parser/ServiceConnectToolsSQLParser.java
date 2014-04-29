package org.zml.data.vo.parser;
import org.zml.data.vo.bind.ServiceConnectTools;
public class ServiceConnectToolsSQLParser extends SQLParser implements SQLParserAble
{
	public ServiceConnectToolsSQLParser( ServiceConnectTools element)
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
		if ( !(this.getQueryDefineElement() instanceof ServiceConnectTools))
		{
			throw new Exception(" ServiceConnectToolsSQLParser only parse ServiceConnectTools");
		}
		result = true;
		return result;
	}
}