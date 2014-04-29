package org.zml.data.vo.bind;
public class GetStatus extends Status
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