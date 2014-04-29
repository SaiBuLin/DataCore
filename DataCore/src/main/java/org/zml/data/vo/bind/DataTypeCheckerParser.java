package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.util.UtilTools;
public class DataTypeCheckerParser extends ValidatorParser implements IXmlVisitorParserable
{
	public DataTypeCheckerParser()
	{
	}
	public DataTypeCheckerParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof DataTypeChecker ))  return result;
		DataTypeChecker objElement = (DataTypeChecker)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("datatype")!= null )
		{
			objElement.setDatatype((DataType)this.getObjectFromAttribute(node,"datatype",DataType.class.getName()));
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
		result = new DataTypeChecker();
		loadXML((DataTypeChecker)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof DataTypeChecker ))  return;
			DataTypeChecker objElement = (DataTypeChecker)element;
			if(  objElement.getDatatype() != null  )
			{
				DataType dataOneElement = objElement.getDatatype();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("datatype",tmpValue);
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