package org.zml.form.bind;
import java.util.ArrayList;
public class SectionGroup extends Section
{
	private ArrayList<Section> section = new ArrayList<Section>();
	public ArrayList<Section> getSection()
	{
		return this.section;
	}
	public void setSection(ArrayList<Section> insection )
	{
		this.section = insection;
	}
}