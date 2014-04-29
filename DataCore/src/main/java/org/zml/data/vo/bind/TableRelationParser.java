package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.XMLVisitorParser;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.zml.tools.xml.parser.CTXMLElement;
import org.dom4j.Element;
import org.zml.tools.xml.parser.UTools;
import org.zml.util.UtilTools;
public class TableRelationParser extends XMLVisitorParser implements IXmlVisitorParserable
{
	public TableRelationParser(XMLVisitorFactory thisFactory)
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
		if (NodeValue.equals("INNER_JOIN"))
		{
			result = TableRelation.INNER_JOIN;
		}
		else if (NodeValue.equals("RIGHT_OUTER_JOIN"))
		{
			result = TableRelation.RIGHT_OUTER_JOIN;
		}
		else if (NodeValue.equals("EXISTS"))
		{
			result = TableRelation.EXISTS;
		}
		else if (NodeValue.equals("NOT_EXISTS"))
		{
			result = TableRelation.NOT_EXISTS;
		}
		else if (NodeValue.equals("LEFT_OUTER_JOIN"))
		{
			result = TableRelation.LEFT_OUTER_JOIN;
		}
		return result;
	}
	public Object parserValue(String value)
	{
		Object result = null;
		if (UtilTools.isNull(value) ) return result;
		String tmpValue = UtilTools.getTrim(value);
		if (tmpValue.equals("INNER_JOIN"))
		{
			result = TableRelation.INNER_JOIN;
		}
		else if (tmpValue.equals("RIGHT_OUTER_JOIN"))
		{
			result = TableRelation.RIGHT_OUTER_JOIN;
		}
		else if (tmpValue.equals("EXISTS"))
		{
			result = TableRelation.EXISTS;
		}
		else if (tmpValue.equals("NOT_EXISTS"))
		{
			result = TableRelation.NOT_EXISTS;
		}
		else if (tmpValue.equals("LEFT_OUTER_JOIN"))
		{
			result = TableRelation.LEFT_OUTER_JOIN;
		}
		return result;
	}
}