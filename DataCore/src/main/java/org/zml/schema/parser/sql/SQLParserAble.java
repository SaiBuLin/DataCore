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
	 * �÷����� ����SchemaConfig, ��ö�ӦSQL ��
	 * @param formcode
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	public SQLString parserSQLString(String formcode, FormNode formrequest) throws Exception;
	
	/**
	 * �ýӿ���Form ��View �����Parser ʵ�֣� �Թ�SchemaConfig ����
	 * ����Form ����SQL ����
	 * @param form
	 * @return
	 * @throws Exception
	 */
	public SQLString parserSQLString(FormNode formrequest) throws Exception;
	
	/**
	 * �ýӿ���command ʵ��
	 * @param field
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	public SQLString parserSQLString( Field field, String alias, String content,  FormNode formrequest) throws Exception;
	
	/**
	 * �÷����� ����SchemaConfig 
	 * @param formcode  Schema Code ��ֵ
	 * @param field 	field
	 * @return          ����ֶ�Field ��Ӧ���ֵ䣬�򷵻�Map<String,String> ��ʽMap<key,value> ģʽ��
	 * @throws Exception
	 */
	public Map<String, String> getLibrary(String formcode, String field) throws Exception;
	
	/**
	 * �ýӿ���Form ��View �����Parser ʵ�֣� �Թ�SchemaConfig ����
	 * @param field
	 * @return
	 * @throws Exception
	 */
	public Map<String,String> getLibrary(String field) throws Exception;
	
	/**
	 * �ýӿ���Form ��ӦParser ʵ�֡���ö�Ӧ��SELECT ���� �ֶ��б�, �ýӿڱ�Field ʵ��
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	public List<FieldInfo> getSelectFields( String alias, FormNode formrequest) throws Exception;
	
	/**
	 * �ýӿ���Form ��ӦParser ʵ�֡���ö�Ӧ��Where ���� �ֶ��б�
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
	 * �ýӿ���Form ��ӦParser ʵ�֡���ö�Ӧ��Order By ���� �ֶ��б�
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	public List<FieldInfo> getOrderByFields(String alias, FormNode formrequest) throws Exception;
	
	/**
	 * �ýӿ���Form ��ӦParser ʵ�֡���ö�Ӧ��Group by ���� �ֶ��б�
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	public List<FieldInfo> getGroupByFields(String alias, FormNode formrequest) throws Exception;	
	
	 
	/**
	 * �������Ҫ��parameter
	 * parameter �ýӿ��� Command ����ʵ��
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	public List<SQLParameter> getSQLParameters(FormNode formrequest) throws Exception;
	
	
	
	/**
	 * ����Select ���֣�  �÷�������Ҫcommand ʵ��
	 * @param formrequest
	 * @param alias
	 * @param fields
	 * @return
	 * @throws Exception
	 */
	public String parserSelectSentence( String alias, List<FieldInfo> fields) throws Exception;
	
	/**
	 * �����������ɶ�ӦWhere ���֣� �ýӿ���command ʵ��
	 * @param alias
	 * @param fields
	 * @param conditionSyntax
	 * @return
	 * @throws Exception
	 */
	public String parserWhereSentence(String alias, List<FieldInfo> fields, ConditionSection conditionSyntax) throws Exception;
	
	/**
	 * ����order by ����Order by �ַ���
	 * @param alias
	 * @param fields
	 * @return
	 * @throws Exception
	 */
	public String parserOrderBySentence(String alias,  List<FieldInfo> fields) throws Exception;

	/**
	 * ����alias ����Group by �ַ�����
	 * @param alias
	 * @param fields
	 * @return
	 * @throws Exception
	 */
	public String parserGroupBySentence(String alias,  List<FieldInfo> fields) throws Exception;
	
	/**
	 * �ýӿ���SechemConfig ʵ�֡�
	 * @param formcode
	 * @param formrequest
	 * @return
	 * @throws Exception
	 */
	public NetDataSet executeForm(String formcode, FormNode formrequest) throws Exception; 
	
	/**
	 *  ִ��, �ýӿ���Form ��Ӧparser ʵ�֡� 
	 * @param service
	 * @param formrequest
	 * @return  ����DataSet , DataSet �������Table .
	 * @throws Exception
	 */
	public NetDataSet executeForm(Service service, FormNode formrequest) throws Exception; 
	
	/**
	 * ִ��SQL ��� �� �����Service ʵ�ֽӿ�
	 * @param SQLString
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public NetDataSet executeSQL(String SQLString, List<SQLParameter> params) throws Exception; 
	
	
	/* ���Ի�ȡ */
	/**
	 * �������ֵ
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getAttributes() throws Exception;
	
	/**
	 * ����attr Name ���ֵ�б�
	 * @param attrname
	 * @return
	 * @throws Exception
	 */
	public List<Object> getAttribute(String attrname ) throws Exception;
	
	/**
	 * ������������ֵ
	 * @param attrname
	 * @param value
	 * @throws Exception
	 */
	public void setAttribute(String attrname, Object value) throws Exception;
	
	/**
	 * �������
	 * @throws Exception
	 */
	public void clear() throws Exception;
	
	/**
	 * ������������ɾ������
	 * @param attrname
	 * @throws Exception
	 */
	public void deleteAttribute(String attrname)throws Exception;
	
	/**
	 * �ж��Ƿ����Լ�
	 * @param attrname
	 * @throws Exception
	 */
	public boolean isMine(String attrname) throws Exception;
	
	
	
	
}