package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.ConditionSyntax;
public class ConditionSyntaxVOServiceRequest extends VOServiceRequest implements VOServiceRequestAble
{
	public ConditionSyntaxVOServiceRequest( ConditionSyntax element)
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
		if ( !(this.getQueryDefineElement() instanceof ConditionSyntax))
		{
			throw new Exception(" ConditionSyntaxVOServiceRequest only parse ConditionSyntax");
		}
		result = true;
		return result;
	}
}