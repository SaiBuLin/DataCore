package org.zml.schema.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class ViewRelationParser extends RelationParser implements IXmlVisitorParserable
{
	public ViewRelationParser()
	{
	}
	public ViewRelationParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof ViewRelation ))  return result;
		ViewRelation objElement = (ViewRelation)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("right")!= null )
		{
			objElement.setRight(node.attribute("right").getText());
		}
		objElement.setExpress((Express)this.getObjectFromElement(node,"express","Express"));
		if(node.attribute("left")!= null )
		{
			objElement.setLeft(node.attribute("left").getText());
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
		result = new ViewRelation();
		loadXML((ViewRelation)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof ViewRelation ))  return;
			ViewRelation objElement = (ViewRelation)element;
			if( !UtilTools.isNull( objElement.getRight() ))
			{
				String dataOneElement = objElement.getRight();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("right",tmpValue);
			}
			if(  objElement.getExpress()  != null )
			{
				Express dataOneElement = objElement.getExpress();
				String xmlElementNameEx = "";
				if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
				{
					xmlElementNameEx = this.getRealElementName("express",dataOneElement.getClass().getName());
				}
				else
				{
					xmlElementNameEx = dataOneElement.getXmlElementName();
				}
				Element OchildElement = fatherElement.addElement(UtilTools.getTrim( xmlElementNameEx));
				encodeObjectToXMLForElement(OchildElement ,dataOneElement);
			}
			if( !UtilTools.isNull( objElement.getLeft() ))
			{
				String dataOneElement = objElement.getLeft();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("left",tmpValue);
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