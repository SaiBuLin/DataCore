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
			logger.debug("AttributeGroupSQLParser.getAttributeGroup ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			AttributeGroup config = (AttributeGroup)this.queryDefineElement;
			
			logger.debug("�ж�����AttributeGroup �Ƿ���ڡ�");
			if( config.getAttribute() == null ){
				logger.warn( "AttributeGroupSQLParser.getAttributeGroup �����Ӧattribute ���ԡ���" );
				return result;
			}
			
			int mSize = config.getAttribute().size();
			
			if( mSize == 0 ){
				logger.warn( "AttributeGroupSQLParser.getAttributeGroup ����attribute �����Ա�� ������ʯArrayList���͵Ķ���" );
				return result;
			}
			
			for( int i = 0; i < mSize; i++ ){
				Attribute attribute = config.getAttribute().get( i );
				if( attribute == null )continue;
				try{
					SQLParserAble attrAble = (SQLParserAble)SQLParserFactory.getQueryDefineInterpreter(attribute);
					
					//SQLParserAble attrAble = AttributeCognitronFactory.getQueryDefineInterpreter( attribute );
					if( attrAble == null ){
						logger.warn( "AttributeGroupSQLParser.getAttributeGroup ����attribute���Գ�Աû����ȷ��ʵ������SQLParserAble��" );
						continue;
					}
					
					Map<String,Object> attmap =  attrAble.getAttributes();
					
					if( attmap != null ){
						result.putAll( attmap );
					}
				}catch(Exception e){
					logger.warn("�쳣��" + e.getMessage());
					continue;
				}
			}
			
			logger.debug("AttributeGroupSQLParser.getAttributeGroup ������ϡ�");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}
	
	@Override
	public List<Object> getAttribute(String attrname ) throws Exception{
		List<Object> result = new ArrayList<Object>();
		try{
			logger.debug("AttributeGroupSQLParser.getAttribute ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( UtilTools.isNull(attrname) ){
				logger.error("AttributeGroupSQLParser.getAttribute ���� ��ڲ���attrname Ϊ�ա�");
			}
			
			AttributeGroup config = (AttributeGroup)this.queryDefineElement;
			
			logger.debug("�ж�����AttributeGroup �Ƿ���ڡ�");
			if( config.getAttribute() == null ){
				logger.warn( "AttributeGroupSQLParser.getAttribute �����Ӧattribute ���ԡ���" );
				return result;
			}
			
			int mSize = config.getAttribute().size();
			
			if( mSize == 0 ){
				logger.warn( "AttributeGroupSQLParser.getAttribute ����attribute �����Ա�� ������ʯArrayList���͵Ķ���" );
				return result;
			}
			
			for( int i = 0; i < mSize; i++ ){
				Attribute attribute = config.getAttribute().get( i );
				if( attribute == null )continue;
				try{
					SQLParserAble attrAble = (SQLParserAble)SQLParserFactory.getQueryDefineInterpreter(attribute);
					
					//SQLParserAble attrAble = AttributeCognitronFactory.getQueryDefineInterpreter( attribute );
					if( attrAble == null ){
						logger.warn( "AttributeGroupSQLParser.getAttribute ����attribute���Գ�Աû����ȷ��ʵ������SQLParserAble��" );
						continue;
					}
					
					List<Object> values =  attrAble.getAttribute( attrname );
					
					if( values != null ){
						result.addAll( values );
					}
				}catch(Exception e){
					logger.warn("�쳣��" + e.getMessage());
					continue;
				}
				
				
			}
			
			logger.debug("AttributeGroupSQLParser.getAttribute ������ϡ�");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}
	
	@Override
	public void setAttribute(String attrname, Object value) throws Exception{
		try{
			logger.debug("AttributeGroupSQLParser.setAttribute ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return ;
			}
			
			if( UtilTools.isNull(attrname) ){
				logger.error("AttributeGroupSQLParser.setAttribute ���� ��ڲ���attrname Ϊ�ա�");
			}
			
			AttributeGroup config = (AttributeGroup)this.queryDefineElement;
			
			logger.debug("�ж�����AttributeGroup �Ƿ���ڡ�");
			if( config.getAttribute() == null ){
				logger.warn( "AttributeGroupSQLParser.setAttribute �����Ӧattribute ���ԡ���" );
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
							logger.warn( "AttributeGroupSQLParser.setAttribute ����attribute���Գ�Աû����ȷ��ʵ������SQLParserAble��" );
							continue;
						}
						
						attrAble.setAttribute(attrname, value);
					}catch(Exception e){
						logger.warn("�쳣��" + e.getMessage());
						continue;
					}
				}				
			}
			logger.debug("AttributeGroupSQLParser.setAttribute ������ϡ�");
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}
	
	@Override
	public void clear() throws Exception{
		
		try{
			logger.debug("AttributeGroupSQLParser.clear ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return ;
			}
			AttributeGroup config = (AttributeGroup)this.queryDefineElement;
			
			logger.debug("�ж�����AttributeGroup �Ƿ���ڡ�");
			if( config.getAttribute() == null ){
				logger.warn( "AttributeGroupSQLParser.clear �����Ӧattribute ���ԡ���" );
				return ;
			}
			
			int mSize = config.getAttribute().size();
			
			if( mSize == 0 ){
				logger.warn( "AttributeGroupSQLParser.clear ����attribute �����Ա�� ������ʯArrayList���͵Ķ���" );
				return ;
			}
			
			for( int i = 0; i < mSize; i++ ){
				Attribute attribute = config.getAttribute().get( i );
				if( attribute == null )continue;
				
				try{
					SQLParserAble attrAble = (SQLParserAble)SQLParserFactory.getQueryDefineInterpreter(attribute);
					
					//SQLParserAble attrAble = AttributeCognitronFactory.getQueryDefineInterpreter( attribute );
					if( attrAble == null ){
						logger.warn( "AttributeGroupSQLParser.clear ����attribute���Գ�Աû����ȷ��ʵ������SQLParserAble��" );
						continue;
					}
					
					attrAble.clear();
				}catch(Exception e){
					logger.warn("�쳣��" + e.getMessage());
					continue;
				}
				
				
			}
			logger.debug("AttributeGroupSQLParser.clear ִ������б�");
			config.getAttribute().clear();
			
			
			logger.debug("AttributeGroupSQLParser.clear ������ϡ�");
			
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}
	
	@Override
	public void deleteAttribute(String attrname)throws Exception{
		try{
			logger.debug("AttributeGroupSQLParser.deleteAttribute ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return ;
			}
			
			if( UtilTools.isNull(attrname) ){
				logger.error("AttributeGroupSQLParser.deleteAttribute ���� ��ڲ���attrname Ϊ�ա�");
			}
			
			AttributeGroup config = (AttributeGroup)this.queryDefineElement;
			
			logger.debug("�ж�����AttributeGroup �Ƿ���ڡ�");
			if( config.getAttribute() == null ){
				logger.warn( "AttributeGroupSQLParser.deleteAttribute �����Ӧattribute ���ԡ���" );
				return ;
			}
			
			int mSize = config.getAttribute().size();
			
			if( mSize == 0 ){
				logger.warn( "AttributeGroupSQLParser.deleteAttribute ����attribute �����Ա�� ������ʯArrayList���͵Ķ���" );
				return ;
			}
			
			
			logger.debug("AttributeGroupSQLParser.deleteAttribute ִ������б�");
			int step = 0;
			while( step < mSize){
				
				Attribute attr =  config.getAttribute().get( step );
				
				try{
					SQLParserAble attrAble = (SQLParserAble)SQLParserFactory.getQueryDefineInterpreter(attr);
					if( attrAble == null ){
						logger.warn( "AttributeGroupSQLParser.deleteAttribute ����attribute���Գ�Աû����ȷ��ʵ������SQLParserAble��" );
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
					logger.warn("�쳣��" + e.getMessage());
					step++;	
					continue;
				}
				step++;				
			}
			
			
			logger.debug("AttributeGroupSQLParser.deleteAttribute ������ϡ�");
			
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}
}