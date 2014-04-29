package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class DatabaseConnectionParser extends ConnectionParser implements IXmlVisitorParserable
{
	public DatabaseConnectionParser()
	{
	}
	public DatabaseConnectionParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof DatabaseConnection ))  return result;
		DatabaseConnection objElement = (DatabaseConnection)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("connectionString")!= null )
		{
			objElement.setConnectionString(node.attribute("connectionString").getText());
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
		result = new DatabaseConnection();
		loadXML((DatabaseConnection)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof DatabaseConnection ))  return;
			DatabaseConnection objElement = (DatabaseConnection)element;
			if( !UtilTools.isNull( objElement.getConnectionString() ))
			{
				String dataOneElement = objElement.getConnectionString();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("connectionString",tmpValue);
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