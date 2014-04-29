package org.zml.data.vo.command.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class ServiceParameterParser extends RequestParameterParser implements IXmlVisitorParserable
{
	public ServiceParameterParser()
	{
	}
	public ServiceParameterParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof ServiceParameter ))  return result;
		ServiceParameter objElement = (ServiceParameter)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("paramtype")!= null )
		{
			objElement.setParamtype((ParamValueType)this.getObjectFromAttribute(node,"paramtype",ParamValueType.class.getName()));
		}
		if(node.attribute("param")!= null )
		{
			objElement.setParam(node.attribute("param").getText());
		}
		objElement.setValuecontent((String)this.getObjectFromElement(node,"valuecontent","String"));
		if ( !UtilTools.isNull( node.getText() ) )
		{
			objElement.setText(UtilTools.getTrim(node.getText()));
		}
		return result;
	}
	public Object parserNode(Element node)
	{
		Object result = null;
		if (node == null) return result;
		result = new ServiceParameter();
		loadXML((ServiceParameter)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof ServiceParameter ))  return;
			ServiceParameter objElement = (ServiceParameter)element;
			if(  objElement.getParamtype() != null  )
			{
				ParamValueType dataOneElement = objElement.getParamtype();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("paramtype",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getParam() ))
			{
				String dataOneElement = objElement.getParam();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("param",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getValuecontent() ) )
			{
				String dataOneElement = objElement.getValuecontent();
				Element subElement =  fatherElement.addElement("valuecontent");
				String tmpValue = String.valueOf(dataOneElement);
				subElement.setText(tmpValue);
			}
			if (!UtilTools.isNull(objElement.getText()))
			{
				String dataOneElement = objElement.getText();
				fatherElement.setText(dataOneElement);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}