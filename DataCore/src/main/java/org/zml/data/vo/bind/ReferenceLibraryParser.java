package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class ReferenceLibraryParser extends LibraryParser implements IXmlVisitorParserable
{
	public ReferenceLibraryParser()
	{
	}
	public ReferenceLibraryParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof ReferenceLibrary ))  return result;
		ReferenceLibrary objElement = (ReferenceLibrary)element;
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
		if(node.attribute("formCode")!= null )
		{
			objElement.setFormCode(node.attribute("formCode").getText());
		}
		if(node.attribute("voCode")!= null )
		{
			objElement.setVoCode(node.attribute("voCode").getText());
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
		result = new ReferenceLibrary();
		loadXML((ReferenceLibrary)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof ReferenceLibrary ))  return;
			ReferenceLibrary objElement = (ReferenceLibrary)element;
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
			if( !UtilTools.isNull( objElement.getFormCode() ))
			{
				String dataOneElement = objElement.getFormCode();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("formCode",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getVoCode() ))
			{
				String dataOneElement = objElement.getVoCode();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("voCode",tmpValue);
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