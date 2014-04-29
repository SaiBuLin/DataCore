package org.zml.data.vo.command.bind;
import org.zml.tools.xml.parser.XMLVisitorParser;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.zml.tools.xml.parser.CTXMLElement;
import org.dom4j.Element;
import org.zml.tools.xml.parser.UTools;
import org.zml.util.UtilTools;
public class ParamValueTypeParser extends XMLVisitorParser implements IXmlVisitorParserable
{
	public ParamValueTypeParser(XMLVisitorFactory thisFactory)
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
		if (NodeValue.equals("zyhDatetime"))
		{
			result = ParamValueType.zyhDatetime;
		}
		else if (NodeValue.equals("zyhInteger"))
		{
			result = ParamValueType.zyhInteger;
		}
		else if (NodeValue.equals("zyhFloat"))
		{
			result = ParamValueType.zyhFloat;
		}
		else if (NodeValue.equals("zyhLong"))
		{
			result = ParamValueType.zyhLong;
		}
		else if (NodeValue.equals("zyhBoolean"))
		{
			result = ParamValueType.zyhBoolean;
		}
		else if (NodeValue.equals("zyhString"))
		{
			result = ParamValueType.zyhString;
		}
		else if (NodeValue.equals("zyhXML"))
		{
			result = ParamValueType.zyhXML;
		}
		else if (NodeValue.equals("zyhDouble"))
		{
			result = ParamValueType.zyhDouble;
		}
		else if (NodeValue.equals("zyhBlob"))
		{
			result = ParamValueType.zyhBlob;
		}
		else if (NodeValue.equals("zyhNumberic"))
		{
			result = ParamValueType.zyhNumberic;
		}
		else if (NodeValue.equals("zyhShort"))
		{
			result = ParamValueType.zyhShort;
		}
		else if (NodeValue.equals("zyhDate"))
		{
			result = ParamValueType.zyhDate;
		}
		return result;
	}
	public Object parserValue(String value)
	{
		Object result = null;
		if (UtilTools.isNull(value) ) return result;
		String tmpValue = UtilTools.getTrim(value);
		if (tmpValue.equals("zyhDatetime"))
		{
			result = ParamValueType.zyhDatetime;
		}
		else if (tmpValue.equals("zyhInteger"))
		{
			result = ParamValueType.zyhInteger;
		}
		else if (tmpValue.equals("zyhFloat"))
		{
			result = ParamValueType.zyhFloat;
		}
		else if (tmpValue.equals("zyhLong"))
		{
			result = ParamValueType.zyhLong;
		}
		else if (tmpValue.equals("zyhBoolean"))
		{
			result = ParamValueType.zyhBoolean;
		}
		else if (tmpValue.equals("zyhString"))
		{
			result = ParamValueType.zyhString;
		}
		else if (tmpValue.equals("zyhXML"))
		{
			result = ParamValueType.zyhXML;
		}
		else if (tmpValue.equals("zyhDouble"))
		{
			result = ParamValueType.zyhDouble;
		}
		else if (tmpValue.equals("zyhBlob"))
		{
			result = ParamValueType.zyhBlob;
		}
		else if (tmpValue.equals("zyhNumberic"))
		{
			result = ParamValueType.zyhNumberic;
		}
		else if (tmpValue.equals("zyhShort"))
		{
			result = ParamValueType.zyhShort;
		}
		else if (tmpValue.equals("zyhDate"))
		{
			result = ParamValueType.zyhDate;
		}
		return result;
	}
}