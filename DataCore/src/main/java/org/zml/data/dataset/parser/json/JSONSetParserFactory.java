package org.zml.data.dataset.parser.json;
import org.zml.data.dataset.bind.*;
import org.zml.tools.xml.parser.CTXMLElement;
public class JSONSetParserFactory
{
	public static JSONSetParserAble getQueryDefineInterpreter(CTXMLElement element) throws Exception
	{
		JSONSetParserAble result = null;
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
	private static JSONSetParserAble getQueryDefineInterpreterForNoEquals(CTXMLElement element) throws Exception
	{
		JSONSetParserAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		if( element instanceof DatasetNode  )
		{
			result = new DatasetNodeJSONSetParser((DatasetNode)element);
		}
		else if( element instanceof DataFieldGroup  )
		{
			result = new DataFieldGroupJSONSetParser((DataFieldGroup)element);
		}
		else if( element instanceof DataTable  )
		{
			result = new DataTableJSONSetParser((DataTable)element);
		}
		else if( element instanceof ExtendException  )
		{
			result = new ExtendExceptionJSONSetParser((ExtendException)element);
		}
		else if( element instanceof DataValueGroup  )
		{
			result = new DataValueGroupJSONSetParser((DataValueGroup)element);
		}
		else if( element instanceof TableGroup  )
		{
			result = new TableGroupJSONSetParser((TableGroup)element);
		}
		else if( element instanceof DataExceptionGroup  )
		{
			result = new DataExceptionGroupJSONSetParser((DataExceptionGroup)element);
		}
		else if( element instanceof Table  )
		{
			result = new TableJSONSetParser((Table)element);
		}
		else if( element instanceof NetDataSet  )
		{
			result = new NetDataSetJSONSetParser((NetDataSet)element);
		}
		else if( element instanceof ColumnField  )
		{
			result = new ColumnFieldJSONSetParser((ColumnField)element);
		}
		else if( element instanceof DataField  )
		{
			result = new DataFieldJSONSetParser((DataField)element);
		}
		else if( element instanceof DataException  )
		{
			result = new DataExceptionJSONSetParser((DataException)element);
		}
		else if( element instanceof DataValue  )
		{
			result = new DataValueJSONSetParser((DataValue)element);
		}
		else if( element instanceof MyValue  )
		{
			result = new MyValueJSONSetParser((MyValue)element);
		}
		return result;
	}
	private static JSONSetParserAble getQueryDefineInterpreterIndicateClsName(CTXMLElement element) throws Exception
	{
		JSONSetParserAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		String tmpElementClassName = element.getClass().getName();
		if( tmpElementClassName.equals(  DatasetNode.class.getName())  )
		{
			result = new DatasetNodeJSONSetParser((DatasetNode)element);
		}
		else if( tmpElementClassName.equals(  DataFieldGroup.class.getName())  )
		{
			result = new DataFieldGroupJSONSetParser((DataFieldGroup)element);
		}
		else if( tmpElementClassName.equals(  DataTable.class.getName())  )
		{
			result = new DataTableJSONSetParser((DataTable)element);
		}
		else if( tmpElementClassName.equals(  ExtendException.class.getName())  )
		{
			result = new ExtendExceptionJSONSetParser((ExtendException)element);
		}
		else if( tmpElementClassName.equals(  DataValueGroup.class.getName())  )
		{
			result = new DataValueGroupJSONSetParser((DataValueGroup)element);
		}
		else if( tmpElementClassName.equals(  TableGroup.class.getName())  )
		{
			result = new TableGroupJSONSetParser((TableGroup)element);
		}
		else if( tmpElementClassName.equals(  DataExceptionGroup.class.getName())  )
		{
			result = new DataExceptionGroupJSONSetParser((DataExceptionGroup)element);
		}
		else if( tmpElementClassName.equals(  Table.class.getName())  )
		{
			result = new TableJSONSetParser((Table)element);
		}
		else if( tmpElementClassName.equals(  NetDataSet.class.getName())  )
		{
			result = new NetDataSetJSONSetParser((NetDataSet)element);
		}
		else if( tmpElementClassName.equals(  ColumnField.class.getName())  )
		{
			result = new ColumnFieldJSONSetParser((ColumnField)element);
		}
		else if( tmpElementClassName.equals(  DataField.class.getName())  )
		{
			result = new DataFieldJSONSetParser((DataField)element);
		}
		else if( tmpElementClassName.equals(  DataException.class.getName())  )
		{
			result = new DataExceptionJSONSetParser((DataException)element);
		}
		else if( tmpElementClassName.equals(  DataValue.class.getName())  )
		{
			result = new DataValueJSONSetParser((DataValue)element);
		}
		else if( tmpElementClassName.equals(  MyValue.class.getName())  )
		{
			result = new MyValueJSONSetParser((MyValue)element);
		}
		return result;
	}
}