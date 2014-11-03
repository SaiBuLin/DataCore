package org.zml.schema.parser.olap;
import org.zml.schema.bind.*;
import org.zml.tools.xml.parser.CTXMLElement;
public class OlapParserFactory
{
	public static OlapParserAble getQueryDefineInterpreter(CTXMLElement element) throws Exception
	{
		OlapParserAble result = null;
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
	private static OlapParserAble getQueryDefineInterpreterForNoEquals(CTXMLElement element) throws Exception
	{
		OlapParserAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		if( element instanceof DataService  )
		{
			result = new DataServiceOlapParser((DataService)element);
		}
		else if( element instanceof Update  )
		{
			result = new UpdateOlapParser((Update)element);
		}
		else if( element instanceof AttributeGroup  )
		{
			result = new AttributeGroupOlapParser((AttributeGroup)element);
		}
		else if( element instanceof Form  )
		{
			result = new FormOlapParser((Form)element);
		}
		else if( element instanceof ExpressGroup  )
		{
			result = new ExpressGroupOlapParser((ExpressGroup)element);
		}
		else if( element instanceof FieldsExpress  )
		{
			result = new FieldsExpressOlapParser((FieldsExpress)element);
		}
		else if( element instanceof Query  )
		{
			result = new QueryOlapParser((Query)element);
		}
		else if( element instanceof RightOuterJoin  )
		{
			result = new RightOuterJoinOlapParser((RightOuterJoin)element);
		}
		else if( element instanceof Parameter  )
		{
			result = new ParameterOlapParser((Parameter)element);
		}
		else if( element instanceof Relation  )
		{
			result = new RelationOlapParser((Relation)element);
		}
		else if( element instanceof LeftOuterJoin  )
		{
			result = new LeftOuterJoinOlapParser((LeftOuterJoin)element);
		}
		else if( element instanceof Express  )
		{
			result = new ExpressOlapParser((Express)element);
		}
		else if( element instanceof Service  )
		{
			result = new ServiceOlapParser((Service)element);
		}
		else if( element instanceof Library  )
		{
			result = new LibraryOlapParser((Library)element);
		}
		else if( element instanceof PageFactory  )
		{
			result = new PageFactoryOlapParser((PageFactory)element);
		}
		else if( element instanceof Transaction  )
		{
			result = new TransactionOlapParser((Transaction)element);
		}
		else if( element instanceof Schema  )
		{
			result = new SchemaOlapParser((Schema)element);
		}
		else if( element instanceof Delete  )
		{
			result = new DeleteOlapParser((Delete)element);
		}
		else if( element instanceof SchemaConfigure  )
		{
			result = new SchemaConfigureOlapParser((SchemaConfigure)element);
		}
		else if( element instanceof SqlLibrary  )
		{
			result = new SqlLibraryOlapParser((SqlLibrary)element);
		}
		else if( element instanceof View  )
		{
			result = new ViewOlapParser((View)element);
		}
		else if( element instanceof FormLibrary  )
		{
			result = new FormLibraryOlapParser((FormLibrary)element);
		}
		else if( element instanceof Insert  )
		{
			result = new InsertOlapParser((Insert)element);
		}
		else if( element instanceof ReferenceLibrary  )
		{
			result = new ReferenceLibraryOlapParser((ReferenceLibrary)element);
		}
		else if( element instanceof InnerJoin  )
		{
			result = new InnerJoinOlapParser((InnerJoin)element);
		}
		else if( element instanceof Define  )
		{
			result = new DefineOlapParser((Define)element);
		}
		else if( element instanceof Command  )
		{
			result = new CommandOlapParser((Command)element);
		}
		else if( element instanceof Attribute  )
		{
			result = new AttributeOlapParser((Attribute)element);
		}
		else if( element instanceof SchemaGroup  )
		{
			result = new SchemaGroupOlapParser((SchemaGroup)element);
		}
		else if( element instanceof Field  )
		{
			result = new FieldOlapParser((Field)element);
		}
		else if( element instanceof FieldGroup  )
		{
			result = new FieldGroupOlapParser((FieldGroup)element);
		}
		else if( element instanceof Factory  )
		{
			result = new FactoryOlapParser((Factory)element);
		}
		else if( element instanceof AttributeLibrary  )
		{
			result = new AttributeLibraryOlapParser((AttributeLibrary)element);
		}
		else if( element instanceof RelationGroup  )
		{
			result = new RelationGroupOlapParser((RelationGroup)element);
		}
		else if( element instanceof NoneExists  )
		{
			result = new NoneExistsOlapParser((NoneExists)element);
		}
		else if( element instanceof Exists  )
		{
			result = new ExistsOlapParser((Exists)element);
		}
		else if( element instanceof FieldValueExpress  )
		{
			result = new FieldValueExpressOlapParser((FieldValueExpress)element);
		}
		else if( element instanceof Filter  )
		{
			result = new FilterOlapParser((Filter)element);
		}
		else if( element instanceof ViewRelation  )
		{
			result = new ViewRelationOlapParser((ViewRelation)element);
		}
		else if( element instanceof LibraryGroup  )
		{
			result = new LibraryGroupOlapParser((LibraryGroup)element);
		}
		else if( element instanceof ServiceField  )
		{
			result = new ServiceFieldOlapParser((ServiceField)element);
		}
		else if( element instanceof SchemaDefine  )
		{
			result = new SchemaDefineOlapParser((SchemaDefine)element);
		}
		return result;
	}
	private static OlapParserAble getQueryDefineInterpreterIndicateClsName(CTXMLElement element) throws Exception
	{
		OlapParserAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		String tmpElementClassName = element.getClass().getName();
		if( tmpElementClassName.equals(  DataService.class.getName())  )
		{
			result = new DataServiceOlapParser((DataService)element);
		}
		else if( tmpElementClassName.equals(  Update.class.getName())  )
		{
			result = new UpdateOlapParser((Update)element);
		}
		else if( tmpElementClassName.equals(  AttributeGroup.class.getName())  )
		{
			result = new AttributeGroupOlapParser((AttributeGroup)element);
		}
		else if( tmpElementClassName.equals(  Form.class.getName())  )
		{
			result = new FormOlapParser((Form)element);
		}
		else if( tmpElementClassName.equals(  ExpressGroup.class.getName())  )
		{
			result = new ExpressGroupOlapParser((ExpressGroup)element);
		}
		else if( tmpElementClassName.equals(  FieldsExpress.class.getName())  )
		{
			result = new FieldsExpressOlapParser((FieldsExpress)element);
		}
		else if( tmpElementClassName.equals(  Query.class.getName())  )
		{
			result = new QueryOlapParser((Query)element);
		}
		else if( tmpElementClassName.equals(  RightOuterJoin.class.getName())  )
		{
			result = new RightOuterJoinOlapParser((RightOuterJoin)element);
		}
		else if( tmpElementClassName.equals(  Parameter.class.getName())  )
		{
			result = new ParameterOlapParser((Parameter)element);
		}
		else if( tmpElementClassName.equals(  Relation.class.getName())  )
		{
			result = new RelationOlapParser((Relation)element);
		}
		else if( tmpElementClassName.equals(  LeftOuterJoin.class.getName())  )
		{
			result = new LeftOuterJoinOlapParser((LeftOuterJoin)element);
		}
		else if( tmpElementClassName.equals(  Express.class.getName())  )
		{
			result = new ExpressOlapParser((Express)element);
		}
		else if( tmpElementClassName.equals(  Service.class.getName())  )
		{
			result = new ServiceOlapParser((Service)element);
		}
		else if( tmpElementClassName.equals(  Library.class.getName())  )
		{
			result = new LibraryOlapParser((Library)element);
		}
		else if( tmpElementClassName.equals(  PageFactory.class.getName())  )
		{
			result = new PageFactoryOlapParser((PageFactory)element);
		}
		else if( tmpElementClassName.equals(  Transaction.class.getName())  )
		{
			result = new TransactionOlapParser((Transaction)element);
		}
		else if( tmpElementClassName.equals(  Schema.class.getName())  )
		{
			result = new SchemaOlapParser((Schema)element);
		}
		else if( tmpElementClassName.equals(  Delete.class.getName())  )
		{
			result = new DeleteOlapParser((Delete)element);
		}
		else if( tmpElementClassName.equals(  SchemaConfigure.class.getName())  )
		{
			result = new SchemaConfigureOlapParser((SchemaConfigure)element);
		}
		else if( tmpElementClassName.equals(  SqlLibrary.class.getName())  )
		{
			result = new SqlLibraryOlapParser((SqlLibrary)element);
		}
		else if( tmpElementClassName.equals(  View.class.getName())  )
		{
			result = new ViewOlapParser((View)element);
		}
		else if( tmpElementClassName.equals(  FormLibrary.class.getName())  )
		{
			result = new FormLibraryOlapParser((FormLibrary)element);
		}
		else if( tmpElementClassName.equals(  Insert.class.getName())  )
		{
			result = new InsertOlapParser((Insert)element);
		}
		else if( tmpElementClassName.equals(  ReferenceLibrary.class.getName())  )
		{
			result = new ReferenceLibraryOlapParser((ReferenceLibrary)element);
		}
		else if( tmpElementClassName.equals(  InnerJoin.class.getName())  )
		{
			result = new InnerJoinOlapParser((InnerJoin)element);
		}
		else if( tmpElementClassName.equals(  Define.class.getName())  )
		{
			result = new DefineOlapParser((Define)element);
		}
		else if( tmpElementClassName.equals(  Command.class.getName())  )
		{
			result = new CommandOlapParser((Command)element);
		}
		else if( tmpElementClassName.equals(  Attribute.class.getName())  )
		{
			result = new AttributeOlapParser((Attribute)element);
		}
		else if( tmpElementClassName.equals(  SchemaGroup.class.getName())  )
		{
			result = new SchemaGroupOlapParser((SchemaGroup)element);
		}
		else if( tmpElementClassName.equals(  Field.class.getName())  )
		{
			result = new FieldOlapParser((Field)element);
		}
		else if( tmpElementClassName.equals(  FieldGroup.class.getName())  )
		{
			result = new FieldGroupOlapParser((FieldGroup)element);
		}
		else if( tmpElementClassName.equals(  Factory.class.getName())  )
		{
			result = new FactoryOlapParser((Factory)element);
		}
		else if( tmpElementClassName.equals(  AttributeLibrary.class.getName())  )
		{
			result = new AttributeLibraryOlapParser((AttributeLibrary)element);
		}
		else if( tmpElementClassName.equals(  RelationGroup.class.getName())  )
		{
			result = new RelationGroupOlapParser((RelationGroup)element);
		}
		else if( tmpElementClassName.equals(  NoneExists.class.getName())  )
		{
			result = new NoneExistsOlapParser((NoneExists)element);
		}
		else if( tmpElementClassName.equals(  Exists.class.getName())  )
		{
			result = new ExistsOlapParser((Exists)element);
		}
		else if( tmpElementClassName.equals(  FieldValueExpress.class.getName())  )
		{
			result = new FieldValueExpressOlapParser((FieldValueExpress)element);
		}
		else if( tmpElementClassName.equals(  Filter.class.getName())  )
		{
			result = new FilterOlapParser((Filter)element);
		}
		else if( tmpElementClassName.equals(  ViewRelation.class.getName())  )
		{
			result = new ViewRelationOlapParser((ViewRelation)element);
		}
		else if( tmpElementClassName.equals(  LibraryGroup.class.getName())  )
		{
			result = new LibraryGroupOlapParser((LibraryGroup)element);
		}
		else if( tmpElementClassName.equals(  ServiceField.class.getName())  )
		{
			result = new ServiceFieldOlapParser((ServiceField)element);
		}
		else if( tmpElementClassName.equals(  SchemaDefine.class.getName())  )
		{
			result = new SchemaDefineOlapParser((SchemaDefine)element);
		}
		return result;
	}
}