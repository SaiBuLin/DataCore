package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class FunctionToolsParser extends ActionToolsParser implements IXmlVisitorParserable
{
	public FunctionToolsParser()
	{
	}
	public FunctionToolsParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof FunctionTools ))  return result;
		FunctionTools objElement = (FunctionTools)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("classname")!= null )
		{
			objElement.setClassname(node.attribute("classname").getText());
		}
		objElement.setAttribute((Attribute)this.getObjectFromElement(node,"attribute","Attribute"));
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
		result = new FunctionTools();
		loadXML((FunctionTools)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof FunctionTools ))  return;
			FunctionTools objElement = (FunctionTools)element;
			if( !UtilTools.isNull( objElement.getClassname() ))
			{
				String dataOneElement = objElement.getClassname();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("classname",tmpValue);
			}
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