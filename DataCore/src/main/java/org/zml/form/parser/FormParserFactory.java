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
		if( element instanceof ScriptColumn  )
		{
			result = new ScriptColumnFormParser((ScriptColumn)element);
		}
		else if( element instanceof GridSection  )
		{
			result = new GridSectionFormParser((GridSection)element);
		}
		else if( element instanceof ConditionColumn  )
		{
			result = new ConditionColumnFormParser((ConditionColumn)element);
		}
		else if( element instanceof FormGroup  )
		{
			result = new FormGroupFormParser((FormGroup)element);
		}
		else if( element instanceof FieldColumn  )
		{
			result = new FieldColumnFormParser((FieldColumn)element);
		}
		else if( element instanceof FormNode  )
		{
			result = new FormNodeFormParser((FormNode)element);
		}
		else if( element instanceof VOFormService  )
		{
			result = new VOFormServiceFormParser((VOFormService)element);
		}
		else if( element instanceof AnalystColumn  )
		{
			result = new AnalystColumnFormParser((AnalystColumn)element);
		}
		else if( element instanceof FieldCondition  )
		{
			result = new FieldConditionFormParser((FieldCondition)element);
		}
		else if( element instanceof SectionGroup  )
		{
			result = new SectionGroupFormParser((SectionGroup)element);
		}
		else if( element instanceof ConditionSection  )
		{
			result = new ConditionSectionFormParser((ConditionSection)element);
		}
		else if( element instanceof Section  )
		{
			result = new SectionFormParser((Section)element);
		}
		else if( element instanceof Condition  )
		{
			result = new ConditionFormParser((Condition)element);
		}
		else if( element instanceof GroupbyColumn  )
		{
			result = new GroupbyColumnFormParser((GroupbyColumn)element);
		}
		else if( element instanceof PageInfo  )
		{
			result = new PageInfoFormParser((PageInfo)element);
		}
		else if( element instanceof Form  )
		{
			result = new FormFormParser((Form)element);
		}
		else if( element instanceof SQLFormService  )
		{
			result = new SQLFormServiceFormParser((SQLFormService)element);
		}
		else if( element instanceof OrderColumn  )
		{
			result = new OrderColumnFormParser((OrderColumn)element);
		}
		else if( element instanceof DataForm  )
		{
			result = new DataFormFormParser((DataForm)element);
		}
		else if( element instanceof FormService  )
		{
			result = new FormServiceFormParser((FormService)element);
		}
		else if( element instanceof Column  )
		{
			result = new ColumnFormParser((Column)element);
		}
		else if( element instanceof Conditions  )
		{
			result = new ConditionsFormParser((Conditions)element);
		}
		else if( element instanceof ColumnGroup  )
		{
			result = new ColumnGroupFormParser((ColumnGroup)element);
		}
		else if( element instanceof ColumnSection  )
		{
			result = new ColumnSectionFormParser((ColumnSection)element);
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
		if( tmpElementClassName.equals(  ScriptColumn.class.getName())  )
		{
			result = new ScriptColumnFormParser((ScriptColumn)element);
		}
		else if( tmpElementClassName.equals(  GridSection.class.getName())  )
		{
			result = new GridSectionFormParser((GridSection)element);
		}
		else if( tmpElementClassName.equals(  ConditionColumn.class.getName())  )
		{
			result = new ConditionColumnFormParser((ConditionColumn)element);
		}
		else if( tmpElementClassName.equals(  FormGroup.class.getName())  )
		{
			result = new FormGroupFormParser((FormGroup)element);
		}
		else if( tmpElementClassName.equals(  FieldColumn.class.getName())  )
		{
			result = new FieldColumnFormParser((FieldColumn)element);
		}
		else if( tmpElementClassName.equals(  FormNode.class.getName())  )
		{
			result = new FormNodeFormParser((FormNode)element);
		}
		else if( tmpElementClassName.equals(  VOFormService.class.getName())  )
		{
			result = new VOFormServiceFormParser((VOFormService)element);
		}
		else if( tmpElementClassName.equals(  AnalystColumn.class.getName())  )
		{
			result = new AnalystColumnFormParser((AnalystColumn)element);
		}
		else if( tmpElementClassName.equals(  FieldCondition.class.getName())  )
		{
			result = new FieldConditionFormParser((FieldCondition)element);
		}
		else if( tmpElementClassName.equals(  SectionGroup.class.getName())  )
		{
			result = new SectionGroupFormParser((SectionGroup)element);
		}
		else if( tmpElementClassName.equals(  ConditionSection.class.getName())  )
		{
			result = new ConditionSectionFormParser((ConditionSection)element);
		}
		else if( tmpElementClassName.equals(  Section.class.getName())  )
		{
			result = new SectionFormParser((Section)element);
		}
		else if( tmpElementClassName.equals(  Condition.class.getName())  )
		{
			result = new ConditionFormParser((Condition)element);
		}
		else if( tmpElementClassName.equals(  GroupbyColumn.class.getName())  )
		{
			result = new GroupbyColumnFormParser((GroupbyColumn)element);
		}
		else if( tmpElementClassName.equals(  PageInfo.class.getName())  )
		{
			result = new PageInfoFormParser((PageInfo)element);
		}
		else if( tmpElementClassName.equals(  Form.class.getName())  )
		{
			result = new FormFormParser((Form)element);
		}
		else if( tmpElementClassName.equals(  SQLFormService.class.getName())  )
		{
			result = new SQLFormServiceFormParser((SQLFormService)element);
		}
		else if( tmpElementClassName.equals(  OrderColumn.class.getName())  )
		{
			result = new OrderColumnFormParser((OrderColumn)element);
		}
		else if( tmpElementClassName.equals(  DataForm.class.getName())  )
		{
			result = new DataFormFormParser((DataForm)element);
		}
		else if( tmpElementClassName.equals(  FormService.class.getName())  )
		{
			result = new FormServiceFormParser((FormService)element);
		}
		else if( tmpElementClassName.equals(  Column.class.getName())  )
		{
			result = new ColumnFormParser((Column)element);
		}
		else if( tmpElementClassName.equals(  Conditions.class.getName())  )
		{
			result = new ConditionsFormParser((Conditions)element);
		}
		else if( tmpElementClassName.equals(  ColumnGroup.class.getName())  )
		{
			result = new ColumnGroupFormParser((ColumnGroup)element);
		}
		else if( tmpElementClassName.equals(  ColumnSection.class.getName())  )
		{
			result = new ColumnSectionFormParser((ColumnSection)element);
		}
		return result;
	}
}