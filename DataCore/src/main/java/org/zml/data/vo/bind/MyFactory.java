package org.zml.data.vo.bind;
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
		this.addBindMap("connection","define");
		this.addBindMap("actionLibrary","library");
		this.addBindMap("relationGroup","define");
		this.addBindMap("serviceForm","form");
		this.addBindMap("attributeLibrary","library");
		this.addBindMap("formSet","dataSet");
		this.addBindMap("schema","schemaDefine");
		this.addBindMap("left","define");
		this.addBindMap("groupByPart","fieldsPart");
		this.addBindMap("attributeGroup","attribute");
		this.addBindMap("status","define");
		this.addBindMap("viewForm","serviceForm");
		this.addBindMap("fieldsPart","formPart");
		this.addBindMap("wherePart","fieldsPart");
		this.addBindMap("storedproductForm","serviceForm");
		this.addBindMap("leriFormsConnection","formRelation");
		this.addBindMap("boundaryChecker","validator");
		this.addBindMap("validator","define");
		this.addBindMap("jndiConnection","connection");
		this.addBindMap("validatorGroup","validator");
		this.addBindMap("fieldValue","define");
		this.addBindMap("belongCollection","validator");
		this.addBindMap("formPart","define");
		this.addBindMap("referenceLibrary","library");
		this.addBindMap("setStatus","status");
		this.addBindMap("databaseConnection","connection");
		this.addBindMap("form","schemaDefine");
		this.addBindMap("statusGroup","status");
		this.addBindMap("sqlSet","dataSet");
		this.addBindMap("templateSet","dataSet");
		this.addBindMap("dataForm","serviceForm");
		this.addBindMap("functionTools","actionTools");
		this.addBindMap("serviceConnection","connection");
		this.addBindMap("field","define");
		this.addBindMap("serviceActionTools","functionTools");
		this.addBindMap("fieldValueRelation","define");
		this.addBindMap("voSchema","schema");
		this.addBindMap("extendMethodChecker","validator");
		this.addBindMap("fieldGroup","field");
		this.addBindMap("right","define");
		this.addBindMap("cannotBeNull","validator");
		this.addBindMap("selectForm","dataForm");
		this.addBindMap("dataTypeChecker","validator");
		this.addBindMap("tableSet","dataSet");
		this.addBindMap("serviceConnectTools","connectTools");
		this.addBindMap("transactionForm","serviceForm");
		this.addBindMap("attribute","define");
		this.addBindMap("valueAttribute","attribute");
		this.addBindMap("simpleValue","fieldValue");
		this.addBindMap("actionTools","define");
		this.addBindMap("schemaGroup","schema");
		this.addBindMap("serviceField","field");
		this.addBindMap("jsonFieldValue","schemaValue");
		this.addBindMap("libraryGroup","library");
		this.addBindMap("orderPart","fieldsPart");
		this.addBindMap("canBeNull","validator");
		this.addBindMap("library","define");
		this.addBindMap("formLibrary","library");
		this.addBindMap("formGroup","form");
		this.addBindMap("schemaConfigure","schemaDefine");
		this.addBindMap("schemaValue","fieldValue");
		this.addBindMap("dataSet","define");
		this.addBindMap("formPartGroup","formPart");
		this.addBindMap("sqlLibrary","library");
		this.addBindMap("getStatus","status");
		this.addBindMap("formRelationGroup","formRelation");
		this.addBindMap("formRelation","define");
		this.addBindMap("connectTools","define");
		this.addBindMap("relation","define");
		this.addBindMap("schemaDefine","define");
		this.addBindMap("noneBelongCollection","validator");
		this.addBindMap("viSchema","schema");
		this.addBindMap("selectedPart","fieldsPart");
		this.addBindMap("fieldsRelation","define");
		this.addBindMap("doActionSet","dataSet");
		this.addBindMap("insertForm","dataForm");
		this.addBindMap("updateForm","dataForm");
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
		if(tmpName.equals("attribute"))
		{
			result = new AttributeParser(this);
		}
		else if(tmpName.equals("storedproductForm"))
		{
			result = new StoredproductFormParser(this);
		}
		else if(tmpName.equals("statusGroup"))
		{
			result = new StatusGroupParser(this);
		}
		else if(tmpName.equals("serviceConnectTools"))
		{
			result = new ServiceConnectToolsParser(this);
		}
		else if(tmpName.equals("validatorGroup"))
		{
			result = new ValidatorGroupParser(this);
		}
		else if(tmpName.equals("attributeGroup"))
		{
			result = new AttributeGroupParser(this);
		}
		else if(tmpName.equals("status"))
		{
			result = new StatusParser(this);
		}
		else if(tmpName.equals("voSchema"))
		{
			result = new VOSchemaParser(this);
		}
		else if(tmpName.equals("viewForm"))
		{
			result = new ViewFormParser(this);
		}
		else if(tmpName.equals("formGroup"))
		{
			result = new FormGroupParser(this);
		}
		else if(tmpName.equals("extendMethodChecker"))
		{
			result = new ExtendMethodCheckerParser(this);
		}
		else if(tmpName.equals("formRelationGroup"))
		{
			result = new FormRelationGroupParser(this);
		}
		else if(tmpName.equals("dataSet"))
		{
			result = new DataSetParser(this);
		}
		else if(tmpName.equals("serviceForm"))
		{
			result = new ServiceFormParser(this);
		}
		else if(tmpName.equals("formSet"))
		{
			result = new FormSetParser(this);
		}
		else if(tmpName.equals("templateSet"))
		{
			result = new TemplateSetParser(this);
		}
		else if(tmpName.equals("fieldGroup"))
		{
			result = new FieldGroupParser(this);
		}
		else if(tmpName.equals("left"))
		{
			result = new LeftParser(this);
		}
		else if(tmpName.equals("libraryGroup"))
		{
			result = new LibraryGroupParser(this);
		}
		else if(tmpName.equals("validator"))
		{
			result = new ValidatorParser(this);
		}
		else if(tmpName.equals("getStatus"))
		{
			result = new GetStatusParser(this);
		}
		else if(tmpName.equals("sqlSet"))
		{
			result = new SQLSetParser(this);
		}
		else if(tmpName.equals("library"))
		{
			result = new LibraryParser(this);
		}
		else if(tmpName.equals("actionLibrary"))
		{
			result = new ActionLibraryParser(this);
		}
		else if(tmpName.equals("right"))
		{
			result = new RightParser(this);
		}
		else if(tmpName.equals("fieldValue"))
		{
			result = new FieldValueParser(this);
		}
		else if(tmpName.equals("serviceActionTools"))
		{
			result = new ServiceActionToolsParser(this);
		}
		else if(tmpName.equals("formPartGroup"))
		{
			result = new FormPartGroupParser(this);
		}
		else if(tmpName.equals("fieldValueRelation"))
		{
			result = new FieldValueRelationParser(this);
		}
		else if(tmpName.equals("valueAttribute"))
		{
			result = new ValueAttributeParser(this);
		}
		else if(tmpName.equals("schemaGroup"))
		{
			result = new SchemaGroupParser(this);
		}
		else if(tmpName.equals("belongCollection"))
		{
			result = new BelongCollectionParser(this);
		}
		else if(tmpName.equals("boundaryChecker"))
		{
			result = new BoundaryCheckerParser(this);
		}
		else if(tmpName.equals("serviceField"))
		{
			result = new ServiceFieldParser(this);
		}
		else if(tmpName.equals("dataForm"))
		{
			result = new DataFormParser(this);
		}
		else if(tmpName.equals("sqlLibrary"))
		{
			result = new SqlLibraryParser(this);
		}
		else if(tmpName.equals("orderPart"))
		{
			result = new OrderPartParser(this);
		}
		else if(tmpName.equals("selectedPart"))
		{
			result = new SelectedPartParser(this);
		}
		else if(tmpName.equals("schemaValue"))
		{
			result = new SchemaValueParser(this);
		}
		else if(tmpName.equals("schemaDefine"))
		{
			result = new SchemaDefineParser(this);
		}
		else if(tmpName.equals("wherePart"))
		{
			result = new WherePartParser(this);
		}
		else if(tmpName.equals("schemaConfigure"))
		{
			result = new SchemaConfigureParser(this);
		}
		else if(tmpName.equals("referenceLibrary"))
		{
			result = new ReferenceLibraryParser(this);
		}
		else if(tmpName.equals("cannotBeNull"))
		{
			result = new CannotBeNullParser(this);
		}
		else if(tmpName.equals("jsonFieldValue"))
		{
			result = new JSONFieldValueParser(this);
		}
		else if(tmpName.equals("attributeLibrary"))
		{
			result = new AttributeLibraryParser(this);
		}
		else if(tmpName.equals("formRelation"))
		{
			result = new FormRelationParser(this);
		}
		else if(tmpName.equals("connection"))
		{
			result = new ConnectionParser(this);
		}
		else if(tmpName.equals("fieldsRelation"))
		{
			result = new FieldsRelationParser(this);
		}
		else if(tmpName.equals("noneBelongCollection"))
		{
			result = new NoneBelongCollectionParser(this);
		}
		else if(tmpName.equals("functionTools"))
		{
			result = new FunctionToolsParser(this);
		}
		else if(tmpName.equals("field"))
		{
			result = new FieldParser(this);
		}
		else if(tmpName.equals("formLibrary"))
		{
			result = new FormLibraryParser(this);
		}
		else if(tmpName.equals("simpleValue"))
		{
			result = new SimpleValueParser(this);
		}
		else if(tmpName.equals("dataTypeChecker"))
		{
			result = new DataTypeCheckerParser(this);
		}
		else if(tmpName.equals("actionTools"))
		{
			result = new ActionToolsParser(this);
		}
		else if(tmpName.equals("form"))
		{
			result = new FormParser(this);
		}
		else if(tmpName.equals("selectForm"))
		{
			result = new SelectFormParser(this);
		}
		else if(tmpName.equals("viSchema"))
		{
			result = new VISchemaParser(this);
		}
		else if(tmpName.equals("fieldsPart"))
		{
			result = new FieldsPartParser(this);
		}
		else if(tmpName.equals("tableSet"))
		{
			result = new TableSetParser(this);
		}
		else if(tmpName.equals("insertForm"))
		{
			result = new InsertFormParser(this);
		}
		else if(tmpName.equals("schema"))
		{
			result = new SchemaParser(this);
		}
		else if(tmpName.equals("connectTools"))
		{
			result = new ConnectToolsParser(this);
		}
		else if(tmpName.equals("canBeNull"))
		{
			result = new CanBeNullParser(this);
		}
		else if(tmpName.equals("jndiConnection"))
		{
			result = new JNDIConnectionParser(this);
		}
		else if(tmpName.equals("serviceConnection"))
		{
			result = new ServiceConnectionParser(this);
		}
		else if(tmpName.equals("relation"))
		{
			result = new RelationParser(this);
		}
		else if(tmpName.equals("leriFormsConnection"))
		{
			result = new LeRiFormsConnectionParser(this);
		}
		else if(tmpName.equals("relationGroup"))
		{
			result = new RelationGroupParser(this);
		}
		else if(tmpName.equals("doActionSet"))
		{
			result = new DoActionSetParser(this);
		}
		else if(tmpName.equals("updateForm"))
		{
			result = new UpdateFormParser(this);
		}
		else if(tmpName.equals("define"))
		{
			result = new DefineParser(this);
		}
		else if(tmpName.equals("setStatus"))
		{
			result = new SetStatusParser(this);
		}
		else if(tmpName.equals("databaseConnection"))
		{
			result = new DatabaseConnectionParser(this);
		}
		else if(tmpName.equals("transactionForm"))
		{
			result = new TransactionFormParser(this);
		}
		else if(tmpName.equals("groupByPart"))
		{
			result = new GroupByPartParser(this);
		}
		else if(tmpName.equals("formPart"))
		{
			result = new FormPartParser(this);
		}
		return result;
	}
	public IXmlVisitorParserable createXMLVisitorParserByCTXMLElement( CTXMLElement ob )
	{
		IXmlVisitorParserable result = null;
		if( ob == null ) return result;
		if( ob.getClass().getName().equals( "org.zml.data.vo.bind.ActionTools"))
		{
			result = new ActionToolsParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.SelectedPart"))
		{
			result = new SelectedPartParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.AttributeGroup"))
		{
			result = new AttributeGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.Relation"))
		{
			result = new RelationParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.WherePart"))
		{
			result = new WherePartParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.Right"))
		{
			result = new RightParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.Validator"))
		{
			result = new ValidatorParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.StoredproductForm"))
		{
			result = new StoredproductFormParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.DatabaseConnection"))
		{
			result = new DatabaseConnectionParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.ConnectTools"))
		{
			result = new ConnectToolsParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.BelongCollection"))
		{
			result = new BelongCollectionParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.VISchema"))
		{
			result = new VISchemaParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.Library"))
		{
			result = new LibraryParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.FormRelationGroup"))
		{
			result = new FormRelationGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.TemplateSet"))
		{
			result = new TemplateSetParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.DoActionSet"))
		{
			result = new DoActionSetParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.CannotBeNull"))
		{
			result = new CannotBeNullParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.ServiceActionTools"))
		{
			result = new ServiceActionToolsParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.SchemaConfigure"))
		{
			result = new SchemaConfigureParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.FormatChecker"))
		{
			result = new FormatCheckerParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.SQLSet"))
		{
			result = new SQLSetParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.ServiceConnectTools"))
		{
			result = new ServiceConnectToolsParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.BoundaryChecker"))
		{
			result = new BoundaryCheckerParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.ValueAttribute"))
		{
			result = new ValueAttributeParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.SqlLibrary"))
		{
			result = new SqlLibraryParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.OrderPart"))
		{
			result = new OrderPartParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.Define"))
		{
			result = new DefineParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.GetStatus"))
		{
			result = new GetStatusParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.ActionLibrary"))
		{
			result = new ActionLibraryParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.DataSet"))
		{
			result = new DataSetParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.ValidatorGroup"))
		{
			result = new ValidatorGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.FunctionTools"))
		{
			result = new FunctionToolsParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.FormLibrary"))
		{
			result = new FormLibraryParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.ServiceForm"))
		{
			result = new ServiceFormParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.GroupByPart"))
		{
			result = new GroupByPartParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.UpdateForm"))
		{
			result = new UpdateFormParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.VOSchema"))
		{
			result = new VOSchemaParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.FieldsPart"))
		{
			result = new FieldsPartParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.ViewForm"))
		{
			result = new ViewFormParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.Connection"))
		{
			result = new ConnectionParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.FieldGroup"))
		{
			result = new FieldGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.StatusGroup"))
		{
			result = new StatusGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.ServiceConnection"))
		{
			result = new ServiceConnectionParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.Field"))
		{
			result = new FieldParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.Status"))
		{
			result = new StatusParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.SchemaDefine"))
		{
			result = new SchemaDefineParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.Attribute"))
		{
			result = new AttributeParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.SimpleValue"))
		{
			result = new SimpleValueParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.DataTypeChecker"))
		{
			result = new DataTypeCheckerParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.Form"))
		{
			result = new FormParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.FormPartGroup"))
		{
			result = new FormPartGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.SelectForm"))
		{
			result = new SelectFormParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.LeRiFormsConnection"))
		{
			result = new LeRiFormsConnectionParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.FieldValue"))
		{
			result = new FieldValueParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.JSONFieldValue"))
		{
			result = new JSONFieldValueParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.FieldValueRelation"))
		{
			result = new FieldValueRelationParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.CanBeNull"))
		{
			result = new CanBeNullParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.DataForm"))
		{
			result = new DataFormParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.TableSet"))
		{
			result = new TableSetParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.ServiceField"))
		{
			result = new ServiceFieldParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.FieldsRelation"))
		{
			result = new FieldsRelationParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.SetStatus"))
		{
			result = new SetStatusParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.FormPart"))
		{
			result = new FormPartParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.Schema"))
		{
			result = new SchemaParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.RelationGroup"))
		{
			result = new RelationGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.InsertForm"))
		{
			result = new InsertFormParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.SchemaGroup"))
		{
			result = new SchemaGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.ReferenceLibrary"))
		{
			result = new ReferenceLibraryParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.ExtendMethodChecker"))
		{
			result = new ExtendMethodCheckerParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.FormSet"))
		{
			result = new FormSetParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.SchemaValue"))
		{
			result = new SchemaValueParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.JNDIConnection"))
		{
			result = new JNDIConnectionParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.FormRelation"))
		{
			result = new FormRelationParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.LibraryGroup"))
		{
			result = new LibraryGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.NoneBelongCollection"))
		{
			result = new NoneBelongCollectionParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.AttributeLibrary"))
		{
			result = new AttributeLibraryParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.FormGroup"))
		{
			result = new FormGroupParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.DeleteForm"))
		{
			result = new DeleteFormParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.TransactionForm"))
		{
			result = new TransactionFormParser(this);
		}
		else if( ob.getClass().getName().equals( "org.zml.data.vo.bind.Left"))
		{
			result = new LeftParser(this);
		}
		return result;
	}
	public IXmlVisitorParserable createXMLVisitorParserByElmentTypeName( String typeName )
	{
		IXmlVisitorParserable result = null;
		if( UtilTools.isNull(typeName) ) return result;
		String tmpTypeName = UtilTools.getTrim( typeName );
		if( tmpTypeName.equals( "org.zml.data.vo.bind.Define"))
		{
			result = new DefineParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.SchemaDefine"))
		{
			result = new SchemaDefineParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.SchemaConfigure"))
		{
			result = new SchemaConfigureParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.Schema"))
		{
			result = new SchemaParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.SchemaGroup"))
		{
			result = new SchemaGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.VOSchema"))
		{
			result = new VOSchemaParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.VISchema"))
		{
			result = new VISchemaParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.FormRelation"))
		{
			result = new FormRelationParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.FormRelationGroup"))
		{
			result = new FormRelationGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.LeRiFormsConnection"))
		{
			result = new LeRiFormsConnectionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.Form"))
		{
			result = new FormParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.FormGroup"))
		{
			result = new FormGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.ServiceForm"))
		{
			result = new ServiceFormParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.DataForm"))
		{
			result = new DataFormParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.SelectForm"))
		{
			result = new SelectFormParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.UpdateForm"))
		{
			result = new UpdateFormParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.InsertForm"))
		{
			result = new InsertFormParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.DeleteForm"))
		{
			result = new DeleteFormParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.StoredproductForm"))
		{
			result = new StoredproductFormParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.ViewForm"))
		{
			result = new ViewFormParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.Left"))
		{
			result = new LeftParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.Right"))
		{
			result = new RightParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.Relation"))
		{
			result = new RelationParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.RelationGroup"))
		{
			result = new RelationGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.FieldsRelation"))
		{
			result = new FieldsRelationParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.FieldValueRelation"))
		{
			result = new FieldValueRelationParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.TransactionForm"))
		{
			result = new TransactionFormParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.DataType"))
		{
			result = new DataTypeParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.TableRelation"))
		{
			result = new TableRelationParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.FieldLogical"))
		{
			result = new FieldLogicalParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.OperationLogical"))
		{
			result = new OperationLogicalParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.OrderDirection"))
		{
			result = new OrderDirectionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.SQLFunction"))
		{
			result = new SQLFunctionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.Field"))
		{
			result = new FieldParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.FieldGroup"))
		{
			result = new FieldGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.FieldValue"))
		{
			result = new FieldValueParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.SimpleValue"))
		{
			result = new SimpleValueParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.SchemaValue"))
		{
			result = new SchemaValueParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.JSONFieldValue"))
		{
			result = new JSONFieldValueParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.Status"))
		{
			result = new StatusParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.StatusGroup"))
		{
			result = new StatusGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.GetStatus"))
		{
			result = new GetStatusParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.SetStatus"))
		{
			result = new SetStatusParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.ServiceField"))
		{
			result = new ServiceFieldParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.FormPart"))
		{
			result = new FormPartParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.FormPartGroup"))
		{
			result = new FormPartGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.FieldsPart"))
		{
			result = new FieldsPartParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.SelectedPart"))
		{
			result = new SelectedPartParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.WherePart"))
		{
			result = new WherePartParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.GroupByPart"))
		{
			result = new GroupByPartParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.OrderPart"))
		{
			result = new OrderPartParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.Connection"))
		{
			result = new ConnectionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.DatabaseConnection"))
		{
			result = new DatabaseConnectionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.JNDIConnection"))
		{
			result = new JNDIConnectionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.ServiceConnection"))
		{
			result = new ServiceConnectionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.ConnectTools"))
		{
			result = new ConnectToolsParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.ServiceConnectTools"))
		{
			result = new ServiceConnectToolsParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.Attribute"))
		{
			result = new AttributeParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.AttributeGroup"))
		{
			result = new AttributeGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.ValueAttribute"))
		{
			result = new ValueAttributeParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.ActionTools"))
		{
			result = new ActionToolsParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.FunctionTools"))
		{
			result = new FunctionToolsParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.ServiceActionTools"))
		{
			result = new ServiceActionToolsParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.Library"))
		{
			result = new LibraryParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.LibraryGroup"))
		{
			result = new LibraryGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.FormLibrary"))
		{
			result = new FormLibraryParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.ReferenceLibrary"))
		{
			result = new ReferenceLibraryParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.SqlLibrary"))
		{
			result = new SqlLibraryParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.AttributeLibrary"))
		{
			result = new AttributeLibraryParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.ActionLibrary"))
		{
			result = new ActionLibraryParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.DataSet"))
		{
			result = new DataSetParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.TableSet"))
		{
			result = new TableSetParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.SQLSet"))
		{
			result = new SQLSetParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.FormSet"))
		{
			result = new FormSetParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.TemplateSet"))
		{
			result = new TemplateSetParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.DoActionSet"))
		{
			result = new DoActionSetParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.Validator"))
		{
			result = new ValidatorParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.ValidatorGroup"))
		{
			result = new ValidatorGroupParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.DataTypeChecker"))
		{
			result = new DataTypeCheckerParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.CanBeNull"))
		{
			result = new CanBeNullParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.CannotBeNull"))
		{
			result = new CannotBeNullParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.BelongCollection"))
		{
			result = new BelongCollectionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.NoneBelongCollection"))
		{
			result = new NoneBelongCollectionParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.BoundaryChecker"))
		{
			result = new BoundaryCheckerParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.FormatChecker"))
		{
			result = new FormatCheckerParser(this);
		}
		else if( tmpTypeName.equals( "org.zml.data.vo.bind.ExtendMethodChecker"))
		{
			result = new ExtendMethodCheckerParser(this);
		}
		return result;
	}
	public String getTypeNameForElement(String confElementName)
	{
		String result = "";
		if( UtilTools.isNull( confElementName ) ) return result;
		String tmpName = UTools.getTrim(confElementName);
		if(tmpName.equals("attribute"))
		{
			result = "org.zml.data.vo.bind.Attribute";
		}
		else if(tmpName.equals("storedproductForm"))
		{
			result = "org.zml.data.vo.bind.StoredproductForm";
		}
		else if(tmpName.equals("statusGroup"))
		{
			result = "org.zml.data.vo.bind.StatusGroup";
		}
		else if(tmpName.equals("serviceConnectTools"))
		{
			result = "org.zml.data.vo.bind.ServiceConnectTools";
		}
		else if(tmpName.equals("validatorGroup"))
		{
			result = "org.zml.data.vo.bind.ValidatorGroup";
		}
		else if(tmpName.equals("attributeGroup"))
		{
			result = "org.zml.data.vo.bind.AttributeGroup";
		}
		else if(tmpName.equals("status"))
		{
			result = "org.zml.data.vo.bind.Status";
		}
		else if(tmpName.equals("voSchema"))
		{
			result = "org.zml.data.vo.bind.VOSchema";
		}
		else if(tmpName.equals("viewForm"))
		{
			result = "org.zml.data.vo.bind.ViewForm";
		}
		else if(tmpName.equals("formGroup"))
		{
			result = "org.zml.data.vo.bind.FormGroup";
		}
		else if(tmpName.equals("extendMethodChecker"))
		{
			result = "org.zml.data.vo.bind.ExtendMethodChecker";
		}
		else if(tmpName.equals("formRelationGroup"))
		{
			result = "org.zml.data.vo.bind.FormRelationGroup";
		}
		else if(tmpName.equals("dataSet"))
		{
			result = "org.zml.data.vo.bind.DataSet";
		}
		else if(tmpName.equals("serviceForm"))
		{
			result = "org.zml.data.vo.bind.ServiceForm";
		}
		else if(tmpName.equals("formSet"))
		{
			result = "org.zml.data.vo.bind.FormSet";
		}
		else if(tmpName.equals("templateSet"))
		{
			result = "org.zml.data.vo.bind.TemplateSet";
		}
		else if(tmpName.equals("fieldGroup"))
		{
			result = "org.zml.data.vo.bind.FieldGroup";
		}
		else if(tmpName.equals("left"))
		{
			result = "org.zml.data.vo.bind.Left";
		}
		else if(tmpName.equals("libraryGroup"))
		{
			result = "org.zml.data.vo.bind.LibraryGroup";
		}
		else if(tmpName.equals("validator"))
		{
			result = "org.zml.data.vo.bind.Validator";
		}
		else if(tmpName.equals("getStatus"))
		{
			result = "org.zml.data.vo.bind.GetStatus";
		}
		else if(tmpName.equals("sqlSet"))
		{
			result = "org.zml.data.vo.bind.SQLSet";
		}
		else if(tmpName.equals("library"))
		{
			result = "org.zml.data.vo.bind.Library";
		}
		else if(tmpName.equals("actionLibrary"))
		{
			result = "org.zml.data.vo.bind.ActionLibrary";
		}
		else if(tmpName.equals("right"))
		{
			result = "org.zml.data.vo.bind.Right";
		}
		else if(tmpName.equals("fieldValue"))
		{
			result = "org.zml.data.vo.bind.FieldValue";
		}
		else if(tmpName.equals("serviceActionTools"))
		{
			result = "org.zml.data.vo.bind.ServiceActionTools";
		}
		else if(tmpName.equals("formPartGroup"))
		{
			result = "org.zml.data.vo.bind.FormPartGroup";
		}
		else if(tmpName.equals("fieldValueRelation"))
		{
			result = "org.zml.data.vo.bind.FieldValueRelation";
		}
		else if(tmpName.equals("valueAttribute"))
		{
			result = "org.zml.data.vo.bind.ValueAttribute";
		}
		else if(tmpName.equals("schemaGroup"))
		{
			result = "org.zml.data.vo.bind.SchemaGroup";
		}
		else if(tmpName.equals("belongCollection"))
		{
			result = "org.zml.data.vo.bind.BelongCollection";
		}
		else if(tmpName.equals("boundaryChecker"))
		{
			result = "org.zml.data.vo.bind.BoundaryChecker";
		}
		else if(tmpName.equals("serviceField"))
		{
			result = "org.zml.data.vo.bind.ServiceField";
		}
		else if(tmpName.equals("dataForm"))
		{
			result = "org.zml.data.vo.bind.DataForm";
		}
		else if(tmpName.equals("sqlLibrary"))
		{
			result = "org.zml.data.vo.bind.SqlLibrary";
		}
		else if(tmpName.equals("orderPart"))
		{
			result = "org.zml.data.vo.bind.OrderPart";
		}
		else if(tmpName.equals("selectedPart"))
		{
			result = "org.zml.data.vo.bind.SelectedPart";
		}
		else if(tmpName.equals("schemaValue"))
		{
			result = "org.zml.data.vo.bind.SchemaValue";
		}
		else if(tmpName.equals("schemaDefine"))
		{
			result = "org.zml.data.vo.bind.SchemaDefine";
		}
		else if(tmpName.equals("wherePart"))
		{
			result = "org.zml.data.vo.bind.WherePart";
		}
		else if(tmpName.equals("schemaConfigure"))
		{
			result = "org.zml.data.vo.bind.SchemaConfigure";
		}
		else if(tmpName.equals("referenceLibrary"))
		{
			result = "org.zml.data.vo.bind.ReferenceLibrary";
		}
		else if(tmpName.equals("cannotBeNull"))
		{
			result = "org.zml.data.vo.bind.CannotBeNull";
		}
		else if(tmpName.equals("jsonFieldValue"))
		{
			result = "org.zml.data.vo.bind.JSONFieldValue";
		}
		else if(tmpName.equals("attributeLibrary"))
		{
			result = "org.zml.data.vo.bind.AttributeLibrary";
		}
		else if(tmpName.equals("formRelation"))
		{
			result = "org.zml.data.vo.bind.FormRelation";
		}
		else if(tmpName.equals("connection"))
		{
			result = "org.zml.data.vo.bind.Connection";
		}
		else if(tmpName.equals("fieldsRelation"))
		{
			result = "org.zml.data.vo.bind.FieldsRelation";
		}
		else if(tmpName.equals("noneBelongCollection"))
		{
			result = "org.zml.data.vo.bind.NoneBelongCollection";
		}
		else if(tmpName.equals("functionTools"))
		{
			result = "org.zml.data.vo.bind.FunctionTools";
		}
		else if(tmpName.equals("field"))
		{
			result = "org.zml.data.vo.bind.Field";
		}
		else if(tmpName.equals("formLibrary"))
		{
			result = "org.zml.data.vo.bind.FormLibrary";
		}
		else if(tmpName.equals("simpleValue"))
		{
			result = "org.zml.data.vo.bind.SimpleValue";
		}
		else if(tmpName.equals("dataTypeChecker"))
		{
			result = "org.zml.data.vo.bind.DataTypeChecker";
		}
		else if(tmpName.equals("actionTools"))
		{
			result = "org.zml.data.vo.bind.ActionTools";
		}
		else if(tmpName.equals("form"))
		{
			result = "org.zml.data.vo.bind.Form";
		}
		else if(tmpName.equals("selectForm"))
		{
			result = "org.zml.data.vo.bind.SelectForm";
		}
		else if(tmpName.equals("viSchema"))
		{
			result = "org.zml.data.vo.bind.VISchema";
		}
		else if(tmpName.equals("fieldsPart"))
		{
			result = "org.zml.data.vo.bind.FieldsPart";
		}
		else if(tmpName.equals("tableSet"))
		{
			result = "org.zml.data.vo.bind.TableSet";
		}
		else if(tmpName.equals("insertForm"))
		{
			result = "org.zml.data.vo.bind.InsertForm";
		}
		else if(tmpName.equals("schema"))
		{
			result = "org.zml.data.vo.bind.Schema";
		}
		else if(tmpName.equals("connectTools"))
		{
			result = "org.zml.data.vo.bind.ConnectTools";
		}
		else if(tmpName.equals("canBeNull"))
		{
			result = "org.zml.data.vo.bind.CanBeNull";
		}
		else if(tmpName.equals("jndiConnection"))
		{
			result = "org.zml.data.vo.bind.JNDIConnection";
		}
		else if(tmpName.equals("serviceConnection"))
		{
			result = "org.zml.data.vo.bind.ServiceConnection";
		}
		else if(tmpName.equals("relation"))
		{
			result = "org.zml.data.vo.bind.Relation";
		}
		else if(tmpName.equals("leriFormsConnection"))
		{
			result = "org.zml.data.vo.bind.LeRiFormsConnection";
		}
		else if(tmpName.equals("relationGroup"))
		{
			result = "org.zml.data.vo.bind.RelationGroup";
		}
		else if(tmpName.equals("doActionSet"))
		{
			result = "org.zml.data.vo.bind.DoActionSet";
		}
		else if(tmpName.equals("updateForm"))
		{
			result = "org.zml.data.vo.bind.UpdateForm";
		}
		else if(tmpName.equals("define"))
		{
			result = "org.zml.data.vo.bind.Define";
		}
		else if(tmpName.equals("setStatus"))
		{
			result = "org.zml.data.vo.bind.SetStatus";
		}
		else if(tmpName.equals("databaseConnection"))
		{
			result = "org.zml.data.vo.bind.DatabaseConnection";
		}
		else if(tmpName.equals("transactionForm"))
		{
			result = "org.zml.data.vo.bind.TransactionForm";
		}
		else if(tmpName.equals("groupByPart"))
		{
			result = "org.zml.data.vo.bind.GroupByPart";
		}
		else if(tmpName.equals("formPart"))
		{
			result = "org.zml.data.vo.bind.FormPart";
		}
		return result;
	}
	public String getElementForType(String typeName)
	{
		String result = "";
		if( UtilTools.isNull( typeName ) ) return result;
		String tmpName = UTools.getTrim(typeName);
		if(tmpName.equals("org.zml.data.vo.bind.Attribute"))
		{
			result = "attribute";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.StoredproductForm"))
		{
			result = "storedproductForm";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.StatusGroup"))
		{
			result = "statusGroup";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.ServiceConnectTools"))
		{
			result = "serviceConnectTools";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.ValidatorGroup"))
		{
			result = "validatorGroup";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.AttributeGroup"))
		{
			result = "attributeGroup";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.Status"))
		{
			result = "status";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.VOSchema"))
		{
			result = "voSchema";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.ViewForm"))
		{
			result = "viewForm";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.FormGroup"))
		{
			result = "formGroup";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.ExtendMethodChecker"))
		{
			result = "extendMethodChecker";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.FormRelationGroup"))
		{
			result = "formRelationGroup";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.DataSet"))
		{
			result = "dataSet";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.ServiceForm"))
		{
			result = "serviceForm";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.FormSet"))
		{
			result = "formSet";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.TemplateSet"))
		{
			result = "templateSet";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.FieldGroup"))
		{
			result = "fieldGroup";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.Left"))
		{
			result = "left";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.LibraryGroup"))
		{
			result = "libraryGroup";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.Validator"))
		{
			result = "validator";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.GetStatus"))
		{
			result = "getStatus";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.SQLSet"))
		{
			result = "sqlSet";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.Library"))
		{
			result = "library";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.ActionLibrary"))
		{
			result = "actionLibrary";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.Right"))
		{
			result = "right";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.FieldValue"))
		{
			result = "fieldValue";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.ServiceActionTools"))
		{
			result = "serviceActionTools";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.FormPartGroup"))
		{
			result = "formPartGroup";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.FieldValueRelation"))
		{
			result = "fieldValueRelation";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.ValueAttribute"))
		{
			result = "valueAttribute";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.SchemaGroup"))
		{
			result = "schemaGroup";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.BelongCollection"))
		{
			result = "belongCollection";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.BoundaryChecker"))
		{
			result = "boundaryChecker";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.ServiceField"))
		{
			result = "serviceField";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.DataForm"))
		{
			result = "dataForm";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.SqlLibrary"))
		{
			result = "sqlLibrary";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.OrderPart"))
		{
			result = "orderPart";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.SelectedPart"))
		{
			result = "selectedPart";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.SchemaValue"))
		{
			result = "schemaValue";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.SchemaDefine"))
		{
			result = "schemaDefine";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.WherePart"))
		{
			result = "wherePart";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.SchemaConfigure"))
		{
			result = "schemaConfigure";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.ReferenceLibrary"))
		{
			result = "referenceLibrary";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.CannotBeNull"))
		{
			result = "cannotBeNull";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.JSONFieldValue"))
		{
			result = "jsonFieldValue";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.AttributeLibrary"))
		{
			result = "attributeLibrary";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.FormRelation"))
		{
			result = "formRelation";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.Connection"))
		{
			result = "connection";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.FieldsRelation"))
		{
			result = "fieldsRelation";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.NoneBelongCollection"))
		{
			result = "noneBelongCollection";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.FunctionTools"))
		{
			result = "functionTools";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.Field"))
		{
			result = "field";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.FormLibrary"))
		{
			result = "formLibrary";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.SimpleValue"))
		{
			result = "simpleValue";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.DataTypeChecker"))
		{
			result = "dataTypeChecker";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.ActionTools"))
		{
			result = "actionTools";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.Form"))
		{
			result = "form";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.SelectForm"))
		{
			result = "selectForm";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.VISchema"))
		{
			result = "viSchema";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.FieldsPart"))
		{
			result = "fieldsPart";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.TableSet"))
		{
			result = "tableSet";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.InsertForm"))
		{
			result = "insertForm";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.Schema"))
		{
			result = "schema";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.ConnectTools"))
		{
			result = "connectTools";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.CanBeNull"))
		{
			result = "canBeNull";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.JNDIConnection"))
		{
			result = "jndiConnection";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.ServiceConnection"))
		{
			result = "serviceConnection";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.Relation"))
		{
			result = "relation";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.LeRiFormsConnection"))
		{
			result = "leriFormsConnection";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.RelationGroup"))
		{
			result = "relationGroup";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.DoActionSet"))
		{
			result = "doActionSet";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.UpdateForm"))
		{
			result = "updateForm";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.Define"))
		{
			result = "define";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.SetStatus"))
		{
			result = "setStatus";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.DatabaseConnection"))
		{
			result = "databaseConnection";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.TransactionForm"))
		{
			result = "transactionForm";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.GroupByPart"))
		{
			result = "groupByPart";
		}
		else if(tmpName.equals("org.zml.data.vo.bind.FormPart"))
		{
			result = "formPart";
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