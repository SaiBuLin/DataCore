package org.zml.data.vo.parser;
import java.util.Map;

import org.zml.data.vo.bind.Attribute;
import org.zml.data.vo.bind.AttributeGroup;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.util.UtilTools;

public class AttributeGroupSQLParser extends SQLParser implements SQLParserAble
{
	public AttributeGroupSQLParser( AttributeGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof AttributeGroup))
		{
			throw new Exception(" AttributeGroupSQLParser only parse AttributeGroup");
		}
		result = true;
		return result;
	}
	
	@Override
	public void loadProperties( Map<String, Object> properties ) throws DataServiceException{
		try{
			logger.debug("AttributeGroupSQLParser开始执行loadProperties。");
			
			if( !this.checkQueryElementComfort() ){
				return ;
			}
			
			if( properties == null ){
				throw new Exception( "loadProperties的入口参数properties为空。" );
			}
			
			AttributeGroup config = (AttributeGroup)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception( "AttributeGroup强制转换错误。" );
			}
			
			if( config.getAttribute() == null ){
				throw new Exception( "AttributeGroup的属性Attribute没有配置。" );
			}
			
			int mSize = config.getAttribute().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				Attribute attr =  config.getAttribute().get(ii);
				SQLParserAble attrAble = SQLParserFactory.getQueryDefineInterpreter( attr );
				if( attrAble == null )continue;
				attrAble.loadProperties( properties );
			}
			
			logger.debug("AttributeGroupSQLParser执行loadProperties完毕。");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("AttributeGroupSQLParser::loadProperties 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("AttributeGroupSQLParser::loadProperties 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("AttributeGroupSQLParser::loadProperties 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
	}
}