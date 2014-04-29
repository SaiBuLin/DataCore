package org.zml.data.vo.command.bind;
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
		this.addBindMap("requestParameter","commandDefine");
		this.addBindMap("commandConfiguration","commandDefine");
		this.addBindMap("serviceTask","requestTask");
		this.addBindMap("serviceParameter","requestParameter");
		this.addBindMap("requestTask","commandDefine");
		this.addBindMap("requestParameterGroup","requestParameter");
		this.addBindMap("requestTaskGroup","requestTask");
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
		if(tmpName.equals("serviceParameter"))
		{
			result = new ServiceParameterParser(this);
		}
		else if(tmpName.equals("serviceTask"))
		{
			result = new ServiceTaskParser(this);
		}
		else if(tmpName.equals("requestTask"))
		{
			result = new RequestTaskParser(this);
		}
		else if(tmpName.equals("requestTaskGroup"))
		{
			result = new RequestTaskGroupParser(this);
		}
		else if(tmpName.equals("requestParameter"))
		{
			result = new RequestParameterParser(this);
		}
		else if(tmpName.equals("commandDefine"))
		{
			result = new CommandDefineParser(this);
		}
		else if(tmpName.equals("requestParameterGroup"))
		{
			result = new RequestParameterGroupParser(this);
		}
		else if(tmpName.equals("commandConfiguration"))
		{
			result = new CommandConfigurationParser(this);
		}
		return result;
	}
	public IXmlVisitorParserable createXMLVisitorParserByCTXMLElement( CTXMLElement ob )
	{
		IXmlVisitorParserable result = null;
		if( ob == null ) return result;
		if( ob.getClass().getName().equals( "org.zml.data.vo.command.bind.CommandConfiguration"))
		{
			result = new CommandConfigurationParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.command.bind.ServiceParameter"))
		{
			result = new ServiceParameterParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.command.bind.RequestParameter"))
		{
			result = new RequestParameterParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.command.bind.RequestTaskGroup"))
		{
			result = new RequestTaskGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.command.bind.RequestParameterGroup"))
		{
			result = new RequestParameterGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.command.bind.RequestTask"))
		{
			result = new RequestTaskParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.command.bind.CommandDefine"))
		{
			result = new CommandDefineParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.command.bind.ServiceTask"))
		{
			result = new ServiceTaskParser(this);
		}
		return result;
	}
	public IXmlVisitorParserable createXMLVisitorParserByElmentTypeName( String typeName )
	{
		IXmlVisitorParserable result = null;
		if( UtilTools.isNull(typeName) ) return result;
		String tmpTypeName = UtilTools.getTrim( typeName );
		if( tmpTypeName.equals( "org.zml.data.vo.command.bind.CommandDefine"))
		{
			result = new CommandDefineParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.command.bind.CommandConfiguration"))
		{
			result = new CommandConfigurationParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.command.bind.RequestTask"))
		{
			result = new RequestTaskParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.command.bind.RequestTaskGroup"))
		{
			result = new RequestTaskGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.command.bind.ServiceTask"))
		{
			result = new ServiceTaskParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.command.bind.RequestParameter"))
		{
			result = new RequestParameterParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.command.bind.RequestParameterGroup"))
		{
			result = new RequestParameterGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.command.bind.ServiceParameter"))
		{
			result = new ServiceParameterParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.command.bind.ParamValueType"))
		{
			result = new ParamValueTypeParser(this);
		}
		return result;
	}
	public String getTypeNameForElement(String confElementName)
	{
		String result = "";
		if( UtilTools.isNull( confElementName ) ) return result;
		String tmpName = UTools.getTrim(confElementName);
		if(tmpName.equals("serviceParameter"))
		{
			result = "org.zml.data.vo.command.bind.ServiceParameter";
		}
		else if(tmpName.equals("serviceTask"))
		{
			result = "org.zml.data.vo.command.bind.ServiceTask";
		}
		else if(tmpName.equals("requestTask"))
		{
			result = "org.zml.data.vo.command.bind.RequestTask";
		}
		else if(tmpName.equals("requestTaskGroup"))
		{
			result = "org.zml.data.vo.command.bind.RequestTaskGroup";
		}
		else if(tmpName.equals("requestParameter"))
		{
			result = "org.zml.data.vo.command.bind.RequestParameter";
		}
		else if(tmpName.equals("commandDefine"))
		{
			result = "org.zml.data.vo.command.bind.CommandDefine";
		}
		else if(tmpName.equals("requestParameterGroup"))
		{
			result = "org.zml.data.vo.command.bind.RequestParameterGroup";
		}
		else if(tmpName.equals("commandConfiguration"))
		{
			result = "org.zml.data.vo.command.bind.CommandConfiguration";
		}
		return result;
	}
	public String getElementForType(String typeName)
	{
		String result = "";
		if( UtilTools.isNull( typeName ) ) return result;
		String tmpName = UTools.getTrim(typeName);
		if(tmpName.equals("org.zml.data.vo.command.bind.ServiceParameter"))
		{
			result = "serviceParameter";
		}
		else if(tmpName.equals("org.zml.data.vo.command.bind.ServiceTask"))
		{
			result = "serviceTask";
		}
		else if(tmpName.equals("org.zml.data.vo.command.bind.RequestTask"))
		{
			result = "requestTask";
		}
		else if(tmpName.equals("org.zml.data.vo.command.bind.RequestTaskGroup"))
		{
			result = "requestTaskGroup";
		}
		else if(tmpName.equals("org.zml.data.vo.command.bind.RequestParameter"))
		{
			result = "requestParameter";
		}
		else if(tmpName.equals("org.zml.data.vo.command.bind.CommandDefine"))
		{
			result = "commandDefine";
		}
		else if(tmpName.equals("org.zml.data.vo.command.bind.RequestParameterGroup"))
		{
			result = "requestParameterGroup";
		}
		else if(tmpName.equals("org.zml.data.vo.command.bind.CommandConfiguration"))
		{
			result = "commandConfiguration";
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