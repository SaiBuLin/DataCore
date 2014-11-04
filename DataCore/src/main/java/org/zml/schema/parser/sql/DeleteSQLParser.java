package org.zml.schema.parser.sql;
import java.util.ArrayList;

import org.zml.data.SQLParameter;
import org.zml.data.SQLString;
import org.zml.form.bind.FormNode;
import org.zml.schema.bind.Delete;
import org.zml.schema.bind.Field;
import org.zml.util.UtilTools;

public class DeleteSQLParser extends SQLParser implements SQLParserAble
{
	public DeleteSQLParser( Delete element)
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
		if ( !(this.getQueryDefineElement() instanceof Delete))
		{
			throw new Exception(" DeleteSQLParser only parse Delete");
		}
		result = true;
		return result;
	}
	
	/**
	 * �ýӿ���command ʵ��
	 * @param field
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	@Override
	public SQLString parserSQLString( Field field,  String alias, String content, FormNode formrequest) throws Exception{
		SQLString result = null;
		try{
			logger.debug("DeleteSQLParser.parserSQLString ��ʼ�����á�");
			
			if(!this.checkQueryElementComfort()){
				return result;
			}
			
			if( formrequest == null ){
				throw new Exception("��ڲ���formrequest��null��");
			}
			
			if( field == null ){
				throw new Exception("��ڲ���fieldΪ�ա�");
			}
			
			if( UtilTools.isNull(content)){
				throw new Exception("��ڲ���content Ϊ�գ� ����ڲ�����Ҫ�����Ӧֵ��");
			}
			
			//Query config = (Query)this.queryDefineElement;
			
			SQLParserAble fieldable = SQLParserFactory.getQueryDefineInterpreter(field);
			if( fieldable == null ){
				throw new Exception("��ڲ���fieldʵ����SQLParserAble����");
			}
			/* ���Condition Field  */
			SQLString whereString = fieldable.parserSQLStringForWhereString(alias, formrequest);
			
				
			result = new SQLString();
			
			result.setParameters(new ArrayList<SQLParameter>());
			result.setSqlString("");
			
			StringBuffer sBuf = new StringBuffer();
			
			sBuf.append( " DELETE " );
			sBuf.append(" FROM ");
			
			sBuf.append( UtilTools.getTrim(content) );			
			
			if( whereString != null ){
				if( !UtilTools.isNull( whereString.getSqlString()) ){
					sBuf.append( " WHERE " );
					sBuf.append( UtilTools.getTrim( whereString.getSqlString()) );
				}
			}
			
			
			result.setSqlString( sBuf.toString() );
			
			if( whereString.getParameters() != null ){
				result.getParameters().addAll( whereString.getParameters() );
			}
			logger.debug("DeleteSQLParser.parserSQLString ������ϡ�");
			return result;
		}catch(Exception e){
			logger.error( "�쳣��Ϣ��" + e.getMessage() );
			throw e;
		}
	}
}