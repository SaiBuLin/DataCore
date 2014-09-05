package org.zml.form.bind;
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
		this.addBindMap("orderColumn","fieldColumn");
		this.addBindMap("scriptColumn","fieldColumn");
		this.addBindMap("conditionSection","section");
		this.addBindMap("analystColumn","fieldColumn");
		this.addBindMap("fieldCondition","condition");
		this.addBindMap("condition","formNode");
		this.addBindMap("columnSection","section");
		this.addBindMap("conditions","condition");
		this.addBindMap("section","formNode");
		this.addBindMap("pageInfo","formNode");
		this.addBindMap("columnGroup","column");
		this.addBindMap("fieldColumn","column");
		this.addBindMap("sqlFormService","formService");
		this.addBindMap("voFormService","formService");
		this.addBindMap("column","formNode");
		this.addBindMap("gridSection","columnSection");
		this.addBindMap("dataForm","form");
		this.addBindMap("form","formNode");
		this.addBindMap("formService","formNode");
		this.addBindMap("formGroup","form");
		this.addBindMap("sectionGroup","section");
		this.addBindMap("conditionColumn","fieldColumn");
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
		if(tmpName.equals("sqlFormService"))
		{
			result = new SQLFormServiceParser(this);
		}
		else if(tmpName.equals("formNode"))
		{
			result = new FormNodeParser(this);
		}
		else if(tmpName.equals("condition"))
		{
			result = new ConditionParser(this);
		}
		else if(tmpName.equals("gridSection"))
		{
			result = new GridSectionParser(this);
		}
		else if(tmpName.equals("columnGroup"))
		{
			result = new ColumnGroupParser(this);
		}
		else if(tmpName.equals("pageInfo"))
		{
			result = new PageInfoParser(this);
		}
		else if(tmpName.equals("conditions"))
		{
			result = new ConditionsParser(this);
		}
		else if(tmpName.equals("voFormService"))
		{
			result = new VOFormServiceParser(this);
		}
		else if(tmpName.equals("conditionColumn"))
		{
			result = new ConditionColumnParser(this);
		}
		else if(tmpName.equals("fieldCondition"))
		{
			result = new FieldConditionParser(this);
		}
		else if(tmpName.equals("orderColumn"))
		{
			result = new OrderColumnParser(this);
		}
		else if(tmpName.equals("column"))
		{
			result = new ColumnParser(this);
		}
		else if(tmpName.equals("sectionGroup"))
		{
			result = new SectionGroupParser(this);
		}
		else if(tmpName.equals("section"))
		{
			result = new SectionParser(this);
		}
		else if(tmpName.equals("conditionSection"))
		{
			result = new ConditionSectionParser(this);
		}
		else if(tmpName.equals("columnSection"))
		{
			result = new ColumnSectionParser(this);
		}
		else if(tmpName.equals("dataForm"))
		{
			result = new DataFormParser(this);
		}
		else if(tmpName.equals("form"))
		{
			result = new FormParser(this);
		}
		else if(tmpName.equals("fieldColumn"))
		{
			result = new FieldColumnParser(this);
		}
		else if(tmpName.equals("formGroup"))
		{
			result = new FormGroupParser(this);
		}
		else if(tmpName.equals("formService"))
		{
			result = new FormServiceParser(this);
		}
		else if(tmpName.equals("analystColumn"))
		{
			result = new AnalystColumnParser(this);
		}
		else if(tmpName.equals("scriptColumn"))
		{
			result = new ScriptColumnParser(this);
		}
		return result;
	}
	public IXmlVisitorParserable createXMLVisitorParserByCTXMLElement( CTXMLElement ob )
	{
		IXmlVisitorParserable result = null;
		if( ob == null ) return result;
		if( ob.getClass().getName().equals( "org.zml.form.bind.ScriptColumn"))
		{
			result = new ScriptColumnParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.GridSection"))
		{
			result = new GridSectionParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.ConditionColumn"))
		{
			result = new ConditionColumnParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.FormGroup"))
		{
			result = new FormGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.FieldColumn"))
		{
			result = new FieldColumnParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.FormNode"))
		{
			result = new FormNodeParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.VOFormService"))
		{
			result = new VOFormServiceParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.AnalystColumn"))
		{
			result = new AnalystColumnParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.FieldCondition"))
		{
			result = new FieldConditionParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.SectionGroup"))
		{
			result = new SectionGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.ConditionSection"))
		{
			result = new ConditionSectionParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.Section"))
		{
			result = new SectionParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.Condition"))
		{
			result = new ConditionParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.PageInfo"))
		{
			result = new PageInfoParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.Form"))
		{
			result = new FormParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.SQLFormService"))
		{
			result = new SQLFormServiceParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.OrderColumn"))
		{
			result = new OrderColumnParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.DataForm"))
		{
			result = new DataFormParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.FormService"))
		{
			result = new FormServiceParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.Column"))
		{
			result = new ColumnParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.Conditions"))
		{
			result = new ConditionsParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.ColumnGroup"))
		{
			result = new ColumnGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.form.bind.ColumnSection"))
		{
			result = new ColumnSectionParser(this);
		}
		return result;
	}
	public IXmlVisitorParserable createXMLVisitorParserByElmentTypeName( String typeName )
	{
		IXmlVisitorParserable result = null;
		if( UtilTools.isNull(typeName) ) return result;
		String tmpTypeName = UtilTools.getTrim( typeName );
		if( tmpTypeName.equals( "org.zml.form.bind.FormNode"))
		{
			result = new FormNodeParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.Form"))
		{
			result = new FormParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.FormGroup"))
		{
			result = new FormGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.DataForm"))
		{
			result = new DataFormParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.Section"))
		{
			result = new SectionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.SectionGroup"))
		{
			result = new SectionGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.ColumnSection"))
		{
			result = new ColumnSectionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.GridSection"))
		{
			result = new GridSectionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.ConditionSection"))
		{
			result = new ConditionSectionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.Column"))
		{
			result = new ColumnParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.ColumnGroup"))
		{
			result = new ColumnGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.FieldColumn"))
		{
			result = new FieldColumnParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.AnalystColumn"))
		{
			result = new AnalystColumnParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.ScriptColumn"))
		{
			result = new ScriptColumnParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.ConditionColumn"))
		{
			result = new ConditionColumnParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.OrderColumn"))
		{
			result = new OrderColumnParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.FormService"))
		{
			result = new FormServiceParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.VOFormService"))
		{
			result = new VOFormServiceParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.SQLFormService"))
		{
			result = new SQLFormServiceParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.PageInfo"))
		{
			result = new PageInfoParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.Condition"))
		{
			result = new ConditionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.Conditions"))
		{
			result = new ConditionsParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.FieldCondition"))
		{
			result = new FieldConditionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.SQLFunction"))
		{
			result = new SQLFunctionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.FieldLogical"))
		{
			result = new FieldLogicalParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.OperationLogical"))
		{
			result = new OperationLogicalParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.form.bind.OrderDirection"))
		{
			result = new OrderDirectionParser(this);
		}
		return result;
	}
	public String getTypeNameForElement(String confElementName)
	{
		String result = "";
		if( UtilTools.isNull( confElementName ) ) return result;
		String tmpName = UTools.getTrim(confElementName);
		if(tmpName.equals("sqlFormService"))
		{
			result = "org.zml.form.bind.SQLFormService";
		}
		else if(tmpName.equals("formNode"))
		{
			result = "org.zml.form.bind.FormNode";
		}
		else if(tmpName.equals("condition"))
		{
			result = "org.zml.form.bind.Condition";
		}
		else if(tmpName.equals("gridSection"))
		{
			result = "org.zml.form.bind.GridSection";
		}
		else if(tmpName.equals("columnGroup"))
		{
			result = "org.zml.form.bind.ColumnGroup";
		}
		else if(tmpName.equals("pageInfo"))
		{
			result = "org.zml.form.bind.PageInfo";
		}
		else if(tmpName.equals("conditions"))
		{
			result = "org.zml.form.bind.Conditions";
		}
		else if(tmpName.equals("voFormService"))
		{
			result = "org.zml.form.bind.VOFormService";
		}
		else if(tmpName.equals("conditionColumn"))
		{
			result = "org.zml.form.bind.ConditionColumn";
		}
		else if(tmpName.equals("fieldCondition"))
		{
			result = "org.zml.form.bind.FieldCondition";
		}
		else if(tmpName.equals("orderColumn"))
		{
			result = "org.zml.form.bind.OrderColumn";
		}
		else if(tmpName.equals("column"))
		{
			result = "org.zml.form.bind.Column";
		}
		else if(tmpName.equals("sectionGroup"))
		{
			result = "org.zml.form.bind.SectionGroup";
		}
		else if(tmpName.equals("section"))
		{
			result = "org.zml.form.bind.Section";
		}
		else if(tmpName.equals("conditionSection"))
		{
			result = "org.zml.form.bind.ConditionSection";
		}
		else if(tmpName.equals("columnSection"))
		{
			result = "org.zml.form.bind.ColumnSection";
		}
		else if(tmpName.equals("dataForm"))
		{
			result = "org.zml.form.bind.DataForm";
		}
		else if(tmpName.equals("form"))
		{
			result = "org.zml.form.bind.Form";
		}
		else if(tmpName.equals("fieldColumn"))
		{
			result = "org.zml.form.bind.FieldColumn";
		}
		else if(tmpName.equals("formGroup"))
		{
			result = "org.zml.form.bind.FormGroup";
		}
		else if(tmpName.equals("formService"))
		{
			result = "org.zml.form.bind.FormService";
		}
		else if(tmpName.equals("analystColumn"))
		{
			result = "org.zml.form.bind.AnalystColumn";
		}
		else if(tmpName.equals("scriptColumn"))
		{
			result = "org.zml.form.bind.ScriptColumn";
		}
		return result;
	}
	public String getElementForType(String typeName)
	{
		String result = "";
		if( UtilTools.isNull( typeName ) ) return result;
		String tmpName = UTools.getTrim(typeName);
		if(tmpName.equals("org.zml.form.bind.SQLFormService"))
		{
			result = "sqlFormService";
		}
		else if(tmpName.equals("org.zml.form.bind.FormNode"))
		{
			result = "formNode";
		}
		else if(tmpName.equals("org.zml.form.bind.Condition"))
		{
			result = "condition";
		}
		else if(tmpName.equals("org.zml.form.bind.GridSection"))
		{
			result = "gridSection";
		}
		else if(tmpName.equals("org.zml.form.bind.ColumnGroup"))
		{
			result = "columnGroup";
		}
		else if(tmpName.equals("org.zml.form.bind.PageInfo"))
		{
			result = "pageInfo";
		}
		else if(tmpName.equals("org.zml.form.bind.Conditions"))
		{
			result = "conditions";
		}
		else if(tmpName.equals("org.zml.form.bind.VOFormService"))
		{
			result = "voFormService";
		}
		else if(tmpName.equals("org.zml.form.bind.ConditionColumn"))
		{
			result = "conditionColumn";
		}
		else if(tmpName.equals("org.zml.form.bind.FieldCondition"))
		{
			result = "fieldCondition";
		}
		else if(tmpName.equals("org.zml.form.bind.OrderColumn"))
		{
			result = "orderColumn";
		}
		else if(tmpName.equals("org.zml.form.bind.Column"))
		{
			result = "column";
		}
		else if(tmpName.equals("org.zml.form.bind.SectionGroup"))
		{
			result = "sectionGroup";
		}
		else if(tmpName.equals("org.zml.form.bind.Section"))
		{
			result = "section";
		}
		else if(tmpName.equals("org.zml.form.bind.ConditionSection"))
		{
			result = "conditionSection";
		}
		else if(tmpName.equals("org.zml.form.bind.ColumnSection"))
		{
			result = "columnSection";
		}
		else if(tmpName.equals("org.zml.form.bind.DataForm"))
		{
			result = "dataForm";
		}
		else if(tmpName.equals("org.zml.form.bind.Form"))
		{
			result = "form";
		}
		else if(tmpName.equals("org.zml.form.bind.FieldColumn"))
		{
			result = "fieldColumn";
		}
		else if(tmpName.equals("org.zml.form.bind.FormGroup"))
		{
			result = "formGroup";
		}
		else if(tmpName.equals("org.zml.form.bind.FormService"))
		{
			result = "formService";
		}
		else if(tmpName.equals("org.zml.form.bind.AnalystColumn"))
		{
			result = "analystColumn";
		}
		else if(tmpName.equals("org.zml.form.bind.ScriptColumn"))
		{
			result = "scriptColumn";
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