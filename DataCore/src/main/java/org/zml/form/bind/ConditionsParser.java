package org.zml.form.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import java.util.ArrayList;
import org.zml.tools.xml.parser.Convert;
import org.zml.util.UtilTools;
public class ConditionsParser extends ConditionParser implements IXmlVisitorParserable
{
	public ConditionsParser()
	{
	}
	public ConditionsParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof Conditions ))  return result;
		Conditions objElement = (Conditions)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("operation")!= null )
		{
			objElement.setOperation((OperationLogical)this.getObjectFromAttribute(node,"operation",OperationLogical.class.getName()));
		}
		if(objElement.getCondition()== null )
		{
			objElement.setCondition( new ArrayList<Condition>());
		}
		objElement.getCondition().clear();
		objElement.setCondition(this.getObjectsFromElement(node,"condition","Condition"));
		if(node.attribute("bracket")!= null )
		{
			objElement.setBracket(Convert.toBoolean(node.attribute("bracket").getText()));
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
		result = new Conditions();
		loadXML((Conditions)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof Conditions ))  return;
			Conditions objElement = (Conditions)element;
			if(  objElement.getOperation() != null  )
			{
				OperationLogical dataOneElement = objElement.getOperation();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("operation",tmpValue);
			}
			if(  !UtilTools.isNull(objElement.getCondition() ) )
			{
				int mSize =objElement.getCondition().size();
				for( int ii = 0;
				ii < mSize;
				ii++ )
				{
					Condition dataOneElement = objElement.getCondition().get(ii);
					String xmlElementNameEx = "";
					if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
					{
						xmlElementNameEx = this.getRealElementName("condition",dataOneElement.getClass().getName());
					}
					else
					{
						xmlElementNameEx = dataOneElement.getXmlElementName();
					}
					Element OchildElement = fatherElement.addElement(UtilTools.getTrim( xmlElementNameEx));
					encodeObjectToXMLForElement(OchildElement ,dataOneElement);
				}
			}
			if( !UtilTools.isNull( objElement.getBracket() ))
			{
				Boolean dataOneElement = objElement.getBracket();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("bracket",tmpValue);
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