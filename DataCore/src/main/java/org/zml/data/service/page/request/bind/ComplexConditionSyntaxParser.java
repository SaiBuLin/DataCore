package org.zml.data.service.page.request.bind;
import org.zml.data.vo.bind.OperationLogical;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;

import java.util.ArrayList;

import org.zml.util.UtilTools;


public class ComplexConditionSyntaxParser extends ConditionSyntaxParser implements IXmlVisitorParserable
{
	public ComplexConditionSyntaxParser()
	{
	}
	public ComplexConditionSyntaxParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof ComplexConditionSyntax ))  return result;
		ComplexConditionSyntax objElement = (ComplexConditionSyntax)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(node.attribute("operation")!= null )
		{
			objElement.setOperation((OperationLogical)this.getObjectFromAttribute(node,"operation",OperationLogical.class.getName()));
		}
		if(objElement.getConditionSyntax()== null )
		{
			objElement.setConditionSyntax( new ArrayList<ConditionSyntax>());
		}
		objElement.getConditionSyntax().clear();
		objElement.setConditionSyntax(this.getObjectsFromElement(node,"conditionSyntax","ConditionSyntax"));
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
		result = new ComplexConditionSyntax();
		loadXML((ComplexConditionSyntax)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof ComplexConditionSyntax ))  return;
			ComplexConditionSyntax objElement = (ComplexConditionSyntax)element;
			if(  objElement.getOperation() != null )
			{
				OperationLogical dataOneElement = objElement.getOperation();
				String tmpValue = String.valueOf(dataOneElement);
				fatherElement.addAttribute("operation",tmpValue);
			}
			if(  !UtilTools.isNull(objElement.getConditionSyntax() ) )
			{
				int mSize =objElement.getConditionSyntax().size();
				for( int ii = 0;
				ii < mSize;
				ii++ )
				{
					ConditionSyntax dataOneElement = objElement.getConditionSyntax().get(ii);
					String xmlElementNameEx = "";
					if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
					{
						xmlElementNameEx = this.getRealElementName("conditionSyntax",dataOneElement.getClass().getName());
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