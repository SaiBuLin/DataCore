package org.zml.form.parser;
import org.zml.form.bind.*;
import org.zml.tools.xml.parser.CTXMLElement;
public class DemandFormFactory
{
	public static DemandFormAble getQueryDefineInterpreter(CTXMLElement element) throws Exception
	{
		DemandFormAble result = null;
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
	private static DemandFormAble getQueryDefineInterpreterForNoEquals(CTXMLElement element) throws Exception
	{
		DemandFormAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		if( element instanceof ScriptColumn  )
		{
			result = new ScriptColumnDemandForm((ScriptColumn)element);
		}
		else if( element instanceof GridSection  )
		{
			result = new GridSectionDemandForm((GridSection)element);
		}
		else if( element instanceof ConditionColumn  )
		{
			result = new ConditionColumnDemandForm((ConditionColumn)element);
		}
		else if( element instanceof FormGroup  )
		{
			result = new FormGroupDemandForm((FormGroup)element);
		}
		else if( element instanceof FieldColumn  )
		{
			result = new FieldColumnDemandForm((FieldColumn)element);
		}
		else if( element instanceof FormNode  )
		{
			result = new FormNodeDemandForm((FormNode)element);
		}
		else if( element instanceof VOFormService  )
		{
			result = new VOFormServiceDemandForm((VOFormService)element);
		}
		else if( element instanceof AnalystColumn  )
		{
			result = new AnalystColumnDemandForm((AnalystColumn)element);
		}
		else if( element instanceof FieldCondition  )
		{
			result = new FieldConditionDemandForm((FieldCondition)element);
		}
		else if( element instanceof SectionGroup  )
		{
			result = new SectionGroupDemandForm((SectionGroup)element);
		}
		else if( element instanceof ConditionSection  )
		{
			result = new ConditionSectionDemandForm((ConditionSection)element);
		}
		else if( element instanceof Section  )
		{
			result = new SectionDemandForm((Section)element);
		}
		else if( element instanceof Condition  )
		{
			result = new ConditionDemandForm((Condition)element);
		}
		else if( element instanceof PageInfo  )
		{
			result = new PageInfoDemandForm((PageInfo)element);
		}
		else if( element instanceof Form  )
		{
			result = new FormDemandForm((Form)element);
		}
		else if( element instanceof SQLFormService  )
		{
			result = new SQLFormServiceDemandForm((SQLFormService)element);
		}
		else if( element instanceof OrderColumn  )
		{
			result = new OrderColumnDemandForm((OrderColumn)element);
		}
		else if( element instanceof DataForm  )
		{
			result = new DataFormDemandForm((DataForm)element);
		}
		else if( element instanceof FormService  )
		{
			result = new FormServiceDemandForm((FormService)element);
		}
		else if( element instanceof Column  )
		{
			result = new ColumnDemandForm((Column)element);
		}
		else if( element instanceof Conditions  )
		{
			result = new ConditionsDemandForm((Conditions)element);
		}
		else if( element instanceof ColumnGroup  )
		{
			result = new ColumnGroupDemandForm((ColumnGroup)element);
		}
		else if( element instanceof ColumnSection  )
		{
			result = new ColumnSectionDemandForm((ColumnSection)element);
		}
		return result;
	}
	private static DemandFormAble getQueryDefineInterpreterIndicateClsName(CTXMLElement element) throws Exception
	{
		DemandFormAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		String tmpElementClassName = element.getClass().getName();
		if( tmpElementClassName.equals(  ScriptColumn.class.getName())  )
		{
			result = new ScriptColumnDemandForm((ScriptColumn)element);
		}
		else if( tmpElementClassName.equals(  GridSection.class.getName())  )
		{
			result = new GridSectionDemandForm((GridSection)element);
		}
		else if( tmpElementClassName.equals(  ConditionColumn.class.getName())  )
		{
			result = new ConditionColumnDemandForm((ConditionColumn)element);
		}
		else if( tmpElementClassName.equals(  FormGroup.class.getName())  )
		{
			result = new FormGroupDemandForm((FormGroup)element);
		}
		else if( tmpElementClassName.equals(  FieldColumn.class.getName())  )
		{
			result = new FieldColumnDemandForm((FieldColumn)element);
		}
		else if( tmpElementClassName.equals(  FormNode.class.getName())  )
		{
			result = new FormNodeDemandForm((FormNode)element);
		}
		else if( tmpElementClassName.equals(  VOFormService.class.getName())  )
		{
			result = new VOFormServiceDemandForm((VOFormService)element);
		}
		else if( tmpElementClassName.equals(  AnalystColumn.class.getName())  )
		{
			result = new AnalystColumnDemandForm((AnalystColumn)element);
		}
		else if( tmpElementClassName.equals(  FieldCondition.class.getName())  )
		{
			result = new FieldConditionDemandForm((FieldCondition)element);
		}
		else if( tmpElementClassName.equals(  SectionGroup.class.getName())  )
		{
			result = new SectionGroupDemandForm((SectionGroup)element);
		}
		else if( tmpElementClassName.equals(  ConditionSection.class.getName())  )
		{
			result = new ConditionSectionDemandForm((ConditionSection)element);
		}
		else if( tmpElementClassName.equals(  Section.class.getName())  )
		{
			result = new SectionDemandForm((Section)element);
		}
		else if( tmpElementClassName.equals(  Condition.class.getName())  )
		{
			result = new ConditionDemandForm((Condition)element);
		}
		else if( tmpElementClassName.equals(  PageInfo.class.getName())  )
		{
			result = new PageInfoDemandForm((PageInfo)element);
		}
		else if( tmpElementClassName.equals(  Form.class.getName())  )
		{
			result = new FormDemandForm((Form)element);
		}
		else if( tmpElementClassName.equals(  SQLFormService.class.getName())  )
		{
			result = new SQLFormServiceDemandForm((SQLFormService)element);
		}
		else if( tmpElementClassName.equals(  OrderColumn.class.getName())  )
		{
			result = new OrderColumnDemandForm((OrderColumn)element);
		}
		else if( tmpElementClassName.equals(  DataForm.class.getName())  )
		{
			result = new DataFormDemandForm((DataForm)element);
		}
		else if( tmpElementClassName.equals(  FormService.class.getName())  )
		{
			result = new FormServiceDemandForm((FormService)element);
		}
		else if( tmpElementClassName.equals(  Column.class.getName())  )
		{
			result = new ColumnDemandForm((Column)element);
		}
		else if( tmpElementClassName.equals(  Conditions.class.getName())  )
		{
			result = new ConditionsDemandForm((Conditions)element);
		}
		else if( tmpElementClassName.equals(  ColumnGroup.class.getName())  )
		{
			result = new ColumnGroupDemandForm((ColumnGroup)element);
		}
		else if( tmpElementClassName.equals(  ColumnSection.class.getName())  )
		{
			result = new ColumnSectionDemandForm((ColumnSection)element);
		}
		return result;
	}
}