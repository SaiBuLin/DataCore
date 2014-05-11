package org.zml.data.vo.tools.action.impl;

import org.zml.data.vo.command.bind.ParamValueType;
import org.zml.data.vo.command.bind.RequestTask;
import org.zml.data.vo.command.bind.ServiceParameter;
import org.zml.data.vo.command.bind.ServiceTask;
import org.zml.data.vo.tools.action.IFormActionTools;
import org.zml.util.UtilTools;
import org.zml.vo.AIVOEngine;

public class SQLGenerateFormAction extends AIVOEngine implements IFormActionTools {

	@Override
	public RequestTask parseSelectFieldForQuery(
			String alias, String field,
			String extendString) throws Exception {
		RequestTask result = null;
		
		if( UtilTools.isNull(field )){
			throw new Exception("SQLGenerateFormAction����parseSelectFieldForQuery���� �쳣����ڲ���fieldû��ָ����");
		}
		
		StringBuffer sBuf = new StringBuffer();
		
		if(!UtilTools.isNull( alias )){
			sBuf.append( UtilTools.getTrim( alias ) );
			sBuf.append(".");			
		}
		sBuf.append( UtilTools.getTrim( field ) );
		
		if(!UtilTools.isNull( extendString )){
			sBuf.append( " AS " );
			sBuf.append( UtilTools.getTrim( extendString ) );		
		}
		
		result = new ServiceTask();
		
		((ServiceTask)result).setCode(  UtilTools.getTrim( field ) );
		((ServiceTask)result).setIndex(0); /* ����Ĭ��ֵΪ0 */
		((ServiceTask)result).setCommandContent(UtilTools.getTrim( sBuf.toString() ));
		((ServiceTask)result).setRequestParameter(null);
		return result;
	}

	@Override
	public RequestTask parseSelectFieldForUpdate(String alias, String field,
			String extendString) throws Exception {
		RequestTask result = null;
		
		if( UtilTools.isNull(field )){
			throw new Exception("SQLGenerateFormAction����parseSelectFieldForUpdate���� �쳣����ڲ���fieldû��ָ����");
		}
		
		StringBuffer sBuf = new StringBuffer();
		
		if(!UtilTools.isNull( alias )){
			sBuf.append( UtilTools.getTrim( alias ) );
			sBuf.append(".");			
		}
		
		/* ������Ϊ@%%@ ��ָ�� */
		sBuf.append( UtilTools.getTrim( field ) );
		sBuf.append( "=[@<" );
		sBuf.append( UtilTools.getTrim( field ) );
		sBuf.append( "]" );
		
		ServiceParameter param = new ServiceParameter();
		param.setCode(UtilTools.getTrim( field ) );
		param.setParam("[@<" + UtilTools.getTrim( field ) + "]" );
		
		param.setParamtype(ParamValueType.SQLParameter);
		
		param.setValuecontent("");
		
		result = new ServiceTask();
		
		((ServiceTask)result).setCode(  UtilTools.getTrim( field ) );
		((ServiceTask)result).setIndex(0); 								/* ����Ĭ��ֵΪ0 */
		((ServiceTask)result).setCommandContent(UtilTools.getTrim( sBuf.toString() ));
		((ServiceTask)result).setRequestParameter(param);	
		return result;
	}

	@Override
	public RequestTask parseSelectFieldForInsert(String alias, String field,
			String extendString) throws Exception {
		RequestTask result = null;
		
		if( UtilTools.isNull(field )){
			throw new Exception("SQLGenerateFormAction����parseSelectFieldForInsert���� �쳣����ڲ���fieldû��ָ����");
		}
		
		StringBuffer sBuf = new StringBuffer();
		
		sBuf.append( UtilTools.getTrim( field ) );
		
		result = new ServiceTask();
		
		((ServiceTask)result).setCode(  UtilTools.getTrim( field ) );
		((ServiceTask)result).setIndex(0); /* ����Ĭ��ֵΪ0 */
		((ServiceTask)result).setCommandContent(UtilTools.getTrim( sBuf.toString() ));
		((ServiceTask)result).setRequestParameter(null);
		return result;
	}
	
	@Override
	public RequestTask parseSelectFieldForInsertValues(String alias, String field, String extendString) throws Exception{
		RequestTask result = null;
		
		if( UtilTools.isNull(field )){
			throw new Exception("SQLGenerateFormAction����parseSelectFieldForInsertValues���� �쳣����ڲ���fieldû��ָ����");
		}
		
		StringBuffer sBuf = new StringBuffer();
		
		/* ������Ϊ@%%@ ��ָ�� */
		sBuf.append( "[@<" );
		sBuf.append( UtilTools.getTrim( field ) );
		sBuf.append( "]" );
		
		ServiceParameter param = new ServiceParameter();
		param.setCode(UtilTools.getTrim( field ) );
		param.setParam("[@<" + UtilTools.getTrim( field ) + "]" );
		
		param.setParamtype(ParamValueType.SQLParameter);
		
		param.setValuecontent("");
		
		result = new ServiceTask();
		
		((ServiceTask)result).setCode(  UtilTools.getTrim( field ) );
		((ServiceTask)result).setIndex(0); 								/* ����Ĭ��ֵΪ0 */
		((ServiceTask)result).setCommandContent(UtilTools.getTrim( sBuf.toString() ));
		((ServiceTask)result).setRequestParameter(param);	
		return result;
	}

	@Override
	public RequestTask parseSelectFieldForDelete(String alias, String field,
			String extendString) throws Exception {
		return null;
	}

	@Override
	public RequestTask parseWhereFieldForQuery(String alias, String field,
			String extendString) throws Exception {
		RequestTask result = null;
		if( UtilTools.isNull(field )){
			throw new Exception("SQLGenerateFormAction����parseWhereFieldForQuery���� �쳣����ڲ���fieldû��ָ����");
		}
		
		StringBuffer sBuf = new StringBuffer();
		
		if(!UtilTools.isNull( alias )){
			sBuf.append( UtilTools.getTrim( alias ) );
			sBuf.append(".");			
		}
		
		/* ������Ϊ@%%@ ��ָ�� */
		sBuf.append( UtilTools.getTrim( field ) );
		sBuf.append( "=[@<" );
		sBuf.append( UtilTools.getTrim( field ) );
		sBuf.append( "]" );
		
		ServiceParameter param = new ServiceParameter();
		param.setCode(UtilTools.getTrim( field ) );
		param.setParam("[@<" + UtilTools.getTrim( field ) + "]" );
		
		param.setParamtype(ParamValueType.SQLParameter);
		
		param.setValuecontent("");
		
		result = new ServiceTask();
		
		((ServiceTask)result).setCode(  UtilTools.getTrim( field ) );
		((ServiceTask)result).setIndex(0); 								/* ����Ĭ��ֵΪ0 */
		((ServiceTask)result).setCommandContent(UtilTools.getTrim( sBuf.toString() ));
		((ServiceTask)result).setRequestParameter(param);	
		return result;
	}

	@Override
	public RequestTask parseWhereFieldForUpdate(String alias, String field,
			String extendString) throws Exception {
		RequestTask result = null;
		if( UtilTools.isNull(field )){
			throw new Exception("SQLGenerateFormAction����parseWhereFieldForUpdate���� �쳣����ڲ���fieldû��ָ����");
		}
		
		StringBuffer sBuf = new StringBuffer();
		
		if(!UtilTools.isNull( alias )){
			sBuf.append( UtilTools.getTrim( alias ) );
			sBuf.append(".");			
		}
		
		/* ������Ϊ@%%@ ��ָ�� */
		sBuf.append( UtilTools.getTrim( field ) );
		sBuf.append( "=[@<" );
		sBuf.append( UtilTools.getTrim( field ) );
		sBuf.append( "]" );
		
		ServiceParameter param = new ServiceParameter();
		param.setCode(UtilTools.getTrim( field ) );
		param.setParam("[@<" + UtilTools.getTrim( field ) + "]" );
		
		param.setParamtype(ParamValueType.SQLParameter);
		
		param.setValuecontent("");
		
		result = new ServiceTask();
		
		((ServiceTask)result).setCode(  UtilTools.getTrim( field ) );
		((ServiceTask)result).setIndex(0); 								/* ����Ĭ��ֵΪ0 */
		((ServiceTask)result).setCommandContent(UtilTools.getTrim( sBuf.toString() ));
		((ServiceTask)result).setRequestParameter(param);	
		return result;
	}

	@Override
	public RequestTask parseWhereFieldForInsert(String alias, String field,
			String extendString) throws Exception {
		return null;
	}

	@Override
	public RequestTask parseWhereFieldForDelete(String alias, String field,
			String extendString) throws Exception {
		RequestTask result = null;
		if( UtilTools.isNull(field )){
			throw new Exception("SQLGenerateFormAction����parseWhereFieldForDelete���� �쳣����ڲ���fieldû��ָ����");
		}
		
		StringBuffer sBuf = new StringBuffer();
		
		if(!UtilTools.isNull( alias )){
			sBuf.append( UtilTools.getTrim( alias ) );
			sBuf.append(".");			
		}
		
		/* ������Ϊ@%%@ ��ָ�� */
		sBuf.append( UtilTools.getTrim( field ) );
		sBuf.append( "=[@<" );
		sBuf.append( UtilTools.getTrim( field ) );
		sBuf.append( "]" );
		
		ServiceParameter param = new ServiceParameter();
		param.setCode(UtilTools.getTrim( field ) );
		param.setParam("[@<" + UtilTools.getTrim( field ) + "]" );
		
		param.setParamtype(ParamValueType.SQLParameter);
		
		param.setValuecontent("");
		
		result = new ServiceTask();
		
		((ServiceTask)result).setCode(  UtilTools.getTrim( field ) );
		((ServiceTask)result).setIndex(0); 								/* ����Ĭ��ֵΪ0 */
		((ServiceTask)result).setCommandContent(UtilTools.getTrim( sBuf.toString() ));
		((ServiceTask)result).setRequestParameter(param);	
		return result;
	}

	@Override
	public RequestTask parseOrderFieldForQuery(String alias, String field,
			String extendString) throws Exception {
		RequestTask result = null;
		if( UtilTools.isNull(field )){
			throw new Exception("SQLGenerateFormAction����parseOrderFieldForQuery���� �쳣����ڲ���fieldû��ָ����");
		}
		
		StringBuffer sBuf = new StringBuffer();
		
		if(!UtilTools.isNull( alias )){
			sBuf.append( UtilTools.getTrim( alias ) );
			sBuf.append(".");			
		}
		sBuf.append( UtilTools.getTrim( field ) );
		
		if(!UtilTools.isNull( extendString )){
			sBuf.append( "  " );
			sBuf.append( UtilTools.getTrim( extendString ) );		
		}
		
		result = new ServiceTask();
		
		((ServiceTask)result).setCode(  UtilTools.getTrim( field ) );
		((ServiceTask)result).setIndex(0); /* ����Ĭ��ֵΪ0 */
		((ServiceTask)result).setCommandContent(UtilTools.getTrim( sBuf.toString() ));
		((ServiceTask)result).setRequestParameter(null);
		return result;
	}

	@Override
	public RequestTask parseGroupbyFieldForQuery(String alias, String field,
			String extendString) throws Exception {
		RequestTask result = null;
		if( UtilTools.isNull(field )){
			throw new Exception("SQLGenerateFormAction����parseOrderFieldForQuery���� �쳣����ڲ���fieldû��ָ����");
		}
		
		StringBuffer sBuf = new StringBuffer();
		
		if(!UtilTools.isNull( alias )){
			sBuf.append( UtilTools.getTrim( alias ) );
			sBuf.append(".");			
		}
		sBuf.append( UtilTools.getTrim( field ) );
		
		
		result = new ServiceTask();
		
		((ServiceTask)result).setCode(  UtilTools.getTrim( field ) );
		((ServiceTask)result).setIndex(0); /* ����Ĭ��ֵΪ0 */
		((ServiceTask)result).setCommandContent(UtilTools.getTrim( sBuf.toString() ));
		((ServiceTask)result).setRequestParameter(null);
		return result;
	}

	
}
