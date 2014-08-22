package org.zml.schema.bind;
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
		this.addBindMap("query","command");
		this.addBindMap("update","command");
		this.addBindMap("field","define");
		this.addBindMap("fieldsExpress","express");
		this.addBindMap("viewRelation","relation");
		this.addBindMap("referenceLibrary","library");
		this.addBindMap("express","define");
		this.addBindMap("transaction","schema");
		this.addBindMap("schemaDefine","define");
		this.addBindMap("libraryGroup","library");
		this.addBindMap("parameter","attribute");
		this.addBindMap("dataService","define");
		this.addBindMap("view","schema");
		this.addBindMap("schemaGroup","schema");
		this.addBindMap("command","schemaDefine");
		this.addBindMap("attributeLibrary","library");
		this.addBindMap("expressGroup","express");
		this.addBindMap("fieldGroup","field");
		this.addBindMap("attributeGroup","attribute");
		this.addBindMap("form","schema");
		this.addBindMap("delete","command");
		this.addBindMap("schema","schemaDefine");
		this.addBindMap("relation","define");
		this.addBindMap("library","define");
		this.addBindMap("filter","define");
		this.addBindMap("schemaConfigure","define");
		this.addBindMap("attribute","define");
		this.addBindMap("fieldValueExpress","express");
		this.addBindMap("formLibrary","library");
		this.addBindMap("exists","viewRelation");
		this.addBindMap("relationGroup","relation");
		this.addBindMap("factory","define");
		this.addBindMap("innerJoin","viewRelation");
		this.addBindMap("serviceField","field");
		this.addBindMap("service","define");
		this.addBindMap("insert","command");
		this.addBindMap("noneExists","viewRelation");
		this.addBindMap("sqlLibrary","library");
		this.addBindMap("rightOuterJoin","viewRelation");
		this.addBindMap("leftOuterJoin","viewRelation");
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
		if(tmpName.equals("fieldsExpress"))
		{
			result = new FieldsExpressParser(this);
		}
		else if(tmpName.equals("fieldValueExpress"))
		{
			result = new FieldValueExpressParser(this);
		}
		else if(tmpName.equals("library"))
		{
			result = new LibraryParser(this);
		}
		else if(tmpName.equals("delete"))
		{
			result = new DeleteParser(this);
		}
		else if(tmpName.equals("factory"))
		{
			result = new FactoryParser(this);
		}
		else if(tmpName.equals("expressGroup"))
		{
			result = new ExpressGroupParser(this);
		}
		else if(tmpName.equals("noneExists"))
		{
			result = new NoneExistsParser(this);
		}
		else if(tmpName.equals("command"))
		{
			result = new CommandParser(this);
		}
		else if(tmpName.equals("form"))
		{
			result = new FormParser(this);
		}
		else if(tmpName.equals("attribute"))
		{
			result = new AttributeParser(this);
		}
		else if(tmpName.equals("transaction"))
		{
			result = new TransactionParser(this);
		}
		else if(tmpName.equals("schemaConfigure"))
		{
			result = new SchemaConfigureParser(this);
		}
		else if(tmpName.equals("exists"))
		{
			result = new ExistsParser(this);
		}
		else if(tmpName.equals("fieldGroup"))
		{
			result = new FieldGroupParser(this);
		}
		else if(tmpName.equals("leftOuterJoin"))
		{
			result = new LeftOuterJoinParser(this);
		}
		else if(tmpName.equals("field"))
		{
			result = new FieldParser(this);
		}
		else if(tmpName.equals("sqlLibrary"))
		{
			result = new SqlLibraryParser(this);
		}
		else if(tmpName.equals("relation"))
		{
			result = new RelationParser(this);
		}
		else if(tmpName.equals("filter"))
		{
			result = new FilterParser(this);
		}
		else if(tmpName.equals("dataService"))
		{
			result = new DataServiceParser(this);
		}
		else if(tmpName.equals("update"))
		{
			result = new UpdateParser(this);
		}
		else if(tmpName.equals("service"))
		{
			result = new ServiceParser(this);
		}
		else if(tmpName.equals("serviceField"))
		{
			result = new ServiceFieldParser(this);
		}
		else if(tmpName.equals("referenceLibrary"))
		{
			result = new ReferenceLibraryParser(this);
		}
		else if(tmpName.equals("query"))
		{
			result = new QueryParser(this);
		}
		else if(tmpName.equals("insert"))
		{
			result = new InsertParser(this);
		}
		else if(tmpName.equals("libraryGroup"))
		{
			result = new LibraryGroupParser(this);
		}
		else if(tmpName.equals("define"))
		{
			result = new DefineParser(this);
		}
		else if(tmpName.equals("attributeLibrary"))
		{
			result = new AttributeLibraryParser(this);
		}
		else if(tmpName.equals("innerJoin"))
		{
			result = new InnerJoinParser(this);
		}
		else if(tmpName.equals("view"))
		{
			result = new ViewParser(this);
		}
		else if(tmpName.equals("parameter"))
		{
			result = new ParameterParser(this);
		}
		else if(tmpName.equals("relationGroup"))
		{
			result = new RelationGroupParser(this);
		}
		else if(tmpName.equals("formLibrary"))
		{
			result = new FormLibraryParser(this);
		}
		else if(tmpName.equals("express"))
		{
			result = new ExpressParser(this);
		}
		else if(tmpName.equals("viewRelation"))
		{
			result = new ViewRelationParser(this);
		}
		else if(tmpName.equals("schema"))
		{
			result = new SchemaParser(this);
		}
		else if(tmpName.equals("schemaGroup"))
		{
			result = new SchemaGroupParser(this);
		}
		else if(tmpName.equals("attributeGroup"))
		{
			result = new AttributeGroupParser(this);
		}
		else if(tmpName.equals("rightOuterJoin"))
		{
			result = new RightOuterJoinParser(this);
		}
		else if(tmpName.equals("schemaDefine"))
		{
			result = new SchemaDefineParser(this);
		}
		return result;
	}
	public IXmlVisitorParserable createXMLVisitorParserByCTXMLElement( CTXMLElement ob )
	{
		IXmlVisitorParserable result = null;
		if( ob == null ) return result;
		if( ob.getClass().getName().equals( "org.zml.schema.bind.DataService"))
		{
			result = new DataServiceParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.Update"))
		{
			result = new UpdateParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.AttributeGroup"))
		{
			result = new AttributeGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.Form"))
		{
			result = new FormParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.ExpressGroup"))
		{
			result = new ExpressGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.FieldsExpress"))
		{
			result = new FieldsExpressParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.Query"))
		{
			result = new QueryParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.RightOuterJoin"))
		{
			result = new RightOuterJoinParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.Parameter"))
		{
			result = new ParameterParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.Relation"))
		{
			result = new RelationParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.LeftOuterJoin"))
		{
			result = new LeftOuterJoinParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.Express"))
		{
			result = new ExpressParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.Service"))
		{
			result = new ServiceParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.Library"))
		{
			result = new LibraryParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.Transaction"))
		{
			result = new TransactionParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.Schema"))
		{
			result = new SchemaParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.Delete"))
		{
			result = new DeleteParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.SchemaConfigure"))
		{
			result = new SchemaConfigureParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.SqlLibrary"))
		{
			result = new SqlLibraryParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.View"))
		{
			result = new ViewParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.FormLibrary"))
		{
			result = new FormLibraryParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.Insert"))
		{
			result = new InsertParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.ReferenceLibrary"))
		{
			result = new ReferenceLibraryParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.InnerJoin"))
		{
			result = new InnerJoinParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.Define"))
		{
			result = new DefineParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.Command"))
		{
			result = new CommandParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.Attribute"))
		{
			result = new AttributeParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.SchemaGroup"))
		{
			result = new SchemaGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.Field"))
		{
			result = new FieldParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.FieldGroup"))
		{
			result = new FieldGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.Factory"))
		{
			result = new FactoryParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.AttributeLibrary"))
		{
			result = new AttributeLibraryParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.RelationGroup"))
		{
			result = new RelationGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.NoneExists"))
		{
			result = new NoneExistsParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.Exists"))
		{
			result = new ExistsParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.FieldValueExpress"))
		{
			result = new FieldValueExpressParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.Filter"))
		{
			result = new FilterParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.ViewRelation"))
		{
			result = new ViewRelationParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.LibraryGroup"))
		{
			result = new LibraryGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.ServiceField"))
		{
			result = new ServiceFieldParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.schema.bind.SchemaDefine"))
		{
			result = new SchemaDefineParser(this);
		}
		return result;
	}
	public IXmlVisitorParserable createXMLVisitorParserByElmentTypeName( String typeName )
	{
		IXmlVisitorParserable result = null;
		if( UtilTools.isNull(typeName) ) return result;
		String tmpTypeName = UtilTools.getTrim( typeName );
		if( tmpTypeName.equals( "org.zml.schema.bind.Define"))
		{
			result = new DefineParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.SchemaDefine"))
		{
			result = new SchemaDefineParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.SchemaConfigure"))
		{
			result = new SchemaConfigureParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.Schema"))
		{
			result = new SchemaParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.SchemaGroup"))
		{
			result = new SchemaGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.Form"))
		{
			result = new FormParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.View"))
		{
			result = new ViewParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.Transaction"))
		{
			result = new TransactionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.Relation"))
		{
			result = new RelationParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.RelationGroup"))
		{
			result = new RelationGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.ViewRelation"))
		{
			result = new ViewRelationParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.InnerJoin"))
		{
			result = new InnerJoinParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.LeftOuterJoin"))
		{
			result = new LeftOuterJoinParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.RightOuterJoin"))
		{
			result = new RightOuterJoinParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.Exists"))
		{
			result = new ExistsParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.NoneExists"))
		{
			result = new NoneExistsParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.Express"))
		{
			result = new ExpressParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.ExpressGroup"))
		{
			result = new ExpressGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.FieldsExpress"))
		{
			result = new FieldsExpressParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.FieldValueExpress"))
		{
			result = new FieldValueExpressParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.Field"))
		{
			result = new FieldParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.FieldGroup"))
		{
			result = new FieldGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.ServiceField"))
		{
			result = new ServiceFieldParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.Command"))
		{
			result = new CommandParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.Query"))
		{
			result = new QueryParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.Update"))
		{
			result = new UpdateParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.Delete"))
		{
			result = new DeleteParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.Insert"))
		{
			result = new InsertParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.Service"))
		{
			result = new ServiceParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.DataService"))
		{
			result = new DataServiceParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.Attribute"))
		{
			result = new AttributeParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.AttributeGroup"))
		{
			result = new AttributeGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.Parameter"))
		{
			result = new ParameterParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.Filter"))
		{
			result = new FilterParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.Library"))
		{
			result = new LibraryParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.LibraryGroup"))
		{
			result = new LibraryGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.FormLibrary"))
		{
			result = new FormLibraryParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.ReferenceLibrary"))
		{
			result = new ReferenceLibraryParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.SqlLibrary"))
		{
			result = new SqlLibraryParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.AttributeLibrary"))
		{
			result = new AttributeLibraryParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.Factory"))
		{
			result = new FactoryParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.DataType"))
		{
			result = new DataTypeParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.FieldLogical"))
		{
			result = new FieldLogicalParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.schema.bind.OperationLogical"))
		{
			result = new OperationLogicalParser(this);
		}
		return result;
	}
	public String getTypeNameForElement(String confElementName)
	{
		String result = "";
		if( UtilTools.isNull( confElementName ) ) return result;
		String tmpName = UTools.getTrim(confElementName);
		if(tmpName.equals("fieldsExpress"))
		{
			result = "org.zml.schema.bind.FieldsExpress";
		}
		else if(tmpName.equals("fieldValueExpress"))
		{
			result = "org.zml.schema.bind.FieldValueExpress";
		}
		else if(tmpName.equals("library"))
		{
			result = "org.zml.schema.bind.Library";
		}
		else if(tmpName.equals("delete"))
		{
			result = "org.zml.schema.bind.Delete";
		}
		else if(tmpName.equals("factory"))
		{
			result = "org.zml.schema.bind.Factory";
		}
		else if(tmpName.equals("expressGroup"))
		{
			result = "org.zml.schema.bind.ExpressGroup";
		}
		else if(tmpName.equals("noneExists"))
		{
			result = "org.zml.schema.bind.NoneExists";
		}
		else if(tmpName.equals("command"))
		{
			result = "org.zml.schema.bind.Command";
		}
		else if(tmpName.equals("form"))
		{
			result = "org.zml.schema.bind.Form";
		}
		else if(tmpName.equals("attribute"))
		{
			result = "org.zml.schema.bind.Attribute";
		}
		else if(tmpName.equals("transaction"))
		{
			result = "org.zml.schema.bind.Transaction";
		}
		else if(tmpName.equals("schemaConfigure"))
		{
			result = "org.zml.schema.bind.SchemaConfigure";
		}
		else if(tmpName.equals("exists"))
		{
			result = "org.zml.schema.bind.Exists";
		}
		else if(tmpName.equals("fieldGroup"))
		{
			result = "org.zml.schema.bind.FieldGroup";
		}
		else if(tmpName.equals("leftOuterJoin"))
		{
			result = "org.zml.schema.bind.LeftOuterJoin";
		}
		else if(tmpName.equals("field"))
		{
			result = "org.zml.schema.bind.Field";
		}
		else if(tmpName.equals("sqlLibrary"))
		{
			result = "org.zml.schema.bind.SqlLibrary";
		}
		else if(tmpName.equals("relation"))
		{
			result = "org.zml.schema.bind.Relation";
		}
		else if(tmpName.equals("filter"))
		{
			result = "org.zml.schema.bind.Filter";
		}
		else if(tmpName.equals("dataService"))
		{
			result = "org.zml.schema.bind.DataService";
		}
		else if(tmpName.equals("update"))
		{
			result = "org.zml.schema.bind.Update";
		}
		else if(tmpName.equals("service"))
		{
			result = "org.zml.schema.bind.Service";
		}
		else if(tmpName.equals("serviceField"))
		{
			result = "org.zml.schema.bind.ServiceField";
		}
		else if(tmpName.equals("referenceLibrary"))
		{
			result = "org.zml.schema.bind.ReferenceLibrary";
		}
		else if(tmpName.equals("query"))
		{
			result = "org.zml.schema.bind.Query";
		}
		else if(tmpName.equals("insert"))
		{
			result = "org.zml.schema.bind.Insert";
		}
		else if(tmpName.equals("libraryGroup"))
		{
			result = "org.zml.schema.bind.LibraryGroup";
		}
		else if(tmpName.equals("define"))
		{
			result = "org.zml.schema.bind.Define";
		}
		else if(tmpName.equals("attributeLibrary"))
		{
			result = "org.zml.schema.bind.AttributeLibrary";
		}
		else if(tmpName.equals("innerJoin"))
		{
			result = "org.zml.schema.bind.InnerJoin";
		}
		else if(tmpName.equals("view"))
		{
			result = "org.zml.schema.bind.View";
		}
		else if(tmpName.equals("parameter"))
		{
			result = "org.zml.schema.bind.Parameter";
		}
		else if(tmpName.equals("relationGroup"))
		{
			result = "org.zml.schema.bind.RelationGroup";
		}
		else if(tmpName.equals("formLibrary"))
		{
			result = "org.zml.schema.bind.FormLibrary";
		}
		else if(tmpName.equals("express"))
		{
			result = "org.zml.schema.bind.Express";
		}
		else if(tmpName.equals("viewRelation"))
		{
			result = "org.zml.schema.bind.ViewRelation";
		}
		else if(tmpName.equals("schema"))
		{
			result = "org.zml.schema.bind.Schema";
		}
		else if(tmpName.equals("schemaGroup"))
		{
			result = "org.zml.schema.bind.SchemaGroup";
		}
		else if(tmpName.equals("attributeGroup"))
		{
			result = "org.zml.schema.bind.AttributeGroup";
		}
		else if(tmpName.equals("rightOuterJoin"))
		{
			result = "org.zml.schema.bind.RightOuterJoin";
		}
		else if(tmpName.equals("schemaDefine"))
		{
			result = "org.zml.schema.bind.SchemaDefine";
		}
		return result;
	}
	public String getElementForType(String typeName)
	{
		String result = "";
		if( UtilTools.isNull( typeName ) ) return result;
		String tmpName = UTools.getTrim(typeName);
		if(tmpName.equals("org.zml.schema.bind.FieldsExpress"))
		{
			result = "fieldsExpress";
		}
		else if(tmpName.equals("org.zml.schema.bind.FieldValueExpress"))
		{
			result = "fieldValueExpress";
		}
		else if(tmpName.equals("org.zml.schema.bind.Library"))
		{
			result = "library";
		}
		else if(tmpName.equals("org.zml.schema.bind.Delete"))
		{
			result = "delete";
		}
		else if(tmpName.equals("org.zml.schema.bind.Factory"))
		{
			result = "factory";
		}
		else if(tmpName.equals("org.zml.schema.bind.ExpressGroup"))
		{
			result = "expressGroup";
		}
		else if(tmpName.equals("org.zml.schema.bind.NoneExists"))
		{
			result = "noneExists";
		}
		else if(tmpName.equals("org.zml.schema.bind.Command"))
		{
			result = "command";
		}
		else if(tmpName.equals("org.zml.schema.bind.Form"))
		{
			result = "form";
		}
		else if(tmpName.equals("org.zml.schema.bind.Attribute"))
		{
			result = "attribute";
		}
		else if(tmpName.equals("org.zml.schema.bind.Transaction"))
		{
			result = "transaction";
		}
		else if(tmpName.equals("org.zml.schema.bind.SchemaConfigure"))
		{
			result = "schemaConfigure";
		}
		else if(tmpName.equals("org.zml.schema.bind.Exists"))
		{
			result = "exists";
		}
		else if(tmpName.equals("org.zml.schema.bind.FieldGroup"))
		{
			result = "fieldGroup";
		}
		else if(tmpName.equals("org.zml.schema.bind.LeftOuterJoin"))
		{
			result = "leftOuterJoin";
		}
		else if(tmpName.equals("org.zml.schema.bind.Field"))
		{
			result = "field";
		}
		else if(tmpName.equals("org.zml.schema.bind.SqlLibrary"))
		{
			result = "sqlLibrary";
		}
		else if(tmpName.equals("org.zml.schema.bind.Relation"))
		{
			result = "relation";
		}
		else if(tmpName.equals("org.zml.schema.bind.Filter"))
		{
			result = "filter";
		}
		else if(tmpName.equals("org.zml.schema.bind.DataService"))
		{
			result = "dataService";
		}
		else if(tmpName.equals("org.zml.schema.bind.Update"))
		{
			result = "update";
		}
		else if(tmpName.equals("org.zml.schema.bind.Service"))
		{
			result = "service";
		}
		else if(tmpName.equals("org.zml.schema.bind.ServiceField"))
		{
			result = "serviceField";
		}
		else if(tmpName.equals("org.zml.schema.bind.ReferenceLibrary"))
		{
			result = "referenceLibrary";
		}
		else if(tmpName.equals("org.zml.schema.bind.Query"))
		{
			result = "query";
		}
		else if(tmpName.equals("org.zml.schema.bind.Insert"))
		{
			result = "insert";
		}
		else if(tmpName.equals("org.zml.schema.bind.LibraryGroup"))
		{
			result = "libraryGroup";
		}
		else if(tmpName.equals("org.zml.schema.bind.Define"))
		{
			result = "define";
		}
		else if(tmpName.equals("org.zml.schema.bind.AttributeLibrary"))
		{
			result = "attributeLibrary";
		}
		else if(tmpName.equals("org.zml.schema.bind.InnerJoin"))
		{
			result = "innerJoin";
		}
		else if(tmpName.equals("org.zml.schema.bind.View"))
		{
			result = "view";
		}
		else if(tmpName.equals("org.zml.schema.bind.Parameter"))
		{
			result = "parameter";
		}
		else if(tmpName.equals("org.zml.schema.bind.RelationGroup"))
		{
			result = "relationGroup";
		}
		else if(tmpName.equals("org.zml.schema.bind.FormLibrary"))
		{
			result = "formLibrary";
		}
		else if(tmpName.equals("org.zml.schema.bind.Express"))
		{
			result = "express";
		}
		else if(tmpName.equals("org.zml.schema.bind.ViewRelation"))
		{
			result = "viewRelation";
		}
		else if(tmpName.equals("org.zml.schema.bind.Schema"))
		{
			result = "schema";
		}
		else if(tmpName.equals("org.zml.schema.bind.SchemaGroup"))
		{
			result = "schemaGroup";
		}
		else if(tmpName.equals("org.zml.schema.bind.AttributeGroup"))
		{
			result = "attributeGroup";
		}
		else if(tmpName.equals("org.zml.schema.bind.RightOuterJoin"))
		{
			result = "rightOuterJoin";
		}
		else if(tmpName.equals("org.zml.schema.bind.SchemaDefine"))
		{
			result = "schemaDefine";
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