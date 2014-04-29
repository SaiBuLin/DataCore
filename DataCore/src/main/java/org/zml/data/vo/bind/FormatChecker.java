package org.zml.data.vo.bind;
public class FormatChecker extends Validator
{
	private String syntaxString;
	public String getSyntaxString()
	{
		return this.syntaxString;
	}
	public void setSyntaxString(String insyntaxString )
	{
		this.syntaxString = insyntaxString;
	}
}