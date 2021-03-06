package org.zml.schema.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class ServiceFieldParser extends FieldParser implements IXmlVisitorParserable
{
	public ServiceFieldParser()
	{
	}
	public ServiceFieldParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof ServiceField ))  return result;
		ServiceField objElement = (ServiceField)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("field")!= null )
		{
			objElement.setField(node.attribute("field").getText());
		}
		if(node.attribute("format")!= null )
		{
			objElement.setFormat(node.attribute("format").getText());
		}
		objElement.setLibrary((Library)this.getObjectFromElement(node,"library","Library"));
		if(node.attribute("size")!= null )
		{
			objElement.setSize(Convert.toInt(node.attribute("size").getText()));
		}
		if(node.attribute("dataType")!= null )
		{
			objElement.setDataType((DataType)this.getObjectFromAttribute(node,"dataType",DataType.class.getName()));
		}
		objElement.setFilter((Filter)this.getObjectFromElement(node,"filter","Filter"));
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
		result = new ServiceField();
		loadXML((ServiceField)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof ServiceField ))  return;
			ServiceField objElement = (ServiceField)element;
			if( !UtilTools.isNull( objElement.getField() ))
			{
				String dataOneElement = objElement.getField();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("field",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getFormat() ))
			{
				String dataOneElement = objElement.getFormat();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("format",tmpValue);
			}
			if(  objElement.getLibrary()  != null )
			{
				Library dataOneElement = objElement.getLibrary();
				String xmlElementNameEx = "";
				if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
				{
					xmlElementNameEx = this.getRealElementName("library",dataOneElement.getClass().getName());
				}
				else
				{
					xmlElementNameEx = dataOneElement.getXmlElementName();
				}
				Element OchildElement = fatherElement.addElement(UtilTools.getTrim( xmlElementNameEx));
				encodeObjectToXMLForElement(OchildElement ,dataOneElement);
			}
			if( !UtilTools.isNull( objElement.getSize() ))
			{
				int dataOneElement = objElement.getSize();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("size",tmpValue);
			}
			if(  objElement.getDataType() != null  )
			{
				DataType dataOneElement = objElement.getDataType();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("dataType",tmpValue);
			}
			if(  objElement.getFilter()  != null )
			{
				Filter dataOneElement = objElement.getFilter();
				String xmlElementNameEx = "";
				if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
				{
					xmlElementNameEx = this.getRealElementName("filter",dataOneElement.getClass().getName());
				}
				else
				{
					xmlElementNameEx = dataOneElement.getXmlElementName();
				}
				Element OchildElement = fatherElement.addElement(UtilTools.getTrim( xmlElementNameEx));
				encodeObjectToXMLForElement(OchildElement ,dataOneElement);
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