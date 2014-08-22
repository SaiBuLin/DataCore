package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.*;
import org.zml.tools.xml.parser.CTXMLElement;
public class JSONParserFactory
{
	public static JSONParserAble getQueryDefineInterpreter(CTXMLElement element) throws Exception
	{
		JSONParserAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		result = getQueryDefineInterpreterIndicateClsName( element );
		if ( result == null )
		{
			result =getQueryDefineInterpreterForNoEquals(element);
		}
		return result;
	}
	private static JSONParserAble getQueryDefineInterpreterForNoEquals(CTXMLElement element) throws Exception
	{
		JSONParserAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		if( element instanceof DatasetNode  )
		{
			result = new DatasetNodeJSONParser((DatasetNode)element);
		}
		else if( element instanceof DataFieldGroup  )
		{
			result = new DataFieldGroupJSONParser((DataFieldGroup)element);
		}
		else if( element instanceof DataTable  )
		{
			result = new DataTableJSONParser((DataTable)element);
		}
		else if( element instanceof ExtendException  )
		{
			result = new ExtendExceptionJSONParser((ExtendException)element);
		}
		else if( element instanceof DataValueGroup  )
		{
			result = new DataValueGroupJSONParser((DataValueGroup)element);
		}
		else if( element instanceof TableGroup  )
		{
			result = new TableGroupJSONParser((TableGroup)element);
		}
		else if( element instanceof DataExceptionGroup  )
		{
			result = new DataExceptionGroupJSONParser((DataExceptionGroup)element);
		}
		else if( element instanceof Table  )
		{
			result = new TableJSONParser((Table)element);
		}
		else if( element instanceof NetDataSet  )
		{
			result = new NetDataSetJSONParser((NetDataSet)element);
		}
		else if( element instanceof ColumnField  )
		{
			result = new ColumnFieldJSONParser((ColumnField)element);
		}
		else if( element instanceof DataField  )
		{
			result = new DataFieldJSONParser((DataField)element);
		}
		else if( element instanceof DataException  )
		{
			result = new DataExceptionJSONParser((DataException)element);
		}
		else if( element instanceof DataValue  )
		{
			result = new DataValueJSONParser((DataValue)element);
		}
		else if( element instanceof MyValue  )
		{
			result = new MyValueJSONParser((MyValue)element);
		}
		return result;
	}
	private static JSONParserAble getQueryDefineInterpreterIndicateClsName(CTXMLElement element) throws Exception
	{
		JSONParserAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		String tmpElementClassName = element.getClass().getName();
		if( tmpElementClassName.equals(  DatasetNode.class.getName())  )
		{
			result = new DatasetNodeJSONParser((DatasetNode)element);
		}
		else if( tmpElementClassName.equals(  DataFieldGroup.class.getName())  )
		{
			result = new DataFieldGroupJSONParser((DataFieldGroup)element);
		}
		else if( tmpElementClassName.equals(  DataTable.class.getName())  )
		{
			result = new DataTableJSONParser((DataTable)element);
		}
		else if( tmpElementClassName.equals(  ExtendException.class.getName())  )
		{
			result = new ExtendExceptionJSONParser((ExtendException)element);
		}
		else if( tmpElementClassName.equals(  DataValueGroup.class.getName())  )
		{
			result = new DataValueGroupJSONParser((DataValueGroup)element);
		}
		else if( tmpElementClassName.equals(  TableGroup.class.getName())  )
		{
			result = new TableGroupJSONParser((TableGroup)element);
		}
		else if( tmpElementClassName.equals(  DataExceptionGroup.class.getName())  )
		{
			result = new DataExceptionGroupJSONParser((DataExceptionGroup)element);
		}
		else if( tmpElementClassName.equals(  Table.class.getName())  )
		{
			result = new TableJSONParser((Table)element);
		}
		else if( tmpElementClassName.equals(  NetDataSet.class.getName())  )
		{
			result = new NetDataSetJSONParser((NetDataSet)element);
		}
		else if( tmpElementClassName.equals(  ColumnField.class.getName())  )
		{
			result = new ColumnFieldJSONParser((ColumnField)element);
		}
		else if( tmpElementClassName.equals(  DataField.class.getName())  )
		{
			result = new DataFieldJSONParser((DataField)element);
		}
		else if( tmpElementClassName.equals(  DataException.class.getName())  )
		{
			result = new DataExceptionJSONParser((DataException)element);
		}
		else if( tmpElementClassName.equals(  DataValue.class.getName())  )
		{
			result = new DataValueJSONParser((DataValue)element);
		}
		else if( tmpElementClassName.equals(  MyValue.class.getName())  )
		{
			result = new MyValueJSONParser((MyValue)element);
		}
		return result;
	}
}