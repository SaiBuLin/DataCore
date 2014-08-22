package org.zml.data.dataset.bind;
import org.zml.tools.xml.parser.IXmlVisitorParserable;
import org.zml.tools.xml.parser.XMLVisitorFactory;
import org.dom4j.Element;
import org.zml.tools.xml.parser.CTXMLElement;
import java.util.ArrayList;
import org.zml.util.UtilTools;
public class TableGroupParser extends TableParser implements IXmlVisitorParserable
{
	public TableGroupParser()
	{
	}
	public TableGroupParser(XMLVisitorFactory thisFactory)
	{
		setFactory(thisFactory);
	}
	public boolean loadXML(CTXMLElement element, Element node)
	{
		boolean result = false;
		if( element == null) return result;
		if( node == null) return result;
		if( !(element instanceof TableGroup ))  return result;
		TableGroup objElement = (TableGroup)element;
		super.loadXML(element,node);
		objElement.setXmlElementName(node.getName());
		if(objElement.getDataTable()== null )
		{
			objElement.setDataTable( new ArrayList<DataTable>());
		}
		objElement.getDataTable().clear();
		objElement.setDataTable(this.getObjectsFromElement(node,"dataTable","DataTable"));
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
		result = new TableGroup();
		loadXML((TableGroup)result, node);
		return result;
	}
	public void encodeObjectToElement( Element fatherElement, CTXMLElement element )
	{
		try
		{
			if ( fatherElement == null ) return;
			if ( element == null ) return;
			super.encodeObjectToElement(fatherElement, element);
			if( !(element instanceof TableGroup ))  return;
			TableGroup objElement = (TableGroup)element;
			if(  !UtilTools.isNull(objElement.getDataTable() ) )
			{
				int mSize =objElement.getDataTable().size();
				for( int ii = 0;
				ii < mSize;
				ii++ )
				{
					DataTable dataOneElement = objElement.getDataTable().get(ii);
					String xmlElementNameEx = "";
					if(UtilTools.isNull( dataOneElement.getXmlElementName() ))
					{
						xmlElementNameEx = this.getRealElementName("dataTable",dataOneElement.getClass().getName());
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