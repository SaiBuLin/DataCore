package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class FieldValueRelationParser extends RelationParser implements IXmlVisitorParserable
{
	public FieldValueRelationParser()
	{
	}
	public FieldValueRelationParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof FieldValueRelation ))  return result;
		FieldValueRelation objElement = (FieldValueRelation)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("operation")!= null )
		{
			objElement.setOperation((FieldLogical)this.getObjectFromAttribute(node,"operation",FieldLogical.class.getName()));
		}
		if(node.attribute("value")!= null )
		{
			objElement.setValue(node.attribute("value").getText());
		}
		if(node.attribute("field")!= null )
		{
			objElement.setField(node.attribute("field").getText());
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
		result = new FieldValueRelation();
		loadXML((FieldValueRelation)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof FieldValueRelation ))  return;
			FieldValueRelation objElement = (FieldValueRelation)element;
			if(  objElement.getOperation() != null  )
			{
				FieldLogical dataOneElement = objElement.getOperation();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("operation",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getValue() ))
			{
				String dataOneElement = objElement.getValue();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("value",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getField() ))
			{
				String dataOneElement = objElement.getField();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("field",tmpValue);
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