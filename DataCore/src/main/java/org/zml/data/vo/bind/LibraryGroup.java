package org.zml.data.vo.bind;
import java.util.ArrayList;
public class LibraryGroup extends Library
{
	private ArrayList<Library> library = new ArrayList<Library>();
	public ArrayList<Library> getLibrary()
	{
		return this.library;
	}
	public void setLibrary(ArrayList<Library> inlibrary )
	{
		this.library = inlibrary;
	}
}