package org.zml.schema.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class SchemaDefineParser extends DefineParser implements IXmlVisitorParserable
{
	public SchemaDefineParser()
	{
	}
	public SchemaDefineParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof SchemaDefine ))  return result;
		SchemaDefine objElement = (SchemaDefine)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		objElement.setAttribute((Attribute)this.getObjectFromElement(node,"attribute","Attribute"));
		objElement.setDescription((String)this.getObjectFromElement(node,"description","String"));
		if(node.attribute("label")!= null )
		{
			objElement.setLabel(node.attribute("label").getText());
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
		result = new SchemaDefine();
		loadXML((SchemaDefine)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof SchemaDefine ))  return;
			SchemaDefine objElement = (SchemaDefine)element;
			if(  objElement.getAttribute()  != null )
			{
				Attribute dataOneElement = objElement.getAttribute();
				String xmlElementNameEx = "";
				if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
				{
					xmlElementNameEx = this.getRealElementName("attribute",dataOneElement.getClass().getName());
				}
				else
				{
					xmlElementNameEx = dataOneElement.getXmlElementName();
				}
				Element OchildElement = fatherElement.addElement(UtilTools.getTrim( xmlElementNameEx));
				encodeObjectToXMLForElement(OchildElement ,dataOneElement);
			}
			if( !UtilTools.isNull( objElement.getDescription() ) )
			{
				String dataOneElement = objElement.getDescription();
				Element subElement =  fatherElement.addElement("description");
				String tmpValue = String.valueOf(dataOneElement);
				subElement.setText(tmpValue);
			}
			if( !UtilTools.isNull( objElement.getLabel() ))
			{
				String dataOneElement = objElement.getLabel();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("label",tmpValue);
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