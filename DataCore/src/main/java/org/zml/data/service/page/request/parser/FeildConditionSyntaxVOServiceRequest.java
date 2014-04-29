package org.zml.data.service.page.request.parser;
import org.zml.data.service.page.request.bind.FeildConditionSyntax;
public class FeildConditionSyntaxVOServiceRequest extends VOServiceRequest implements VOServiceRequestAble
{
	public FeildConditionSyntaxVOServiceRequest( FeildConditionSyntax element)
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
		if ( !(this.getQueryDefineElement() instanceof FeildConditionSyntax))
		{
			throw new Exception(" FeildConditionSyntaxVOServiceRequest only parse FeildConditionSyntax");
		}
		result = true;
		return result;
	}
}