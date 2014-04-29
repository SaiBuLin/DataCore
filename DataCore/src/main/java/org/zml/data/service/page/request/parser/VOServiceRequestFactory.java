package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.*;
import org.zml.tools.xml.parser.CTXMLElement;
public class VOServiceRequestFactory
{
	public static VOServiceRequestAble getQueryDefineInterpreter(CTXMLElement element) throws Exception
	{
		VOServiceRequestAble result = null;
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
	private static VOServiceRequestAble getQueryDefineInterpreterForNoEquals(CTXMLElement element) throws Exception
	{
		VOServiceRequestAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		if( element instanceof ConditionSyntax  )
		{
			result = new ConditionSyntaxVOServiceRequest((ConditionSyntax)element);
		}
		else if( element instanceof SimpleField  )
		{
			result = new SimpleFieldVOServiceRequest((SimpleField)element);
		}
		else if( element instanceof RequestColumn  )
		{
			result = new RequestColumnVOServiceRequest((RequestColumn)element);
		}
		else if( element instanceof RequestField  )
		{
			result = new RequestFieldVOServiceRequest((RequestField)element);
		}
		else if( element instanceof ComplexConditionSyntax  )
		{
			result = new ComplexConditionSyntaxVOServiceRequest((ComplexConditionSyntax)element);
		}
		else if( element instanceof ConditionField  )
		{
			result = new ConditionFieldVOServiceRequest((ConditionField)element);
		}
		else if( element instanceof QueryRequest  )
		{
			result = new QueryRequestVOServiceRequest((QueryRequest)element);
		}
		else if( element instanceof OrderByField  )
		{
			result = new OrderByFieldVOServiceRequest((OrderByField)element);
		}
		else if( element instanceof OrderByColumn  )
		{
			result = new OrderByColumnVOServiceRequest((OrderByColumn)element);
		}
		else if( element instanceof RequestPart  )
		{
			result = new RequestPartVOServiceRequest((RequestPart)element);
		}
		else if( element instanceof QueryFormNode  )
		{
			result = new QueryFormNodeVOServiceRequest((QueryFormNode)element);
		}
		else if( element instanceof FeildConditionSyntax  )
		{
			result = new FeildConditionSyntaxVOServiceRequest((FeildConditionSyntax)element);
		}
		else if( element instanceof RequestFieldGroup  )
		{
			result = new RequestFieldGroupVOServiceRequest((RequestFieldGroup)element);
		}
		else if( element instanceof RequestPartGroup  )
		{
			result = new RequestPartGroupVOServiceRequest((RequestPartGroup)element);
		}
		else if( element instanceof ConditionColumn  )
		{
			result = new ConditionColumnVOServiceRequest((ConditionColumn)element);
		}
		return result;
	}
	private static VOServiceRequestAble getQueryDefineInterpreterIndicateClsName(CTXMLElement element) throws Exception
	{
		VOServiceRequestAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		String tmpElementClassName = element.getClass().getName();
		if( tmpElementClassName.equals(  ConditionSyntax.class.getName())  )
		{
			result = new ConditionSyntaxVOServiceRequest((ConditionSyntax)element);
		}
		else if( tmpElementClassName.equals(  SimpleField.class.getName())  )
		{
			result = new SimpleFieldVOServiceRequest((SimpleField)element);
		}
		else if( tmpElementClassName.equals(  RequestColumn.class.getName())  )
		{
			result = new RequestColumnVOServiceRequest((RequestColumn)element);
		}
		else if( tmpElementClassName.equals(  RequestField.class.getName())  )
		{
			result = new RequestFieldVOServiceRequest((RequestField)element);
		}
		else if( tmpElementClassName.equals(  ComplexConditionSyntax.class.getName())  )
		{
			result = new ComplexConditionSyntaxVOServiceRequest((ComplexConditionSyntax)element);
		}
		else if( tmpElementClassName.equals(  ConditionField.class.getName())  )
		{
			result = new ConditionFieldVOServiceRequest((ConditionField)element);
		}
		else if( tmpElementClassName.equals(  QueryRequest.class.getName())  )
		{
			result = new QueryRequestVOServiceRequest((QueryRequest)element);
		}
		else if( tmpElementClassName.equals(  OrderByField.class.getName())  )
		{
			result = new OrderByFieldVOServiceRequest((OrderByField)element);
		}
		else if( tmpElementClassName.equals(  OrderByColumn.class.getName())  )
		{
			result = new OrderByColumnVOServiceRequest((OrderByColumn)element);
		}
		else if( tmpElementClassName.equals(  RequestPart.class.getName())  )
		{
			result = new RequestPartVOServiceRequest((RequestPart)element);
		}
		else if( tmpElementClassName.equals(  QueryFormNode.class.getName())  )
		{
			result = new QueryFormNodeVOServiceRequest((QueryFormNode)element);
		}
		else if( tmpElementClassName.equals(  FeildConditionSyntax.class.getName())  )
		{
			result = new FeildConditionSyntaxVOServiceRequest((FeildConditionSyntax)element);
		}
		else if( tmpElementClassName.equals(  RequestFieldGroup.class.getName())  )
		{
			result = new RequestFieldGroupVOServiceRequest((RequestFieldGroup)element);
		}
		else if( tmpElementClassName.equals(  RequestPartGroup.class.getName())  )
		{
			result = new RequestPartGroupVOServiceRequest((RequestPartGroup)element);
		}
		else if( tmpElementClassName.equals(  ConditionColumn.class.getName())  )
		{
			result = new ConditionColumnVOServiceRequest((ConditionColumn)element);
		}
		return result;
	}
}