package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import java.util.ArrayList;
import org.zml.util.UtilTools;
public class AttributeGroupParser extends AttributeParser implements IXmlVisitorParserable
{
	public AttributeGroupParser()
	{
	}
	public AttributeGroupParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof AttributeGroup ))  return result;
		AttributeGroup objElement = (AttributeGroup)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(objElement.getAttribute()== null )
		{
			objElement.setAttribute( new ArrayList<Attribute>());
		}
		objElement.getAttribute().clear();
		objElement.setAttribute(this.getObjectsFromElement(node,"attribute","Attribute"));
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
		result = new AttributeGroup();
		loadXML((AttributeGroup)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof AttributeGroup ))  return;
			AttributeGroup objElement = (AttributeGroup)element;
			if(  !UtilTools.isNull(objElement.getAttribute() ) )
			{
				int mSize =objElement.getAttribute().size();
				for( int ii = 0;
				ii < mSize;
				ii++ )
				{
					Attribute dataOneElement = objElement.getAttribute().get(ii);
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