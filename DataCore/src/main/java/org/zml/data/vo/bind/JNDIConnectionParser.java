package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class JNDIConnectionParser extends ConnectionParser implements IXmlVisitorParserable
{
	public JNDIConnectionParser()
	{
	}
	public JNDIConnectionParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof JNDIConnection ))  return result;
		JNDIConnection objElement = (JNDIConnection)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("jndi")!= null )
		{
			objElement.setJndi(node.attribute("jndi").getText());
		}
		if(node.attribute("context")!= null )
		{
			objElement.setContext(node.attribute("context").getText());
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
		result = new JNDIConnection();
		loadXML((JNDIConnection)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof JNDIConnection ))  return;
			JNDIConnection objElement = (JNDIConnection)element;
			if( !UtilTools.isNull( objElement.getJndi() ))
			{
				String dataOneElement = objElement.getJndi();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("jndi",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getContext() ))
			{
				String dataOneElement = objElement.getContext();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("context",tmpValue);
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