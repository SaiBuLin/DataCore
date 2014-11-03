package org.zml.schema.parser.sql;
import java.util.ArrayList;
import java.util.List;

import org.zml.form.bind.FormNode;
import org.zml.schema.bind.Field;
import org.zml.schema.bind.FieldGroup;

public class FieldGroupSQLParser extends SQLParser implements SQLParserAble
{
	public FieldGroupSQLParser( FieldGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldGroup))
		{
			throw new Exception(" FieldGroupSQLParser only parse FieldGroup");
		}
		result = true;
		return result;
	}
	
	/**
	 * �ýӿ���Form ��ӦParser ʵ�֡���ö�Ӧ��SELECT ���� �ֶ��б�, �ýӿڱ�Field ʵ��
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getSelectFields(FormNode formrequest) throws Exception{
		List<FieldInfo> result = new ArrayList<FieldInfo>();
		try{
			logger.debug("FieldGroupSQLParser.getSelectFields ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			FieldGroup config = (FieldGroup)this.queryDefineElement;
			
			logger.debug("�ж�����fieldGroup �Ƿ���ڡ�");
			if( config.getField() == null ){
				logger.warn( "FieldGroupSQLParser.getSelectFields �����Ӧfield ���ԡ���" );
				return result;
			}
			
			int mSize = config.getField().size();
			
			if( mSize == 0 ){
				logger.warn( "FieldGroupSQLParser.getSelectFields ����field �����Ա�� ������ʯArrayList���͵Ķ���" );
				return result;
			}
			
			for( int i = 0; i < mSize; i++ ){
				Field field = config.getField().get( i );
				if( field == null )continue;
				try{
					SQLParserAble fieldAble = (SQLParserAble)SQLParserFactory.getQueryDefineInterpreter(field);
					
					//SQLParserAble attrAble = fieldCognitronFactory.getQueryDefineInterpreter( field );
					if( fieldAble == null ){
						logger.warn( "FieldGroupSQLParser.getSelectFields ����field���Գ�Աû����ȷ��ʵ������SQLParserAble��" );
						continue;
					}
					
					List<FieldInfo>  fieldmap =  fieldAble.getSelectFields(formrequest);
					
					if( fieldmap != null ){
						result.addAll( fieldmap );
					}
				}catch(Exception e){
					logger.warn("�쳣��" + e.getMessage());
					continue;
				}
			}
			
			logger.debug("FieldGroupSQLParser.getSelectFields ������ϡ�");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
		
	}
	
	/**
	 * �ýӿ���Form ��ӦParser ʵ�֡���ö�Ӧ��Where ���� �ֶ��б�
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getConditionFields(FormNode formrequest) throws Exception{
		List<FieldInfo> result = new ArrayList<FieldInfo>();
		try{
			logger.debug("FieldGroupSQLParser.getConditionFields ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			FieldGroup config = (FieldGroup)this.queryDefineElement;
			
			logger.debug("�ж�����fieldGroup �Ƿ���ڡ�");
			if( config.getField() == null ){
				logger.warn( "FieldGroupSQLParser.getConditionFields �����Ӧfield ���ԡ���" );
				return result;
			}
			
			int mSize = config.getField().size();
			
			if( mSize == 0 ){
				logger.warn( "FieldGroupSQLParser.getConditionFields ����field �����Ա�� ������ʯArrayList���͵Ķ���" );
				return result;
			}
			
			for( int i = 0; i < mSize; i++ ){
				Field field = config.getField().get( i );
				if( field == null )continue;
				try{
					SQLParserAble fieldAble = (SQLParserAble)SQLParserFactory.getQueryDefineInterpreter(field);
					
					//SQLParserAble attrAble = fieldCognitronFactory.getQueryDefineInterpreter( field );
					if( fieldAble == null ){
						logger.warn( "FieldGroupSQLParser.getConditionFields ����field���Գ�Աû����ȷ��ʵ������SQLParserAble��" );
						continue;
					}
					
					List<FieldInfo>  fieldmap =  fieldAble.getConditionFields(formrequest);
					
					if( fieldmap != null ){
						result.addAll( fieldmap );
					}
				}catch(Exception e){
					logger.warn("�쳣��" + e.getMessage());
					continue;
				}
			}
			
			logger.debug("FieldGroupSQLParser.getConditionFields ������ϡ�");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}
	
	/**
	 * �ýӿ���Form ��ӦParser ʵ�֡���ö�Ӧ��Order By ���� �ֶ��б�
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getOrderByFields(FormNode formrequest) throws Exception{
		List<FieldInfo> result = new ArrayList<FieldInfo>();
		try{
			logger.debug("FieldGroupSQLParser.getOrderByFields ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			FieldGroup config = (FieldGroup)this.queryDefineElement;
			
			logger.debug("�ж�����fieldGroup �Ƿ���ڡ�");
			if( config.getField() == null ){
				logger.warn( "FieldGroupSQLParser.getOrderByFields �����Ӧfield ���ԡ���" );
				return result;
			}
			
			int mSize = config.getField().size();
			
			if( mSize == 0 ){
				logger.warn( "FieldGroupSQLParser.getOrderByFields ����field �����Ա�� ������ʯArrayList���͵Ķ���" );
				return result;
			}
			
			for( int i = 0; i < mSize; i++ ){
				Field field = config.getField().get( i );
				if( field == null )continue;
				try{
					SQLParserAble fieldAble = (SQLParserAble)SQLParserFactory.getQueryDefineInterpreter(field);
					
					//SQLParserAble attrAble = fieldCognitronFactory.getQueryDefineInterpreter( field );
					if( fieldAble == null ){
						logger.warn( "FieldGroupSQLParser.getOrderByFields ����field���Գ�Աû����ȷ��ʵ������SQLParserAble��" );
						continue;
					}
					
					List<FieldInfo>  fieldmap =  fieldAble.getOrderByFields(formrequest);
					
					if( fieldmap != null ){
						result.addAll( fieldmap );
					}
				}catch(Exception e){
					logger.warn("�쳣��" + e.getMessage());
					continue;
				}
			}
			
			logger.debug("FieldGroupSQLParser.getOrderByFields ������ϡ�");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}
	
	/**
	 * �ýӿ���Form ��ӦParser ʵ�֡���ö�Ӧ��Group by ���� �ֶ��б�
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getGroupByFields(FormNode formrequest) throws Exception{
		List<FieldInfo> result = new ArrayList<FieldInfo>();
		try{
			logger.debug("FieldGroupSQLParser.getGroupByFields ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			FieldGroup config = (FieldGroup)this.queryDefineElement;
			
			logger.debug("�ж�����fieldGroup �Ƿ���ڡ�");
			if( config.getField() == null ){
				logger.warn( "FieldGroupSQLParser.getGroupByFields �����Ӧfield ���ԡ���" );
				return result;
			}
			
			int mSize = config.getField().size();
			
			if( mSize == 0 ){
				logger.warn( "FieldGroupSQLParser.getGroupByFields ����field �����Ա�� ������ʯArrayList���͵Ķ���" );
				return result;
			}
			
			for( int i = 0; i < mSize; i++ ){
				Field field = config.getField().get( i );
				if( field == null )continue;
				try{
					SQLParserAble fieldAble = (SQLParserAble)SQLParserFactory.getQueryDefineInterpreter(field);
					
					//SQLParserAble attrAble = fieldCognitronFactory.getQueryDefineInterpreter( field );
					if( fieldAble == null ){
						logger.warn( "FieldGroupSQLParser.getGroupByFields ����field���Գ�Աû����ȷ��ʵ������SQLParserAble��" );
						continue;
					}
					
					List<FieldInfo>  fieldmap =  fieldAble.getGroupByFields(formrequest);
					
					if( fieldmap != null ){
						result.addAll( fieldmap );
					}
				}catch(Exception e){
					logger.warn("�쳣��" + e.getMessage());
					continue;
				}
			}
			
			logger.debug("FieldGroupSQLParser.getGroupByFields ������ϡ�");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}
}