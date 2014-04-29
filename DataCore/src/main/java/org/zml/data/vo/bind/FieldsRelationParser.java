package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class FieldsRelationParser extends RelationParser implements IXmlVisitorParserable
{
	public FieldsRelationParser()
	{
	}
	public FieldsRelationParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof FieldsRelation ))  return result;
		FieldsRelation objElement = (FieldsRelation)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("rightfield")!= null )
		{
			objElement.setRightfield(node.attribute("rightfield").getText());
		}
		if(node.attribute("operation")!= null )
		{
			objElement.setOperation((FieldLogical)this.getObjectFromAttribute(node,"operation",FieldLogical.class.getName()));
		}
		if(node.attribute("leftfield")!= null )
		{
			objElement.setLeftfield(node.attribute("leftfield").getText());
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
		result = new FieldsRelation();
		loadXML((FieldsRelation)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof FieldsRelation ))  return;
			FieldsRelation objElement = (FieldsRelation)element;
			if( !UtilTools.isNull( objElement.getRightfield() ))
			{
				String dataOneElement = objElement.getRightfield();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("rightfield",tmpValue);
			}
			if(  objElement.getOperation() != null  )
			{
				FieldLogical dataOneElement = objElement.getOperation();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("operation",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getLeftfield() ))
			{
				String dataOneElement = objElement.getLeftfield();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("leftfield",tmpValue);
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