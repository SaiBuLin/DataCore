package org.zml.schema.bind;
import org.zml.tools.xml.parser.XMLVisitorParser;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class DefineParser extends XMLVisitorParser implements IXmlVisitorParserable
{
	public DefineParser()
	{
	}
	public DefineParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof Define ))  return result;
		Define objElement = (Define)element;
		objElement.setXmlElementName(node.getName());
		if(node.attribute("index")!= null )
		{
			objElement.setIndex(Convert.toInt(node.attribute("index").getText()));
		}
		if(node.attribute("code")!= null )
		{
			objElement.setCode(node.attribute("code").getText());
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
		result = new Define();
		loadXML((Define)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			if( !(element instanceof Define ))  return;
			Define objElement = (Define)element;
			if( !UtilTools.isNull( objElement.getIndex() ))
			{
				int dataOneElement = objElement.getIndex();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("index",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getCode() ))
			{
				String dataOneElement = objElement.getCode();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("code",tmpValue);
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