package org.zml.data.vo.bind;
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
		if (NodeValue.equals("zyhDatetime"))
		{
			result = DataType.zyhDatetime;
		}
		else if (NodeValue.equals("zyhShort"))
		{
			result = DataType.zyhShort;
		}
		else if (NodeValue.equals("zyhFloat"))
		{
			result = DataType.zyhFloat;
		}
		else if (NodeValue.equals("zyhLong"))
		{
			result = DataType.zyhLong;
		}
		else if (NodeValue.equals("zyhInteger"))
		{
			result = DataType.zyhInteger;
		}
		else if (NodeValue.equals("zyhString"))
		{
			result = DataType.zyhString;
		}
		else if (NodeValue.equals("zyhXML"))
		{
			result = DataType.zyhXML;
		}
		else if (NodeValue.equals("zyhDouble"))
		{
			result = DataType.zyhDouble;
		}
		else if (NodeValue.equals("zyhBlob"))
		{
			result = DataType.zyhBlob;
		}
		else if (NodeValue.equals("zyhNumberic"))
		{
			result = DataType.zyhNumberic;
		}
		else if (NodeValue.equals("zyhBoolean"))
		{
			result = DataType.zyhBoolean;
		}
		else if (NodeValue.equals("zyhDate"))
		{
			result = DataType.zyhDate;
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
			result = DataType.zyhDatetime;
		}
		else if (tmpValue.equals("zyhShort"))
		{
			result = DataType.zyhShort;
		}
		else if (tmpValue.equals("zyhFloat"))
		{
			result = DataType.zyhFloat;
		}
		else if (tmpValue.equals("zyhLong"))
		{
			result = DataType.zyhLong;
		}
		else if (tmpValue.equals("zyhInteger"))
		{
			result = DataType.zyhInteger;
		}
		else if (tmpValue.equals("zyhString"))
		{
			result = DataType.zyhString;
		}
		else if (tmpValue.equals("zyhXML"))
		{
			result = DataType.zyhXML;
		}
		else if (tmpValue.equals("zyhDouble"))
		{
			result = DataType.zyhDouble;
		}
		else if (tmpValue.equals("zyhBlob"))
		{
			result = DataType.zyhBlob;
		}
		else if (tmpValue.equals("zyhNumberic"))
		{
			result = DataType.zyhNumberic;
		}
		else if (tmpValue.equals("zyhBoolean"))
		{
			result = DataType.zyhBoolean;
		}
		else if (tmpValue.equals("zyhDate"))
		{
			result = DataType.zyhDate;
		}
		return result;
	}
}