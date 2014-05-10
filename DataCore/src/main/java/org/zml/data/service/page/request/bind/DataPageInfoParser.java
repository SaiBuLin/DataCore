package org.zml.data.service.page.request.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class DataPageInfoParser extends PageInfoParser implements IXmlVisitorParserable
{
	public DataPageInfoParser()
	{
	}
	public DataPageInfoParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof DataPageInfo ))  return result;
		DataPageInfo objElement = (DataPageInfo)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("page")!= null )
		{
			objElement.setPage(Convert.toInt(node.attribute("page").getText()));
		}
		if(node.attribute("records")!= null )
		{
			objElement.setRecords(Convert.toLong(node.attribute("records").getText()));
		}
		if(node.attribute("pages")!= null )
		{
			objElement.setPages(Convert.toInt(node.attribute("pages").getText()));
		}
		if(node.attribute("size")!= null )
		{
			objElement.setSize(Convert.toInt(node.attribute("size").getText()));
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
		result = new DataPageInfo();
		loadXML((DataPageInfo)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof DataPageInfo ))  return;
			DataPageInfo objElement = (DataPageInfo)element;
			if( !UtilTools.isNull( objElement.getPage() ))
			{
				int dataOneElement = objElement.getPage();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("page",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getRecords() ))
			{
				Long dataOneElement = objElement.getRecords();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("records",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getPages() ))
			{
				int dataOneElement = objElement.getPages();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("pages",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getSize() ))
			{
				int dataOneElement = objElement.getSize();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("size",tmpValue);
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