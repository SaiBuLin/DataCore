package org.zml.data.service.page.request.parser;
import java.util.ArrayList;
import java.util.List;

import org.zml.data.service.page.request.bind.RequestPart;
import org.zml.data.service.page.request.bind.RequestPartGroup;
import org.zml.util.UtilTools;

public class RequestPartGroupVOServiceRequest extends VOServiceRequest implements VOServiceRequestAble
{
	public RequestPartGroupVOServiceRequest( RequestPartGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof RequestPartGroup))
		{
			throw new Exception(" RequestPartGroupVOServiceRequest only parse RequestPartGroup");
		}
		result = true;
		return result;
	}
	
	@Override
	public List<String> listSelectFieldNames() throws Exception {
		logger.debug("RequestPartGroupVOServiceRequest ִ��listSelectFieldNames��");
		List<String> result = new ArrayList<String>();
		try{
						
			/* ǿ��ת�� */
			logger.debug("listSelectFieldNames ִ�У���queryDefineElementǿ��ת����RequestPartGroup.");
			RequestPartGroup config = (RequestPartGroup)this.getQueryDefineElement();
			
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
					logger.error("RequestPartGroupVOServiceRequest ִ��listSelectFieldNames ���ִ�������RequestPart �г�Աû�ж�Ӧ��VOServiceRequestAble��");
					continue;
				}
				
				List<String> lstResult = requestAble.listSelectFieldNames();
				if(lstResult != null ){
					result.addAll( lstResult );
				}
			}
			logger.debug("RequestPartGroupVOServiceRequest ִ��listSelectFieldNames��ϡ�");
			return result;			
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("RequestPartGroupVOServiceRequest::listSelectFieldNames �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("RequestPartGroupVOServiceRequest::listSelectFieldNames �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("RequestPartGroupVOServiceRequest::listSelectFieldNames �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return new ArrayList<String>();
	}

	@Override
	public List<String> listWhereFieldNames() throws Exception {
		logger.debug("RequestPartGroupVOServiceRequest ִ��listWhereFieldNames��");
		List<String> result = new ArrayList<String>();
		try{
						
			/* ǿ��ת�� */
			logger.debug("listWhereFieldNames ִ�У���queryDefineElementǿ��ת����QueryRequest.");
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
					logger.error("RequestPartGroupVOServiceRequest ִ��listWhereFieldNames ���ִ�������RequestPart �г�Աû�ж�Ӧ��VOServiceRequestAble��");
					continue;
				}
				
				List<String> lstResult = requestAble.listWhereFieldNames();
				if(lstResult != null ){
					result.addAll( lstResult );
				}
			}
			logger.debug("RequestPartGroupVOServiceRequest ִ��listWhereFieldNames ��ϡ�");
			return result;			
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("RequestPartGroupVOServiceRequest::listWhereFieldNames �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("RequestPartGroupVOServiceRequest::listWhereFieldNames �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("RequestPartGroupVOServiceRequest::listWhereFieldNames �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return new ArrayList<String>();
	}

	@Override
	public List<String> listOrderByFieldNames() throws Exception {
		logger.debug("RequestPartGroupVOServiceRequest ִ��listOrderByFieldNames��");
		List<String> result = new ArrayList<String>();
		try{
						
			/* ǿ��ת�� */
			logger.debug("listOrderByFieldNames ִ�У���queryDefineElementǿ��ת����QueryRequest.");
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
					logger.error("RequestPartGroupVOServiceRequest ִ��listOrderByFieldNames ���ִ�������RequestPart �г�Աû�ж�Ӧ��VOServiceRequestAble��");
					continue;
				}
				
				List<String> lstResult = requestAble.listOrderByFieldNames();
				if(lstResult != null ){
					result.addAll( lstResult );
				}
			}
			logger.debug("RequestPartGroupVOServiceRequest ִ��listOrderByFieldNames��ϡ�");
			return result;			
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("RequestPartGroupVOServiceRequest::listOrderByFieldNames �׳��쳣�� �쳣�ࣺ" + execeptionClassName);
				}
				logger.error("RequestPartGroupVOServiceRequest::listOrderByFieldNames �׳��쳣�� �쳣��Ϣ��" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("RequestPartGroupVOServiceRequest::listOrderByFieldNames �׳��쳣�� �쳣��Ϣ��" + localMessage);
				}
			}
		}
		return new ArrayList<String>();
	}
}