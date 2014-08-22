package org.zml.form.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.util.UtilTools;
public class PythonColumnParser extends ColumnParser implements IXmlVisitorParserable
{
	public PythonColumnParser()
	{
	}
	public PythonColumnParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof PythonColumn ))  return result;
		PythonColumn objElement = (PythonColumn)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		objElement.setContent((String)this.getObjectFromElement(node,"content","String"));
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
		result = new PythonColumn();
		loadXML((PythonColumn)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof PythonColumn ))  return;
			PythonColumn objElement = (PythonColumn)element;
			if( !UtilTools.isNull( objElement.getContent() ) )
			{
				String dataOneElement = objElement.getContent();
				Element subElement =  fatherElement.addElement("content");
				String tmpValue = String.valueOf(dataOneElement);
				subElement.setText(tmpValue);
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