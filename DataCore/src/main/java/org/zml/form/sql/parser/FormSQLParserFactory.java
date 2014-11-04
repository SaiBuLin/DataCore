package org.zml.form.sql.parser;
import org.zml.form.bind.*;
import org.zml.tools.xml.parser.CTXMLElement;
public class FormSQLParserFactory
{
	public static FormSQLParserAble getQueryDefineInterpreter(CTXMLElement element) throws Exception
	{
		FormSQLParserAble result = null;
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
	private static FormSQLParserAble getQueryDefineInterpreterForNoEquals(CTXMLElement element) throws Exception
	{
		FormSQLParserAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		if( element instanceof ScriptColumn  )
		{
			result = new ScriptColumnFormSQLParser((ScriptColumn)element);
		}
		else if( element instanceof GridSection  )
		{
			result = new GridSectionFormSQLParser((GridSection)element);
		}
		else if( element instanceof ConditionColumn  )
		{
			result = new ConditionColumnFormSQLParser((ConditionColumn)element);
		}
		else if( element instanceof FormGroup  )
		{
			result = new FormGroupFormSQLParser((FormGroup)element);
		}
		else if( element instanceof FieldColumn  )
		{
			result = new FieldColumnFormSQLParser((FieldColumn)element);
		}
		else if( element instanceof FormNode  )
		{
			result = new FormNodeFormSQLParser((FormNode)element);
		}
		else if( element instanceof VOFormService  )
		{
			result = new VOFormServiceFormSQLParser((VOFormService)element);
		}
		else if( element instanceof AnalystColumn  )
		{
			result = new AnalystColumnFormSQLParser((AnalystColumn)element);
		}
		else if( element instanceof FieldCondition  )
		{
			result = new FieldConditionFormSQLParser((FieldCondition)element);
		}
		else if( element instanceof SectionGroup  )
		{
			result = new SectionGroupFormSQLParser((SectionGroup)element);
		}
		else if( element instanceof ConditionSection  )
		{
			result = new ConditionSectionFormSQLParser((ConditionSection)element);
		}
		else if( element instanceof Section  )
		{
			result = new SectionFormSQLParser((Section)element);
		}
		else if( element instanceof Condition  )
		{
			result = new ConditionFormSQLParser((Condition)element);
		}
		else if( element instanceof GroupbyColumn  )
		{
			result = new GroupbyColumnFormSQLParser((GroupbyColumn)element);
		}
		else if( element instanceof PageInfo  )
		{
			result = new PageInfoFormSQLParser((PageInfo)element);
		}
		else if( element instanceof Form  )
		{
			result = new FormFormSQLParser((Form)element);
		}
		else if( element instanceof SQLFormService  )
		{
			result = new SQLFormServiceFormSQLParser((SQLFormService)element);
		}
		else if( element instanceof OrderColumn  )
		{
			result = new OrderColumnFormSQLParser((OrderColumn)element);
		}
		else if( element instanceof DataForm  )
		{
			result = new DataFormFormSQLParser((DataForm)element);
		}
		else if( element instanceof FormService  )
		{
			result = new FormServiceFormSQLParser((FormService)element);
		}
		else if( element instanceof Column  )
		{
			result = new ColumnFormSQLParser((Column)element);
		}
		else if( element instanceof Conditions  )
		{
			result = new ConditionsFormSQLParser((Conditions)element);
		}
		else if( element instanceof ColumnGroup  )
		{
			result = new ColumnGroupFormSQLParser((ColumnGroup)element);
		}
		else if( element instanceof ColumnSection  )
		{
			result = new ColumnSectionFormSQLParser((ColumnSection)element);
		}
		return result;
	}
	private static FormSQLParserAble getQueryDefineInterpreterIndicateClsName(CTXMLElement element) throws Exception
	{
		FormSQLParserAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		String tmpElementClassName = element.getClass().getName();
		if( tmpElementClassName.equals(  ScriptColumn.class.getName())  )
		{
			result = new ScriptColumnFormSQLParser((ScriptColumn)element);
		}
		else if( tmpElementClassName.equals(  GridSection.class.getName())  )
		{
			result = new GridSectionFormSQLParser((GridSection)element);
		}
		else if( tmpElementClassName.equals(  ConditionColumn.class.getName())  )
		{
			result = new ConditionColumnFormSQLParser((ConditionColumn)element);
		}
		else if( tmpElementClassName.equals(  FormGroup.class.getName())  )
		{
			result = new FormGroupFormSQLParser((FormGroup)element);
		}
		else if( tmpElementClassName.equals(  FieldColumn.class.getName())  )
		{
			result = new FieldColumnFormSQLParser((FieldColumn)element);
		}
		else if( tmpElementClassName.equals(  FormNode.class.getName())  )
		{
			result = new FormNodeFormSQLParser((FormNode)element);
		}
		else if( tmpElementClassName.equals(  VOFormService.class.getName())  )
		{
			result = new VOFormServiceFormSQLParser((VOFormService)element);
		}
		else if( tmpElementClassName.equals(  AnalystColumn.class.getName())  )
		{
			result = new AnalystColumnFormSQLParser((AnalystColumn)element);
		}
		else if( tmpElementClassName.equals(  FieldCondition.class.getName())  )
		{
			result = new FieldConditionFormSQLParser((FieldCondition)element);
		}
		else if( tmpElementClassName.equals(  SectionGroup.class.getName())  )
		{
			result = new SectionGroupFormSQLParser((SectionGroup)element);
		}
		else if( tmpElementClassName.equals(  ConditionSection.class.getName())  )
		{
			result = new ConditionSectionFormSQLParser((ConditionSection)element);
		}
		else if( tmpElementClassName.equals(  Section.class.getName())  )
		{
			result = new SectionFormSQLParser((Section)element);
		}
		else if( tmpElementClassName.equals(  Condition.class.getName())  )
		{
			result = new ConditionFormSQLParser((Condition)element);
		}
		else if( tmpElementClassName.equals(  GroupbyColumn.class.getName())  )
		{
			result = new GroupbyColumnFormSQLParser((GroupbyColumn)element);
		}
		else if( tmpElementClassName.equals(  PageInfo.class.getName())  )
		{
			result = new PageInfoFormSQLParser((PageInfo)element);
		}
		else if( tmpElementClassName.equals(  Form.class.getName())  )
		{
			result = new FormFormSQLParser((Form)element);
		}
		else if( tmpElementClassName.equals(  SQLFormService.class.getName())  )
		{
			result = new SQLFormServiceFormSQLParser((SQLFormService)element);
		}
		else if( tmpElementClassName.equals(  OrderColumn.class.getName())  )
		{
			result = new OrderColumnFormSQLParser((OrderColumn)element);
		}
		else if( tmpElementClassName.equals(  DataForm.class.getName())  )
		{
			result = new DataFormFormSQLParser((DataForm)element);
		}
		else if( tmpElementClassName.equals(  FormService.class.getName())  )
		{
			result = new FormServiceFormSQLParser((FormService)element);
		}
		else if( tmpElementClassName.equals(  Column.class.getName())  )
		{
			result = new ColumnFormSQLParser((Column)element);
		}
		else if( tmpElementClassName.equals(  Conditions.class.getName())  )
		{
			result = new ConditionsFormSQLParser((Conditions)element);
		}
		else if( tmpElementClassName.equals(  ColumnGroup.class.getName())  )
		{
			result = new ColumnGroupFormSQLParser((ColumnGroup)element);
		}
		else if( tmpElementClassName.equals(  ColumnSection.class.getName())  )
		{
			result = new ColumnSectionFormSQLParser((ColumnSection)element);
		}
		return result;
	}
}