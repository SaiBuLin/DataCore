package org.zml.schema.bind;
import org.zml.tools.xml.parser.XMLVisitorParser;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.zml.tools.xml.parser.CTXMLElement;
import org.dom4j.Element;
import org.zml.tools.xml.parser.UTools;
import org.zml.util.UtilTools;
public class OperationLogicalParser extends XMLVisitorParser implements IXmlVisitorParserable
{
	public OperationLogicalParser(XMLVisitorFactory thisFactory)
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
		if (NodeValue.equals("AND"))
		{
			result = OperationLogical.AND;
		}
		else if (NodeValue.equals("NOT"))
		{
			result = OperationLogical.NOT;
		}
		else if (NodeValue.equals("OR"))
		{
			result = OperationLogical.OR;
		}
		return result;
	}
	public Object parserValue(String value)
	{
		Object result = null;
		if (UtilTools.isNull(value) ) return result;
		String tmpValue = UtilTools.getTrim(value);
		if (tmpValue.equals("AND"))
		{
			result = OperationLogical.AND;
		}
		else if (tmpValue.equals("NOT"))
		{
			result = OperationLogical.NOT;
		}
		else if (tmpValue.equals("OR"))
		{
			result = OperationLogical.OR;
		}
		return result;
	}
}