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
		this.addBindMap("conditionSyntax","queryFormNode");
		this.addBindMap("conditionSection","section");
		this.addBindMap("analystColumn","fieldColumn");
		this.addBindMap("dataTable","formSet");
		this.addBindMap("formSet","queryFormNode");
		this.addBindMap("groupBySection","selectSection");
		this.addBindMap("pythonColumn","column");
		this.addBindMap("columnGroup","column");
		this.addBindMap("section","queryFormNode");
		this.addBindMap("pageInfo","queryFormNode");
		this.addBindMap("conditionColumn","fieldColumn");
		this.addBindMap("dataSource","queryFormNode");
		this.addBindMap("voSource","pageDataSource");
		this.addBindMap("formSetGroup","formSet");
		this.addBindMap("orderBySection","selectSection");
		this.addBindMap("column","queryFormNode");
		this.addBindMap("orderByColumn","fieldColumn");
		this.addBindMap("selectSection","section");
		this.addBindMap("dataPageInfo","pageInfo");
		this.addBindMap("sqlSource","pageDataSource");
		this.addBindMap("fieldColumn","column");
		this.addBindMap("complexWhere","conditionSyntax");
		this.addBindMap("pageDataSource","dataSource");
		this.addBindMap("requestService","queryFormNode");
		this.addBindMap("fieldWhere","conditionSyntax");
		this.addBindMap("sectionGroup","section");
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
		if(tmpName.equals("dataPageInfo"))
		{
			result = new DataPageInfoParser(this);
		}
		else if(tmpName.equals("column"))
		{
			result = new ColumnParser(this);
		}
		else if(tmpName.equals("pythonColumn"))
		{
			result = new PythonColumnParser(this);
		}
		else if(tmpName.equals("conditionSyntax"))
		{
			result = new ConditionSyntaxParser(this);
		}
		else if(tmpName.equals("formSetGroup"))
		{
			result = new FormSetGroupParser(this);
		}
		else if(tmpName.equals("orderBySection"))
		{
			result = new OrderBySectionParser(this);
		}
		else if(tmpName.equals("dataSource"))
		{
			result = new DataSourceParser(this);
		}
		else if(tmpName.equals("formSet"))
		{
			result = new FormSetParser(this);
		}
		else if(tmpName.equals("columnGroup"))
		{
			result = new ColumnGroupParser(this);
		}
		else if(tmpName.equals("queryFormNode"))
		{
			result = new QueryFormNodeParser(this);
		}
		else if(tmpName.equals("pageInfo"))
		{
			result = new PageInfoParser(this);
		}
		else if(tmpName.equals("groupBySection"))
		{
			result = new GroupBySectionParser(this);
		}
		else if(tmpName.equals("conditionColumn"))
		{
			result = new ConditionColumnParser(this);
		}
		else if(tmpName.equals("analystColumn"))
		{
			result = new AnalystColumnParser(this);
		}
		else if(tmpName.equals("sectionGroup"))
		{
			result = new SectionGroupParser(this);
		}
		else if(tmpName.equals("pageDataSource"))
		{
			result = new PageDataSourceParser(this);
		}
		else if(tmpName.equals("fieldWhere"))
		{
			result = new FieldWhereParser(this);
		}
		else if(tmpName.equals("orderByColumn"))
		{
			result = new OrderByColumnParser(this);
		}
		else if(tmpName.equals("section"))
		{
			result = new SectionParser(this);
		}
		else if(tmpName.equals("conditionSection"))
		{
			result = new ConditionSectionParser(this);
		}
		else if(tmpName.equals("voSource"))
		{
			result = new VOSourceParser(this);
		}
		else if(tmpName.equals("selectSection"))
		{
			result = new SelectSectionParser(this);
		}
		else if(tmpName.equals("complexWhere"))
		{
			result = new ComplexWhereParser(this);
		}
		else if(tmpName.equals("fieldColumn"))
		{
			result = new FieldColumnParser(this);
		}
		else if(tmpName.equals("sqlSource"))
		{
			result = new SQLSourceParser(this);
		}
		else if(tmpName.equals("dataTable"))
		{
			result = new DataTableParser(this);
		}
		else if(tmpName.equals("requestService"))
		{
			result = new RequestServiceParser(this);
		}
		return result;
	}
	public IXmlVisitorParserable createXMLVisitorParserByCTXMLElement( CTXMLElement ob )
	{
		IXmlVisitorParserable result = null;
		if( ob == null ) return result;
		if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.OrderByColumn"))
		{
			result = new OrderByColumnParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.QueryFormNode"))
		{
			result = new QueryFormNodeParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.DataTable"))
		{
			result = new DataTableParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.ConditionColumn"))
		{
			result = new ConditionColumnParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.PythonColumn"))
		{
			result = new PythonColumnParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.VOSource"))
		{
			result = new VOSourceParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.FieldWhere"))
		{
			result = new FieldWhereParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.FieldColumn"))
		{
			result = new FieldColumnParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.FormSetGroup"))
		{
			result = new FormSetGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.AnalystColumn"))
		{
			result = new AnalystColumnParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.DataPageInfo"))
		{
			result = new DataPageInfoParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.SectionGroup"))
		{
			result = new SectionGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.ConditionSection"))
		{
			result = new ConditionSectionParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.PageDataSource"))
		{
			result = new PageDataSourceParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.RequestService"))
		{
			result = new RequestServiceParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.OrderBySection"))
		{
			result = new OrderBySectionParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.Section"))
		{
			result = new SectionParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.FormSet"))
		{
			result = new FormSetParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.SQLSource"))
		{
			result = new SQLSourceParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.Column"))
		{
			result = new ColumnParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.ComplexWhere"))
		{
			result = new ComplexWhereParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.SelectSection"))
		{
			result = new SelectSectionParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.DataSource"))
		{
			result = new DataSourceParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.ConditionSyntax"))
		{
			result = new ConditionSyntaxParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.GroupBySection"))
		{
			result = new GroupBySectionParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.PageInfo"))
		{
			result = new PageInfoParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.service.page.request.bind.ColumnGroup"))
		{
			result = new ColumnGroupParser(this);
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
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.RequestService"))
		{
			result = new RequestServiceParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.FormSet"))
		{
			result = new FormSetParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.FormSetGroup"))
		{
			result = new FormSetGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.DataTable"))
		{
			result = new DataTableParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.Section"))
		{
			result = new SectionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.SectionGroup"))
		{
			result = new SectionGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.SelectSection"))
		{
			result = new SelectSectionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.ConditionSection"))
		{
			result = new ConditionSectionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.OrderBySection"))
		{
			result = new OrderBySectionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.GroupBySection"))
		{
			result = new GroupBySectionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.Column"))
		{
			result = new ColumnParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.ColumnGroup"))
		{
			result = new ColumnGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.FieldColumn"))
		{
			result = new FieldColumnParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.AnalystColumn"))
		{
			result = new AnalystColumnParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.PythonColumn"))
		{
			result = new PythonColumnParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.ConditionColumn"))
		{
			result = new ConditionColumnParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.OrderByColumn"))
		{
			result = new OrderByColumnParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.DataSource"))
		{
			result = new DataSourceParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.PageDataSource"))
		{
			result = new PageDataSourceParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.VOSource"))
		{
			result = new VOSourceParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.SQLSource"))
		{
			result = new SQLSourceParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.PageInfo"))
		{
			result = new PageInfoParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.DataPageInfo"))
		{
			result = new DataPageInfoParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.ConditionSyntax"))
		{
			result = new ConditionSyntaxParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.ComplexWhere"))
		{
			result = new ComplexWhereParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.service.page.request.bind.FieldWhere"))
		{
			result = new FieldWhereParser(this);
		}
		return result;
	}
	public String getTypeNameForElement(String confElementName)
	{
		String result = "";
		if( UtilTools.isNull( confElementName ) ) return result;
		String tmpName = UTools.getTrim(confElementName);
		if(tmpName.equals("dataPageInfo"))
		{
			result = "org.zml.data.service.page.request.bind.DataPageInfo";
		}
		else if(tmpName.equals("column"))
		{
			result = "org.zml.data.service.page.request.bind.Column";
		}
		else if(tmpName.equals("pythonColumn"))
		{
			result = "org.zml.data.service.page.request.bind.PythonColumn";
		}
		else if(tmpName.equals("conditionSyntax"))
		{
			result = "org.zml.data.service.page.request.bind.ConditionSyntax";
		}
		else if(tmpName.equals("formSetGroup"))
		{
			result = "org.zml.data.service.page.request.bind.FormSetGroup";
		}
		else if(tmpName.equals("orderBySection"))
		{
			result = "org.zml.data.service.page.request.bind.OrderBySection";
		}
		else if(tmpName.equals("dataSource"))
		{
			result = "org.zml.data.service.page.request.bind.DataSource";
		}
		else if(tmpName.equals("formSet"))
		{
			result = "org.zml.data.service.page.request.bind.FormSet";
		}
		else if(tmpName.equals("columnGroup"))
		{
			result = "org.zml.data.service.page.request.bind.ColumnGroup";
		}
		else if(tmpName.equals("queryFormNode"))
		{
			result = "org.zml.data.service.page.request.bind.QueryFormNode";
		}
		else if(tmpName.equals("pageInfo"))
		{
			result = "org.zml.data.service.page.request.bind.PageInfo";
		}
		else if(tmpName.equals("groupBySection"))
		{
			result = "org.zml.data.service.page.request.bind.GroupBySection";
		}
		else if(tmpName.equals("conditionColumn"))
		{
			result = "org.zml.data.service.page.request.bind.ConditionColumn";
		}
		else if(tmpName.equals("analystColumn"))
		{
			result = "org.zml.data.service.page.request.bind.AnalystColumn";
		}
		else if(tmpName.equals("sectionGroup"))
		{
			result = "org.zml.data.service.page.request.bind.SectionGroup";
		}
		else if(tmpName.equals("pageDataSource"))
		{
			result = "org.zml.data.service.page.request.bind.PageDataSource";
		}
		else if(tmpName.equals("fieldWhere"))
		{
			result = "org.zml.data.service.page.request.bind.FieldWhere";
		}
		else if(tmpName.equals("orderByColumn"))
		{
			result = "org.zml.data.service.page.request.bind.OrderByColumn";
		}
		else if(tmpName.equals("section"))
		{
			result = "org.zml.data.service.page.request.bind.Section";
		}
		else if(tmpName.equals("conditionSection"))
		{
			result = "org.zml.data.service.page.request.bind.ConditionSection";
		}
		else if(tmpName.equals("voSource"))
		{
			result = "org.zml.data.service.page.request.bind.VOSource";
		}
		else if(tmpName.equals("selectSection"))
		{
			result = "org.zml.data.service.page.request.bind.SelectSection";
		}
		else if(tmpName.equals("complexWhere"))
		{
			result = "org.zml.data.service.page.request.bind.ComplexWhere";
		}
		else if(tmpName.equals("fieldColumn"))
		{
			result = "org.zml.data.service.page.request.bind.FieldColumn";
		}
		else if(tmpName.equals("sqlSource"))
		{
			result = "org.zml.data.service.page.request.bind.SQLSource";
		}
		else if(tmpName.equals("dataTable"))
		{
			result = "org.zml.data.service.page.request.bind.DataTable";
		}
		else if(tmpName.equals("requestService"))
		{
			result = "org.zml.data.service.page.request.bind.RequestService";
		}
		return result;
	}
	public String getElementForType(String typeName)
	{
		String result = "";
		if( UtilTools.isNull( typeName ) ) return result;
		String tmpName = UTools.getTrim(typeName);
		if(tmpName.equals("org.zml.data.service.page.request.bind.DataPageInfo"))
		{
			result = "dataPageInfo";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.Column"))
		{
			result = "column";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.PythonColumn"))
		{
			result = "pythonColumn";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.ConditionSyntax"))
		{
			result = "conditionSyntax";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.FormSetGroup"))
		{
			result = "formSetGroup";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.OrderBySection"))
		{
			result = "orderBySection";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.DataSource"))
		{
			result = "dataSource";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.FormSet"))
		{
			result = "formSet";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.ColumnGroup"))
		{
			result = "columnGroup";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.QueryFormNode"))
		{
			result = "queryFormNode";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.PageInfo"))
		{
			result = "pageInfo";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.GroupBySection"))
		{
			result = "groupBySection";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.ConditionColumn"))
		{
			result = "conditionColumn";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.AnalystColumn"))
		{
			result = "analystColumn";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.SectionGroup"))
		{
			result = "sectionGroup";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.PageDataSource"))
		{
			result = "pageDataSource";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.FieldWhere"))
		{
			result = "fieldWhere";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.OrderByColumn"))
		{
			result = "orderByColumn";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.Section"))
		{
			result = "section";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.ConditionSection"))
		{
			result = "conditionSection";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.VOSource"))
		{
			result = "voSource";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.SelectSection"))
		{
			result = "selectSection";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.ComplexWhere"))
		{
			result = "complexWhere";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.FieldColumn"))
		{
			result = "fieldColumn";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.SQLSource"))
		{
			result = "sqlSource";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.DataTable"))
		{
			result = "dataTable";
		}
		else if(tmpName.equals("org.zml.data.service.page.request.bind.RequestService"))
		{
			result = "requestService";
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