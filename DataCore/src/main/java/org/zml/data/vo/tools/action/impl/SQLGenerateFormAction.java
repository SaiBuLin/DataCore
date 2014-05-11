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
			throw new Exception("SQLGenerateFormAction调用parseSelectFieldForQuery错误， 异常：入口参数field没有指定。");
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
		((ServiceTask)result).setIndex(0); /* 设置默认值为0 */
		((ServiceTask)result).setCommandContent(UtilTools.getTrim( sBuf.toString() ));
		((ServiceTask)result).setRequestParameter(null);
		return result;
	}

	@Override
	public RequestTask parseSelectFieldForUpdate(String alias, String field,
			String extendString) throws Exception {
		RequestTask result = null;
		
		if( UtilTools.isNull(field )){
			throw new Exception("SQLGenerateFormAction调用parseSelectFieldForUpdate错误， 异常：入口参数field没有指定。");
		}
		
		StringBuffer sBuf = new StringBuffer();
		
		if(!UtilTools.isNull( alias )){
			sBuf.append( UtilTools.getTrim( alias ) );
			sBuf.append(".");			
		}
		
		/* 变量名为@%%@ 来指定 */
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
		((ServiceTask)result).setIndex(0); 								/* 设置默认值为0 */
		((ServiceTask)result).setCommandContent(UtilTools.getTrim( sBuf.toString() ));
		((ServiceTask)result).setRequestParameter(param);	
		return result;
	}

	@Override
	public RequestTask parseSelectFieldForInsert(String alias, String field,
			String extendString) throws Exception {
		RequestTask result = null;
		
		if( UtilTools.isNull(field )){
			throw new Exception("SQLGenerateFormAction调用parseSelectFieldForInsert错误， 异常：入口参数field没有指定。");
		}
		
		StringBuffer sBuf = new StringBuffer();
		
		sBuf.append( UtilTools.getTrim( field ) );
		
		result = new ServiceTask();
		
		((ServiceTask)result).setCode(  UtilTools.getTrim( field ) );
		((ServiceTask)result).setIndex(0); /* 设置默认值为0 */
		((ServiceTask)result).setCommandContent(UtilTools.getTrim( sBuf.toString() ));
		((ServiceTask)result).setRequestParameter(null);
		return result;
	}
	
	@Override
	public RequestTask parseSelectFieldForInsertValues(String alias, String field, String extendString) throws Exception{
		RequestTask result = null;
		
		if( UtilTools.isNull(field )){
			throw new Exception("SQLGenerateFormAction调用parseSelectFieldForInsertValues错误， 异常：入口参数field没有指定。");
		}
		
		StringBuffer sBuf = new StringBuffer();
		
		/* 变量名为@%%@ 来指定 */
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
		((ServiceTask)result).setIndex(0); 								/* 设置默认值为0 */
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
			throw new Exception("SQLGenerateFormAction调用parseWhereFieldForQuery错误， 异常：入口参数field没有指定。");
		}
		
		StringBuffer sBuf = new StringBuffer();
		
		if(!UtilTools.isNull( alias )){
			sBuf.append( UtilTools.getTrim( alias ) );
			sBuf.append(".");			
		}
		
		/* 变量名为@%%@ 来指定 */
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
		((ServiceTask)result).setIndex(0); 								/* 设置默认值为0 */
		((ServiceTask)result).setCommandContent(UtilTools.getTrim( sBuf.toString() ));
		((ServiceTask)result).setRequestParameter(param);	
		return result;
	}

	@Override
	public RequestTask parseWhereFieldForUpdate(String alias, String field,
			String extendString) throws Exception {
		RequestTask result = null;
		if( UtilTools.isNull(field )){
			throw new Exception("SQLGenerateFormAction调用parseWhereFieldForUpdate错误， 异常：入口参数field没有指定。");
		}
		
		StringBuffer sBuf = new StringBuffer();
		
		if(!UtilTools.isNull( alias )){
			sBuf.append( UtilTools.getTrim( alias ) );
			sBuf.append(".");			
		}
		
		/* 变量名为@%%@ 来指定 */
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
		((ServiceTask)result).setIndex(0); 								/* 设置默认值为0 */
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
			throw new Exception("SQLGenerateFormAction调用parseWhereFieldForDelete错误， 异常：入口参数field没有指定。");
		}
		
		StringBuffer sBuf = new StringBuffer();
		
		if(!UtilTools.isNull( alias )){
			sBuf.append( UtilTools.getTrim( alias ) );
			sBuf.append(".");			
		}
		
		/* 变量名为@%%@ 来指定 */
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
		((ServiceTask)result).setIndex(0); 								/* 设置默认值为0 */
		((ServiceTask)result).setCommandContent(UtilTools.getTrim( sBuf.toString() ));
		((ServiceTask)result).setRequestParameter(param);	
		return result;
	}

	@Override
	public RequestTask parseOrderFieldForQuery(String alias, String field,
			String extendString) throws Exception {
		RequestTask result = null;
		if( UtilTools.isNull(field )){
			throw new Exception("SQLGenerateFormAction调用parseOrderFieldForQuery错误， 异常：入口参数field没有指定。");
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
		((ServiceTask)result).setIndex(0); /* 设置默认值为0 */
		((ServiceTask)result).setCommandContent(UtilTools.getTrim( sBuf.toString() ));
		((ServiceTask)result).setRequestParameter(null);
		return result;
	}

	@Override
	public RequestTask parseGroupbyFieldForQuery(String alias, String field,
			String extendString) throws Exception {
		RequestTask result = null;
		if( UtilTools.isNull(field )){
			throw new Exception("SQLGenerateFormAction调用parseOrderFieldForQuery错误， 异常：入口参数field没有指定。");
		}
		
		StringBuffer sBuf = new StringBuffer();
		
		if(!UtilTools.isNull( alias )){
			sBuf.append( UtilTools.getTrim( alias ) );
			sBuf.append(".");			
		}
		sBuf.append( UtilTools.getTrim( field ) );
		
		
		result = new ServiceTask();
		
		((ServiceTask)result).setCode(  UtilTools.getTrim( field ) );
		((ServiceTask)result).setIndex(0); /* 设置默认值为0 */
		((ServiceTask)result).setCommandContent(UtilTools.getTrim( sBuf.toString() ));
		((ServiceTask)result).setRequestParameter(null);
		return result;
	}

	
}
