package org.zml.data.vo.tools.action.impl;

import java.util.ArrayList;

import org.zml.data.vo.command.bind.ParamValueType;
import org.zml.data.vo.command.bind.RequestParameter;
import org.zml.data.vo.command.bind.RequestParameterGroup;
import org.zml.data.vo.command.bind.RequestTask;
import org.zml.data.vo.command.bind.RequestTaskGroup;
import org.zml.data.vo.command.bind.ServiceParameter;
import org.zml.data.vo.command.bind.ServiceTask;
import org.zml.data.vo.command.parser.SQLCommandAble;
import org.zml.data.vo.command.parser.SQLCommandFactory;
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
	
	@Override
	public RequestTask parserCommandForQuery(RequestTask selectTask, 
			RequestTask whereTask, 
			RequestTask orderbyTask, 
			RequestTask groupbyTask,
			RequestTask dataset
			) throws Exception{
		
		RequestTask result = null;
		
		if( selectTask == null ){
			throw new Exception("SQLGenerateFormAction调用parserCommandForQuery错误， 异常：入口参数selectTask没有指定。");
		}
		
		ServiceTask selectPart = (ServiceTask)parserSelectPartOFQuery( selectTask );
		
		if( selectPart == null ){
			throw new Exception("SQLGenerateFormAction调用parserCommandForQuery错误， 异常：根据selectTask生成SelectPart 错误。");
		}
		
		if( UtilTools.isNull( selectPart.getCommandContent() )){
			throw new Exception("SQLGenerateFormAction调用parserCommandForQuery错误， 异常：根据selectTask生成SelectPart中的CommandContent为空。");
		}
		
		StringBuffer sBuf = new StringBuffer();
		
		sBuf.append(" SELECT ");
		
		/* 加入Select 部分 */
		sBuf.append( UtilTools.getTrim( selectPart.getCommandContent() ) );
		
		if( dataset == null ){
			throw new Exception("SQLGenerateFormAction调用parserCommandForQuery错误， 异常：入口参数dataset没有指定。");
		}
		ServiceTask datasetPart = (ServiceTask) dataset;
		
		if( datasetPart == null ){
			throw new Exception("SQLGenerateFormAction调用parserCommandForQuery错误， 异常：入口参数dataset必须能被ServiceTask构型。");
		}
		
		
		sBuf.append(" FROM ");
		
		/* 生成 Dataset 部分 */
		sBuf.append( UtilTools.getTrim( datasetPart.getCommandContent() ) );
		
		RequestParameter parameter = new RequestParameterGroup();
		( (RequestParameterGroup)parameter ).setRequestParameter( new ArrayList<RequestParameter>() );
		
		SQLCommandAble parameterAble = SQLCommandFactory.getQueryDefineInterpreter( parameter );
		/* 生成Where 及条件部分 */
		if( whereTask != null ){
			ServiceTask wherepart = (ServiceTask)whereTask;
			/* 获得Where Parameter */
			parameterAble.addParameter( wherepart.getRequestParameter() );
			if( !UtilTools.isNull( wherepart.getCommandContent() )){
				sBuf.append(" WHERE ");
				sBuf.append( UtilTools.getTrim( wherepart.getCommandContent() ) );
			}
		}
		
		if( datasetPart != null ){
			/* 获得Dataset 部分的parameters  */
			parameterAble.addParameter( datasetPart.getRequestParameter() );
		}
		
		/*生成Group by  部分*/
		if( groupbyTask != null ){
			ServiceTask grouppart = (ServiceTask)groupbyTask;
			
			if( !UtilTools.isNull( grouppart.getCommandContent() )){
				sBuf.append(" GROUP BY  ");
				sBuf.append( UtilTools.getTrim( grouppart.getCommandContent() ) );
			}
		}
		
		/*生成Order By 部分*/
		if( orderbyTask != null ){
			ServiceTask orderpart = (ServiceTask)orderbyTask;
			
			if( !UtilTools.isNull( orderpart.getCommandContent() )){
				sBuf.append(" ORDER BY  ");
				sBuf.append( UtilTools.getTrim( orderpart.getCommandContent() ) );
			}
		}
		
		result = new ServiceTask();
		
		((ServiceTask)result).setCode("Query");
		((ServiceTask)result).setCommandContent( UtilTools.getTrim(sBuf.toString()) );
		((ServiceTask)result).setRequestParameter(parameter);
		
		return result;
	}
	
	
	private RequestTask parserSelectPartOFQuery(RequestTask selectTask) throws Exception{
		RequestTask result = null;
		
		StringBuffer sBuf = new StringBuffer();
		
		if( selectTask instanceof RequestTaskGroup ){
			RequestTaskGroup selectGroup = (RequestTaskGroup)selectTask;
			
			if( selectGroup.getRequestTask() == null ){
				throw new Exception("SQLGenerateFormAction调用parserCommandForQuery错误， 异常：入口参数selectTask没有配置TaskRequest。");
			}
			
			int mSize = selectGroup.getRequestTask().size();
			
			if( mSize == 0 ){
				throw new Exception("SQLGenerateFormAction调用parserCommandForQuery错误， 异常：入口参数selectTask没有配置TaskRequest。");
			}
			
			int mCount = 0;
			for( int ii = 0; ii < mSize; ii++ )
			{
				RequestTask task = selectGroup.getRequestTask().get(ii);
				if( task == null ) continue;
				
				ServiceTask serviceTask = (ServiceTask)task;				
				if( serviceTask != null ){
				
					if( mCount > 0  ){
						sBuf.append(" , ");
					}
					
					sBuf.append(serviceTask.getCommandContent());					
					mCount++;
				}
			}
		} 
		else if( selectTask instanceof ServiceTask ){
			ServiceTask serviceTask = (ServiceTask)selectTask;
			
			if( serviceTask != null ){
				sBuf.append(serviceTask.getCommandContent());
			}
		}
		else {
			throw new Exception("SQLGenerateFormAction调用parserCommandForQuery错误， 异常：入口参数selectTask不能转换成 ServiceTask。");
		}
		
		result = new ServiceTask();
		
		((ServiceTask)result).setCode("10");
		((ServiceTask)result).setCommandContent( sBuf.toString() );
		((ServiceTask)result).setIndex(0);
		return result;
		
	}
	
	
	
	@Override
	public RequestTask parserCommandForInsert(
			RequestTask selectTask, 
			RequestTask valueTask,
			RequestTask dataset) throws Exception{
				
		RequestTask result = null;
		if( selectTask == null ){
			throw new Exception("SQLGenerateFormAction调用parserCommandForInsert错误， 异常：入口参数selectTask没有指定。");
		}
		
		ServiceTask selectPart = (ServiceTask)parserSelectPartOFQuery( selectTask );
		
		if( selectPart == null ){
			throw new Exception("SQLGenerateFormAction调用parserCommandForInsert错误， 异常：根据selectTask生成SelectPart 错误。");
		}
		
		if( UtilTools.isNull( selectPart.getCommandContent() )){
			throw new Exception("SQLGenerateFormAction调用parserCommandForInsert错误， 异常：根据selectTask生成SelectPart中的CommandContent为空。");
		}
		
		
		if( valueTask == null ){
			throw new Exception("SQLGenerateFormAction调用parserCommandForInsert错误， 异常：入口参数valueTask没有指定。");
		}
		
		ServiceTask valuesPart = (ServiceTask)valueTask;
		
		if( valuesPart == null ){
			throw new Exception("SQLGenerateFormAction调用parserCommandForInsert错误， 异常：根据valuesTask生成valuesPart 错误。");
		}
		
		if( UtilTools.isNull( valuesPart.getCommandContent() )){
			throw new Exception("SQLGenerateFormAction调用parserCommandForInsert错误， 异常：根据selectTask生成valuesTask中的CommandContent为空。");
		}
		
		
		if( dataset == null ){
			throw new Exception("SQLGenerateFormAction调用parserCommandForQuery错误， 异常：入口参数dataset没有指定。");
		}
		ServiceTask datasetPart = (ServiceTask) dataset;
		
		if( datasetPart == null ){
			throw new Exception("SQLGenerateFormAction调用parserCommandForQuery错误， 异常：入口参数dataset必须能被ServiceTask构型。");
		}
		
		RequestParameter parameter = new RequestParameterGroup();
		( (RequestParameterGroup)parameter ).setRequestParameter( new ArrayList<RequestParameter>() );
		
		SQLCommandAble parameterAble = SQLCommandFactory.getQueryDefineInterpreter( parameter );
		
		StringBuffer sBuf = new StringBuffer();
		
		sBuf.append(" INSERT INTO ");
		
		/* 生成 Dataset 部分 */
		sBuf.append( UtilTools.getTrim( datasetPart.getCommandContent() ) );
		
		/* 加入Select 部分 */
		sBuf.append(" (");
		sBuf.append( UtilTools.getTrim( selectPart.getCommandContent() ) );
		sBuf.append(" )");
		
		
		sBuf.append("VALUES");
		sBuf.append(" (");
		sBuf.append( UtilTools.getTrim( valuesPart.getCommandContent() ) );
		sBuf.append(" )");
		
		parameterAble.addParameter( valuesPart.getRequestParameter() );
		
		result = new ServiceTask();
		
		((ServiceTask)result).setCode("Insert");
		((ServiceTask)result).setCommandContent( UtilTools.getTrim(sBuf.toString()) );
		((ServiceTask)result).setRequestParameter(parameter);
		
		return result;
	}

	@Override
	public RequestTask parserCommandForDelete(RequestTask whereTask,
			RequestTask dataset) throws Exception {
		
		RequestTask result = null;
		
		
		if( whereTask == null ){
			throw new Exception("SQLGenerateFormAction调用parserCommandForDelete错误， 异常：入口参数whereTask没有指定。");
		}
		
		ServiceTask wherePart = (ServiceTask)whereTask;
		
		if( wherePart == null ){
			throw new Exception("SQLGenerateFormAction调用parserCommandForInsert错误， 异常：根据selectTask生成wherePart 错误。");
		}
		
		if( UtilTools.isNull( wherePart.getCommandContent() )){
			throw new Exception("SQLGenerateFormAction调用parserCommandForInsert错误， 异常：根据selectTask生成wherePart中的CommandContent为空。");
		}
		
		
		if( dataset == null ){
			throw new Exception("SQLGenerateFormAction调用parserCommandForQuery错误， 异常：入口参数dataset没有指定。");
		}
		ServiceTask datasetPart = (ServiceTask) dataset;
		
		if( datasetPart == null ){
			throw new Exception("SQLGenerateFormAction调用parserCommandForQuery错误， 异常：入口参数dataset必须能被ServiceTask构型。");
		}
		
		RequestParameter parameter = new RequestParameterGroup();
		( (RequestParameterGroup)parameter ).setRequestParameter( new ArrayList<RequestParameter>() );
		
		SQLCommandAble parameterAble = SQLCommandFactory.getQueryDefineInterpreter( parameter );
		
		StringBuffer sBuf = new StringBuffer();
		
		sBuf.append(" DELETE FROM ");
		
		/* 生成 Dataset 部分 */
		sBuf.append( UtilTools.getTrim( datasetPart.getCommandContent() ) );
		
		/* 加入Where 部分 */
		/* 生成Where 及条件部分 */
		if( whereTask != null ){
			ServiceTask wherepart = (ServiceTask)whereTask;
			/* 获得Where Parameter */
			parameterAble.addParameter( wherepart.getRequestParameter() );
			if( !UtilTools.isNull( wherepart.getCommandContent() )){
				sBuf.append(" WHERE ");
				sBuf.append( UtilTools.getTrim( wherepart.getCommandContent() ) );
			}
		}
		
		result = new ServiceTask();
		
		((ServiceTask)result).setCode("Delete");
		((ServiceTask)result).setCommandContent( UtilTools.getTrim(sBuf.toString()) );
		((ServiceTask)result).setRequestParameter(parameter);
		
		return result;
	}

	@Override
	public RequestTask parserCommandForUpdate(RequestTask selectTask,
			RequestTask whereTask, RequestTask dataset) throws Exception {
		RequestTask result = null;
		
		if( selectTask == null ){
			throw new Exception("SQLGenerateFormAction调用parserCommandForInsert错误， 异常：入口参数selectTask没有指定。");
		}
		
		ServiceTask selectPart = (ServiceTask) selectTask;
		
		if( selectPart == null ){
			throw new Exception("SQLGenerateFormAction调用parserCommandForInsert错误， 异常：根据selectTask生成SelectPart 错误。");
		}
		
		if( UtilTools.isNull( selectPart.getCommandContent() )){
			throw new Exception("SQLGenerateFormAction调用parserCommandForInsert错误， 异常：根据selectTask生成SelectPart中的CommandContent为空。");
		}
		
		if( whereTask == null ){
			throw new Exception("SQLGenerateFormAction调用parserCommandForUpdate错误， 异常：入口参数whereTask没有指定。");
		}
		
		ServiceTask wherePart = (ServiceTask)whereTask;
		
		if( wherePart == null ){
			throw new Exception("SQLGenerateFormAction调用parserCommandForUpdate错误， 异常：根据selectTask生成wherePart 错误。");
		}
		
		if( UtilTools.isNull( wherePart.getCommandContent() )){
			throw new Exception("SQLGenerateFormAction调用parserCommandForUpdate错误， 异常：根据selectTask生成wherePart中的CommandContent为空。");
		}
		
		
		if( dataset == null ){
			throw new Exception("SQLGenerateFormAction调用parserCommandForUpdate错误， 异常：入口参数dataset没有指定。");
		}
		ServiceTask datasetPart = (ServiceTask) dataset;
		
		if( datasetPart == null ){
			throw new Exception("SQLGenerateFormAction调用parserCommandForUpdate错误， 异常：入口参数dataset必须能被ServiceTask构型。");
		}
		
		RequestParameter parameter = new RequestParameterGroup();
		( (RequestParameterGroup)parameter ).setRequestParameter( new ArrayList<RequestParameter>() );
		
		SQLCommandAble parameterAble = SQLCommandFactory.getQueryDefineInterpreter( parameter );
		
		StringBuffer sBuf = new StringBuffer();
		
		sBuf.append(" UPDATE ");
	
		/* 生成 Dataset 部分 */
		sBuf.append( UtilTools.getTrim( datasetPart.getCommandContent() ) );
		
		if( selectPart != null ){
			
			if( !UtilTools.isNull( selectPart.getCommandContent() )){
				sBuf.append(" SET ");
				sBuf.append( UtilTools.getTrim( selectPart.getCommandContent() ) );
			}
			
			
			if( parameterAble != null ){
				parameterAble.addParameter( selectPart.getRequestParameter() );
			}
		}
		
		
		/* 加入Where 部分 */
		/* 生成Where 及条件部分 */
		if( whereTask != null ){
			ServiceTask wherepart = (ServiceTask)whereTask;
			/* 获得Where Parameter */
			if( parameterAble != null ){
				parameterAble.addParameter( wherepart.getRequestParameter() );
			}
			if( !UtilTools.isNull( wherepart.getCommandContent() )){
				sBuf.append(" WHERE ");
				sBuf.append( UtilTools.getTrim( wherepart.getCommandContent() ) );
			}
		}
		
		result = new ServiceTask();
		
		((ServiceTask)result).setCode("Delete");
		((ServiceTask)result).setCommandContent( UtilTools.getTrim(sBuf.toString()) );
		((ServiceTask)result).setRequestParameter(parameter);
		
		return result;
	}
	
	
}
