package org.zml.schema.parser.sql;
import org.zml.schema.bind.*;
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
		if( element instanceof DataService  )
		{
			result = new DataServiceSQLParser((DataService)element);
		}
		else if( element instanceof Update  )
		{
			result = new UpdateSQLParser((Update)element);
		}
		else if( element instanceof AttributeGroup  )
		{
			result = new AttributeGroupSQLParser((AttributeGroup)element);
		}
		else if( element instanceof Form  )
		{
			result = new FormSQLParser((Form)element);
		}
		else if( element instanceof ExpressGroup  )
		{
			result = new ExpressGroupSQLParser((ExpressGroup)element);
		}
		else if( element instanceof FieldsExpress  )
		{
			result = new FieldsExpressSQLParser((FieldsExpress)element);
		}
		else if( element instanceof Query  )
		{
			result = new QuerySQLParser((Query)element);
		}
		else if( element instanceof RightOuterJoin  )
		{
			result = new RightOuterJoinSQLParser((RightOuterJoin)element);
		}
		else if( element instanceof Parameter  )
		{
			result = new ParameterSQLParser((Parameter)element);
		}
		else if( element instanceof Relation  )
		{
			result = new RelationSQLParser((Relation)element);
		}
		else if( element instanceof LeftOuterJoin  )
		{
			result = new LeftOuterJoinSQLParser((LeftOuterJoin)element);
		}
		else if( element instanceof Express  )
		{
			result = new ExpressSQLParser((Express)element);
		}
		else if( element instanceof Service  )
		{
			result = new ServiceSQLParser((Service)element);
		}
		else if( element instanceof Library  )
		{
			result = new LibrarySQLParser((Library)element);
		}
		else if( element instanceof Transaction  )
		{
			result = new TransactionSQLParser((Transaction)element);
		}
		else if( element instanceof Schema  )
		{
			result = new SchemaSQLParser((Schema)element);
		}
		else if( element instanceof Delete  )
		{
			result = new DeleteSQLParser((Delete)element);
		}
		else if( element instanceof SchemaConfigure  )
		{
			result = new SchemaConfigureSQLParser((SchemaConfigure)element);
		}
		else if( element instanceof SqlLibrary  )
		{
			result = new SqlLibrarySQLParser((SqlLibrary)element);
		}
		else if( element instanceof View  )
		{
			result = new ViewSQLParser((View)element);
		}
		else if( element instanceof FormLibrary  )
		{
			result = new FormLibrarySQLParser((FormLibrary)element);
		}
		else if( element instanceof Insert  )
		{
			result = new InsertSQLParser((Insert)element);
		}
		else if( element instanceof ReferenceLibrary  )
		{
			result = new ReferenceLibrarySQLParser((ReferenceLibrary)element);
		}
		else if( element instanceof InnerJoin  )
		{
			result = new InnerJoinSQLParser((InnerJoin)element);
		}
		else if( element instanceof Define  )
		{
			result = new DefineSQLParser((Define)element);
		}
		else if( element instanceof Command  )
		{
			result = new CommandSQLParser((Command)element);
		}
		else if( element instanceof Attribute  )
		{
			result = new AttributeSQLParser((Attribute)element);
		}
		else if( element instanceof SchemaGroup  )
		{
			result = new SchemaGroupSQLParser((SchemaGroup)element);
		}
		else if( element instanceof Field  )
		{
			result = new FieldSQLParser((Field)element);
		}
		else if( element instanceof FieldGroup  )
		{
			result = new FieldGroupSQLParser((FieldGroup)element);
		}
		else if( element instanceof Factory  )
		{
			result = new FactorySQLParser((Factory)element);
		}
		else if( element instanceof AttributeLibrary  )
		{
			result = new AttributeLibrarySQLParser((AttributeLibrary)element);
		}
		else if( element instanceof RelationGroup  )
		{
			result = new RelationGroupSQLParser((RelationGroup)element);
		}
		else if( element instanceof NoneExists  )
		{
			result = new NoneExistsSQLParser((NoneExists)element);
		}
		else if( element instanceof Exists  )
		{
			result = new ExistsSQLParser((Exists)element);
		}
		else if( element instanceof FieldValueExpress  )
		{
			result = new FieldValueExpressSQLParser((FieldValueExpress)element);
		}
		else if( element instanceof Filter  )
		{
			result = new FilterSQLParser((Filter)element);
		}
		else if( element instanceof ViewRelation  )
		{
			result = new ViewRelationSQLParser((ViewRelation)element);
		}
		else if( element instanceof LibraryGroup  )
		{
			result = new LibraryGroupSQLParser((LibraryGroup)element);
		}
		else if( element instanceof ServiceField  )
		{
			result = new ServiceFieldSQLParser((ServiceField)element);
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
		if( tmpElementClassName.equals(  DataService.class.getName())  )
		{
			result = new DataServiceSQLParser((DataService)element);
		}
		else if( tmpElementClassName.equals(  Update.class.getName())  )
		{
			result = new UpdateSQLParser((Update)element);
		}
		else if( tmpElementClassName.equals(  AttributeGroup.class.getName())  )
		{
			result = new AttributeGroupSQLParser((AttributeGroup)element);
		}
		else if( tmpElementClassName.equals(  Form.class.getName())  )
		{
			result = new FormSQLParser((Form)element);
		}
		else if( tmpElementClassName.equals(  ExpressGroup.class.getName())  )
		{
			result = new ExpressGroupSQLParser((ExpressGroup)element);
		}
		else if( tmpElementClassName.equals(  FieldsExpress.class.getName())  )
		{
			result = new FieldsExpressSQLParser((FieldsExpress)element);
		}
		else if( tmpElementClassName.equals(  Query.class.getName())  )
		{
			result = new QuerySQLParser((Query)element);
		}
		else if( tmpElementClassName.equals(  RightOuterJoin.class.getName())  )
		{
			result = new RightOuterJoinSQLParser((RightOuterJoin)element);
		}
		else if( tmpElementClassName.equals(  Parameter.class.getName())  )
		{
			result = new ParameterSQLParser((Parameter)element);
		}
		else if( tmpElementClassName.equals(  Relation.class.getName())  )
		{
			result = new RelationSQLParser((Relation)element);
		}
		else if( tmpElementClassName.equals(  LeftOuterJoin.class.getName())  )
		{
			result = new LeftOuterJoinSQLParser((LeftOuterJoin)element);
		}
		else if( tmpElementClassName.equals(  Express.class.getName())  )
		{
			result = new ExpressSQLParser((Express)element);
		}
		else if( tmpElementClassName.equals(  Service.class.getName())  )
		{
			result = new ServiceSQLParser((Service)element);
		}
		else if( tmpElementClassName.equals(  Library.class.getName())  )
		{
			result = new LibrarySQLParser((Library)element);
		}
		else if( tmpElementClassName.equals(  Transaction.class.getName())  )
		{
			result = new TransactionSQLParser((Transaction)element);
		}
		else if( tmpElementClassName.equals(  Schema.class.getName())  )
		{
			result = new SchemaSQLParser((Schema)element);
		}
		else if( tmpElementClassName.equals(  Delete.class.getName())  )
		{
			result = new DeleteSQLParser((Delete)element);
		}
		else if( tmpElementClassName.equals(  SchemaConfigure.class.getName())  )
		{
			result = new SchemaConfigureSQLParser((SchemaConfigure)element);
		}
		else if( tmpElementClassName.equals(  SqlLibrary.class.getName())  )
		{
			result = new SqlLibrarySQLParser((SqlLibrary)element);
		}
		else if( tmpElementClassName.equals(  View.class.getName())  )
		{
			result = new ViewSQLParser((View)element);
		}
		else if( tmpElementClassName.equals(  FormLibrary.class.getName())  )
		{
			result = new FormLibrarySQLParser((FormLibrary)element);
		}
		else if( tmpElementClassName.equals(  Insert.class.getName())  )
		{
			result = new InsertSQLParser((Insert)element);
		}
		else if( tmpElementClassName.equals(  ReferenceLibrary.class.getName())  )
		{
			result = new ReferenceLibrarySQLParser((ReferenceLibrary)element);
		}
		else if( tmpElementClassName.equals(  InnerJoin.class.getName())  )
		{
			result = new InnerJoinSQLParser((InnerJoin)element);
		}
		else if( tmpElementClassName.equals(  Define.class.getName())  )
		{
			result = new DefineSQLParser((Define)element);
		}
		else if( tmpElementClassName.equals(  Command.class.getName())  )
		{
			result = new CommandSQLParser((Command)element);
		}
		else if( tmpElementClassName.equals(  Attribute.class.getName())  )
		{
			result = new AttributeSQLParser((Attribute)element);
		}
		else if( tmpElementClassName.equals(  SchemaGroup.class.getName())  )
		{
			result = new SchemaGroupSQLParser((SchemaGroup)element);
		}
		else if( tmpElementClassName.equals(  Field.class.getName())  )
		{
			result = new FieldSQLParser((Field)element);
		}
		else if( tmpElementClassName.equals(  FieldGroup.class.getName())  )
		{
			result = new FieldGroupSQLParser((FieldGroup)element);
		}
		else if( tmpElementClassName.equals(  Factory.class.getName())  )
		{
			result = new FactorySQLParser((Factory)element);
		}
		else if( tmpElementClassName.equals(  AttributeLibrary.class.getName())  )
		{
			result = new AttributeLibrarySQLParser((AttributeLibrary)element);
		}
		else if( tmpElementClassName.equals(  RelationGroup.class.getName())  )
		{
			result = new RelationGroupSQLParser((RelationGroup)element);
		}
		else if( tmpElementClassName.equals(  NoneExists.class.getName())  )
		{
			result = new NoneExistsSQLParser((NoneExists)element);
		}
		else if( tmpElementClassName.equals(  Exists.class.getName())  )
		{
			result = new ExistsSQLParser((Exists)element);
		}
		else if( tmpElementClassName.equals(  FieldValueExpress.class.getName())  )
		{
			result = new FieldValueExpressSQLParser((FieldValueExpress)element);
		}
		else if( tmpElementClassName.equals(  Filter.class.getName())  )
		{
			result = new FilterSQLParser((Filter)element);
		}
		else if( tmpElementClassName.equals(  ViewRelation.class.getName())  )
		{
			result = new ViewRelationSQLParser((ViewRelation)element);
		}
		else if( tmpElementClassName.equals(  LibraryGroup.class.getName())  )
		{
			result = new LibraryGroupSQLParser((LibraryGroup)element);
		}
		else if( tmpElementClassName.equals(  ServiceField.class.getName())  )
		{
			result = new ServiceFieldSQLParser((ServiceField)element);
		}
		else if( tmpElementClassName.equals(  SchemaDefine.class.getName())  )
		{
			result = new SchemaDefineSQLParser((SchemaDefine)element);
		}
		return result;
	}
}