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
	
	@Override
	public RequestTask parserCommandForQuery(RequestTask selectTask, 
			RequestTask whereTask, 
			RequestTask orderbyTask, 
			RequestTask groupbyTask,
			RequestTask dataset
			) throws Exception{
		
		RequestTask result = null;
		
		if( selectTask == null ){
			throw new Exception("SQLGenerateFormAction����parserCommandForQuery���� �쳣����ڲ���selectTaskû��ָ����");
		}
		
		ServiceTask selectPart = (ServiceTask)parserSelectPartOFQuery( selectTask );
		
		if( selectPart == null ){
			throw new Exception("SQLGenerateFormAction����parserCommandForQuery���� �쳣������selectTask����SelectPart ����");
		}
		
		if( UtilTools.isNull( selectPart.getCommandContent() )){
			throw new Exception("SQLGenerateFormAction����parserCommandForQuery���� �쳣������selectTask����SelectPart�е�CommandContentΪ�ա�");
		}
		
		StringBuffer sBuf = new StringBuffer();
		
		sBuf.append(" SELECT ");
		
		/* ����Select ���� */
		sBuf.append( UtilTools.getTrim( selectPart.getCommandContent() ) );
		
		if( dataset == null ){
			throw new Exception("SQLGenerateFormAction����parserCommandForQuery���� �쳣����ڲ���datasetû��ָ����");
		}
		ServiceTask datasetPart = (ServiceTask) dataset;
		
		if( datasetPart == null ){
			throw new Exception("SQLGenerateFormAction����parserCommandForQuery���� �쳣����ڲ���dataset�����ܱ�ServiceTask���͡�");
		}
		
		
		sBuf.append(" FROM ");
		
		/* ���� Dataset ���� */
		sBuf.append( UtilTools.getTrim( datasetPart.getCommandContent() ) );
		
		RequestParameter parameter = new RequestParameterGroup();
		( (RequestParameterGroup)parameter ).setRequestParameter( new ArrayList<RequestParameter>() );
		
		SQLCommandAble parameterAble = SQLCommandFactory.getQueryDefineInterpreter( parameter );
		/* ����Where ���������� */
		if( whereTask != null ){
			ServiceTask wherepart = (ServiceTask)whereTask;
			/* ���Where Parameter */
			parameterAble.addParameter( wherepart.getRequestParameter() );
			if( !UtilTools.isNull( wherepart.getCommandContent() )){
				sBuf.append(" WHERE ");
				sBuf.append( UtilTools.getTrim( wherepart.getCommandContent() ) );
			}
		}
		
		if( datasetPart != null ){
			/* ���Dataset ���ֵ�parameters  */
			parameterAble.addParameter( datasetPart.getRequestParameter() );
		}
		
		/*����Group by  ����*/
		if( groupbyTask != null ){
			ServiceTask grouppart = (ServiceTask)groupbyTask;
			
			if( !UtilTools.isNull( grouppart.getCommandContent() )){
				sBuf.append(" GROUP BY  ");
				sBuf.append( UtilTools.getTrim( grouppart.getCommandContent() ) );
			}
		}
		
		/*����Order By ����*/
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
				throw new Exception("SQLGenerateFormAction����parserCommandForQuery���� �쳣����ڲ���selectTaskû������TaskRequest��");
			}
			
			int mSize = selectGroup.getRequestTask().size();
			
			if( mSize == 0 ){
				throw new Exception("SQLGenerateFormAction����parserCommandForQuery���� �쳣����ڲ���selectTaskû������TaskRequest��");
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
			throw new Exception("SQLGenerateFormAction����parserCommandForQuery���� �쳣����ڲ���selectTask����ת���� ServiceTask��");
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
			throw new Exception("SQLGenerateFormAction����parserCommandForInsert���� �쳣����ڲ���selectTaskû��ָ����");
		}
		
		ServiceTask selectPart = (ServiceTask)parserSelectPartOFQuery( selectTask );
		
		if( selectPart == null ){
			throw new Exception("SQLGenerateFormAction����parserCommandForInsert���� �쳣������selectTask����SelectPart ����");
		}
		
		if( UtilTools.isNull( selectPart.getCommandContent() )){
			throw new Exception("SQLGenerateFormAction����parserCommandForInsert���� �쳣������selectTask����SelectPart�е�CommandContentΪ�ա�");
		}
		
		
		if( valueTask == null ){
			throw new Exception("SQLGenerateFormAction����parserCommandForInsert���� �쳣����ڲ���valueTaskû��ָ����");
		}
		
		ServiceTask valuesPart = (ServiceTask)valueTask;
		
		if( valuesPart == null ){
			throw new Exception("SQLGenerateFormAction����parserCommandForInsert���� �쳣������valuesTask����valuesPart ����");
		}
		
		if( UtilTools.isNull( valuesPart.getCommandContent() )){
			throw new Exception("SQLGenerateFormAction����parserCommandForInsert���� �쳣������selectTask����valuesTask�е�CommandContentΪ�ա�");
		}
		
		
		if( dataset == null ){
			throw new Exception("SQLGenerateFormAction����parserCommandForQuery���� �쳣����ڲ���datasetû��ָ����");
		}
		ServiceTask datasetPart = (ServiceTask) dataset;
		
		if( datasetPart == null ){
			throw new Exception("SQLGenerateFormAction����parserCommandForQuery���� �쳣����ڲ���dataset�����ܱ�ServiceTask���͡�");
		}
		
		RequestParameter parameter = new RequestParameterGroup();
		( (RequestParameterGroup)parameter ).setRequestParameter( new ArrayList<RequestParameter>() );
		
		SQLCommandAble parameterAble = SQLCommandFactory.getQueryDefineInterpreter( parameter );
		
		StringBuffer sBuf = new StringBuffer();
		
		sBuf.append(" INSERT INTO ");
		
		/* ���� Dataset ���� */
		sBuf.append( UtilTools.getTrim( datasetPart.getCommandContent() ) );
		
		/* ����Select ���� */
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
			throw new Exception("SQLGenerateFormAction����parserCommandForDelete���� �쳣����ڲ���whereTaskû��ָ����");
		}
		
		ServiceTask wherePart = (ServiceTask)whereTask;
		
		if( wherePart == null ){
			throw new Exception("SQLGenerateFormAction����parserCommandForInsert���� �쳣������selectTask����wherePart ����");
		}
		
		if( UtilTools.isNull( wherePart.getCommandContent() )){
			throw new Exception("SQLGenerateFormAction����parserCommandForInsert���� �쳣������selectTask����wherePart�е�CommandContentΪ�ա�");
		}
		
		
		if( dataset == null ){
			throw new Exception("SQLGenerateFormAction����parserCommandForQuery���� �쳣����ڲ���datasetû��ָ����");
		}
		ServiceTask datasetPart = (ServiceTask) dataset;
		
		if( datasetPart == null ){
			throw new Exception("SQLGenerateFormAction����parserCommandForQuery���� �쳣����ڲ���dataset�����ܱ�ServiceTask���͡�");
		}
		
		RequestParameter parameter = new RequestParameterGroup();
		( (RequestParameterGroup)parameter ).setRequestParameter( new ArrayList<RequestParameter>() );
		
		SQLCommandAble parameterAble = SQLCommandFactory.getQueryDefineInterpreter( parameter );
		
		StringBuffer sBuf = new StringBuffer();
		
		sBuf.append(" DELETE FROM ");
		
		/* ���� Dataset ���� */
		sBuf.append( UtilTools.getTrim( datasetPart.getCommandContent() ) );
		
		/* ����Where ���� */
		/* ����Where ���������� */
		if( whereTask != null ){
			ServiceTask wherepart = (ServiceTask)whereTask;
			/* ���Where Parameter */
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
			throw new Exception("SQLGenerateFormAction����parserCommandForInsert���� �쳣����ڲ���selectTaskû��ָ����");
		}
		
		ServiceTask selectPart = (ServiceTask) selectTask;
		
		if( selectPart == null ){
			throw new Exception("SQLGenerateFormAction����parserCommandForInsert���� �쳣������selectTask����SelectPart ����");
		}
		
		if( UtilTools.isNull( selectPart.getCommandContent() )){
			throw new Exception("SQLGenerateFormAction����parserCommandForInsert���� �쳣������selectTask����SelectPart�е�CommandContentΪ�ա�");
		}
		
		if( whereTask == null ){
			throw new Exception("SQLGenerateFormAction����parserCommandForUpdate���� �쳣����ڲ���whereTaskû��ָ����");
		}
		
		ServiceTask wherePart = (ServiceTask)whereTask;
		
		if( wherePart == null ){
			throw new Exception("SQLGenerateFormAction����parserCommandForUpdate���� �쳣������selectTask����wherePart ����");
		}
		
		if( UtilTools.isNull( wherePart.getCommandContent() )){
			throw new Exception("SQLGenerateFormAction����parserCommandForUpdate���� �쳣������selectTask����wherePart�е�CommandContentΪ�ա�");
		}
		
		
		if( dataset == null ){
			throw new Exception("SQLGenerateFormAction����parserCommandForUpdate���� �쳣����ڲ���datasetû��ָ����");
		}
		ServiceTask datasetPart = (ServiceTask) dataset;
		
		if( datasetPart == null ){
			throw new Exception("SQLGenerateFormAction����parserCommandForUpdate���� �쳣����ڲ���dataset�����ܱ�ServiceTask���͡�");
		}
		
		RequestParameter parameter = new RequestParameterGroup();
		( (RequestParameterGroup)parameter ).setRequestParameter( new ArrayList<RequestParameter>() );
		
		SQLCommandAble parameterAble = SQLCommandFactory.getQueryDefineInterpreter( parameter );
		
		StringBuffer sBuf = new StringBuffer();
		
		sBuf.append(" UPDATE ");
	
		/* ���� Dataset ���� */
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
		
		
		/* ����Where ���� */
		/* ����Where ���������� */
		if( whereTask != null ){
			ServiceTask wherepart = (ServiceTask)whereTask;
			/* ���Where Parameter */
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
