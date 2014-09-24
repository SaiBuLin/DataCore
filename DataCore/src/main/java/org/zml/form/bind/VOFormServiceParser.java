package org.zml.form.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class VOFormServiceParser extends FormServiceParser implements IXmlVisitorParserable
{
	public VOFormServiceParser()
	{
	}
	public VOFormServiceParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof VOFormService ))  return result;
		VOFormService objElement = (VOFormService)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("formcode")!= null )
		{
			objElement.setFormcode(node.attribute("formcode").getText());
		}
		if(node.attribute("vocode")!= null )
		{
			objElement.setVocode(node.attribute("vocode").getText());
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
		result = new VOFormService();
		loadXML((VOFormService)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof VOFormService ))  return;
			VOFormService objElement = (VOFormService)element;
			if( !UtilTools.isNull( objElement.getFormcode() ))
			{
				String dataOneElement = objElement.getFormcode();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("formcode",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getVocode() ))
			{
				String dataOneElement = objElement.getVocode();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("vocode",tmpValue);
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