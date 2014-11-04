package org.zml.schema.parser.sql;

import java.util.ArrayList;
import java.util.List;

import org.zml.data.FieldInfo;
import org.zml.data.SQLString;
import org.zml.form.bind.FormNode;
import org.zml.schema.bind.Form;

public class FormSQLParser extends SQLParser implements SQLParserAble
{
	public FormSQLParser( Form element)
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
		if ( !(this.getQueryDefineElement() instanceof Form))
		{
			throw new Exception(" FormSQLParser only parse Form");
		}
		result = true;
		return result;
	}
	
	/**
	 * �÷����� ����SchemaConfig, ��ö�ӦSQL ��
	 * @param formcode
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public SQLString parserSQLString( FormNode formrequest ) throws Exception{
		SQLString result = null;
		try{
			logger.debug("FormSQLParser.parserSQLString ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( formrequest == null ){
				throw new Exception("��ڲ���formrequest��null��");
			}
			
			Form config = (Form)this.queryDefineElement;
			
			if( config.getCommand() == null ){
				throw new Exception("form����commandΪ�գ� �����Ҫ���á�");
			}
			
			if( config.getField() == null ){
				throw new Exception("form��Ҫ����Field���ԡ�");
			}
			
			/* ����SQL  */
			SQLParserAble sqlAble = SQLParserFactory.getQueryDefineInterpreter( config.getCommand()  );
			
			if( sqlAble == null ){
				throw new Exception("form ����commandû�ж�Ӧ��SQLParserAble.");
			}
			
			String content = config.getContent();
			
			if( !config.getOnlytable() ){
				content = "(" + content + ")";
			}
			
			result = sqlAble.parserSQLString( config.getField(), config.getAlias(), content , formrequest );			
			logger.debug("FormSQLParser.parserSQLString ������ϡ�");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
		
	}
	
	/**
	 * �ýӿ���Form ��ӦParser ʵ�֡���ö�Ӧ��SELECT ���� �ֶ��б�
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getSelectFields(String alias,FormNode formrequest) throws Exception{
		List<FieldInfo> result = new ArrayList<FieldInfo>();
		
		try{
			logger.debug("FormSQLParser.getSelectFields ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( formrequest == null ){
				throw new Exception("��ڲ���formrequest��null��");
			}
			
			Form config = (Form)this.queryDefineElement;
			
			if( config.getField() == null ){
				throw new Exception("form����commandΪ�գ� �����Ҫ���á�");
			}
			
			
			
			
			
			
			logger.debug("FormSQLParser.getSelectFields ������ϡ�");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}		
	}
}