package org.zml.data.vo.bind;
import java.util.ArrayList;
public class ValidatorGroup extends Validator
{
	private ArrayList<Validator> validator = new ArrayList<Validator>();
	public ArrayList<Validator> getValidator()
	{
		return this.validator;
	}
	public void setValidator(ArrayList<Validator> invalidator )
	{
		this.validator = invalidator;
	}
}