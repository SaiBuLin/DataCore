package org.zml.schema.parser.sql;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zml.schema.bind.Attribute;
import org.zml.schema.bind.AttributeGroup;
import org.zml.schema.bind.Parameter;
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
	public Map<String, Object> getAttributes() throws Exception{
		Map<String, Object> result = new HashMap<String,Object>();
		try{
			logger.debug("AttributeGroupSQLParser.getAttributeGroup 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			AttributeGroup config = (AttributeGroup)this.queryDefineElement;
			
			logger.debug("判断属性AttributeGroup 是否存在。");
			if( config.getAttribute() == null ){
				logger.warn( "AttributeGroupSQLParser.getAttributeGroup 浉曡对应attribute 属性。。" );
				return result;
			}
			
			int mSize = config.getAttribute().size();
			
			if( mSize == 0 ){
				logger.warn( "AttributeGroupSQLParser.getAttributeGroup 属性attribute 浉曡成员。 该属性石ArrayList类型的对象。" );
				return result;
			}
			
			for( int i = 0; i < mSize; i++ ){
				Attribute attribute = config.getAttribute().get( i );
				if( attribute == null )continue;
				try{
					SQLParserAble attrAble = (SQLParserAble)SQLParserFactory.getQueryDefineInterpreter(attribute);
					
					//SQLParserAble attrAble = AttributeCognitronFactory.getQueryDefineInterpreter( attribute );
					if( attrAble == null ){
						logger.warn( "AttributeGroupSQLParser.getAttributeGroup 属性attribute属性成员没有正确的实例化出SQLParserAble。" );
						continue;
					}
					
					Map<String,Object> attmap =  attrAble.getAttributes();
					
					if( attmap != null ){
						result.putAll( attmap );
					}
				}catch(Exception e){
					logger.warn("异常：" + e.getMessage());
					continue;
				}
			}
			
			logger.debug("AttributeGroupSQLParser.getAttributeGroup 调用完毕。");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}
	
	@Override
	public List<Object> getAttribute(String attrname ) throws Exception{
		List<Object> result = new ArrayList<Object>();
		try{
			logger.debug("AttributeGroupSQLParser.getAttribute 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( UtilTools.isNull(attrname) ){
				logger.error("AttributeGroupSQLParser.getAttribute 错误， 入口参数attrname 为空。");
			}
			
			AttributeGroup config = (AttributeGroup)this.queryDefineElement;
			
			logger.debug("判断属性AttributeGroup 是否存在。");
			if( config.getAttribute() == null ){
				logger.warn( "AttributeGroupSQLParser.getAttribute 浉曡对应attribute 属性。。" );
				return result;
			}
			
			int mSize = config.getAttribute().size();
			
			if( mSize == 0 ){
				logger.warn( "AttributeGroupSQLParser.getAttribute 属性attribute 浉曡成员。 该属性石ArrayList类型的对象。" );
				return result;
			}
			
			for( int i = 0; i < mSize; i++ ){
				Attribute attribute = config.getAttribute().get( i );
				if( attribute == null )continue;
				try{
					SQLParserAble attrAble = (SQLParserAble)SQLParserFactory.getQueryDefineInterpreter(attribute);
					
					//SQLParserAble attrAble = AttributeCognitronFactory.getQueryDefineInterpreter( attribute );
					if( attrAble == null ){
						logger.warn( "AttributeGroupSQLParser.getAttribute 属性attribute属性成员没有正确的实例化出SQLParserAble。" );
						continue;
					}
					
					List<Object> values =  attrAble.getAttribute( attrname );
					
					if( values != null ){
						result.addAll( values );
					}
				}catch(Exception e){
					logger.warn("异常：" + e.getMessage());
					continue;
				}
				
				
			}
			
			logger.debug("AttributeGroupSQLParser.getAttribute 调用完毕。");
			return result;
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}
	
	@Override
	public void setAttribute(String attrname, Object value) throws Exception{
		try{
			logger.debug("AttributeGroupSQLParser.setAttribute 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return ;
			}
			
			if( UtilTools.isNull(attrname) ){
				logger.error("AttributeGroupSQLParser.setAttribute 错误， 入口参数attrname 为空。");
			}
			
			AttributeGroup config = (AttributeGroup)this.queryDefineElement;
			
			logger.debug("判断属性AttributeGroup 是否存在。");
			if( config.getAttribute() == null ){
				logger.warn( "AttributeGroupSQLParser.setAttribute 浉曡对应attribute 属性。。" );
				config.setAttribute( new ArrayList<Attribute>() );
			}
			
			List<Object> attvalues = getAttribute(attrname);
			
			if(( attvalues == null ) || (attvalues.size() == 0)) {
				Parameter param = new Parameter();
				param.setCode(UtilTools.getTrim(attrname));
				param.setValue(String.valueOf(value));
				
				config.getAttribute().add( param );
			}else {
				int mSize = attvalues.size();
				for( int i = 0; i < mSize; i++ ){
					Attribute attribute = config.getAttribute().get( i );
					if( attribute == null )continue;
					try{
						SQLParserAble attrAble = (SQLParserAble)SQLParserFactory.getQueryDefineInterpreter(attribute);
						
						//SQLParserAble attrAble = AttributeCognitronFactory.getQueryDefineInterpreter( attribute );
						if( attrAble == null ){
							logger.warn( "AttributeGroupSQLParser.setAttribute 属性attribute属性成员没有正确的实例化出SQLParserAble。" );
							continue;
						}
						
						attrAble.setAttribute(attrname, value);
					}catch(Exception e){
						logger.warn("异常：" + e.getMessage());
						continue;
					}
				}				
			}
			logger.debug("AttributeGroupSQLParser.setAttribute 调用完毕。");
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}
	
	@Override
	public void clear() throws Exception{
		
		try{
			logger.debug("AttributeGroupSQLParser.clear 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return ;
			}
			AttributeGroup config = (AttributeGroup)this.queryDefineElement;
			
			logger.debug("判断属性AttributeGroup 是否存在。");
			if( config.getAttribute() == null ){
				logger.warn( "AttributeGroupSQLParser.clear 浉曡对应attribute 属性。。" );
				return ;
			}
			
			int mSize = config.getAttribute().size();
			
			if( mSize == 0 ){
				logger.warn( "AttributeGroupSQLParser.clear 属性attribute 浉曡成员。 该属性石ArrayList类型的对象。" );
				return ;
			}
			
			for( int i = 0; i < mSize; i++ ){
				Attribute attribute = config.getAttribute().get( i );
				if( attribute == null )continue;
				
				try{
					SQLParserAble attrAble = (SQLParserAble)SQLParserFactory.getQueryDefineInterpreter(attribute);
					
					//SQLParserAble attrAble = AttributeCognitronFactory.getQueryDefineInterpreter( attribute );
					if( attrAble == null ){
						logger.warn( "AttributeGroupSQLParser.clear 属性attribute属性成员没有正确的实例化出SQLParserAble。" );
						continue;
					}
					
					attrAble.clear();
				}catch(Exception e){
					logger.warn("异常：" + e.getMessage());
					continue;
				}
				
				
			}
			logger.debug("AttributeGroupSQLParser.clear 执行清除列表。");
			config.getAttribute().clear();
			
			
			logger.debug("AttributeGroupSQLParser.clear 调用完毕。");
			
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}
	
	@Override
	public void deleteAttribute(String attrname)throws Exception{
		try{
			logger.debug("AttributeGroupSQLParser.deleteAttribute 开始被调用。");
			
			if(!this.checkQueryElementComfort()){
				return ;
			}
			
			if( UtilTools.isNull(attrname) ){
				logger.error("AttributeGroupSQLParser.deleteAttribute 错误， 入口参数attrname 为空。");
			}
			
			AttributeGroup config = (AttributeGroup)this.queryDefineElement;
			
			logger.debug("判断属性AttributeGroup 是否存在。");
			if( config.getAttribute() == null ){
				logger.warn( "AttributeGroupSQLParser.deleteAttribute 浉曡对应attribute 属性。。" );
				return ;
			}
			
			int mSize = config.getAttribute().size();
			
			if( mSize == 0 ){
				logger.warn( "AttributeGroupSQLParser.deleteAttribute 属性attribute 浉曡成员。 该属性石ArrayList类型的对象。" );
				return ;
			}
			
			
			logger.debug("AttributeGroupSQLParser.deleteAttribute 执行清除列表。");
			int step = 0;
			while( step < mSize){
				
				Attribute attr =  config.getAttribute().get( step );
				
				try{
					SQLParserAble attrAble = (SQLParserAble)SQLParserFactory.getQueryDefineInterpreter(attr);
					if( attrAble == null ){
						logger.warn( "AttributeGroupSQLParser.deleteAttribute 属性attribute属性成员没有正确的实例化出SQLParserAble。" );
						step++;	
						continue;
					}
					
					if( attrAble.isMine(attrname)){
						config.getAttribute().remove(step);
						mSize = config.getAttribute().size();
						continue;
					}else{
						attrAble.deleteAttribute(attrname);
					}
				}catch(Exception e){
					logger.warn("异常：" + e.getMessage());
					step++;	
					continue;
				}
				step++;				
			}
			
			
			logger.debug("AttributeGroupSQLParser.deleteAttribute 调用完毕。");
			
		}catch(Exception e){
			logger.error( "异常信息：" + e.getMessage() );
			throw e;
		}
	}
}