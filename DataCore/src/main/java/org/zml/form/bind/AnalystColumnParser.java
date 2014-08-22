package org.zml.form.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.util.UtilTools;
public class AnalystColumnParser extends FieldColumnParser implements IXmlVisitorParserable
{
	public AnalystColumnParser()
	{
	}
	public AnalystColumnParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof AnalystColumn ))  return result;
		AnalystColumn objElement = (AnalystColumn)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("function")!= null )
		{
			objElement.setFunction((SQLFunction)this.getObjectFromAttribute(node,"function",SQLFunction.class.getName()));
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
		result = new AnalystColumn();
		loadXML((AnalystColumn)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof AnalystColumn ))  return;
			AnalystColumn objElement = (AnalystColumn)element;
			if(  objElement.getFunction() != null  )
			{
				SQLFunction dataOneElement = objElement.getFunction();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("function",tmpValue);
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