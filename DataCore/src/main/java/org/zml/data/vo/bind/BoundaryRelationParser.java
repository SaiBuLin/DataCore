package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.util.UtilTools;
public class BoundaryRelationParser extends RelationParser implements IXmlVisitorParserable
{
	public BoundaryRelationParser()
	{
	}
	public BoundaryRelationParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof BoundaryRelation ))  return result;
		BoundaryRelation objElement = (BoundaryRelation)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		objElement.setBoundary((Boundary)this.getObjectFromElement(node,"boundary","Boundary"));
		if(node.attribute("tableRelation")!= null )
		{
			objElement.setTableRelation((TableRelation)this.getObjectFromAttribute(node,"tableRelation",TableRelation.class.getName()));
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
		result = new BoundaryRelation();
		loadXML((BoundaryRelation)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof BoundaryRelation ))  return;
			BoundaryRelation objElement = (BoundaryRelation)element;
			if(  objElement.getBoundary()  != null )
			{
				Boundary dataOneElement = objElement.getBoundary();
				String xmlElementNameEx = "";
				if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
				{
					xmlElementNameEx = this.getRealElementName("boundary",dataOneElement.getClass().getName());
				}
				else
				{
					xmlElementNameEx = dataOneElement.getXmlElementName();
				}
				Element OchildElement = fatherElement.addElement(UtilTools.getTrim( xmlElementNameEx));
				encodeObjectToXMLForElement(OchildElement ,dataOneElement);
			}
			if(  objElement.getTableRelation() != null  )
			{
				TableRelation dataOneElement = objElement.getTableRelation();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("tableRelation",tmpValue);
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