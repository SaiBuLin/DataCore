package org.zml.schema.parser.sql;
import java.util.ArrayList;
import java.util.List;

import org.zml.data.FieldDefine;
import org.zml.data.FieldInfo;
import org.zml.form.bind.FormNode;
import org.zml.form.sql.parser.FormSQLParserAble;
import org.zml.form.sql.parser.FormSQLParserFactory;
import org.zml.schema.bind.ServiceField;
import org.zml.util.UtilTools;

public class ServiceFieldSQLParser extends SQLParser implements SQLParserAble
{
	public ServiceFieldSQLParser( ServiceField element)
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
		if ( !(this.getQueryDefineElement() instanceof ServiceField))
		{
			throw new Exception(" ServiceFieldSQLParser only parse ServiceField");
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
	public List<FieldInfo> getSelectFields(String alias, FormNode formrequest) throws Exception{
		 List<FieldInfo> result = new ArrayList<FieldInfo>();
		 try{
			logger.debug("ServiceFieldSQLParser.getSelectFields 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( formrequest == null ){
				logger.warn("入口参数formrequest为空。");
				return result;
			}
			
			logger.debug("读取ServiceField.");
			ServiceField serviceFile = (ServiceField)this.getQueryDefineElement();
			
			if( UtilTools.isNull( serviceFile.getCode() ) ){
				logger.warn(" ServiceField必须配置属性code。 ");
				return result;
			}
			
			String tmpFieldCode = UtilTools.getTrim( serviceFile.getCode()  );
			String tmpField = UtilTools.getTrim( serviceFile.getField() );
			
			FormSQLParserAble formParser = FormSQLParserFactory.getQueryDefineInterpreter(formrequest);
			
			if( formParser == null ){
				logger.warn("入口参数formrequest 没有对应的FormParserAble.");
				return result;
			}
			
			FieldDefine fieldDef = new FieldDefine();
			
			fieldDef.setAlias( alias );
			fieldDef.setField( tmpField );
			fieldDef.setFieldCode( tmpFieldCode );
			
			fieldDef.setDataType( serviceFile.getDataType() );
			
			FieldInfo fieldinfo = formParser.getSelectField(fieldDef);
			if( fieldinfo != null ){			
				result.add(fieldinfo);
			}
			logger.debug("ServiceFieldSQLParser.getSelectFields 调用完毕。");
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
	public List<FieldInfo> getConditionFields(String alias, FormNode formrequest) throws Exception{
		 List<FieldInfo> result = null;
		 
		 return result;
	}
	
	/**
	 * 该接口由Form 对应Parser 实现。获得对应的Order By 部分 字段列表
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getOrderByFields(String alias, FormNode formrequest) throws Exception{
		 List<FieldInfo> result = null;
		 
		 return result;
	}
	
	/**
	 * 该接口由Form 对应Parser 实现。获得对应的Group by 部分 字段列表
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FieldInfo> getGroupByFields(String alias, FormNode formrequest) throws Exception{
		 List<FieldInfo> result = null;
		 
		 return result;
	}
	
}