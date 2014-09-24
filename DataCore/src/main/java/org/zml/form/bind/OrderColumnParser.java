package org.zml.form.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.util.UtilTools;
public class OrderColumnParser extends FieldColumnParser implements IXmlVisitorParserable
{
	public OrderColumnParser()
	{
	}
	public OrderColumnParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof OrderColumn ))  return result;
		OrderColumn objElement = (OrderColumn)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("operation")!= null )
		{
			objElement.setOperation((OrderDirection)this.getObjectFromAttribute(node,"operation",OrderDirection.class.getName()));
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
		result = new OrderColumn();
		loadXML((OrderColumn)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof OrderColumn ))  return;
			OrderColumn objElement = (OrderColumn)element;
			if(  objElement.getOperation() != null  )
			{
				OrderDirection dataOneElement = objElement.getOperation();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("operation",tmpValue);
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