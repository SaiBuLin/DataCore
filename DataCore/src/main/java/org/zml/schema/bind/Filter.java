package org.zml.schema.bind;
public class Filter extends Define
{
	private Library library;
	public Library getLibrary()
	{
		return this.library;
	}
	public void setLibrary(Library inlibrary )
	{
		this.library = inlibrary;
	}
}