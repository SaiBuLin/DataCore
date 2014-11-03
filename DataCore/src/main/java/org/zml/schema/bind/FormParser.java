package org.zml.schema.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class FormParser extends SchemaParser implements IXmlVisitorParserable
{
	public FormParser()
	{
	}
	public FormParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof Form ))  return result;
		Form objElement = (Form)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		objElement.setContent((String)this.getObjectFromElement(node,"content","String"));
		objElement.setService((Service)this.getObjectFromElement(node,"service","Service"));
		objElement.setField((Field)this.getObjectFromElement(node,"field","Field"));
		if(node.attribute("alias")!= null )
		{
			objElement.setAlias(node.attribute("alias").getText());
		}
		objElement.setCommand((Command)this.getObjectFromElement(node,"command","Command"));
		if(node.attribute("onlytable")!= null )
		{
			objElement.setOnlytable(Convert.toBoolean(node.attribute("onlytable").getText()));
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
		result = new Form();
		loadXML((Form)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof Form ))  return;
			Form objElement = (Form)element;
			if( !UtilTools.isNull( objElement.getContent() ) )
			{
				String dataOneElement = objElement.getContent();
				Element subElement =  fatherElement.addElement("content");
				String tmpValue = String.valueOf(dataOneElement);
				subElement.setText(tmpValue);
			}
			if(  objElement.getService()  != null )
			{
				Service dataOneElement = objElement.getService();
				String xmlElementNameEx = "";
				if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
				{
					xmlElementNameEx = this.getRealElementName("service",dataOneElement.getClass().getName());
				}
				else
				{
					xmlElementNameEx = dataOneElement.getXmlElementName();
				}
				Element OchildElement = fatherElement.addElement(UtilTools.getTrim( xmlElementNameEx));
				encodeObjectToXMLForElement(OchildElement ,dataOneElement);
			}
			if(  objElement.getField()  != null )
			{
				Field dataOneElement = objElement.getField();
				String xmlElementNameEx = "";
				if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
				{
					xmlElementNameEx = this.getRealElementName("field",dataOneElement.getClass().getName());
				}
				else
				{
					xmlElementNameEx = dataOneElement.getXmlElementName();
				}
				Element OchildElement = fatherElement.addElement(UtilTools.getTrim( xmlElementNameEx));
				encodeObjectToXMLForElement(OchildElement ,dataOneElement);
			}
			if( !UtilTools.isNull( objElement.getAlias() ))
			{
				String dataOneElement = objElement.getAlias();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("alias",tmpValue);
			}
			if(  objElement.getCommand()  != null )
			{
				Command dataOneElement = objElement.getCommand();
				String xmlElementNameEx = "";
				if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
				{
					xmlElementNameEx = this.getRealElementName("command",dataOneElement.getClass().getName());
				}
				else
				{
					xmlElementNameEx = dataOneElement.getXmlElementName();
				}
				Element OchildElement = fatherElement.addElement(UtilTools.getTrim( xmlElementNameEx));
				encodeObjectToXMLForElement(OchildElement ,dataOneElement);
			}
			if( !UtilTools.isNull( objElement.getOnlytable() ))
			{
				Boolean dataOneElement = objElement.getOnlytable();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("onlytable",tmpValue);
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