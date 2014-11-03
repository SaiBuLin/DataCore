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
	 * 该接口由Form 对应Parser 实现。获得对应的SELECT 部分 字段列表, 该接口被Field 实现
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getSelectFields(FormNode formrequest) throws Exception{
		List<FieldInfo> result = new ArrayList<FieldInfo>();
		try{
			logger.debug("FieldGroupSQLParser.getSelectFields 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			FieldGroup config = (FieldGroup)this.queryDefineElement;
			
			logger.debug("判断属性fieldGroup 是否存在。");
			if( config.getField() == null ){
				logger.warn( "FieldGroupSQLParser.getSelectFields 浉曡对应field 属性。。" );
				return result;
			}
			
			int mSize = config.getField().size();
			
			if( mSize == 0 ){
				logger.warn( "FieldGroupSQLParser.getSelectFields 属性field 浉曡成员。 该属性石ArrayList类型的对象。" );
				return result;
			}
			
			for( int i = 0; i < mSize; i++ ){
				Field field = config.getField().get( i );
				if( field == null )continue;
				try{
					SQLParserAble fieldAble = (SQLParserAble)SQLParserFactory.getQueryDefineInterpreter(field);
					
					//SQLParserAble attrAble = fieldCognitronFactory.getQueryDefineInterpreter( field );
					if( fieldAble == null ){
						logger.warn( "FieldGroupSQLParser.getSelectFields 属性field属性成员没有正确的实例化出SQLParserAble。" );
						continue;
					}
					
					List<FieldInfo>  fieldmap =  fieldAble.getSelectFields(formrequest);
					
					if( fieldmap != null ){
						result.addAll( fieldmap );
					}
				}catch(Exception e){
					logger.warn("异常：" + e.getMessage());
					continue;
				}
			}
			
			logger.debug("FieldGroupSQLParser.getSelectFields 调用完毕。");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
		
	}
	
	/**
	 * 该接口由Form 对应Parser 实现。获得对应的Where 部分 字段列表
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getConditionFields(FormNode formrequest) throws Exception{
		List<FieldInfo> result = new ArrayList<FieldInfo>();
		try{
			logger.debug("FieldGroupSQLParser.getConditionFields 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			FieldGroup config = (FieldGroup)this.queryDefineElement;
			
			logger.debug("判断属性fieldGroup 是否存在。");
			if( config.getField() == null ){
				logger.warn( "FieldGroupSQLParser.getConditionFields 浉曡对应field 属性。。" );
				return result;
			}
			
			int mSize = config.getField().size();
			
			if( mSize == 0 ){
				logger.warn( "FieldGroupSQLParser.getConditionFields 属性field 浉曡成员。 该属性石ArrayList类型的对象。" );
				return result;
			}
			
			for( int i = 0; i < mSize; i++ ){
				Field field = config.getField().get( i );
				if( field == null )continue;
				try{
					SQLParserAble fieldAble = (SQLParserAble)SQLParserFactory.getQueryDefineInterpreter(field);
					
					//SQLParserAble attrAble = fieldCognitronFactory.getQueryDefineInterpreter( field );
					if( fieldAble == null ){
						logger.warn( "FieldGroupSQLParser.getConditionFields 属性field属性成员没有正确的实例化出SQLParserAble。" );
						continue;
					}
					
					List<FieldInfo>  fieldmap =  fieldAble.getConditionFields(formrequest);
					
					if( fieldmap != null ){
						result.addAll( fieldmap );
					}
				}catch(Exception e){
					logger.warn("异常：" + e.getMessage());
					continue;
				}
			}
			
			logger.debug("FieldGroupSQLParser.getConditionFields 调用完毕。");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}
	
	/**
	 * 该接口由Form 对应Parser 实现。获得对应的Order By 部分 字段列表
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getOrderByFields(FormNode formrequest) throws Exception{
		List<FieldInfo> result = new ArrayList<FieldInfo>();
		try{
			logger.debug("FieldGroupSQLParser.getOrderByFields 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			FieldGroup config = (FieldGroup)this.queryDefineElement;
			
			logger.debug("判断属性fieldGroup 是否存在。");
			if( config.getField() == null ){
				logger.warn( "FieldGroupSQLParser.getOrderByFields 浉曡对应field 属性。。" );
				return result;
			}
			
			int mSize = config.getField().size();
			
			if( mSize == 0 ){
				logger.warn( "FieldGroupSQLParser.getOrderByFields 属性field 浉曡成员。 该属性石ArrayList类型的对象。" );
				return result;
			}
			
			for( int i = 0; i < mSize; i++ ){
				Field field = config.getField().get( i );
				if( field == null )continue;
				try{
					SQLParserAble fieldAble = (SQLParserAble)SQLParserFactory.getQueryDefineInterpreter(field);
					
					//SQLParserAble attrAble = fieldCognitronFactory.getQueryDefineInterpreter( field );
					if( fieldAble == null ){
						logger.warn( "FieldGroupSQLParser.getOrderByFields 属性field属性成员没有正确的实例化出SQLParserAble。" );
						continue;
					}
					
					List<FieldInfo>  fieldmap =  fieldAble.getOrderByFields(formrequest);
					
					if( fieldmap != null ){
						result.addAll( fieldmap );
					}
				}catch(Exception e){
					logger.warn("异常：" + e.getMessage());
					continue;
				}
			}
			
			logger.debug("FieldGroupSQLParser.getOrderByFields 调用完毕。");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}
	
	/**
	 * 该接口由Form 对应Parser 实现。获得对应的Group by 部分 字段列表
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getGroupByFields(FormNode formrequest) throws Exception{
		List<FieldInfo> result = new ArrayList<FieldInfo>();
		try{
			logger.debug("FieldGroupSQLParser.getGroupByFields 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			FieldGroup config = (FieldGroup)this.queryDefineElement;
			
			logger.debug("判断属性fieldGroup 是否存在。");
			if( config.getField() == null ){
				logger.warn( "FieldGroupSQLParser.getGroupByFields 浉曡对应field 属性。。" );
				return result;
			}
			
			int mSize = config.getField().size();
			
			if( mSize == 0 ){
				logger.warn( "FieldGroupSQLParser.getGroupByFields 属性field 浉曡成员。 该属性石ArrayList类型的对象。" );
				return result;
			}
			
			for( int i = 0; i < mSize; i++ ){
				Field field = config.getField().get( i );
				if( field == null )continue;
				try{
					SQLParserAble fieldAble = (SQLParserAble)SQLParserFactory.getQueryDefineInterpreter(field);
					
					//SQLParserAble attrAble = fieldCognitronFactory.getQueryDefineInterpreter( field );
					if( fieldAble == null ){
						logger.warn( "FieldGroupSQLParser.getGroupByFields 属性field属性成员没有正确的实例化出SQLParserAble。" );
						continue;
					}
					
					List<FieldInfo>  fieldmap =  fieldAble.getGroupByFields(formrequest);
					
					if( fieldmap != null ){
						result.addAll( fieldmap );
					}
				}catch(Exception e){
					logger.warn("异常：" + e.getMessage());
					continue;
				}
			}
			
			logger.debug("FieldGroupSQLParser.getGroupByFields 调用完毕。");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}
}