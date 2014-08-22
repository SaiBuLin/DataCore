package org.zml.schema.bind;
import org.zml.tools.xml.parser.XMLVisitorParser;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.zml.tools.xml.parser.CTXMLElement;
import org.dom4j.Element;
import org.zml.tools.xml.parser.UTools;
import org.zml.util.UtilTools;
public class DataTypeParser extends XMLVisitorParser implements IXmlVisitorParserable
{
	public DataTypeParser(XMLVisitorFactory thisFactory)
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
		if (NodeValue.equals("zmlJSON"))
		{
			result = DataType.zmlJSON;
		}
		else if (NodeValue.equals("zmlString"))
		{
			result = DataType.zmlString;
		}
		else if (NodeValue.equals("SQLParameter"))
		{
			result = DataType.SQLParameter;
		}
		else if (NodeValue.equals("zmlLong"))
		{
			result = DataType.zmlLong;
		}
		else if (NodeValue.equals("zmlInteger"))
		{
			result = DataType.zmlInteger;
		}
		else if (NodeValue.equals("zmlDouble"))
		{
			result = DataType.zmlDouble;
		}
		else if (NodeValue.equals("zmlShort"))
		{
			result = DataType.zmlShort;
		}
		else if (NodeValue.equals("zmlGeometry"))
		{
			result = DataType.zmlGeometry;
		}
		else if (NodeValue.equals("zmlBlob"))
		{
			result = DataType.zmlBlob;
		}
		else if (NodeValue.equals("zmlFloat"))
		{
			result = DataType.zmlFloat;
		}
		else if (NodeValue.equals("zmlDatetime"))
		{
			result = DataType.zmlDatetime;
		}
		else if (NodeValue.equals("zmlXML"))
		{
			result = DataType.zmlXML;
		}
		else if (NodeValue.equals("zmlTime"))
		{
			result = DataType.zmlTime;
		}
		else if (NodeValue.equals("zmlDate"))
		{
			result = DataType.zmlDate;
		}
		else if (NodeValue.equals("zmlBoolean"))
		{
			result = DataType.zmlBoolean;
		}
		else if (NodeValue.equals("zmlUNknown"))
		{
			result = DataType.zmlUNknown;
		}
		else if (NodeValue.equals("zmlNumberic"))
		{
			result = DataType.zmlNumberic;
		}
		return result;
	}
	public Object parserValue(String value)
	{
		Object result = null;
		if (UtilTools.isNull(value) ) return result;
		String tmpValue = UtilTools.getTrim(value);
		if (tmpValue.equals("zmlJSON"))
		{
			result = DataType.zmlJSON;
		}
		else if (tmpValue.equals("zmlString"))
		{
			result = DataType.zmlString;
		}
		else if (tmpValue.equals("SQLParameter"))
		{
			result = DataType.SQLParameter;
		}
		else if (tmpValue.equals("zmlLong"))
		{
			result = DataType.zmlLong;
		}
		else if (tmpValue.equals("zmlInteger"))
		{
			result = DataType.zmlInteger;
		}
		else if (tmpValue.equals("zmlDouble"))
		{
			result = DataType.zmlDouble;
		}
		else if (tmpValue.equals("zmlShort"))
		{
			result = DataType.zmlShort;
		}
		else if (tmpValue.equals("zmlGeometry"))
		{
			result = DataType.zmlGeometry;
		}
		else if (tmpValue.equals("zmlBlob"))
		{
			result = DataType.zmlBlob;
		}
		else if (tmpValue.equals("zmlFloat"))
		{
			result = DataType.zmlFloat;
		}
		else if (tmpValue.equals("zmlDatetime"))
		{
			result = DataType.zmlDatetime;
		}
		else if (tmpValue.equals("zmlXML"))
		{
			result = DataType.zmlXML;
		}
		else if (tmpValue.equals("zmlTime"))
		{
			result = DataType.zmlTime;
		}
		else if (tmpValue.equals("zmlDate"))
		{
			result = DataType.zmlDate;
		}
		else if (tmpValue.equals("zmlBoolean"))
		{
			result = DataType.zmlBoolean;
		}
		else if (tmpValue.equals("zmlUNknown"))
		{
			result = DataType.zmlUNknown;
		}
		else if (tmpValue.equals("zmlNumberic"))
		{
			result = DataType.zmlNumberic;
		}
		return result;
	}
}