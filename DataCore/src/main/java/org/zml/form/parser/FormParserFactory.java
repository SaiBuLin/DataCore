package org.zml.form.parser;
import org.zml.form.bind.*;
import org.zml.tools.xml.parser.CTXMLElement;
public class FormParserFactory
{
	public static FormParserAble getQueryDefineInterpreter(CTXMLElement element) throws Exception
	{
		FormParserAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		result = getQueryDefineInterpreterIndicateClsName( element );
		if ( result == null )
		{
			result =getQueryDefineInterpreterForNoEquals(element);
		}
		return result;
	}
	private static FormParserAble getQueryDefineInterpreterForNoEquals(CTXMLElement element) throws Exception
	{
		FormParserAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		if( element instanceof OrderByColumn  )
		{
			result = new OrderByColumnFormParser((OrderByColumn)element);
		}
		else if( element instanceof QueryFormNode  )
		{
			result = new QueryFormNodeFormParser((QueryFormNode)element);
		}
		else if( element instanceof DataTable  )
		{
			result = new DataTableFormParser((DataTable)element);
		}
		else if( element instanceof ConditionColumn  )
		{
			result = new ConditionColumnFormParser((ConditionColumn)element);
		}
		else if( element instanceof PythonColumn  )
		{
			result = new PythonColumnFormParser((PythonColumn)element);
		}
		else if( element instanceof VOSource  )
		{
			result = new VOSourceFormParser((VOSource)element);
		}
		else if( element instanceof FieldWhere  )
		{
			result = new FieldWhereFormParser((FieldWhere)element);
		}
		else if( element instanceof FieldColumn  )
		{
			result = new FieldColumnFormParser((FieldColumn)element);
		}
		else if( element instanceof FormSetGroup  )
		{
			result = new FormSetGroupFormParser((FormSetGroup)element);
		}
		else if( element instanceof AnalystColumn  )
		{
			result = new AnalystColumnFormParser((AnalystColumn)element);
		}
		else if( element instanceof DataPageInfo  )
		{
			result = new DataPageInfoFormParser((DataPageInfo)element);
		}
		else if( element instanceof SectionGroup  )
		{
			result = new SectionGroupFormParser((SectionGroup)element);
		}
		else if( element instanceof ConditionSection  )
		{
			result = new ConditionSectionFormParser((ConditionSection)element);
		}
		else if( element instanceof PageDataSource  )
		{
			result = new PageDataSourceFormParser((PageDataSource)element);
		}
		else if( element instanceof RequestService  )
		{
			result = new RequestServiceFormParser((RequestService)element);
		}
		else if( element instanceof OrderBySection  )
		{
			result = new OrderBySectionFormParser((OrderBySection)element);
		}
		else if( element instanceof Section  )
		{
			result = new SectionFormParser((Section)element);
		}
		else if( element instanceof FormSet  )
		{
			result = new FormSetFormParser((FormSet)element);
		}
		else if( element instanceof SQLSource  )
		{
			result = new SQLSourceFormParser((SQLSource)element);
		}
		else if( element instanceof Column  )
		{
			result = new ColumnFormParser((Column)element);
		}
		else if( element instanceof ComplexWhere  )
		{
			result = new ComplexWhereFormParser((ComplexWhere)element);
		}
		else if( element instanceof SelectSection  )
		{
			result = new SelectSectionFormParser((SelectSection)element);
		}
		else if( element instanceof DataSource  )
		{
			result = new DataSourceFormParser((DataSource)element);
		}
		else if( element instanceof ConditionSyntax  )
		{
			result = new ConditionSyntaxFormParser((ConditionSyntax)element);
		}
		else if( element instanceof GroupBySection  )
		{
			result = new GroupBySectionFormParser((GroupBySection)element);
		}
		else if( element instanceof PageInfo  )
		{
			result = new PageInfoFormParser((PageInfo)element);
		}
		else if( element instanceof ColumnGroup  )
		{
			result = new ColumnGroupFormParser((ColumnGroup)element);
		}
		return result;
	}
	private static FormParserAble getQueryDefineInterpreterIndicateClsName(CTXMLElement element) throws Exception
	{
		FormParserAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		String tmpElementClassName = element.getClass().getName();
		if( tmpElementClassName.equals(  OrderByColumn.class.getName())  )
		{
			result = new OrderByColumnFormParser((OrderByColumn)element);
		}
		else if( tmpElementClassName.equals(  QueryFormNode.class.getName())  )
		{
			result = new QueryFormNodeFormParser((QueryFormNode)element);
		}
		else if( tmpElementClassName.equals(  DataTable.class.getName())  )
		{
			result = new DataTableFormParser((DataTable)element);
		}
		else if( tmpElementClassName.equals(  ConditionColumn.class.getName())  )
		{
			result = new ConditionColumnFormParser((ConditionColumn)element);
		}
		else if( tmpElementClassName.equals(  PythonColumn.class.getName())  )
		{
			result = new PythonColumnFormParser((PythonColumn)element);
		}
		else if( tmpElementClassName.equals(  VOSource.class.getName())  )
		{
			result = new VOSourceFormParser((VOSource)element);
		}
		else if( tmpElementClassName.equals(  FieldWhere.class.getName())  )
		{
			result = new FieldWhereFormParser((FieldWhere)element);
		}
		else if( tmpElementClassName.equals(  FieldColumn.class.getName())  )
		{
			result = new FieldColumnFormParser((FieldColumn)element);
		}
		else if( tmpElementClassName.equals(  FormSetGroup.class.getName())  )
		{
			result = new FormSetGroupFormParser((FormSetGroup)element);
		}
		else if( tmpElementClassName.equals(  AnalystColumn.class.getName())  )
		{
			result = new AnalystColumnFormParser((AnalystColumn)element);
		}
		else if( tmpElementClassName.equals(  DataPageInfo.class.getName())  )
		{
			result = new DataPageInfoFormParser((DataPageInfo)element);
		}
		else if( tmpElementClassName.equals(  SectionGroup.class.getName())  )
		{
			result = new SectionGroupFormParser((SectionGroup)element);
		}
		else if( tmpElementClassName.equals(  ConditionSection.class.getName())  )
		{
			result = new ConditionSectionFormParser((ConditionSection)element);
		}
		else if( tmpElementClassName.equals(  PageDataSource.class.getName())  )
		{
			result = new PageDataSourceFormParser((PageDataSource)element);
		}
		else if( tmpElementClassName.equals(  RequestService.class.getName())  )
		{
			result = new RequestServiceFormParser((RequestService)element);
		}
		else if( tmpElementClassName.equals(  OrderBySection.class.getName())  )
		{
			result = new OrderBySectionFormParser((OrderBySection)element);
		}
		else if( tmpElementClassName.equals(  Section.class.getName())  )
		{
			result = new SectionFormParser((Section)element);
		}
		else if( tmpElementClassName.equals(  FormSet.class.getName())  )
		{
			result = new FormSetFormParser((FormSet)element);
		}
		else if( tmpElementClassName.equals(  SQLSource.class.getName())  )
		{
			result = new SQLSourceFormParser((SQLSource)element);
		}
		else if( tmpElementClassName.equals(  Column.class.getName())  )
		{
			result = new ColumnFormParser((Column)element);
		}
		else if( tmpElementClassName.equals(  ComplexWhere.class.getName())  )
		{
			result = new ComplexWhereFormParser((ComplexWhere)element);
		}
		else if( tmpElementClassName.equals(  SelectSection.class.getName())  )
		{
			result = new SelectSectionFormParser((SelectSection)element);
		}
		else if( tmpElementClassName.equals(  DataSource.class.getName())  )
		{
			result = new DataSourceFormParser((DataSource)element);
		}
		else if( tmpElementClassName.equals(  ConditionSyntax.class.getName())  )
		{
			result = new ConditionSyntaxFormParser((ConditionSyntax)element);
		}
		else if( tmpElementClassName.equals(  GroupBySection.class.getName())  )
		{
			result = new GroupBySectionFormParser((GroupBySection)element);
		}
		else if( tmpElementClassName.equals(  PageInfo.class.getName())  )
		{
			result = new PageInfoFormParser((PageInfo)element);
		}
		else if( tmpElementClassName.equals(  ColumnGroup.class.getName())  )
		{
			result = new ColumnGroupFormParser((ColumnGroup)element);
		}
		return result;
	}
}