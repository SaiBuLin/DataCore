package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import java.util.ArrayList;
import org.zml.util.UtilTools;
public class ValidatorGroupParser extends ValidatorParser implements IXmlVisitorParserable
{
	public ValidatorGroupParser()
	{
	}
	public ValidatorGroupParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof ValidatorGroup ))  return result;
		ValidatorGroup objElement = (ValidatorGroup)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(objElement.getValidator()== null )
		{
			objElement.setValidator( new ArrayList<Validator>());
		}
		objElement.getValidator().clear();
		objElement.setValidator(this.getObjectsFromElement(node,"validator","Validator"));
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
		result = new ValidatorGroup();
		loadXML((ValidatorGroup)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof ValidatorGroup ))  return;
			ValidatorGroup objElement = (ValidatorGroup)element;
			if(  !UtilTools.isNull(objElement.getValidator() ) )
			{
				int mSize =objElement.getValidator().size();
				for( int ii = 0;
				ii < mSize;
				ii++ )
				{
					Validator dataOneElement = objElement.getValidator().get(ii);
					String xmlElementNameEx = "";
					if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
					{
						xmlElementNameEx = this.getRealElementName("validator",dataOneElement.getClass().getName());
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