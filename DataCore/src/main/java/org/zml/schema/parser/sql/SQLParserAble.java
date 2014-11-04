package org.zml.schema.parser.sql;

import java.util.List;
import java.util.Map;

import org.zml.data.FieldInfo;
import org.zml.data.SQLParameter;
import org.zml.data.SQLString;
import org.zml.data.dataset.bind.NetDataSet;
import org.zml.form.bind.ConditionSection;
import org.zml.form.bind.FormNode;
import org.zml.schema.bind.Field;
import org.zml.schema.bind.Service;


public interface SQLParserAble
{
	public boolean checkQueryElementComfort() throws Exception;
	
	
	/**
	 * 该方法， 用于SchemaConfig, 获得对应SQL 文
	 * @param formcode
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	public SQLString parserSQLString(String formcode, FormNode formrequest) throws Exception;
	
	/**
	 * 该接口用Form 和View 对象的Parser 实现， 以供SchemaConfig 调用
	 * 根据Form 进行SQL 生成
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public SQLString parserSQLString(FormNode formrequest) throws Exception;
	
	/**
	 * 该接口由command 实现
	 * @param field
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	public SQLString parserSQLString( Field field, String alias, String content,  FormNode formrequest) throws Exception;
	
	/**
	 * 该方法， 用于SchemaConfig 
	 * @param formcode  Schema Code 的值
	 * @param field 	field
	 * @return          如果字段Field 对应有字典，则返回Map<String,String> 格式Map<key,value> 模式。
	 * @throws Exception
	 */
	public Map<String, String> getLibrary(String formcode, String field) throws Exception;
	
	/**
	 * 该接口用Form 和View 对象的Parser 实现， 以供SchemaConfig 调用
	 * @param field
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> getLibrary(String field) throws Exception;
	
	/**
	 * 该接口由Form 对应Parser 实现。获得对应的SELECT 部分 字段列表, 该接口被Field 实现
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	public List<FieldInfo> getSelectFields( String alias, FormNode formrequest) throws Exception;
	
	/**
	 * 该接口由Form 对应Parser 实现。获得对应的Where 部分 字段列表
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	public List<FieldInfo> getConditionFields(String alias, FormNode formrequest) throws Exception;
	
	/**
	 * 
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	public SQLString parserSQLStringForWhereString(String alias, FormNode formrequest) throws Exception;
	
	/**
	 * 该接口由Form 对应Parser 实现。获得对应的Order By 部分 字段列表
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	public List<FieldInfo> getOrderByFields(String alias, FormNode formrequest) throws Exception;
	
	/**
	 * 该接口由Form 对应Parser 实现。获得对应的Group by 部分 字段列表
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	public List<FieldInfo> getGroupByFields(String alias, FormNode formrequest) throws Exception;	
	
	 
	/**
	 * 获得所需要的parameter
	 * parameter 该接口由 Command 部分实现
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	public List<SQLParameter> getSQLParameters(FormNode formrequest) throws Exception;
	
	
	
	/**
	 * 生成Select 部分，  该方法，主要command 实现
	 * @param formrequest
	 * @param alias
	 * @param fields
	 * @return
	 * @throws Exception
	 */
	public String parserSelectSentence( String alias, List<FieldInfo> fields) throws Exception;
	
	/**
	 * 根据条件生成对应Where 部分， 该接口用command 实现
	 * @param alias
	 * @param fields
	 * @param conditionSyntax
	 * @return
	 * @throws Exception
	 */
	public String parserWhereSentence(String alias, List<FieldInfo> fields, ConditionSection conditionSyntax) throws Exception;
	
	/**
	 * 根据order by 生成Order by 字符串
	 * @param alias
	 * @param fields
	 * @return
	 * @throws Exception
	 */
	public String parserOrderBySentence(String alias,  List<FieldInfo> fields) throws Exception;

	/**
	 * 根据alias 生成Group by 字符串。
	 * @param alias
	 * @param fields
	 * @return
	 * @throws Exception
	 */
	public String parserGroupBySentence(String alias,  List<FieldInfo> fields) throws Exception;
	
	/**
	 * 该接口用SechemConfig 实现。
	 * @param formcode
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	public NetDataSet executeForm(String formcode, FormNode formrequest) throws Exception; 
	
	/**
	 *  执行, 该接口用Form 对应parser 实现。 
	 * @param service
	 * @param formrequest
	 * @return  返回DataSet , DataSet 包括多个Table .
	 * @throws Exception
	 */
	public NetDataSet executeForm(Service service, FormNode formrequest) throws Exception; 
	
	/**
	 * 执行SQL 语句 ， 这个由Service 实现接口
	 * @param SQLString
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public NetDataSet executeSQL(String SQLString, List<SQLParameter> params) throws Exception; 
	
	
	/* 属性获取 */
	/**
	 * 获得属性值
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getAttributes() throws Exception;
	
	/**
	 * 根据attr Name 获得值列表。
	 * @param attrname
	 * @return
	 * @throws Exception
	 */
	public List<Object> getAttribute(String attrname ) throws Exception;
	
	/**
	 * 根据属性设置值
	 * @param attrname
	 * @param value
	 * @throws Exception
	 */
	public void setAttribute(String attrname, Object value) throws Exception;
	
	/**
	 * 清除属性
	 * @throws Exception
	 */
	public void clear() throws Exception;
	
	/**
	 * 根据属性名，删除属性
	 * @param attrname
	 * @throws Exception
	 */
	public void deleteAttribute(String attrname)throws Exception;
	
	/**
	 * 判断是否是自己
	 * @param attrname
	 * @throws Exception
	 */
	public boolean isMine(String attrname) throws Exception;
	
	
	
	
}