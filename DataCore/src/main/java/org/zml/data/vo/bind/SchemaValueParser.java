package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.util.UtilTools;
public class SchemaValueParser extends FieldValueParser implements IXmlVisitorParserable
{
	public SchemaValueParser()
	{
	}
	public SchemaValueParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof SchemaValue ))  return result;
		SchemaValue objElement = (SchemaValue)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		objElement.setValueContent((String)this.getObjectFromElement(node,"ValueContent","String"));
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
		result = new SchemaValue();
		loadXML((SchemaValue)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof SchemaValue ))  return;
			SchemaValue objElement = (SchemaValue)element;
			if( !UtilTools.isNull( objElement.getValueContent() ) )
			{
				String dataOneElement = objElement.getValueContent();
				Element subElement =  fatherElement.addElement("valueContent");
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