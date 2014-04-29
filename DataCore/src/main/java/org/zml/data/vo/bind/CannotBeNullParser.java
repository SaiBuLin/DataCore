package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class CannotBeNullParser extends ValidatorParser implements IXmlVisitorParserable
{
	public CannotBeNullParser()
	{
	}
	public CannotBeNullParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof CannotBeNull ))  return result;
		CannotBeNull objElement = (CannotBeNull)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("defaultValue")!= null )
		{
			objElement.setDefaultValue(node.attribute("defaultValue").getText());
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
		result = new CannotBeNull();
		loadXML((CannotBeNull)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof CannotBeNull ))  return;
			CannotBeNull objElement = (CannotBeNull)element;
			if( !UtilTools.isNull( objElement.getDefaultValue() ))
			{
				String dataOneElement = objElement.getDefaultValue();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("defaultValue",tmpValue);
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