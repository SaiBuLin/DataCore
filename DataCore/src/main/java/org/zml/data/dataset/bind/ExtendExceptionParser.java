package org.zml.data.dataset.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class ExtendExceptionParser extends DataExceptionParser implements IXmlVisitorParserable
{
	public ExtendExceptionParser()
	{
	}
	public ExtendExceptionParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof ExtendException ))  return result;
		ExtendException objElement = (ExtendException)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("errortime")!= null )
		{
			objElement.setErrortime(node.attribute("errortime").getText());
		}
		if(node.attribute("errorcode")!= null )
		{
			objElement.setErrorcode(Convert.toInt(node.attribute("errorcode").getText()));
		}
		objElement.setErrormessage((String)this.getObjectFromElement(node,"errormessage","String"));
		objElement.setErrorreason((String)this.getObjectFromElement(node,"errorreason","String"));
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
		result = new ExtendException();
		loadXML((ExtendException)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof ExtendException ))  return;
			ExtendException objElement = (ExtendException)element;
			if( !UtilTools.isNull( objElement.getErrortime() ))
			{
				String dataOneElement = objElement.getErrortime();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("errortime",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getErrorcode() ))
			{
				int dataOneElement = objElement.getErrorcode();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("errorcode",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getErrormessage() ) )
			{
				String dataOneElement = objElement.getErrormessage();
				Element subElement =  fatherElement.addElement("errormessage");
				String tmpValue = String.valueOf(dataOneElement);
				subElement.setText(tmpValue);
			}
			if( !UtilTools.isNull( objElement.getErrorreason() ) )
			{
				String dataOneElement = objElement.getErrorreason();
				Element subElement =  fatherElement.addElement("errorreason");
				String tmpValue = String.valueOf(dataOneElement);
				subElement.setText(tmpValue);
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