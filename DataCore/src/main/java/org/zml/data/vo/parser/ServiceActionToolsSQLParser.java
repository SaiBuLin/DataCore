package org.zml.data.vo.parser;
import java.util.HashMap;

import org.zml.data.vo.bind.ServiceActionTools;
import org.zml.data.vo.bind.TableRelation;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.command.bind.ServiceTask;
import org.zml.data.vo.command.parser.SQLCommandAble;
import org.zml.data.vo.command.parser.SQLCommandFactory;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.tools.action.IActionTools;
import org.zml.data.vo.tools.connection.IConnectionAble;
import org.zml.util.UtilTools;

public class ServiceActionToolsSQLParser extends SQLParser implements SQLParserAble
{
	public ServiceActionToolsSQLParser( ServiceActionTools element)
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
		if ( !(this.getQueryDefineElement() instanceof ServiceActionTools))
		{
			throw new Exception(" ServiceActionToolsSQLParser only parse ServiceActionTools");
		}
		result = true;
		return result;
	}
	
	@Override 
	public IActionTools parseFormActionTools() throws DataServiceException{
		IActionTools result = null;
		try{
			if( !this.checkQueryElementComfort()){
				return result;
			}
			
			ServiceActionTools config = (ServiceActionTools)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("ServiceActionTools ����ʧ�ܡ�");
			}
			String tmpClassName = UtilTools.getTrim( config.getClassname() );
			
			Object newActionClass = Class.forName(tmpClassName).newInstance();
			
			if(!( newActionClass instanceof org.zml.data.vo.tools.action.IFormActionTools )){
				throw new Exception("Form ʹ�õ�ActionTools ����ʵ��org.zml.data.vo.tools.action.IFormActionTools�ӿڡ�");
			}
			
			result = ( org.zml.data.vo.tools.action.IActionTools )newActionClass;
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceActionToolsSQLParser::parserFormActionTools �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("ServiceActionToolsSQLParser::parserFormActionTools �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceActionToolsSQLParser::parserFormActionTools �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
			result = null;
		}
		return result;
	}
	

	@Override 
	public IConnectionAble parseConnection() throws DataServiceException{
		IConnectionAble result = null;
		try{
			logger.debug("ServiceActionToolsSQLParser��ʼִ��parseConnection��");	
			if( !this.checkQueryElementComfort()){
				return result;
			}
			
			ServiceActionTools config = (ServiceActionTools)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("ServiceActionTools ����ʧ�ܡ�");
			}
			
			if( config.getConnection() ==  null){
				throw new Exception("ServiceActionTools û������Connection");
			}
			
			SQLParserAble connectionParser = SQLParserFactory.getQueryDefineInterpreter( config.getConnection() );
			if( connectionParser == null ){
				throw new Exception("Connection ����SQLParserAble ����");
			}
			
			result = connectionParser.parseConnection();
		
			logger.debug("ServiceActionToolsSQLParserִ��parseConnection��ϡ�");	
			
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("ServiceActionToolsSQLParser::parseConnection �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("ServiceActionToolsSQLParser::parseConnection �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("ServiceActionToolsSQLParser::parseConnection �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
}