package org.zml.data.vo.command.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import java.util.ArrayList;
import org.zml.util.UtilTools;
public class RequestTaskGroupParser extends RequestTaskParser implements IXmlVisitorParserable
{
	public RequestTaskGroupParser()
	{
	}
	public RequestTaskGroupParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof RequestTaskGroup ))  return result;
		RequestTaskGroup objElement = (RequestTaskGroup)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(objElement.getRequestTask()== null )
		{
			objElement.setRequestTask( new ArrayList<RequestTask>());
		}
		objElement.getRequestTask().clear();
		objElement.setRequestTask(this.getObjectsFromElement(node,"requestTask","RequestTask"));
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
		result = new RequestTaskGroup();
		loadXML((RequestTaskGroup)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof RequestTaskGroup ))  return;
			RequestTaskGroup objElement = (RequestTaskGroup)element;
			if(  !UtilTools.isNull(objElement.getRequestTask() ) )
			{
				int mSize =objElement.getRequestTask().size();
				for( int ii = 0;
				ii < mSize;
				ii++ )
				{
					RequestTask dataOneElement = objElement.getRequestTask().get(ii);
					String xmlElementNameEx = "";
					if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
					{
						xmlElementNameEx = this.getRealElementName("requestTask",dataOneElement.getClass().getName());
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