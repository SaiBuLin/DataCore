package org.zml.data.vo.command.bind;
import org.zml.tools.xml.parser.XMLVisitorParser;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class CommandDefineParser extends XMLVisitorParser implements IXmlVisitorParserable
{
	public CommandDefineParser()
	{
	}
	public CommandDefineParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof CommandDefine ))  return result;
		CommandDefine objElement = (CommandDefine)element;
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
		result = new CommandDefine();
		loadXML((CommandDefine)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			if( !(element instanceof CommandDefine ))  return;
			CommandDefine objElement = (CommandDefine)element;
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