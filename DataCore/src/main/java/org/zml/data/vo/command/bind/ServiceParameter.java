package org.zml.data.vo.command.bind;
public class ServiceParameter extends RequestParameter
{
	private ParamValueType paramtype;
	private String param;
	private String valuecontent;
	public ParamValueType getParamtype()
	{
		return this.paramtype;
	}
	public void setParamtype(ParamValueType inparamtype )
	{
		this.paramtype = inparamtype;
	}
	public String getParam()
	{
		return this.param;
	}
	public void setParam(String inparam )
	{
		this.param = inparam;
	}
	public String getValuecontent()
	{
		return this.valuecontent;
	}
	public void setValuecontent(String invaluecontent )
	{
		this.valuecontent = invaluecontent;
	}
}