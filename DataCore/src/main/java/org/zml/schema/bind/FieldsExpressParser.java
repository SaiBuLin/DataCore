package org.zml.schema.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class FieldsExpressParser extends ExpressParser implements IXmlVisitorParserable
{
	public FieldsExpressParser()
	{
	}
	public FieldsExpressParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof FieldsExpress ))  return result;
		FieldsExpress objElement = (FieldsExpress)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("operationship")!= null )
		{
			objElement.setOperationship((FieldLogical)this.getObjectFromAttribute(node,"operationship",FieldLogical.class.getName()));
		}
		if(node.attribute("rightField")!= null )
		{
			objElement.setRightField(node.attribute("rightField").getText());
		}
		if(node.attribute("leftField")!= null )
		{
			objElement.setLeftField(node.attribute("leftField").getText());
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
		result = new FieldsExpress();
		loadXML((FieldsExpress)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof FieldsExpress ))  return;
			FieldsExpress objElement = (FieldsExpress)element;
			if(  objElement.getOperationship() != null  )
			{
				FieldLogical dataOneElement = objElement.getOperationship();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("operationship",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getRightField() ))
			{
				String dataOneElement = objElement.getRightField();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("rightField",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getLeftField() ))
			{
				String dataOneElement = objElement.getLeftField();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("leftField",tmpValue);
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