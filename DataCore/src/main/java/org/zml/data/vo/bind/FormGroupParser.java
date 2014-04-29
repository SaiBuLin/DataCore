package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import java.util.ArrayList;
import org.zml.util.UtilTools;
public class FormGroupParser extends FormParser implements IXmlVisitorParserable
{
	public FormGroupParser()
	{
	}
	public FormGroupParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof FormGroup ))  return result;
		FormGroup objElement = (FormGroup)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(objElement.getForm()== null )
		{
			objElement.setForm( new ArrayList<Form>());
		}
		objElement.getForm().clear();
		objElement.setForm(this.getObjectsFromElement(node,"form","Form"));
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
		result = new FormGroup();
		loadXML((FormGroup)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof FormGroup ))  return;
			FormGroup objElement = (FormGroup)element;
			if(  !UtilTools.isNull(objElement.getForm() ) )
			{
				int mSize =objElement.getForm().size();
				for( int ii = 0;
				ii < mSize;
				ii++ )
				{
					Form dataOneElement = objElement.getForm().get(ii);
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