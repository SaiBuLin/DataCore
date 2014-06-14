package org.zml.data.vo.parser;
import org.zml.data.vo.bind.*;
import org.zml.tools.xml.parser.CTXMLElement;
public class SQLParserFactory
{
	public static SQLParserAble getQueryDefineInterpreter(CTXMLElement element) throws Exception
	{
		SQLParserAble result = null;
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
	private static SQLParserAble getQueryDefineInterpreterForNoEquals(CTXMLElement element) throws Exception
	{
		SQLParserAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		if( element instanceof FieldsRelation  )
		{
			result = new FieldsRelationSQLParser((FieldsRelation)element);
		}
		else if( element instanceof StatusGroup  )
		{
			result = new StatusGroupSQLParser((StatusGroup)element);
		}
		else if( element instanceof ServiceForm  )
		{
			result = new ServiceFormSQLParser((ServiceForm)element);
		}
		else if( element instanceof UpdateForm  )
		{
			result = new UpdateFormSQLParser((UpdateForm)element);
		}
		else if( element instanceof Form  )
		{
			result = new FormSQLParser((Form)element);
		}
		else if( element instanceof DataTypeChecker  )
		{
			result = new DataTypeCheckerSQLParser((DataTypeChecker)element);
		}
		else if( element instanceof Right  )
		{
			result = new RightSQLParser((Right)element);
		}
		else if( element instanceof FormLibrary  )
		{
			result = new FormLibrarySQLParser((FormLibrary)element);
		}
		else if( element instanceof JNDIConnection  )
		{
			result = new JNDIConnectionSQLParser((JNDIConnection)element);
		}
		else if( element instanceof Validator  )
		{
			result = new ValidatorSQLParser((Validator)element);
		}
		else if( element instanceof CanBeNull  )
		{
			result = new CanBeNullSQLParser((CanBeNull)element);
		}
		else if( element instanceof FormRelationGroup  )
		{
			result = new FormRelationGroupSQLParser((FormRelationGroup)element);
		}
		else if( element instanceof Connection  )
		{
			result = new ConnectionSQLParser((Connection)element);
		}
		else if( element instanceof Relation  )
		{
			result = new RelationSQLParser((Relation)element);
		}
		else if( element instanceof ConnectTools  )
		{
			result = new ConnectToolsSQLParser((ConnectTools)element);
		}
		else if( element instanceof Left  )
		{
			result = new LeftSQLParser((Left)element);
		}
		else if( element instanceof Parameter  )
		{
			result = new ParameterSQLParser((Parameter)element);
		}
		else if( element instanceof BelongCollection  )
		{
			result = new BelongCollectionSQLParser((BelongCollection)element);
		}
		else if( element instanceof SchemaValue  )
		{
			result = new SchemaValueSQLParser((SchemaValue)element);
		}
		else if( element instanceof FieldGroup  )
		{
			result = new FieldGroupSQLParser((FieldGroup)element);
		}
		else if( element instanceof ViewForm  )
		{
			result = new ViewFormSQLParser((ViewForm)element);
		}
		else if( element instanceof Library  )
		{
			result = new LibrarySQLParser((Library)element);
		}
		else if( element instanceof DeleteForm  )
		{
			result = new DeleteFormSQLParser((DeleteForm)element);
		}
		else if( element instanceof FieldValueRelation  )
		{
			result = new FieldValueRelationSQLParser((FieldValueRelation)element);
		}
		else if( element instanceof FormSet  )
		{
			result = new FormSetSQLParser((FormSet)element);
		}
		else if( element instanceof SimpleValue  )
		{
			result = new SimpleValueSQLParser((SimpleValue)element);
		}
		else if( element instanceof SelectForm  )
		{
			result = new SelectFormSQLParser((SelectForm)element);
		}
		else if( element instanceof Schema  )
		{
			result = new SchemaSQLParser((Schema)element);
		}
		else if( element instanceof TransactionForm  )
		{
			result = new TransactionFormSQLParser((TransactionForm)element);
		}
		else if( element instanceof DataSet  )
		{
			result = new DataSetSQLParser((DataSet)element);
		}
		else if( element instanceof SQLSet  )
		{
			result = new SQLSetSQLParser((SQLSet)element);
		}
		else if( element instanceof SchemaConfigure  )
		{
			result = new SchemaConfigureSQLParser((SchemaConfigure)element);
		}
		else if( element instanceof BoundaryChecker  )
		{
			result = new BoundaryCheckerSQLParser((BoundaryChecker)element);
		}
		else if( element instanceof DataForm  )
		{
			result = new DataFormSQLParser((DataForm)element);
		}
		else if( element instanceof Status  )
		{
			result = new StatusSQLParser((Status)element);
		}
		else if( element instanceof FunctionTools  )
		{
			result = new FunctionToolsSQLParser((FunctionTools)element);
		}
		else if( element instanceof SqlLibrary  )
		{
			result = new SqlLibrarySQLParser((SqlLibrary)element);
		}
		else if( element instanceof TableSet  )
		{
			result = new TableSetSQLParser((TableSet)element);
		}
		else if( element instanceof SchemaGroup  )
		{
			result = new SchemaGroupSQLParser((SchemaGroup)element);
		}
		else if( element instanceof FormGroup  )
		{
			result = new FormGroupSQLParser((FormGroup)element);
		}
		else if( element instanceof ReferenceLibrary  )
		{
			result = new ReferenceLibrarySQLParser((ReferenceLibrary)element);
		}
		else if( element instanceof Define  )
		{
			result = new DefineSQLParser((Define)element);
		}
		else if( element instanceof Attribute  )
		{
			result = new AttributeSQLParser((Attribute)element);
		}
		else if( element instanceof VOSchema  )
		{
			result = new VOSchemaSQLParser((VOSchema)element);
		}
		else if( element instanceof FormsRelation  )
		{
			result = new FormsRelationSQLParser((FormsRelation)element);
		}
		else if( element instanceof SetStatus  )
		{
			result = new SetStatusSQLParser((SetStatus)element);
		}
		else if( element instanceof ActionLibrary  )
		{
			result = new ActionLibrarySQLParser((ActionLibrary)element);
		}
		else if( element instanceof JSONFieldValue  )
		{
			result = new JSONFieldValueSQLParser((JSONFieldValue)element);
		}
		else if( element instanceof ActionTools  )
		{
			result = new ActionToolsSQLParser((ActionTools)element);
		}
		else if( element instanceof NoneBelongCollection  )
		{
			result = new NoneBelongCollectionSQLParser((NoneBelongCollection)element);
		}
		else if( element instanceof InsertForm  )
		{
			result = new InsertFormSQLParser((InsertForm)element);
		}
		else if( element instanceof FieldValue  )
		{
			result = new FieldValueSQLParser((FieldValue)element);
		}
		else if( element instanceof ExtendMethodChecker  )
		{
			result = new ExtendMethodCheckerSQLParser((ExtendMethodChecker)element);
		}
		else if( element instanceof StoredproductForm  )
		{
			result = new StoredproductFormSQLParser((StoredproductForm)element);
		}
		else if( element instanceof VISchema  )
		{
			result = new VISchemaSQLParser((VISchema)element);
		}
		else if( element instanceof AttributeLibrary  )
		{
			result = new AttributeLibrarySQLParser((AttributeLibrary)element);
		}
		else if( element instanceof Field  )
		{
			result = new FieldSQLParser((Field)element);
		}
		else if( element instanceof GetStatus  )
		{
			result = new GetStatusSQLParser((GetStatus)element);
		}
		else if( element instanceof ServiceActionTools  )
		{
			result = new ServiceActionToolsSQLParser((ServiceActionTools)element);
		}
		else if( element instanceof FormRelation  )
		{
			result = new FormRelationSQLParser((FormRelation)element);
		}
		else if( element instanceof ServiceConnection  )
		{
			result = new ServiceConnectionSQLParser((ServiceConnection)element);
		}
		else if( element instanceof AttributeGroup  )
		{
			result = new AttributeGroupSQLParser((AttributeGroup)element);
		}
		else if( element instanceof CannotBeNull  )
		{
			result = new CannotBeNullSQLParser((CannotBeNull)element);
		}
		else if( element instanceof FormatChecker  )
		{
			result = new FormatCheckerSQLParser((FormatChecker)element);
		}
		else if( element instanceof DatabaseConnection  )
		{
			result = new DatabaseConnectionSQLParser((DatabaseConnection)element);
		}
		else if( element instanceof DoActionSet  )
		{
			result = new DoActionSetSQLParser((DoActionSet)element);
		}
		else if( element instanceof LibraryGroup  )
		{
			result = new LibraryGroupSQLParser((LibraryGroup)element);
		}
		else if( element instanceof ServiceField  )
		{
			result = new ServiceFieldSQLParser((ServiceField)element);
		}
		else if( element instanceof ValidatorGroup  )
		{
			result = new ValidatorGroupSQLParser((ValidatorGroup)element);
		}
		else if( element instanceof ServiceConnectTools  )
		{
			result = new ServiceConnectToolsSQLParser((ServiceConnectTools)element);
		}
		else if( element instanceof TemplateSet  )
		{
			result = new TemplateSetSQLParser((TemplateSet)element);
		}
		else if( element instanceof RelationGroup  )
		{
			result = new RelationGroupSQLParser((RelationGroup)element);
		}
		else if( element instanceof SchemaDefine  )
		{
			result = new SchemaDefineSQLParser((SchemaDefine)element);
		}
		return result;
	}
	private static SQLParserAble getQueryDefineInterpreterIndicateClsName(CTXMLElement element) throws Exception
	{
		SQLParserAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		String tmpElementClassName = element.getClass().getName();
		if( tmpElementClassName.equals(  FieldsRelation.class.getName())  )
		{
			result = new FieldsRelationSQLParser((FieldsRelation)element);
		}
		else if( tmpElementClassName.equals(  StatusGroup.class.getName())  )
		{
			result = new StatusGroupSQLParser((StatusGroup)element);
		}
		else if( tmpElementClassName.equals(  ServiceForm.class.getName())  )
		{
			result = new ServiceFormSQLParser((ServiceForm)element);
		}
		else if( tmpElementClassName.equals(  UpdateForm.class.getName())  )
		{
			result = new UpdateFormSQLParser((UpdateForm)element);
		}
		else if( tmpElementClassName.equals(  Form.class.getName())  )
		{
			result = new FormSQLParser((Form)element);
		}
		else if( tmpElementClassName.equals(  DataTypeChecker.class.getName())  )
		{
			result = new DataTypeCheckerSQLParser((DataTypeChecker)element);
		}
		else if( tmpElementClassName.equals(  Right.class.getName())  )
		{
			result = new RightSQLParser((Right)element);
		}
		else if( tmpElementClassName.equals(  FormLibrary.class.getName())  )
		{
			result = new FormLibrarySQLParser((FormLibrary)element);
		}
		else if( tmpElementClassName.equals(  JNDIConnection.class.getName())  )
		{
			result = new JNDIConnectionSQLParser((JNDIConnection)element);
		}
		else if( tmpElementClassName.equals(  Validator.class.getName())  )
		{
			result = new ValidatorSQLParser((Validator)element);
		}
		else if( tmpElementClassName.equals(  CanBeNull.class.getName())  )
		{
			result = new CanBeNullSQLParser((CanBeNull)element);
		}
		else if( tmpElementClassName.equals(  FormRelationGroup.class.getName())  )
		{
			result = new FormRelationGroupSQLParser((FormRelationGroup)element);
		}
		else if( tmpElementClassName.equals(  Connection.class.getName())  )
		{
			result = new ConnectionSQLParser((Connection)element);
		}
		else if( tmpElementClassName.equals(  Relation.class.getName())  )
		{
			result = new RelationSQLParser((Relation)element);
		}
		else if( tmpElementClassName.equals(  ConnectTools.class.getName())  )
		{
			result = new ConnectToolsSQLParser((ConnectTools)element);
		}
		else if( tmpElementClassName.equals(  Left.class.getName())  )
		{
			result = new LeftSQLParser((Left)element);
		}
		else if( tmpElementClassName.equals(  Parameter.class.getName())  )
		{
			result = new ParameterSQLParser((Parameter)element);
		}
		else if( tmpElementClassName.equals(  BelongCollection.class.getName())  )
		{
			result = new BelongCollectionSQLParser((BelongCollection)element);
		}
		else if( tmpElementClassName.equals(  SchemaValue.class.getName())  )
		{
			result = new SchemaValueSQLParser((SchemaValue)element);
		}
		else if( tmpElementClassName.equals(  FieldGroup.class.getName())  )
		{
			result = new FieldGroupSQLParser((FieldGroup)element);
		}
		else if( tmpElementClassName.equals(  ViewForm.class.getName())  )
		{
			result = new ViewFormSQLParser((ViewForm)element);
		}
		else if( tmpElementClassName.equals(  Library.class.getName())  )
		{
			result = new LibrarySQLParser((Library)element);
		}
		else if( tmpElementClassName.equals(  DeleteForm.class.getName())  )
		{
			result = new DeleteFormSQLParser((DeleteForm)element);
		}
		else if( tmpElementClassName.equals(  FieldValueRelation.class.getName())  )
		{
			result = new FieldValueRelationSQLParser((FieldValueRelation)element);
		}
		else if( tmpElementClassName.equals(  FormSet.class.getName())  )
		{
			result = new FormSetSQLParser((FormSet)element);
		}
		else if( tmpElementClassName.equals(  SimpleValue.class.getName())  )
		{
			result = new SimpleValueSQLParser((SimpleValue)element);
		}
		else if( tmpElementClassName.equals(  SelectForm.class.getName())  )
		{
			result = new SelectFormSQLParser((SelectForm)element);
		}
		else if( tmpElementClassName.equals(  Schema.class.getName())  )
		{
			result = new SchemaSQLParser((Schema)element);
		}
		else if( tmpElementClassName.equals(  TransactionForm.class.getName())  )
		{
			result = new TransactionFormSQLParser((TransactionForm)element);
		}
		else if( tmpElementClassName.equals(  DataSet.class.getName())  )
		{
			result = new DataSetSQLParser((DataSet)element);
		}
		else if( tmpElementClassName.equals(  SQLSet.class.getName())  )
		{
			result = new SQLSetSQLParser((SQLSet)element);
		}
		else if( tmpElementClassName.equals(  SchemaConfigure.class.getName())  )
		{
			result = new SchemaConfigureSQLParser((SchemaConfigure)element);
		}
		else if( tmpElementClassName.equals(  BoundaryChecker.class.getName())  )
		{
			result = new BoundaryCheckerSQLParser((BoundaryChecker)element);
		}
		else if( tmpElementClassName.equals(  DataForm.class.getName())  )
		{
			result = new DataFormSQLParser((DataForm)element);
		}
		else if( tmpElementClassName.equals(  Status.class.getName())  )
		{
			result = new StatusSQLParser((Status)element);
		}
		else if( tmpElementClassName.equals(  FunctionTools.class.getName())  )
		{
			result = new FunctionToolsSQLParser((FunctionTools)element);
		}
		else if( tmpElementClassName.equals(  SqlLibrary.class.getName())  )
		{
			result = new SqlLibrarySQLParser((SqlLibrary)element);
		}
		else if( tmpElementClassName.equals(  TableSet.class.getName())  )
		{
			result = new TableSetSQLParser((TableSet)element);
		}
		else if( tmpElementClassName.equals(  SchemaGroup.class.getName())  )
		{
			result = new SchemaGroupSQLParser((SchemaGroup)element);
		}
		else if( tmpElementClassName.equals(  FormGroup.class.getName())  )
		{
			result = new FormGroupSQLParser((FormGroup)element);
		}
		else if( tmpElementClassName.equals(  ReferenceLibrary.class.getName())  )
		{
			result = new ReferenceLibrarySQLParser((ReferenceLibrary)element);
		}
		else if( tmpElementClassName.equals(  Define.class.getName())  )
		{
			result = new DefineSQLParser((Define)element);
		}
		else if( tmpElementClassName.equals(  Attribute.class.getName())  )
		{
			result = new AttributeSQLParser((Attribute)element);
		}
		else if( tmpElementClassName.equals(  VOSchema.class.getName())  )
		{
			result = new VOSchemaSQLParser((VOSchema)element);
		}
		else if( tmpElementClassName.equals(  FormsRelation.class.getName())  )
		{
			result = new FormsRelationSQLParser((FormsRelation)element);
		}
		else if( tmpElementClassName.equals(  SetStatus.class.getName())  )
		{
			result = new SetStatusSQLParser((SetStatus)element);
		}
		else if( tmpElementClassName.equals(  ActionLibrary.class.getName())  )
		{
			result = new ActionLibrarySQLParser((ActionLibrary)element);
		}
		else if( tmpElementClassName.equals(  JSONFieldValue.class.getName())  )
		{
			result = new JSONFieldValueSQLParser((JSONFieldValue)element);
		}
		else if( tmpElementClassName.equals(  ActionTools.class.getName())  )
		{
			result = new ActionToolsSQLParser((ActionTools)element);
		}
		else if( tmpElementClassName.equals(  NoneBelongCollection.class.getName())  )
		{
			result = new NoneBelongCollectionSQLParser((NoneBelongCollection)element);
		}
		else if( tmpElementClassName.equals(  InsertForm.class.getName())  )
		{
			result = new InsertFormSQLParser((InsertForm)element);
		}
		else if( tmpElementClassName.equals(  FieldValue.class.getName())  )
		{
			result = new FieldValueSQLParser((FieldValue)element);
		}
		else if( tmpElementClassName.equals(  ExtendMethodChecker.class.getName())  )
		{
			result = new ExtendMethodCheckerSQLParser((ExtendMethodChecker)element);
		}
		else if( tmpElementClassName.equals(  StoredproductForm.class.getName())  )
		{
			result = new StoredproductFormSQLParser((StoredproductForm)element);
		}
		else if( tmpElementClassName.equals(  VISchema.class.getName())  )
		{
			result = new VISchemaSQLParser((VISchema)element);
		}
		else if( tmpElementClassName.equals(  AttributeLibrary.class.getName())  )
		{
			result = new AttributeLibrarySQLParser((AttributeLibrary)element);
		}
		else if( tmpElementClassName.equals(  Field.class.getName())  )
		{
			result = new FieldSQLParser((Field)element);
		}
		else if( tmpElementClassName.equals(  GetStatus.class.getName())  )
		{
			result = new GetStatusSQLParser((GetStatus)element);
		}
		else if( tmpElementClassName.equals(  ServiceActionTools.class.getName())  )
		{
			result = new ServiceActionToolsSQLParser((ServiceActionTools)element);
		}
		else if( tmpElementClassName.equals(  FormRelation.class.getName())  )
		{
			result = new FormRelationSQLParser((FormRelation)element);
		}
		else if( tmpElementClassName.equals(  ServiceConnection.class.getName())  )
		{
			result = new ServiceConnectionSQLParser((ServiceConnection)element);
		}
		else if( tmpElementClassName.equals(  AttributeGroup.class.getName())  )
		{
			result = new AttributeGroupSQLParser((AttributeGroup)element);
		}
		else if( tmpElementClassName.equals(  CannotBeNull.class.getName())  )
		{
			result = new CannotBeNullSQLParser((CannotBeNull)element);
		}
		else if( tmpElementClassName.equals(  FormatChecker.class.getName())  )
		{
			result = new FormatCheckerSQLParser((FormatChecker)element);
		}
		else if( tmpElementClassName.equals(  DatabaseConnection.class.getName())  )
		{
			result = new DatabaseConnectionSQLParser((DatabaseConnection)element);
		}
		else if( tmpElementClassName.equals(  DoActionSet.class.getName())  )
		{
			result = new DoActionSetSQLParser((DoActionSet)element);
		}
		else if( tmpElementClassName.equals(  LibraryGroup.class.getName())  )
		{
			result = new LibraryGroupSQLParser((LibraryGroup)element);
		}
		else if( tmpElementClassName.equals(  ServiceField.class.getName())  )
		{
			result = new ServiceFieldSQLParser((ServiceField)element);
		}
		else if( tmpElementClassName.equals(  ValidatorGroup.class.getName())  )
		{
			result = new ValidatorGroupSQLParser((ValidatorGroup)element);
		}
		else if( tmpElementClassName.equals(  ServiceConnectTools.class.getName())  )
		{
			result = new ServiceConnectToolsSQLParser((ServiceConnectTools)element);
		}
		else if( tmpElementClassName.equals(  TemplateSet.class.getName())  )
		{
			result = new TemplateSetSQLParser((TemplateSet)element);
		}
		else if( tmpElementClassName.equals(  RelationGroup.class.getName())  )
		{
			result = new RelationGroupSQLParser((RelationGroup)element);
		}
		else if( tmpElementClassName.equals(  SchemaDefine.class.getName())  )
		{
			result = new SchemaDefineSQLParser((SchemaDefine)element);
		}
		return result;
	}
}