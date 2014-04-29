package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.util.UtilTools;
public class GetStatusParser extends StatusParser implements IXmlVisitorParserable
{
	public GetStatusParser()
	{
	}
	public GetStatusParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof GetStatus ))  return result;
		GetStatus objElement = (GetStatus)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		objElement.setLibrary((Library)this.getObjectFromElement(node,"library","Library"));
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
		result = new GetStatus();
		loadXML((GetStatus)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof GetStatus ))  return;
			GetStatus objElement = (GetStatus)element;
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