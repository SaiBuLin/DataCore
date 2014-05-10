package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.*;
import org.zml.tools.xml.parser.CTXMLElement;
public class FormsetParserFactory
{
	public static FormsetParserAble getQueryDefineInterpreter(CTXMLElement element) throws Exception
	{
		FormsetParserAble result = null;
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
	private static FormsetParserAble getQueryDefineInterpreterForNoEquals(CTXMLElement element) throws Exception
	{
		FormsetParserAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		if( element instanceof OrderByColumn  )
		{
			result = new OrderByColumnFormsetParser((OrderByColumn)element);
		}
		else if( element instanceof QueryFormNode  )
		{
			result = new QueryFormNodeFormsetParser((QueryFormNode)element);
		}
		else if( element instanceof DataTable  )
		{
			result = new DataTableFormsetParser((DataTable)element);
		}
		else if( element instanceof ConditionColumn  )
		{
			result = new ConditionColumnFormsetParser((ConditionColumn)element);
		}
		else if( element instanceof PythonColumn  )
		{
			result = new PythonColumnFormsetParser((PythonColumn)element);
		}
		else if( element instanceof VOSource  )
		{
			result = new VOSourceFormsetParser((VOSource)element);
		}
		else if( element instanceof FieldWhere  )
		{
			result = new FieldWhereFormsetParser((FieldWhere)element);
		}
		else if( element instanceof FieldColumn  )
		{
			result = new FieldColumnFormsetParser((FieldColumn)element);
		}
		else if( element instanceof FormSetGroup  )
		{
			result = new FormSetGroupFormsetParser((FormSetGroup)element);
		}
		else if( element instanceof AnalystColumn  )
		{
			result = new AnalystColumnFormsetParser((AnalystColumn)element);
		}
		else if( element instanceof DataPageInfo  )
		{
			result = new DataPageInfoFormsetParser((DataPageInfo)element);
		}
		else if( element instanceof SectionGroup  )
		{
			result = new SectionGroupFormsetParser((SectionGroup)element);
		}
		else if( element instanceof ConditionSection  )
		{
			result = new ConditionSectionFormsetParser((ConditionSection)element);
		}
		else if( element instanceof PageDataSource  )
		{
			result = new PageDataSourceFormsetParser((PageDataSource)element);
		}
		else if( element instanceof RequestService  )
		{
			result = new RequestServiceFormsetParser((RequestService)element);
		}
		else if( element instanceof OrderBySection  )
		{
			result = new OrderBySectionFormsetParser((OrderBySection)element);
		}
		else if( element instanceof Section  )
		{
			result = new SectionFormsetParser((Section)element);
		}
		else if( element instanceof FormSet  )
		{
			result = new FormSetFormsetParser((FormSet)element);
		}
		else if( element instanceof SQLSource  )
		{
			result = new SQLSourceFormsetParser((SQLSource)element);
		}
		else if( element instanceof Column  )
		{
			result = new ColumnFormsetParser((Column)element);
		}
		else if( element instanceof ComplexWhere  )
		{
			result = new ComplexWhereFormsetParser((ComplexWhere)element);
		}
		else if( element instanceof SelectSection  )
		{
			result = new SelectSectionFormsetParser((SelectSection)element);
		}
		else if( element instanceof DataSource  )
		{
			result = new DataSourceFormsetParser((DataSource)element);
		}
		else if( element instanceof ConditionSyntax  )
		{
			result = new ConditionSyntaxFormsetParser((ConditionSyntax)element);
		}
		else if( element instanceof GroupBySection  )
		{
			result = new GroupBySectionFormsetParser((GroupBySection)element);
		}
		else if( element instanceof PageInfo  )
		{
			result = new PageInfoFormsetParser((PageInfo)element);
		}
		else if( element instanceof ColumnGroup  )
		{
			result = new ColumnGroupFormsetParser((ColumnGroup)element);
		}
		return result;
	}
	private static FormsetParserAble getQueryDefineInterpreterIndicateClsName(CTXMLElement element) throws Exception
	{
		FormsetParserAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		String tmpElementClassName = element.getClass().getName();
		if( tmpElementClassName.equals(  OrderByColumn.class.getName())  )
		{
			result = new OrderByColumnFormsetParser((OrderByColumn)element);
		}
		else if( tmpElementClassName.equals(  QueryFormNode.class.getName())  )
		{
			result = new QueryFormNodeFormsetParser((QueryFormNode)element);
		}
		else if( tmpElementClassName.equals(  DataTable.class.getName())  )
		{
			result = new DataTableFormsetParser((DataTable)element);
		}
		else if( tmpElementClassName.equals(  ConditionColumn.class.getName())  )
		{
			result = new ConditionColumnFormsetParser((ConditionColumn)element);
		}
		else if( tmpElementClassName.equals(  PythonColumn.class.getName())  )
		{
			result = new PythonColumnFormsetParser((PythonColumn)element);
		}
		else if( tmpElementClassName.equals(  VOSource.class.getName())  )
		{
			result = new VOSourceFormsetParser((VOSource)element);
		}
		else if( tmpElementClassName.equals(  FieldWhere.class.getName())  )
		{
			result = new FieldWhereFormsetParser((FieldWhere)element);
		}
		else if( tmpElementClassName.equals(  FieldColumn.class.getName())  )
		{
			result = new FieldColumnFormsetParser((FieldColumn)element);
		}
		else if( tmpElementClassName.equals(  FormSetGroup.class.getName())  )
		{
			result = new FormSetGroupFormsetParser((FormSetGroup)element);
		}
		else if( tmpElementClassName.equals(  AnalystColumn.class.getName())  )
		{
			result = new AnalystColumnFormsetParser((AnalystColumn)element);
		}
		else if( tmpElementClassName.equals(  DataPageInfo.class.getName())  )
		{
			result = new DataPageInfoFormsetParser((DataPageInfo)element);
		}
		else if( tmpElementClassName.equals(  SectionGroup.class.getName())  )
		{
			result = new SectionGroupFormsetParser((SectionGroup)element);
		}
		else if( tmpElementClassName.equals(  ConditionSection.class.getName())  )
		{
			result = new ConditionSectionFormsetParser((ConditionSection)element);
		}
		else if( tmpElementClassName.equals(  PageDataSource.class.getName())  )
		{
			result = new PageDataSourceFormsetParser((PageDataSource)element);
		}
		else if( tmpElementClassName.equals(  RequestService.class.getName())  )
		{
			result = new RequestServiceFormsetParser((RequestService)element);
		}
		else if( tmpElementClassName.equals(  OrderBySection.class.getName())  )
		{
			result = new OrderBySectionFormsetParser((OrderBySection)element);
		}
		else if( tmpElementClassName.equals(  Section.class.getName())  )
		{
			result = new SectionFormsetParser((Section)element);
		}
		else if( tmpElementClassName.equals(  FormSet.class.getName())  )
		{
			result = new FormSetFormsetParser((FormSet)element);
		}
		else if( tmpElementClassName.equals(  SQLSource.class.getName())  )
		{
			result = new SQLSourceFormsetParser((SQLSource)element);
		}
		else if( tmpElementClassName.equals(  Column.class.getName())  )
		{
			result = new ColumnFormsetParser((Column)element);
		}
		else if( tmpElementClassName.equals(  ComplexWhere.class.getName())  )
		{
			result = new ComplexWhereFormsetParser((ComplexWhere)element);
		}
		else if( tmpElementClassName.equals(  SelectSection.class.getName())  )
		{
			result = new SelectSectionFormsetParser((SelectSection)element);
		}
		else if( tmpElementClassName.equals(  DataSource.class.getName())  )
		{
			result = new DataSourceFormsetParser((DataSource)element);
		}
		else if( tmpElementClassName.equals(  ConditionSyntax.class.getName())  )
		{
			result = new ConditionSyntaxFormsetParser((ConditionSyntax)element);
		}
		else if( tmpElementClassName.equals(  GroupBySection.class.getName())  )
		{
			result = new GroupBySectionFormsetParser((GroupBySection)element);
		}
		else if( tmpElementClassName.equals(  PageInfo.class.getName())  )
		{
			result = new PageInfoFormsetParser((PageInfo)element);
		}
		else if( tmpElementClassName.equals(  ColumnGroup.class.getName())  )
		{
			result = new ColumnGroupFormsetParser((ColumnGroup)element);
		}
		return result;
	}
}