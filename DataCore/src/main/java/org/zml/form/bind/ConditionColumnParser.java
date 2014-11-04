package org.zml.form.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.util.UtilTools;
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
		objElement.setContent((String)this.getObjectFromElement(node,"content","String"));
		if(node.attribute("operation")!= null )
		{
			objElement.setOperation((FieldLogical)this.getObjectFromAttribute(node,"operation",FieldLogical.class.getName()));
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
			if( !UtilTools.isNull( objElement.getContent() ) )
			{
				String dataOneElement = objElement.getContent();
				Element subElement =  fatherElement.addElement("content");
				String tmpValue = String.valueOf(dataOneElement);
				subElement.setText(tmpValue);
			}
			if(  objElement.getOperation() != null  )
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