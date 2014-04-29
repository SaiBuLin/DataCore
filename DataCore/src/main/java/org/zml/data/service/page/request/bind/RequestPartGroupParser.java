package org.zml.data.service.page.request.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import java.util.ArrayList;
import org.zml.util.UtilTools;
public class RequestPartGroupParser extends RequestPartParser implements IXmlVisitorParserable
{
	public RequestPartGroupParser()
	{
	}
	public RequestPartGroupParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof RequestPartGroup ))  return result;
		RequestPartGroup objElement = (RequestPartGroup)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(objElement.getRequestPart()== null )
		{
			objElement.setRequestPart( new ArrayList<RequestPart>());
		}
		objElement.getRequestPart().clear();
		objElement.setRequestPart(this.getObjectsFromElement(node,"requestPart","RequestPart"));
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
		result = new RequestPartGroup();
		loadXML((RequestPartGroup)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof RequestPartGroup ))  return;
			RequestPartGroup objElement = (RequestPartGroup)element;
			if(  !UtilTools.isNull(objElement.getRequestPart() ) )
			{
				int mSize =objElement.getRequestPart().size();
				for( int ii = 0;
				ii < mSize;
				ii++ )
				{
					RequestPart dataOneElement = objElement.getRequestPart().get(ii);
					String xmlElementNameEx = "";
					if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
					{
						xmlElementNameEx = this.getRealElementName("requestPart",dataOneElement.getClass().getName());
					}
					else
					{
						xmlElementNameEx = dataOneElement.getXmlElementName();
					}
					Element OchildElement = fatherElement.addElement(UtilTools.getTrim( xmlElementNameEx));
					encodeObjectToXMLForElement(OchildElement ,dataOneElement);
				}
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