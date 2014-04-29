package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class BelongCollectionParser extends ValidatorParser implements IXmlVisitorParserable
{
	public BelongCollectionParser()
	{
	}
	public BelongCollectionParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof BelongCollection ))  return result;
		BelongCollection objElement = (BelongCollection)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("valuesCollection")!= null )
		{
			objElement.setValuesCollection(node.attribute("valuesCollection").getText());
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
		result = new BelongCollection();
		loadXML((BelongCollection)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof BelongCollection ))  return;
			BelongCollection objElement = (BelongCollection)element;
			if( !UtilTools.isNull( objElement.getValuesCollection() ))
			{
				String dataOneElement = objElement.getValuesCollection();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("valuesCollection",tmpValue);
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