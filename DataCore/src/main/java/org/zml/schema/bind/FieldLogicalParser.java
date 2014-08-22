package org.zml.schema.bind;
import org.zml.tools.xml.parser.XMLVisitorParser;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.zml.tools.xml.parser.CTXMLElement;
import org.dom4j.Element;
import org.zml.tools.xml.parser.UTools;
import org.zml.util.UtilTools;
public class FieldLogicalParser extends XMLVisitorParser implements IXmlVisitorParserable
{
	public FieldLogicalParser(XMLVisitorFactory thisFactory)
	{
		setFactory( thisFactory );
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		return result;
	}
	public Object parserNode(Element node)
	{
		Object result = null;
		if (node == null) return result;
		String NodeValue = node.getTextTrim();
		NodeValue = UTools.getTrim( NodeValue );
		if (NodeValue.equals("NOT_LOWER"))
		{
			result = FieldLogical.NOT_LOWER;
		}
		else if (NodeValue.equals("LARGER"))
		{
			result = FieldLogical.LARGER;
		}
		else if (NodeValue.equals("IN"))
		{
			result = FieldLogical.IN;
		}
		else if (NodeValue.equals("LOWER"))
		{
			result = FieldLogical.LOWER;
		}
		else if (NodeValue.equals("NOT_LARGER"))
		{
			result = FieldLogical.NOT_LARGER;
		}
		else if (NodeValue.equals("NOTEQUALS"))
		{
			result = FieldLogical.NOTEQUALS;
		}
		else if (NodeValue.equals("NOT_IN"))
		{
			result = FieldLogical.NOT_IN;
		}
		else if (NodeValue.equals("EQUALS"))
		{
			result = FieldLogical.EQUALS;
		}
		return result;
	}
	public Object parserValue(String value)
	{
		Object result = null;
		if (UtilTools.isNull(value) ) return result;
		String tmpValue = UtilTools.getTrim(value);
		if (tmpValue.equals("NOT_LOWER"))
		{
			result = FieldLogical.NOT_LOWER;
		}
		else if (tmpValue.equals("LARGER"))
		{
			result = FieldLogical.LARGER;
		}
		else if (tmpValue.equals("IN"))
		{
			result = FieldLogical.IN;
		}
		else if (tmpValue.equals("LOWER"))
		{
			result = FieldLogical.LOWER;
		}
		else if (tmpValue.equals("NOT_LARGER"))
		{
			result = FieldLogical.NOT_LARGER;
		}
		else if (tmpValue.equals("NOTEQUALS"))
		{
			result = FieldLogical.NOTEQUALS;
		}
		else if (tmpValue.equals("NOT_IN"))
		{
			result = FieldLogical.NOT_IN;
		}
		else if (tmpValue.equals("EQUALS"))
		{
			result = FieldLogical.EQUALS;
		}
		return result;
	}
}