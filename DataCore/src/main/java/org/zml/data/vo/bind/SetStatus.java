package org.zml.data.vo.bind;
public class SetStatus extends Status
{
	private Library library;
	private Validator validator;
	public Library getLibrary()
	{
		return this.library;
	}
	public void setLibrary(Library inlibrary )
	{
		this.library = inlibrary;
	}
	public Validator getValidator()
	{
		return this.validator;
	}
	public void setValidator(Validator invalidator )
	{
		this.validator = invalidator;
	}
}