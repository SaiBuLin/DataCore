package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.XMLVisitorParser;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.zml.tools.xml.parser.CTXMLElement;
import org.dom4j.Element;
import org.zml.tools.xml.parser.UTools;
import org.zml.util.UtilTools;
public class SQLFunctionParser extends XMLVisitorParser implements IXmlVisitorParserable
{
	public SQLFunctionParser(XMLVisitorFactory thisFactory)
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
		if (NodeValue.equals("VAR"))
		{
			result = SQLFunction.VAR;
		}
		else if (NodeValue.equals("MAX"))
		{
			result = SQLFunction.MAX;
		}
		else if (NodeValue.equals("STDEV"))
		{
			result = SQLFunction.STDEV;
		}
		else if (NodeValue.equals("LAST"))
		{
			result = SQLFunction.LAST;
		}
		else if (NodeValue.equals("FIRST"))
		{
			result = SQLFunction.FIRST;
		}
		else if (NodeValue.equals("SUM"))
		{
			result = SQLFunction.SUM;
		}
		else if (NodeValue.equals("VARP"))
		{
			result = SQLFunction.VARP;
		}
		else if (NodeValue.equals("COUNT"))
		{
			result = SQLFunction.COUNT;
		}
		else if (NodeValue.equals("STDEVP"))
		{
			result = SQLFunction.STDEVP;
		}
		else if (NodeValue.equals("MIN"))
		{
			result = SQLFunction.MIN;
		}
		else if (NodeValue.equals("AVG"))
		{
			result = SQLFunction.AVG;
		}
		return result;
	}
	public Object parserValue(String value)
	{
		Object result = null;
		if (UtilTools.isNull(value) ) return result;
		String tmpValue = UtilTools.getTrim(value);
		if (tmpValue.equals("VAR"))
		{
			result = SQLFunction.VAR;
		}
		else if (tmpValue.equals("MAX"))
		{
			result = SQLFunction.MAX;
		}
		else if (tmpValue.equals("STDEV"))
		{
			result = SQLFunction.STDEV;
		}
		else if (tmpValue.equals("LAST"))
		{
			result = SQLFunction.LAST;
		}
		else if (tmpValue.equals("FIRST"))
		{
			result = SQLFunction.FIRST;
		}
		else if (tmpValue.equals("SUM"))
		{
			result = SQLFunction.SUM;
		}
		else if (tmpValue.equals("VARP"))
		{
			result = SQLFunction.VARP;
		}
		else if (tmpValue.equals("COUNT"))
		{
			result = SQLFunction.COUNT;
		}
		else if (tmpValue.equals("STDEVP"))
		{
			result = SQLFunction.STDEVP;
		}
		else if (tmpValue.equals("MIN"))
		{
			result = SQLFunction.MIN;
		}
		else if (tmpValue.equals("AVG"))
		{
			result = SQLFunction.AVG;
		}
		return result;
	}
}