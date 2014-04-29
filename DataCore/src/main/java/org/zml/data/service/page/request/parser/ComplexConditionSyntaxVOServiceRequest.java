package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.ComplexConditionSyntax;
public class ComplexConditionSyntaxVOServiceRequest extends VOServiceRequest implements VOServiceRequestAble
{
	public ComplexConditionSyntaxVOServiceRequest( ComplexConditionSyntax element)
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
		if ( !(this.getQueryDefineElement() instanceof ComplexConditionSyntax))
		{
			throw new Exception(" ComplexConditionSyntaxVOServiceRequest only parse ComplexConditionSyntax");
		}
		result = true;
		return result;
	}
}