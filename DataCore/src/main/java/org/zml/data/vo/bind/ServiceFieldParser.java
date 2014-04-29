package org.zml.data.vo.bind;
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
		objElement.setFieldValue((FieldValue)this.getObjectFromElement(node,"fieldValue","FieldValue"));
		if(node.attribute("function")!= null )
		{
			objElement.setFunction((SQLFunction)this.getObjectFromAttribute(node,"function",SQLFunction.class.getName()));
		}
		objElement.setStatus((Status)this.getObjectFromElement(node,"status","Status"));
		if(node.attribute("label")!= null )
		{
			objElement.setLabel(node.attribute("label").getText());
		}
		if(node.attribute("dataType")!= null )
		{
			objElement.setDataType((DataType)this.getObjectFromAttribute(node,"dataType",DataType.class.getName()));
		}
		if(node.attribute("format")!= null )
		{
			objElement.setFormat(node.attribute("format").getText());
		}
		if(node.attribute("noneSelected")!= null )
		{
			objElement.setNoneSelected(Convert.toBoolean(node.attribute("noneSelected").getText()));
		}
		if(node.attribute("size")!= null )
		{
			objElement.setSize(Convert.toInt(node.attribute("size").getText()));
		}
		if(node.attribute("field")!= null )
		{
			objElement.setField(node.attribute("field").getText());
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
			if(  objElement.getFieldValue()  != null )
			{
				FieldValue dataOneElement = objElement.getFieldValue();
				String xmlElementNameEx = "";
				if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
				{
					xmlElementNameEx = this.getRealElementName("fieldValue",dataOneElement.getClass().getName());
				}
				else
				{
					xmlElementNameEx = dataOneElement.getXmlElementName();
				}
				Element OchildElement = fatherElement.addElement(UtilTools.getTrim( xmlElementNameEx));
				encodeObjectToXMLForElement(OchildElement ,dataOneElement);
			}
			if(  objElement.getFunction() != null  )
			{
				SQLFunction dataOneElement = objElement.getFunction();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("function",tmpValue);
			}
			if(  objElement.getStatus()  != null )
			{
				Status dataOneElement = objElement.getStatus();
				String xmlElementNameEx = "";
				if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
				{
					xmlElementNameEx = this.getRealElementName("status",dataOneElement.getClass().getName());
				}
				else
				{
					xmlElementNameEx = dataOneElement.getXmlElementName();
				}
				Element OchildElement = fatherElement.addElement(UtilTools.getTrim( xmlElementNameEx));
				encodeObjectToXMLForElement(OchildElement ,dataOneElement);
			}
			if( !UtilTools.isNull( objElement.getLabel() ))
			{
				String dataOneElement = objElement.getLabel();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("label",tmpValue);
			}
			if(  objElement.getDataType() != null  )
			{
				DataType dataOneElement = objElement.getDataType();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("dataType",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getFormat() ))
			{
				String dataOneElement = objElement.getFormat();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("format",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getNoneSelected() ))
			{
				Boolean dataOneElement = objElement.getNoneSelected();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("noneSelected",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getSize() ))
			{
				int dataOneElement = objElement.getSize();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("size",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getField() ))
			{
				String dataOneElement = objElement.getField();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("field",tmpValue);
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