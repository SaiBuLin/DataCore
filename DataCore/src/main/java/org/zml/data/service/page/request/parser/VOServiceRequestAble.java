package org.zml.data.service.page.request.parser;

import org.zml.data.service.page.request.bind.RequestField;
import org.zml.data.vo.form.VOForm;

/**
 * 
 * @author zlmwork
 * @see v2013.12 
 * 
 * 提取请求的配置
 */
public interface VOServiceRequestAble
{
	public boolean checkQueryElementComfort() throws Exception;
	
	public RequestField getSelectedField(String code)throws Exception;
	
	public RequestField getWhereField(String code)throws Exception;
	
	public RequestField getOrderByField(String code)throws Exception;
	
	public RequestField getGroupbyField(String code)throws Exception;	
	
	/**
	 * 
	 * @param form
	 * @param field
	 * @return
	 * @throws Exception
	 */
	public String parseWhereForSyntax(VOForm form, String alias, String[] fields) throws Exception;
	
}