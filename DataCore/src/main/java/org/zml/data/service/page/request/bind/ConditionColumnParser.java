package org.zml.data.service.page.request.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
import org.zml.data.vo.bind.FieldLogical;

public class ConditionColumnParser extends FieldColumnParser implements IXmlVisitorParserable
{
	public ConditionColumnParser()
	{
	}
	public ConditionColumnParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof ConditionColumn ))  return result;
		ConditionColumn objElement = (ConditionColumn)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("defaultvalue")!= null )
		{
			objElement.setDefaultvalue(node.attribute("defaultvalue").getText());
		}
		if(node.attribute("operation")!= null )
		{
			objElement.setOperation(( FieldLogical)this.getObjectFromAttribute(node,"operation", FieldLogical.class.getName()));
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
		result = new ConditionColumn();
		loadXML((ConditionColumn)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof ConditionColumn ))  return;
			ConditionColumn objElement = (ConditionColumn)element;
			if( !UtilTools.isNull( objElement.getDefaultvalue() ))
			{
				String dataOneElement = objElement.getDefaultvalue();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("defaultvalue",tmpValue);
			}
			if(  objElement.getOperation() != null )
			{
				FieldLogical dataOneElement = objElement.getOperation();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("operation",tmpValue);
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