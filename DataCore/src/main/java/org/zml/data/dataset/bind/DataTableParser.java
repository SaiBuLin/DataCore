package org.zml.data.dataset.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class DataTableParser extends TableParser implements IXmlVisitorParserable
{
	public DataTableParser()
	{
	}
	public DataTableParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof DataTable ))  return result;
		DataTable objElement = (DataTable)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		objElement.setDataField((DataField)this.getObjectFromElement(node,"dataField","DataField"));
		if(node.attribute("page")!= null )
		{
			objElement.setPage(Convert.toLong(node.attribute("page").getText()));
		}
		objElement.setMyValue((MyValue)this.getObjectFromElement(node,"myValue","MyValue"));
		if(node.attribute("records")!= null )
		{
			objElement.setRecords(Convert.toLong(node.attribute("records").getText()));
		}
		if(node.attribute("pages")!= null )
		{
			objElement.setPages(Convert.toLong(node.attribute("pages").getText()));
		}
		if(node.attribute("name")!= null )
		{
			objElement.setName(node.attribute("name").getText());
		}
		if(node.attribute("pagesize")!= null )
		{
			objElement.setPagesize(Convert.toLong(node.attribute("pagesize").getText()));
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
		result = new DataTable();
		loadXML((DataTable)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof DataTable ))  return;
			DataTable objElement = (DataTable)element;
			if(  objElement.getDataField()  != null )
			{
				DataField dataOneElement = objElement.getDataField();
				String xmlElementNameEx = "";
				if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
				{
					xmlElementNameEx = this.getRealElementName("dataField",dataOneElement.getClass().getName());
				}
				else
				{
					xmlElementNameEx = dataOneElement.getXmlElementName();
				}
				Element OchildElement = fatherElement.addElement(UtilTools.getTrim( xmlElementNameEx));
				encodeObjectToXMLForElement(OchildElement ,dataOneElement);
			}
			if( !UtilTools.isNull( objElement.getPage() ))
			{
				Long dataOneElement = objElement.getPage();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("page",tmpValue);
			}
			if(  objElement.getMyValue()  != null )
			{
				MyValue dataOneElement = objElement.getMyValue();
				String xmlElementNameEx = "";
				if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
				{
					xmlElementNameEx = this.getRealElementName("myValue",dataOneElement.getClass().getName());
				}
				else
				{
					xmlElementNameEx = dataOneElement.getXmlElementName();
				}
				Element OchildElement = fatherElement.addElement(UtilTools.getTrim( xmlElementNameEx));
				encodeObjectToXMLForElement(OchildElement ,dataOneElement);
			}
			if( !UtilTools.isNull( objElement.getRecords() ))
			{
				Long dataOneElement = objElement.getRecords();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("records",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getPages() ))
			{
				Long dataOneElement = objElement.getPages();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("pages",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getName() ))
			{
				String dataOneElement = objElement.getName();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("name",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getPagesize() ))
			{
				Long dataOneElement = objElement.getPagesize();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("pagesize",tmpValue);
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