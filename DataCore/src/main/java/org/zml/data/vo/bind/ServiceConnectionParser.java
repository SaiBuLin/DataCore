package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class ServiceConnectionParser extends ConnectionParser implements IXmlVisitorParserable
{
	public ServiceConnectionParser()
	{
	}
	public ServiceConnectionParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof ServiceConnection ))  return result;
		ServiceConnection objElement = (ServiceConnection)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("serviceurl")!= null )
		{
			objElement.setServiceurl(node.attribute("serviceurl").getText());
		}
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
		result = new ServiceConnection();
		loadXML((ServiceConnection)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof ServiceConnection ))  return;
			ServiceConnection objElement = (ServiceConnection)element;
			if( !UtilTools.isNull( objElement.getServiceurl() ))
			{
				String dataOneElement = objElement.getServiceurl();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("serviceurl",tmpValue);
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