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
		if (NodeValue.equals("zmlUNknown"))
		{
			result = ParamValueType.zmlUNknown;
		}
		else if (NodeValue.equals("zmlDouble"))
		{
			result = ParamValueType.zmlDouble;
		}
		else if (NodeValue.equals("zmlGeometry"))
		{
			result = ParamValueType.zmlGeometry;
		}
		else if (NodeValue.equals("zmlString"))
		{
			result = ParamValueType.zmlString;
		}
		else if (NodeValue.equals("SQLParameter"))
		{
			result = ParamValueType.SQLParameter;
		}
		else if (NodeValue.equals("zmlNumberic"))
		{
			result = ParamValueType.zmlNumberic;
		}
		else if (NodeValue.equals("zmlLong"))
		{
			result = ParamValueType.zmlLong;
		}
		else if (NodeValue.equals("zmlShort"))
		{
			result = ParamValueType.zmlShort;
		}
		else if (NodeValue.equals("zmlXML"))
		{
			result = ParamValueType.zmlXML;
		}
		else if (NodeValue.equals("zmlFloat"))
		{
			result = ParamValueType.zmlFloat;
		}
		else if (NodeValue.equals("zmlJSON"))
		{
			result = ParamValueType.zmlJSON;
		}
		else if (NodeValue.equals("zmlDatetime"))
		{
			result = ParamValueType.zmlDatetime;
		}
		else if (NodeValue.equals("zmlBoolean"))
		{
			result = ParamValueType.zmlBoolean;
		}
		else if (NodeValue.equals("zmlBlob"))
		{
			result = ParamValueType.zmlBlob;
		}
		else if (NodeValue.equals("zmlDate"))
		{
			result = ParamValueType.zmlDate;
		}
		else if (NodeValue.equals("zmlInteger"))
		{
			result = ParamValueType.zmlInteger;
		}
		return result;
	}
	public Object parserValue(String value)
	{
		Object result = null;
		if (UtilTools.isNull(value) ) return result;
		String tmpValue = UtilTools.getTrim(value);
		if (tmpValue.equals("zmlUNknown"))
		{
			result = ParamValueType.zmlUNknown;
		}
		else if (tmpValue.equals("zmlDouble"))
		{
			result = ParamValueType.zmlDouble;
		}
		else if (tmpValue.equals("zmlGeometry"))
		{
			result = ParamValueType.zmlGeometry;
		}
		else if (tmpValue.equals("zmlString"))
		{
			result = ParamValueType.zmlString;
		}
		else if (tmpValue.equals("SQLParameter"))
		{
			result = ParamValueType.SQLParameter;
		}
		else if (tmpValue.equals("zmlNumberic"))
		{
			result = ParamValueType.zmlNumberic;
		}
		else if (tmpValue.equals("zmlLong"))
		{
			result = ParamValueType.zmlLong;
		}
		else if (tmpValue.equals("zmlShort"))
		{
			result = ParamValueType.zmlShort;
		}
		else if (tmpValue.equals("zmlXML"))
		{
			result = ParamValueType.zmlXML;
		}
		else if (tmpValue.equals("zmlFloat"))
		{
			result = ParamValueType.zmlFloat;
		}
		else if (tmpValue.equals("zmlJSON"))
		{
			result = ParamValueType.zmlJSON;
		}
		else if (tmpValue.equals("zmlDatetime"))
		{
			result = ParamValueType.zmlDatetime;
		}
		else if (tmpValue.equals("zmlBoolean"))
		{
			result = ParamValueType.zmlBoolean;
		}
		else if (tmpValue.equals("zmlBlob"))
		{
			result = ParamValueType.zmlBlob;
		}
		else if (tmpValue.equals("zmlDate"))
		{
			result = ParamValueType.zmlDate;
		}
		else if (tmpValue.equals("zmlInteger"))
		{
			result = ParamValueType.zmlInteger;
		}
		return result;
	}
}