package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class BoundaryCheckerParser extends ValidatorParser implements IXmlVisitorParserable
{
	public BoundaryCheckerParser()
	{
	}
	public BoundaryCheckerParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof BoundaryChecker ))  return result;
		BoundaryChecker objElement = (BoundaryChecker)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("defaultValue")!= null )
		{
			objElement.setDefaultValue(node.attribute("defaultValue").getText());
		}
		if(node.attribute("boundary")!= null )
		{
			objElement.setBoundary((FieldLogical)this.getObjectFromAttribute(node,"boundary",FieldLogical.class.getName()));
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
		result = new BoundaryChecker();
		loadXML((BoundaryChecker)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof BoundaryChecker ))  return;
			BoundaryChecker objElement = (BoundaryChecker)element;
			if( !UtilTools.isNull( objElement.getDefaultValue() ))
			{
				String dataOneElement = objElement.getDefaultValue();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("defaultValue",tmpValue);
			}
			if(  objElement.getBoundary() != null  )
			{
				FieldLogical dataOneElement = objElement.getBoundary();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("boundary",tmpValue);
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