package org.zml.data.dataset.bind;
import org.zml.tools.xml.parser.*;
import org.dom4j.Element;
import org.zml.util.UtilTools;
import org.dom4j.io.SAXReader;
import org.dom4j.Document;
import java.io.StringReader;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import java.io.FileWriter;
import java.io.StringWriter;
public class MyFactory extends XMLVisitorFactory
{
	public MyFactory()
	{
		loadBind();
	}
	public void loadBind()
	{
		this.addBindMap("dataValue","myValue");
		this.addBindMap("columnField","dataField");
		this.addBindMap("dataValueGroup","myValue");
		this.addBindMap("netDataSet","datasetNode");
		this.addBindMap("dataTable","table");
		this.addBindMap("dataException","datasetNode");
		this.addBindMap("table","datasetNode");
		this.addBindMap("extendException","dataException");
		this.addBindMap("tableGroup","table");
		this.addBindMap("dataExceptionGroup","dataException");
		this.addBindMap("myValue","datasetNode");
		this.addBindMap("dataFieldGroup","dataField");
		this.addBindMap("dataField","datasetNode");
	}
	public IXmlVisitorParserable createXMLVisitorParser(Element node)
	{
		IXmlVisitorParserable result = null;
		if(node == null ) return result;
		String tmpName = UTools.getTrim(node.getName());
		tmpName = UTools.getTrim( tmpName );
		result = createXMLVisitorParserByName( tmpName );
		return result;
	}
	public IXmlVisitorParserable createXMLVisitorParserByName( String name )
	{
		IXmlVisitorParserable result = null;
		if( UtilTools.isNull( name ) ) return result;
		String tmpName = UTools.getTrim(name);
		if(tmpName.equals("extendException"))
		{
			result = new ExtendExceptionParser(this);
		}
		else if(tmpName.equals("myValue"))
		{
			result = new MyValueParser(this);
		}
		else if(tmpName.equals("netDataSet"))
		{
			result = new NetDataSetParser(this);
		}
		else if(tmpName.equals("dataExceptionGroup"))
		{
			result = new DataExceptionGroupParser(this);
		}
		else if(tmpName.equals("dataFieldGroup"))
		{
			result = new DataFieldGroupParser(this);
		}
		else if(tmpName.equals("table"))
		{
			result = new TableParser(this);
		}
		else if(tmpName.equals("dataException"))
		{
			result = new DataExceptionParser(this);
		}
		else if(tmpName.equals("dataValueGroup"))
		{
			result = new DataValueGroupParser(this);
		}
		else if(tmpName.equals("tableGroup"))
		{
			result = new TableGroupParser(this);
		}
		else if(tmpName.equals("dataField"))
		{
			result = new DataFieldParser(this);
		}
		else if(tmpName.equals("columnField"))
		{
			result = new ColumnFieldParser(this);
		}
		else if(tmpName.equals("dataTable"))
		{
			result = new DataTableParser(this);
		}
		else if(tmpName.equals("dataValue"))
		{
			result = new DataValueParser(this);
		}
		else if(tmpName.equals("datasetNode"))
		{
			result = new DatasetNodeParser(this);
		}
		return result;
	}
	public IXmlVisitorParserable createXMLVisitorParserByCTXMLElement( CTXMLElement ob )
	{
		IXmlVisitorParserable result = null;
		if( ob == null ) return result;
		if( ob.getClass().getName().equals( "org.zml.data.dataset.bind.DatasetNode"))
		{
			result = new DatasetNodeParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.dataset.bind.DataFieldGroup"))
		{
			result = new DataFieldGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.dataset.bind.DataTable"))
		{
			result = new DataTableParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.dataset.bind.ExtendException"))
		{
			result = new ExtendExceptionParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.dataset.bind.DataValueGroup"))
		{
			result = new DataValueGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.dataset.bind.TableGroup"))
		{
			result = new TableGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.dataset.bind.DataExceptionGroup"))
		{
			result = new DataExceptionGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.dataset.bind.Table"))
		{
			result = new TableParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.dataset.bind.NetDataSet"))
		{
			result = new NetDataSetParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.dataset.bind.ColumnField"))
		{
			result = new ColumnFieldParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.dataset.bind.DataField"))
		{
			result = new DataFieldParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.dataset.bind.DataException"))
		{
			result = new DataExceptionParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.dataset.bind.DataValue"))
		{
			result = new DataValueParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.dataset.bind.MyValue"))
		{
			result = new MyValueParser(this);
		}
		return result;
	}
	public IXmlVisitorParserable createXMLVisitorParserByElmentTypeName( String typeName )
	{
		IXmlVisitorParserable result = null;
		if( UtilTools.isNull(typeName) ) return result;
		String tmpTypeName = UtilTools.getTrim( typeName );
		if( tmpTypeName.equals( "org.zml.data.dataset.bind.DatasetNode"))
		{
			result = new DatasetNodeParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.dataset.bind.NetDataSet"))
		{
			result = new NetDataSetParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.dataset.bind.Table"))
		{
			result = new TableParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.dataset.bind.TableGroup"))
		{
			result = new TableGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.dataset.bind.DataTable"))
		{
			result = new DataTableParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.dataset.bind.DataField"))
		{
			result = new DataFieldParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.dataset.bind.DataFieldGroup"))
		{
			result = new DataFieldGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.dataset.bind.ColumnField"))
		{
			result = new ColumnFieldParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.dataset.bind.MyValue"))
		{
			result = new MyValueParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.dataset.bind.DataValueGroup"))
		{
			result = new DataValueGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.dataset.bind.DataValue"))
		{
			result = new DataValueParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.dataset.bind.DataException"))
		{
			result = new DataExceptionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.dataset.bind.DataExceptionGroup"))
		{
			result = new DataExceptionGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.dataset.bind.ExtendException"))
		{
			result = new ExtendExceptionParser(this);
		}
		return result;
	}
	public String getTypeNameForElement(String confElementName)
	{
		String result = "";
		if( UtilTools.isNull( confElementName ) ) return result;
		String tmpName = UTools.getTrim(confElementName);
		if(tmpName.equals("extendException"))
		{
			result = "org.zml.data.dataset.bind.ExtendException";
		}
		else if(tmpName.equals("myValue"))
		{
			result = "org.zml.data.dataset.bind.MyValue";
		}
		else if(tmpName.equals("netDataSet"))
		{
			result = "org.zml.data.dataset.bind.NetDataSet";
		}
		else if(tmpName.equals("dataExceptionGroup"))
		{
			result = "org.zml.data.dataset.bind.DataExceptionGroup";
		}
		else if(tmpName.equals("dataFieldGroup"))
		{
			result = "org.zml.data.dataset.bind.DataFieldGroup";
		}
		else if(tmpName.equals("table"))
		{
			result = "org.zml.data.dataset.bind.Table";
		}
		else if(tmpName.equals("dataException"))
		{
			result = "org.zml.data.dataset.bind.DataException";
		}
		else if(tmpName.equals("dataValueGroup"))
		{
			result = "org.zml.data.dataset.bind.DataValueGroup";
		}
		else if(tmpName.equals("tableGroup"))
		{
			result = "org.zml.data.dataset.bind.TableGroup";
		}
		else if(tmpName.equals("dataField"))
		{
			result = "org.zml.data.dataset.bind.DataField";
		}
		else if(tmpName.equals("columnField"))
		{
			result = "org.zml.data.dataset.bind.ColumnField";
		}
		else if(tmpName.equals("dataTable"))
		{
			result = "org.zml.data.dataset.bind.DataTable";
		}
		else if(tmpName.equals("dataValue"))
		{
			result = "org.zml.data.dataset.bind.DataValue";
		}
		else if(tmpName.equals("datasetNode"))
		{
			result = "org.zml.data.dataset.bind.DatasetNode";
		}
		return result;
	}
	public String getElementForType(String typeName)
	{
		String result = "";
		if( UtilTools.isNull( typeName ) ) return result;
		String tmpName = UTools.getTrim(typeName);
		if(tmpName.equals("org.zml.data.dataset.bind.ExtendException"))
		{
			result = "extendException";
		}
		else if(tmpName.equals("org.zml.data.dataset.bind.MyValue"))
		{
			result = "myValue";
		}
		else if(tmpName.equals("org.zml.data.dataset.bind.NetDataSet"))
		{
			result = "netDataSet";
		}
		else if(tmpName.equals("org.zml.data.dataset.bind.DataExceptionGroup"))
		{
			result = "dataExceptionGroup";
		}
		else if(tmpName.equals("org.zml.data.dataset.bind.DataFieldGroup"))
		{
			result = "dataFieldGroup";
		}
		else if(tmpName.equals("org.zml.data.dataset.bind.Table"))
		{
			result = "table";
		}
		else if(tmpName.equals("org.zml.data.dataset.bind.DataException"))
		{
			result = "dataException";
		}
		else if(tmpName.equals("org.zml.data.dataset.bind.DataValueGroup"))
		{
			result = "dataValueGroup";
		}
		else if(tmpName.equals("org.zml.data.dataset.bind.TableGroup"))
		{
			result = "tableGroup";
		}
		else if(tmpName.equals("org.zml.data.dataset.bind.DataField"))
		{
			result = "dataField";
		}
		else if(tmpName.equals("org.zml.data.dataset.bind.ColumnField"))
		{
			result = "columnField";
		}
		else if(tmpName.equals("org.zml.data.dataset.bind.DataTable"))
		{
			result = "dataTable";
		}
		else if(tmpName.equals("org.zml.data.dataset.bind.DataValue"))
		{
			result = "dataValue";
		}
		else if(tmpName.equals("org.zml.data.dataset.bind.DatasetNode"))
		{
			result = "datasetNode";
		}
		return result;
	}
	public CTXMLElement readAndLoadXML(String xmlFile) throws Exception
	{
		CTXMLElement result = null;
		if ( UtilTools.isNull(xmlFile))return result;
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new java.io.File( xmlFile ));
		/* if DOC is null then xml open failure.*/
		if( doc == null )
		{
			throw new Exception("File:"     + xmlFile + "cannot be open. ");
		}
		/* using MyFactory tend to read XML file's configuration. */
		IXmlVisitorParserable able = createXMLVisitorParser(doc.getRootElement());
		Object reobject = able.parserNode( doc.getRootElement() );
		if( reobject instanceof CTXMLElement )return (CTXMLElement)reobject;
		return result;
	}
	public CTXMLElement readStrBufferAndLoadXML(String xmlFileContent) throws Exception
	{
		CTXMLElement result = null;
		try
		{
			if ( UtilTools.isNull(xmlFileContent))return result;
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new StringReader( xmlFileContent ));
			/* if DOC is null then xml open failure.*/
			if( doc == null )
			{
				throw new Exception("FileContent is illegal xml content.");
			}
			/* using MyFactory tend to read XML file's configuration.*/
			IXmlVisitorParserable able = createXMLVisitorParser(doc.getRootElement());
			Object reobject = able.parserNode( doc.getRootElement() );
			if( reobject instanceof CTXMLElement )return (CTXMLElement)reobject;
			return result;
		}
		catch(Exception e)
		{
			System.out.println( e.getMessage() );
			throw e;
		}
	}
	public void saveXMLToFile(String xmlFile, CTXMLElement xmlElement) throws Exception
	{
		if ( UtilTools.isNull(xmlFile))return;
		Document doc = DocumentHelper.createDocument();
		String rootXMLName = "";
		if ( !UtilTools.isNull(xmlElement.getXmlElementName() ) )
		{
			rootXMLName =  UTools.getTrim(xmlElement.getXmlElementName());
		}
		else
		{
			rootXMLName =  UTools.getTrim(getElementForType( xmlElement.getClass().getName() ));
		}
		if ( UtilTools.isNull( rootXMLName ) )
		{
			return;
		}
		Element rootElement = doc.addElement(rootXMLName);
		/*using MyFactory tend to read XML file's configuration.*/
		IXmlVisitorParserable able = createXMLVisitorParserByCTXMLElement(xmlElement);
		able.encodeObjectToElement( rootElement, xmlElement);
		OutputFormat opf = OutputFormat.createPrettyPrint();
		opf.setEncoding("GBK");
		opf.setTrimText(true);
		XMLWriter writer = new XMLWriter(new FileWriter(xmlFile), opf);
		if( writer == null )
		{
			throw new Exception("File:"     + xmlFile + "cannot be open. ");
		}
		//write document.
		writer.write(doc);
		// close writer
		writer.flush();
		writer.close();
	}
	public String saveXMLToString( CTXMLElement xmlElement) throws Exception
	{
		String result = "";
		if(xmlElement == null ) return result;;
		Document doc = DocumentHelper.createDocument();
		String rootXMLName = "";
		if ( !UtilTools.isNull(xmlElement.getXmlElementName() ) )
		{
			rootXMLName =  UTools.getTrim(xmlElement.getXmlElementName());
		}
		else
		{
			rootXMLName =  UTools.getTrim(this.getElementForType( xmlElement.getClass().getName() ));
		}
		if ( UtilTools.isNull( rootXMLName ) )
		{
			return result;
		}
		Element rootElement = doc.addElement(rootXMLName);
		/* using MyFactory tend to read XML file's configuration. */
		IXmlVisitorParserable able = createXMLVisitorParserByCTXMLElement(xmlElement);
		able.encodeObjectToElement( rootElement, xmlElement);
		OutputFormat opf = OutputFormat.createPrettyPrint();
		opf.setEncoding("GBK");
		opf.setTrimText(true);
		StringWriter writerStr = new StringWriter();
		XMLWriter writer = new XMLWriter(writerStr, opf );
		if( writer == null )
		{
			throw new Exception("StringWrite is illeagal:");
		}
		// Write Document.
		writer.write(doc);
		writer.flush();
		// close writer
		writer.close();
		result = writerStr.getBuffer().toString();
		return result;
	}
}