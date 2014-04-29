package org.zml.data.service.page.request.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import java.util.ArrayList;
import org.zml.util.UtilTools;
public class RequestFieldGroupParser extends RequestFieldParser implements IXmlVisitorParserable
{
	public RequestFieldGroupParser()
	{
	}
	public RequestFieldGroupParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof RequestFieldGroup ))  return result;
		RequestFieldGroup objElement = (RequestFieldGroup)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(objElement.getRequestField()== null )
		{
			objElement.setRequestField( new ArrayList<RequestField>());
		}
		objElement.getRequestField().clear();
		objElement.setRequestField(this.getObjectsFromElement(node,"requestField","RequestField"));
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
		result = new RequestFieldGroup();
		loadXML((RequestFieldGroup)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof RequestFieldGroup ))  return;
			RequestFieldGroup objElement = (RequestFieldGroup)element;
			if(  !UtilTools.isNull(objElement.getRequestField() ) )
			{
				int mSize =objElement.getRequestField().size();
				for( int ii = 0;
				ii < mSize;
				ii++ )
				{
					RequestField dataOneElement = objElement.getRequestField().get(ii);
					String xmlElementNameEx = "";
					if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
					{
						xmlElementNameEx = this.getRealElementName("requestField",dataOneElement.getClass().getName());
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