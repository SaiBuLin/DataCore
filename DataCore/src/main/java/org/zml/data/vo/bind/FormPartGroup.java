package org.zml.data.vo.bind;
import java.util.ArrayList;
public class FormPartGroup extends FormPart
{
	private ArrayList<FormPart> formPart = new ArrayList<FormPart>();
	public ArrayList<FormPart> getFormPart()
	{
		return this.formPart;
	}
	public void setFormPart(ArrayList<FormPart> informPart )
	{
		this.formPart = informPart;
	}
}