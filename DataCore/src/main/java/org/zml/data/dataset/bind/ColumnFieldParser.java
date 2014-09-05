package org.zml.data.dataset.bind;
import org.zml.schema.bind.DataType;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class ColumnFieldParser extends DataFieldParser implements IXmlVisitorParserable
{
	public ColumnFieldParser()
	{
	}
	public ColumnFieldParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof ColumnField ))  return result;
		ColumnField objElement = (ColumnField)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("fieldsize")!= null )
		{
			objElement.setFieldsize(Convert.toInt(node.attribute("fieldsize").getText()));
		}
		if(node.attribute("field")!= null )
		{
			objElement.setField(node.attribute("field").getText());
		}
		if(node.attribute("datatype")!= null )
		{
			objElement.setDatatype((DataType)this.getObjectFromAttribute(node,"datatype",DataType.class.getName()));
		}
		if(node.attribute("label")!= null )
		{
			objElement.setLabel(node.attribute("label").getText());
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
		result = new ColumnField();
		loadXML((ColumnField)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof ColumnField ))  return;
			ColumnField objElement = (ColumnField)element;
			if( !UtilTools.isNull( objElement.getFieldsize() ))
			{
				int dataOneElement = objElement.getFieldsize();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("fieldsize",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getField() ))
			{
				String dataOneElement = objElement.getField();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("field",tmpValue);
			}
			if( objElement.getDatatype() != null )
			{
				DataType dataOneElement = objElement.getDatatype();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("datatype",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getLabel() ))
			{
				String dataOneElement = objElement.getLabel();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("label",tmpValue);
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