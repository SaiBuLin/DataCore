package org.zml.schema.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class FieldValueExpressParser extends ExpressParser implements IXmlVisitorParserable
{
	public FieldValueExpressParser()
	{
	}
	public FieldValueExpressParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof FieldValueExpress ))  return result;
		FieldValueExpress objElement = (FieldValueExpress)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("operationship")!= null )
		{
			objElement.setOperationship((FieldLogical)this.getObjectFromAttribute(node,"operationship",FieldLogical.class.getName()));
		}
		if(node.attribute("value")!= null )
		{
			objElement.setValue(node.attribute("value").getText());
		}
		if(node.attribute("field")!= null )
		{
			objElement.setField(node.attribute("field").getText());
		}
		if(node.attribute("form")!= null )
		{
			objElement.setForm(node.attribute("form").getText());
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
		result = new FieldValueExpress();
		loadXML((FieldValueExpress)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof FieldValueExpress ))  return;
			FieldValueExpress objElement = (FieldValueExpress)element;
			if(  objElement.getOperationship() != null  )
			{
				FieldLogical dataOneElement = objElement.getOperationship();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("operationship",tmpValue);
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
			if( !UtilTools.isNull( objElement.getForm() ))
			{
				String dataOneElement = objElement.getForm();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("form",tmpValue);
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