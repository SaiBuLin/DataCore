package org.zml.data.vo.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class LeRiFormsConnectionParser extends FormRelationParser implements IXmlVisitorParserable
{
	public LeRiFormsConnectionParser()
	{
	}
	public LeRiFormsConnectionParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof LeRiFormsConnection ))  return result;
		LeRiFormsConnection objElement = (LeRiFormsConnection)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("leftform")!= null )
		{
			objElement.setLeftform(node.attribute("leftform").getText());
		}
		objElement.setRelation((Relation)this.getObjectFromElement(node,"relation","Relation"));
		if(node.attribute("tableRelation")!= null )
		{
			objElement.setTableRelation((TableRelation)this.getObjectFromAttribute(node,"tableRelation",TableRelation.class.getName()));
		}
		if(node.attribute("rightform")!= null )
		{
			objElement.setRightform(node.attribute("rightform").getText());
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
		result = new LeRiFormsConnection();
		loadXML((LeRiFormsConnection)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof LeRiFormsConnection ))  return;
			LeRiFormsConnection objElement = (LeRiFormsConnection)element;
			if( !UtilTools.isNull( objElement.getLeftform() ))
			{
				String dataOneElement = objElement.getLeftform();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("leftform",tmpValue);
			}
			if(  objElement.getRelation()  != null )
			{
				Relation dataOneElement = objElement.getRelation();
				String xmlElementNameEx = "";
				if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
				{
					xmlElementNameEx = this.getRealElementName("relation",dataOneElement.getClass().getName());
				}
				else
				{
					xmlElementNameEx = dataOneElement.getXmlElementName();
				}
				Element OchildElement = fatherElement.addElement(UtilTools.getTrim( xmlElementNameEx));
				encodeObjectToXMLForElement(OchildElement ,dataOneElement);
			}
			if(  objElement.getTableRelation() != null  )
			{
				TableRelation dataOneElement = objElement.getTableRelation();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("tableRelation",tmpValue);
			}
			if( !UtilTools.isNull( objElement.getRightform() ))
			{
				String dataOneElement = objElement.getRightform();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("rightform",tmpValue);
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