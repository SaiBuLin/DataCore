package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class StoredproductFormParser extends ServiceFormParser implements IXmlVisitorParserable
{
	public StoredproductFormParser()
	{
	}
	public StoredproductFormParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof StoredproductForm ))  return result;
		StoredproductForm objElement = (StoredproductForm)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("storedproduct")!= null )
		{
			objElement.setStoredproduct(node.attribute("storedproduct").getText());
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
		result = new StoredproductForm();
		loadXML((StoredproductForm)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof StoredproductForm ))  return;
			StoredproductForm objElement = (StoredproductForm)element;
			if( !UtilTools.isNull( objElement.getStoredproduct() ))
			{
				String dataOneElement = objElement.getStoredproduct();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("storedproduct",tmpValue);
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