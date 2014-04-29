package org.zml.data.vo.parser;
import org.zml.data.vo.bind.TableSet;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.util.UtilTools;

public class TableSetSQLParser extends SQLParser implements SQLParserAble
{
	public TableSetSQLParser( TableSet element)
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
		if ( !(this.getQueryDefineElement() instanceof TableSet))
		{
			throw new Exception(" TableSetSQLParser only parse TableSet");
		}
		result = true;
		return result;
	}
	
	@Override
	public CommandForm parserDataSetStringCommand(VOForm form) throws DataServiceException{
		CommandForm result = null;
		try{
			
			logger.debug("TableSetSQLParser��ʼִ��parserCommand��");	
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			TableSet config = (TableSet)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("queryDefineElement����ΪTableSet����" );
			}
			
			if(UtilTools.isNull( config.getTable() )){
				throw new Exception("TableSet��������Table���ԡ�");
			}
			
			result = new CommandForm();
			
			result.setAlias(UtilTools.getTrim(config.getAlias()));
			
			CommandConfiguration command = new CommandConfiguration();
			
			result.setCommand( command );
			
			logger.debug("TableSetSQLParserִ��parserCommand��ϡ�");	
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("TableSetSQLParser::parserCommand �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("TableSetSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("TableSetSQLParser::parserCommand �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return null;
	}
	
}