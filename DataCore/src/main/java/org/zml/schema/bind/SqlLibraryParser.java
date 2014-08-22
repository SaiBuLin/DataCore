package org.zml.schema.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class SqlLibraryParser extends LibraryParser implements IXmlVisitorParserable
{
	public SqlLibraryParser()
	{
	}
	public SqlLibraryParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof SqlLibrary ))  return result;
		SqlLibrary objElement = (SqlLibrary)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("valuefield")!= null )
		{
			objElement.setValuefield(node.attribute("valuefield").getText());
		}
		if(node.attribute("codefield")!= null )
		{
			objElement.setCodefield(node.attribute("codefield").getText());
		}
		objElement.setSqlcontent((String)this.getObjectFromElement(node,"sqlcontent","String"));
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
		result = new SqlLibrary();
		loadXML((SqlLibrary)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof SqlLibrary ))  return;
			SqlLibrary objElement = (SqlLibrary)element;
			if( !UtilTools.isNull( objElement.getValuefield() ))
			{
				String dataOneElement = objElement.getValuefield();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("valuefield",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getCodefield() ))
			{
				String dataOneElement = objElement.getCodefield();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("codefield",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getSqlcontent() ) )
			{
				String dataOneElement = objElement.getSqlcontent();
				Element subElement =  fatherElement.addElement("sqlcontent");
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