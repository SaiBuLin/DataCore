package org.zml.data.service.page.request.parser;
import java.util.ArrayList;
import java.util.List;

import org.zml.data.service.page.request.bind.QueryRequest;
import org.zml.data.service.page.request.bind.RequestPart;
import org.zml.util.UtilTools;

public class QueryRequestVOServiceRequest extends VOServiceRequest implements VOServiceRequestAble
{
	public QueryRequestVOServiceRequest( QueryRequest element)
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
		if ( !(this.getQueryDefineElement() instanceof QueryRequest))
		{
			throw new Exception(" QueryRequestVOServiceRequest only parse QueryRequest");
		}
		result = true;
		return result;
	}
	
	@Override
	public List<String> listSelectFieldNames() throws Exception {
		logger.debug("QueryRequestVOServiceRequest ִ��listSelectFieldNames��");
		List<String> result = new ArrayList<String>();
		try{
						
			/* ǿ��ת�� */
			logger.debug("listSelectFieldNames ִ�У���queryDefineElementǿ��ת����QueryRequest.");
			QueryRequest config = (QueryRequest)this.getQueryDefineElement();
			
			if( config == null ){
				throw new java.lang.ClassNotFoundException("ǿ��ת������queryDefineElement ����ת����SchemaConfigure��");
			}
			
			if( config.getRequestPart() == null ){
				throw new Exception("�����У�û���ҵ�Request Part ���֡�");
			}
			
			int mSize = config.getRequestPart().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				RequestPart part =  config.getRequestPart().get(ii);
				if( part == null )continue;
				VOServiceRequestAble requestAble = VOServiceRequestFactory.getQueryDefineInterpreter( part );
				
				if( requestAble == null ){
					logger.error("QueryRequestVOServiceRequest ִ��listSelectFieldNames ���ִ�������RequestPart �г�Աû�ж�Ӧ��VOServiceRequestAble��");
					continue;
				}
				
				List<String> lstResult = requestAble.listSelectFieldNames();
				if(lstResult != null ){
					result.addAll( lstResult );
				}
			}
			
			return result;			
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("QueryRequestVOServiceRequest::listSelectFieldNames �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("QueryRequestVOServiceRequest::listSelectFieldNames �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("QueryRequestVOServiceRequest::listSelectFieldNames �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return new ArrayList<String>();
	}

	@Override
	public List<String> listWhereFieldNames() throws Exception {
		logger.debug("QueryRequestVOServiceRequest ִ��listWhereFieldNames��");
		List<String> result = new ArrayList<String>();
		try{
						
			/* ǿ��ת�� */
			logger.debug("listSelectFieldNames ִ�У���queryDefineElementǿ��ת����QueryRequest.");
			QueryRequest config = (QueryRequest)this.getQueryDefineElement();
			
			if( config == null ){
				throw new java.lang.ClassNotFoundException("ǿ��ת������queryDefineElement ����ת����SchemaConfigure��");
			}
			
			if( config.getRequestPart() == null ){
				throw new Exception("�����У�û���ҵ�Request Part ���֡�");
			}
			
			int mSize = config.getRequestPart().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				RequestPart part =  config.getRequestPart().get(ii);
				if( part == null )continue;
				VOServiceRequestAble requestAble = VOServiceRequestFactory.getQueryDefineInterpreter( part );
				
				if( requestAble == null ){
					logger.error("QueryRequestVOServiceRequest ִ��listSelectFieldNames ���ִ�������RequestPart �г�Աû�ж�Ӧ��VOServiceRequestAble��");
					continue;
				}
				
				List<String> lstResult = requestAble.listWhereFieldNames();
				if(lstResult != null ){
					result.addAll( lstResult );
				}
			}
			
			return result;			
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("QueryRequestVOServiceRequest::listSelectFieldNames �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("QueryRequestVOServiceRequest::listSelectFieldNames �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("QueryRequestVOServiceRequest::listSelectFieldNames �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return new ArrayList<String>();
	}

	@Override
	public List<String> listOrderByFieldNames() throws Exception {
		logger.debug("QueryRequestVOServiceRequest ִ��loadSchemas��");
		List<String> result = new ArrayList<String>();
		try{
						
			/* ǿ��ת�� */
			logger.debug("listSelectFieldNames ִ�У���queryDefineElementǿ��ת����QueryRequest.");
			QueryRequest config = (QueryRequest)this.getQueryDefineElement();
			
			if( config == null ){
				throw new java.lang.ClassNotFoundException("ǿ��ת������queryDefineElement ����ת����SchemaConfigure��");
			}
			
			if( config.getRequestPart() == null ){
				throw new Exception("�����У�û���ҵ�Request Part ���֡�");
			}
			
			int mSize = config.getRequestPart().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				RequestPart part =  config.getRequestPart().get(ii);
				if( part == null )continue;
				VOServiceRequestAble requestAble = VOServiceRequestFactory.getQueryDefineInterpreter( part );
				
				if( requestAble == null ){
					logger.error("QueryRequestVOServiceRequest ִ��listSelectFieldNames ���ִ�������RequestPart �г�Աû�ж�Ӧ��VOServiceRequestAble��");
					continue;
				}
				
				List<String> lstResult = requestAble.listOrderByFieldNames();
				if(lstResult != null ){
					result.addAll( lstResult );
				}
			}
			
			return result;			
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("QueryRequestVOServiceRequest::listSelectFieldNames �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("QueryRequestVOServiceRequest::listSelectFieldNames �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("QueryRequestVOServiceRequest::listSelectFieldNames �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return new ArrayList<String>();
	}

	@Override
	public List<String> listGroupByFieldNames() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}