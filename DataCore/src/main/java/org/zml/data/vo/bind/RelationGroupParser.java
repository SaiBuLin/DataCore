package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import java.util.ArrayList;
import org.zml.util.UtilTools;
public class RelationGroupParser extends RelationParser implements IXmlVisitorParserable
{
	public RelationGroupParser()
	{
	}
	public RelationGroupParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof RelationGroup ))  return result;
		RelationGroup objElement = (RelationGroup)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(objElement.getRelation()== null )
		{
			objElement.setRelation( new ArrayList<Relation>());
		}
		objElement.getRelation().clear();
		objElement.setRelation(this.getObjectsFromElement(node,"relation","Relation"));
		if(node.attribute("reloperation")!= null )
		{
			objElement.setReloperation((OperationLogical)this.getObjectFromAttribute(node,"reloperation",OperationLogical.class.getName()));
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
		result = new RelationGroup();
		loadXML((RelationGroup)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof RelationGroup ))  return;
			RelationGroup objElement = (RelationGroup)element;
			if(  !UtilTools.isNull(objElement.getRelation() ) )
			{
				int mSize =objElement.getRelation().size();
				for( int ii = 0;
				ii < mSize;
				ii++ )
				{
					Relation dataOneElement = objElement.getRelation().get(ii);
					String xmlElementNameEx = "";
					if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
					{
						xmlElementNameEx = this.getRealElementName("relation",dataOneElement.getClass().getName());
					}
					else
					{
						xmlElementNameEx = dataOneElement.getXmlElementName();
					}
					Element OchildElement = fatherElement.addElement(UtilTools.getTrim( xmlElementNameEx));
					encodeObjectToXMLForElement(OchildElement ,dataOneElement);
				}
			}
			if(  objElement.getReloperation() != null  )
			{
				OperationLogical dataOneElement = objElement.getReloperation();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("reloperation",tmpValue);
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