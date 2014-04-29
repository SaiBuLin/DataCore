package org.zml.data.service.page.request.bind;
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
		this.addBindMap("complexConditionSyntax","conditionSyntax");
		this.addBindMap("requestColumn","requestPart");
		this.addBindMap("requestPart","queryFormNode");
		this.addBindMap("conditionSyntax","queryFormNode");
		this.addBindMap("requestPartGroup","requestPart");
		this.addBindMap("requestFieldGroup","requestField");
		this.addBindMap("orderByColumn","requestPart");
		this.addBindMap("feildConditionSyntax","conditionSyntax");
		this.addBindMap("simpleField","requestField");
		this.addBindMap("queryRequest","queryFormNode");
		this.addBindMap("requestField","queryFormNode");
		this.addBindMap("conditionColumn","requestPart");
		this.addBindMap("orderByField","requestField");
		this.addBindMap("conditionField","requestField");
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
		if(tmpName.equals("simpleField"))
		{
			result = new SimpleFieldParser(this);
		}
		else if(tmpName.equals("requestPartGroup"))
		{
			result = new RequestPartGroupParser(this);
		}
		else if(tmpName.equals("requestFieldGroup"))
		{
			result = new RequestFieldGroupParser(this);
		}
		else if(tmpName.equals("conditionColumn"))
		{
			result = new ConditionColumnParser(this);
		}
		else if(tmpName.equals("feildConditionSyntax"))
		{
			result = new FeildConditionSyntaxParser(this);
		}
		else if(tmpName.equals("orderByColumn"))
		{
			result = new OrderByColumnParser(this);
		}
		else if(tmpName.equals("conditionField"))
		{
			result = new ConditionFieldParser(this);
		}
		else if(tmpName.equals("conditionSyntax"))
		{
			result = new ConditionSyntaxParser(this);
		}
		else if(tmpName.equals("requestColumn"))
		{
			result = new RequestColumnParser(this);
		}
		else if(tmpName.equals("requestPart"))
		{
			result = new RequestPartParser(this);
		}
		else if(tmpName.equals("complexConditionSyntax"))
		{
			result = new ComplexConditionSyntaxParser(this);
		}
		else if(tmpName.equals("requestField"))
		{
			result = new RequestFieldParser(this);
		}
		else if(tmpName.equals("queryRequest"))
		{
			result = new QueryRequestParser(this);
		}
		else if(tmpName.equals("orderByField"))
		{
			result = new OrderByFieldParser(this);
		}
		else if(tmpName.equals("queryFormNode"))
		{
			result = new QueryFormNodeParser(this);
		}
		return result;
	}
	public IXmlVisitorParserable createXMLVisitorParserByCTXMLElement( CTXMLElement ob )
	{
		IXmlVisitorParserable result = null;
		if( ob == null ) return result;
		if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.ConditionSyntax"))
		{
			result = new ConditionSyntaxParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.SimpleField"))
		{
			result = new SimpleFieldParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.RequestColumn"))
		{
			result = new RequestColumnParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.RequestField"))
		{
			result = new RequestFieldParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.ComplexConditionSyntax"))
		{
			result = new ComplexConditionSyntaxParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.ConditionField"))
		{
			result = new ConditionFieldParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.QueryRequest"))
		{
			result = new QueryRequestParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.OrderByField"))
		{
			result = new OrderByFieldParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.OrderByColumn"))
		{
			result = new OrderByColumnParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.RequestPart"))
		{
			result = new RequestPartParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.QueryFormNode"))
		{
			result = new QueryFormNodeParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.FeildConditionSyntax"))
		{
			result = new FeildConditionSyntaxParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.RequestFieldGroup"))
		{
			result = new RequestFieldGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.RequestPartGroup"))
		{
			result = new RequestPartGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.ConditionColumn"))
		{
			result = new ConditionColumnParser(this);
		}
		return result;
	}
	public IXmlVisitorParserable createXMLVisitorParserByElmentTypeName( String typeName )
	{
		IXmlVisitorParserable result = null;
		if( UtilTools.isNull(typeName) ) return result;
		String tmpTypeName = UtilTools.getTrim( typeName );
		if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.QueryFormNode"))
		{
			result = new QueryFormNodeParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.QueryRequest"))
		{
			result = new QueryRequestParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.RequestPart"))
		{
			result = new RequestPartParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.RequestPartGroup"))
		{
			result = new RequestPartGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.RequestColumn"))
		{
			result = new RequestColumnParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.ConditionColumn"))
		{
			result = new ConditionColumnParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.ConditionSyntax"))
		{
			result = new ConditionSyntaxParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.ComplexConditionSyntax"))
		{
			result = new ComplexConditionSyntaxParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.FeildConditionSyntax"))
		{
			result = new FeildConditionSyntaxParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.OrderByColumn"))
		{
			result = new OrderByColumnParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.RequestField"))
		{
			result = new RequestFieldParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.RequestFieldGroup"))
		{
			result = new RequestFieldGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.SimpleField"))
		{
			result = new SimpleFieldParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.ConditionField"))
		{
			result = new ConditionFieldParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.OrderByField"))
		{
			result = new OrderByFieldParser(this);
		}
		return result;
	}
	public String getTypeNameForElement(String confElementName)
	{
		String result = "";
		if( UtilTools.isNull( confElementName ) ) return result;
		String tmpName = UTools.getTrim(confElementName);
		if(tmpName.equals("simpleField"))
		{
			result = "org.zml.data.service.page.request.bind.SimpleField";
		}
		else if(tmpName.equals("requestPartGroup"))
		{
			result = "org.zml.data.service.page.request.bind.RequestPartGroup";
		}
		else if(tmpName.equals("requestFieldGroup"))
		{
			result = "org.zml.data.service.page.request.bind.RequestFieldGroup";
		}
		else if(tmpName.equals("conditionColumn"))
		{
			result = "org.zml.data.service.page.request.bind.ConditionColumn";
		}
		else if(tmpName.equals("feildConditionSyntax"))
		{
			result = "org.zml.data.service.page.request.bind.FeildConditionSyntax";
		}
		else if(tmpName.equals("orderByColumn"))
		{
			result = "org.zml.data.service.page.request.bind.OrderByColumn";
		}
		else if(tmpName.equals("conditionField"))
		{
			result = "org.zml.data.service.page.request.bind.ConditionField";
		}
		else if(tmpName.equals("conditionSyntax"))
		{
			result = "org.zml.data.service.page.request.bind.ConditionSyntax";
		}
		else if(tmpName.equals("requestColumn"))
		{
			result = "org.zml.data.service.page.request.bind.RequestColumn";
		}
		else if(tmpName.equals("requestPart"))
		{
			result = "org.zml.data.service.page.request.bind.RequestPart";
		}
		else if(tmpName.equals("complexConditionSyntax"))
		{
			result = "org.zml.data.service.page.request.bind.ComplexConditionSyntax";
		}
		else if(tmpName.equals("requestField"))
		{
			result = "org.zml.data.service.page.request.bind.RequestField";
		}
		else if(tmpName.equals("queryRequest"))
		{
			result = "org.zml.data.service.page.request.bind.QueryRequest";
		}
		else if(tmpName.equals("orderByField"))
		{
			result = "org.zml.data.service.page.request.bind.OrderByField";
		}
		else if(tmpName.equals("queryFormNode"))
		{
			result = "org.zml.data.service.page.request.bind.QueryFormNode";
		}
		return result;
	}
	public String getElementForType(String typeName)
	{
		String result = "";
		if( UtilTools.isNull( typeName ) ) return result;
		String tmpName = UTools.getTrim(typeName);
		if(tmpName.equals("org.zml.data.service.page.request.bind.SimpleField"))
		{
			result = "simpleField";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.RequestPartGroup"))
		{
			result = "requestPartGroup";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.RequestFieldGroup"))
		{
			result = "requestFieldGroup";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.ConditionColumn"))
		{
			result = "conditionColumn";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.FeildConditionSyntax"))
		{
			result = "feildConditionSyntax";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.OrderByColumn"))
		{
			result = "orderByColumn";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.ConditionField"))
		{
			result = "conditionField";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.ConditionSyntax"))
		{
			result = "conditionSyntax";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.RequestColumn"))
		{
			result = "requestColumn";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.RequestPart"))
		{
			result = "requestPart";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.ComplexConditionSyntax"))
		{
			result = "complexConditionSyntax";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.RequestField"))
		{
			result = "requestField";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.QueryRequest"))
		{
			result = "queryRequest";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.OrderByField"))
		{
			result = "orderByField";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.QueryFormNode"))
		{
			result = "queryFormNode";
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