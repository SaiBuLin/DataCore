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
		logger.debug("RequestPartGroupVOServiceRequest 执行listSelectFieldNames。");
		List<String> result = new ArrayList<String>();
		try{
						
			/* 强制转换 */
			logger.debug("listSelectFieldNames 执行：将queryDefineElement强制转换成RequestPartGroup.");
			RequestPartGroup config = (RequestPartGroup)this.getQueryDefineElement();
			
			if( config == null ){
				throw new java.lang.ClassNotFoundException("强制转换错误。queryDefineElement 不能转换成SchemaConfigure。");
			}
			
			if( config.getRequestPart() == null ){
				throw new Exception("请求中，没有找到Request Part 部分。");
			}
			
			int mSize = config.getRequestPart().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				RequestPart part =  config.getRequestPart().get(ii);
				if( part == null )continue;
				VOServiceRequestAble requestAble = VOServiceRequestFactory.getQueryDefineInterpreter( part );
				
				if( requestAble == null ){
					logger.error("RequestPartGroupVOServiceRequest 执行listSelectFieldNames 出现错误，其中RequestPart 有成员没有对应的VOServiceRequestAble。");
					continue;
				}
				
				List<String> lstResult = requestAble.listSelectFieldNames();
				if(lstResult != null ){
					result.addAll( lstResult );
				}
			}
			logger.debug("RequestPartGroupVOServiceRequest 执行listSelectFieldNames完毕。");
			return result;			
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("RequestPartGroupVOServiceRequest::listSelectFieldNames 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("RequestPartGroupVOServiceRequest::listSelectFieldNames 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("RequestPartGroupVOServiceRequest::listSelectFieldNames 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return new ArrayList<String>();
	}

	@Override
	public List<String> listWhereFieldNames() throws Exception {
		logger.debug("RequestPartGroupVOServiceRequest 执行listWhereFieldNames。");
		List<String> result = new ArrayList<String>();
		try{
						
			/* 强制转换 */
			logger.debug("listWhereFieldNames 执行：将queryDefineElement强制转换成QueryRequest.");
			QueryRequest config = (QueryRequest)this.getQueryDefineElement();
			
			if( config == null ){
				throw new java.lang.ClassNotFoundException("强制转换错误。queryDefineElement 不能转换成SchemaConfigure。");
			}
			
			if( config.getRequestPart() == null ){
				throw new Exception("请求中，没有找到Request Part 部分。");
			}
			
			int mSize = config.getRequestPart().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				RequestPart part =  config.getRequestPart().get(ii);
				if( part == null )continue;
				VOServiceRequestAble requestAble = VOServiceRequestFactory.getQueryDefineInterpreter( part );
				
				if( requestAble == null ){
					logger.error("RequestPartGroupVOServiceRequest 执行listWhereFieldNames 出现错误，其中RequestPart 有成员没有对应的VOServiceRequestAble。");
					continue;
				}
				
				List<String> lstResult = requestAble.listWhereFieldNames();
				if(lstResult != null ){
					result.addAll( lstResult );
				}
			}
			logger.debug("RequestPartGroupVOServiceRequest 执行listWhereFieldNames 完毕。");
			return result;			
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("RequestPartGroupVOServiceRequest::listWhereFieldNames 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("RequestPartGroupVOServiceRequest::listWhereFieldNames 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("RequestPartGroupVOServiceRequest::listWhereFieldNames 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return new ArrayList<String>();
	}

	@Override
	public List<String> listOrderByFieldNames() throws Exception {
		logger.debug("RequestPartGroupVOServiceRequest 执行listOrderByFieldNames。");
		List<String> result = new ArrayList<String>();
		try{
						
			/* 强制转换 */
			logger.debug("listOrderByFieldNames 执行：将queryDefineElement强制转换成QueryRequest.");
			QueryRequest config = (QueryRequest)this.getQueryDefineElement();
			
			if( config == null ){
				throw new java.lang.ClassNotFoundException("强制转换错误。queryDefineElement 不能转换成SchemaConfigure。");
			}
			
			if( config.getRequestPart() == null ){
				throw new Exception("请求中，没有找到Request Part 部分。");
			}
			
			int mSize = config.getRequestPart().size();
			
			for( int ii = 0; ii < mSize; ii++ ){
				RequestPart part =  config.getRequestPart().get(ii);
				if( part == null )continue;
				VOServiceRequestAble requestAble = VOServiceRequestFactory.getQueryDefineInterpreter( part );
				
				if( requestAble == null ){
					logger.error("RequestPartGroupVOServiceRequest 执行listOrderByFieldNames 出现错误，其中RequestPart 有成员没有对应的VOServiceRequestAble。");
					continue;
				}
				
				List<String> lstResult = requestAble.listOrderByFieldNames();
				if(lstResult != null ){
					result.addAll( lstResult );
				}
			}
			logger.debug("RequestPartGroupVOServiceRequest 执行listOrderByFieldNames完毕。");
			return result;			
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName = e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("RequestPartGroupVOServiceRequest::listOrderByFieldNames 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("RequestPartGroupVOServiceRequest::listOrderByFieldNames 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("RequestPartGroupVOServiceRequest::listOrderByFieldNames 抛出异常， 异常信息：" + localMessage);
				}
			}
		}
		return new ArrayList<String>();
	}
}