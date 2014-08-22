package org.zml.schema.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class FormLibraryParser extends LibraryParser implements IXmlVisitorParserable
{
	public FormLibraryParser()
	{
	}
	public FormLibraryParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof FormLibrary ))  return result;
		FormLibrary objElement = (FormLibrary)element;
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
		objElement.setForm((Form)this.getObjectFromElement(node,"form","Form"));
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
		result = new FormLibrary();
		loadXML((FormLibrary)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof FormLibrary ))  return;
			FormLibrary objElement = (FormLibrary)element;
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
			if(  objElement.getForm()  != null )
			{
				Form dataOneElement = objElement.getForm();
				String xmlElementNameEx = "";
				if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
				{
					xmlElementNameEx = this.getRealElementName("form",dataOneElement.getClass().getName());
				}
				else
				{
					xmlElementNameEx = dataOneElement.getXmlElementName();
				}
				Element OchildElement = fatherElement.addElement(UtilTools.getTrim( xmlElementNameEx));
				encodeObjectToXMLForElement(OchildElement ,dataOneElement);
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