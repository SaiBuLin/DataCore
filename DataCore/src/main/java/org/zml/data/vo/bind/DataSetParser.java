package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class DataSetParser extends DefineParser implements IXmlVisitorParserable
{
	public DataSetParser()
	{
	}
	public DataSetParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof DataSet ))  return result;
		DataSet objElement = (DataSet)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		objElement.setAttribute((Attribute)this.getObjectFromElement(node,"attribute","Attribute"));
		if(node.attribute("alias")!= null )
		{
			objElement.setAlias(node.attribute("alias").getText());
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
		result = new DataSet();
		loadXML((DataSet)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof DataSet ))  return;
			DataSet objElement = (DataSet)element;
			if(  objElement.getAttribute()  != null )
			{
				Attribute dataOneElement = objElement.getAttribute();
				String xmlElementNameEx = "";
				if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
				{
					xmlElementNameEx = this.getRealElementName("attribute",dataOneElement.getClass().getName());
				}
				else
				{
					xmlElementNameEx = dataOneElement.getXmlElementName();
				}
				Element OchildElement = fatherElement.addElement(UtilTools.getTrim( xmlElementNameEx));
				encodeObjectToXMLForElement(OchildElement ,dataOneElement);
			}
			if( !UtilTools.isNull( objElement.getAlias() ))
			{
				String dataOneElement = objElement.getAlias();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("alias",tmpValue);
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