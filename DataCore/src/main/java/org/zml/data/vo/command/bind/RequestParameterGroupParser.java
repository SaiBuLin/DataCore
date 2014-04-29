package org.zml.data.vo.command.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import java.util.ArrayList;
import org.zml.util.UtilTools;
public class RequestParameterGroupParser extends RequestParameterParser implements IXmlVisitorParserable
{
	public RequestParameterGroupParser()
	{
	}
	public RequestParameterGroupParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof RequestParameterGroup ))  return result;
		RequestParameterGroup objElement = (RequestParameterGroup)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(objElement.getRequestParameter()== null )
		{
			objElement.setRequestParameter( new ArrayList<RequestParameter>());
		}
		objElement.getRequestParameter().clear();
		objElement.setRequestParameter(this.getObjectsFromElement(node,"requestParameter","RequestParameter"));
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
		result = new RequestParameterGroup();
		loadXML((RequestParameterGroup)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof RequestParameterGroup ))  return;
			RequestParameterGroup objElement = (RequestParameterGroup)element;
			if(  !UtilTools.isNull(objElement.getRequestParameter() ) )
			{
				int mSize =objElement.getRequestParameter().size();
				for( int ii = 0;
				ii < mSize;
				ii++ )
				{
					RequestParameter dataOneElement = objElement.getRequestParameter().get(ii);
					String xmlElementNameEx = "";
					if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
					{
						xmlElementNameEx = this.getRealElementName("requestParameter",dataOneElement.getClass().getName());
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