package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class DoActionSetParser extends DataSetParser implements IXmlVisitorParserable
{
	public DoActionSetParser()
	{
	}
	public DoActionSetParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof DoActionSet ))  return result;
		DoActionSet objElement = (DoActionSet)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("methodname")!= null )
		{
			objElement.setMethodname(node.attribute("methodname").getText());
		}
		if(node.attribute("actionclass")!= null )
		{
			objElement.setActionclass(node.attribute("actionclass").getText());
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
		result = new DoActionSet();
		loadXML((DoActionSet)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof DoActionSet ))  return;
			DoActionSet objElement = (DoActionSet)element;
			if( !UtilTools.isNull( objElement.getMethodname() ))
			{
				String dataOneElement = objElement.getMethodname();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("methodname",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getActionclass() ))
			{
				String dataOneElement = objElement.getActionclass();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("actionclass",tmpValue);
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