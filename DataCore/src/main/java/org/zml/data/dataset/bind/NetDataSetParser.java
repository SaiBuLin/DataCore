package org.zml.data.dataset.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class NetDataSetParser extends DatasetNodeParser implements IXmlVisitorParserable
{
	public NetDataSetParser()
	{
	}
	public NetDataSetParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof NetDataSet ))  return result;
		NetDataSet objElement = (NetDataSet)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		objElement.setDataTable((DataTable)this.getObjectFromElement(node,"dataTable","DataTable"));
		objElement.setDataException((DataException)this.getObjectFromElement(node,"dataException","DataException"));
		if(node.attribute("updatenumber")!= null )
		{
			objElement.setUpdatenumber(Convert.toInt(node.attribute("updatenumber").getText()));
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
		result = new NetDataSet();
		loadXML((NetDataSet)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof NetDataSet ))  return;
			NetDataSet objElement = (NetDataSet)element;
			if(  objElement.getDataTable()  != null )
			{
				DataTable dataOneElement = objElement.getDataTable();
				String xmlElementNameEx = "";
				if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
				{
					xmlElementNameEx = this.getRealElementName("dataTable",dataOneElement.getClass().getName());
				}
				else
				{
					xmlElementNameEx = dataOneElement.getXmlElementName();
				}
				Element OchildElement = fatherElement.addElement(UtilTools.getTrim( xmlElementNameEx));
				encodeObjectToXMLForElement(OchildElement ,dataOneElement);
			}
			if(  objElement.getDataException()  != null )
			{
				DataException dataOneElement = objElement.getDataException();
				String xmlElementNameEx = "";
				if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
				{
					xmlElementNameEx = this.getRealElementName("dataException",dataOneElement.getClass().getName());
				}
				else
				{
					xmlElementNameEx = dataOneElement.getXmlElementName();
				}
				Element OchildElement = fatherElement.addElement(UtilTools.getTrim( xmlElementNameEx));
				encodeObjectToXMLForElement(OchildElement ,dataOneElement);
			}
			if( !UtilTools.isNull( objElement.getUpdatenumber() ))
			{
				int dataOneElement = objElement.getUpdatenumber();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("updatenumber",tmpValue);
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