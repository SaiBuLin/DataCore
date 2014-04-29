package org.zml.data.vo.command.parser;
import org.zml.data.vo.command.bind.*;
import org.zml.tools.xml.parser.CTXMLElement;
public class SQLCommandFactory
{
	public static SQLCommandAble getQueryDefineInterpreter(CTXMLElement element) throws Exception
	{
		SQLCommandAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		result = getQueryDefineInterpreterIndicateClsName( element );
		if ( result == null )
		{
			result =getQueryDefineInterpreterForNoEquals(element);
		}
		return result;
	}
	private static SQLCommandAble getQueryDefineInterpreterForNoEquals(CTXMLElement element) throws Exception
	{
		SQLCommandAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		if( element instanceof CommandConfiguration  )
		{
			result = new CommandConfigurationSQLCommand((CommandConfiguration)element);
		}
		else if( element instanceof ServiceParameter  )
		{
			result = new ServiceParameterSQLCommand((ServiceParameter)element);
		}
		else if( element instanceof RequestParameter  )
		{
			result = new RequestParameterSQLCommand((RequestParameter)element);
		}
		else if( element instanceof RequestTaskGroup  )
		{
			result = new RequestTaskGroupSQLCommand((RequestTaskGroup)element);
		}
		else if( element instanceof RequestParameterGroup  )
		{
			result = new RequestParameterGroupSQLCommand((RequestParameterGroup)element);
		}
		else if( element instanceof RequestTask  )
		{
			result = new RequestTaskSQLCommand((RequestTask)element);
		}
		else if( element instanceof CommandDefine  )
		{
			result = new CommandDefineSQLCommand((CommandDefine)element);
		}
		else if( element instanceof ServiceTask  )
		{
			result = new ServiceTaskSQLCommand((ServiceTask)element);
		}
		return result;
	}
	private static SQLCommandAble getQueryDefineInterpreterIndicateClsName(CTXMLElement element) throws Exception
	{
		SQLCommandAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		String tmpElementClassName = element.getClass().getName();
		if( tmpElementClassName.equals(  CommandConfiguration.class.getName())  )
		{
			result = new CommandConfigurationSQLCommand((CommandConfiguration)element);
		}
		else if( tmpElementClassName.equals(  ServiceParameter.class.getName())  )
		{
			result = new ServiceParameterSQLCommand((ServiceParameter)element);
		}
		else if( tmpElementClassName.equals(  RequestParameter.class.getName())  )
		{
			result = new RequestParameterSQLCommand((RequestParameter)element);
		}
		else if( tmpElementClassName.equals(  RequestTaskGroup.class.getName())  )
		{
			result = new RequestTaskGroupSQLCommand((RequestTaskGroup)element);
		}
		else if( tmpElementClassName.equals(  RequestParameterGroup.class.getName())  )
		{
			result = new RequestParameterGroupSQLCommand((RequestParameterGroup)element);
		}
		else if( tmpElementClassName.equals(  RequestTask.class.getName())  )
		{
			result = new RequestTaskSQLCommand((RequestTask)element);
		}
		else if( tmpElementClassName.equals(  CommandDefine.class.getName())  )
		{
			result = new CommandDefineSQLCommand((CommandDefine)element);
		}
		else if( tmpElementClassName.equals(  ServiceTask.class.getName())  )
		{
			result = new ServiceTaskSQLCommand((ServiceTask)element);
		}
		return result;
	}
}