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
			logger.debug("AttributeGroupSQLParser��ʼִ��loadProperties��");
			
			if( !this.checkQueryElementComfort() ){
				return ;
			}
			
			if( properties == null ){
				throw new Exception( "loadProperties����ڲ���propertiesΪ�ա�" );
			}
			
			AttributeGroup config = (AttributeGroup)this.queryDefineElement;
			
			if( config == null ){
				throw new Exception( "AttributeGroupǿ��ת������" );
			}
			
			if( config.getAttribute() == null ){
				throw new Exception( "AttributeGroup������Attributeû�����á�" );
			}
			
			int mSize = config.getAttribute().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				Attribute attr =  config.getAttribute().get(ii);
				SQLParserAble attrAble = SQLParserFactory.getQueryDefineInterpreter( attr );
				if( attrAble == null )continue;
				attrAble.loadProperties( properties );
			}
			
			logger.debug("AttributeGroupSQLParserִ��loadProperties��ϡ�");
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("AttributeGroupSQLParser::loadProperties �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("AttributeGroupSQLParser::loadProperties �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("AttributeGroupSQLParser::loadProperties �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
	}
}