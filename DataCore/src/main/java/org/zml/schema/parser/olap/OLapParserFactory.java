package org.zml.schema.parser.olap;
import org.zml.schema.bind.*;
import org.zml.tools.xml.parser.CTXMLElement;
public class OLapParserFactory
{
	public static OLapParserAble getQueryDefineInterpreter(CTXMLElement element) throws Exception
	{
		OLapParserAble result = null;
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
	private static OLapParserAble getQueryDefineInterpreterForNoEquals(CTXMLElement element) throws Exception
	{
		OLapParserAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		if( element instanceof DataService  )
		{
			result = new DataServiceOLapParser((DataService)element);
		}
		else if( element instanceof Update  )
		{
			result = new UpdateOLapParser((Update)element);
		}
		else if( element instanceof AttributeGroup  )
		{
			result = new AttributeGroupOLapParser((AttributeGroup)element);
		}
		else if( element instanceof Form  )
		{
			result = new FormOLapParser((Form)element);
		}
		else if( element instanceof ExpressGroup  )
		{
			result = new ExpressGroupOLapParser((ExpressGroup)element);
		}
		else if( element instanceof FieldsExpress  )
		{
			result = new FieldsExpressOLapParser((FieldsExpress)element);
		}
		else if( element instanceof Query  )
		{
			result = new QueryOLapParser((Query)element);
		}
		else if( element instanceof RightOuterJoin  )
		{
			result = new RightOuterJoinOLapParser((RightOuterJoin)element);
		}
		else if( element instanceof Parameter  )
		{
			result = new ParameterOLapParser((Parameter)element);
		}
		else if( element instanceof Relation  )
		{
			result = new RelationOLapParser((Relation)element);
		}
		else if( element instanceof LeftOuterJoin  )
		{
			result = new LeftOuterJoinOLapParser((LeftOuterJoin)element);
		}
		else if( element instanceof Express  )
		{
			result = new ExpressOLapParser((Express)element);
		}
		else if( element instanceof Service  )
		{
			result = new ServiceOLapParser((Service)element);
		}
		else if( element instanceof Library  )
		{
			result = new LibraryOLapParser((Library)element);
		}
		else if( element instanceof Transaction  )
		{
			result = new TransactionOLapParser((Transaction)element);
		}
		else if( element instanceof Schema  )
		{
			result = new SchemaOLapParser((Schema)element);
		}
		else if( element instanceof Delete  )
		{
			result = new DeleteOLapParser((Delete)element);
		}
		else if( element instanceof SchemaConfigure  )
		{
			result = new SchemaConfigureOLapParser((SchemaConfigure)element);
		}
		else if( element instanceof SqlLibrary  )
		{
			result = new SqlLibraryOLapParser((SqlLibrary)element);
		}
		else if( element instanceof View  )
		{
			result = new ViewOLapParser((View)element);
		}
		else if( element instanceof FormLibrary  )
		{
			result = new FormLibraryOLapParser((FormLibrary)element);
		}
		else if( element instanceof Insert  )
		{
			result = new InsertOLapParser((Insert)element);
		}
		else if( element instanceof ReferenceLibrary  )
		{
			result = new ReferenceLibraryOLapParser((ReferenceLibrary)element);
		}
		else if( element instanceof InnerJoin  )
		{
			result = new InnerJoinOLapParser((InnerJoin)element);
		}
		else if( element instanceof Define  )
		{
			result = new DefineOLapParser((Define)element);
		}
		else if( element instanceof Command  )
		{
			result = new CommandOLapParser((Command)element);
		}
		else if( element instanceof Attribute  )
		{
			result = new AttributeOLapParser((Attribute)element);
		}
		else if( element instanceof SchemaGroup  )
		{
			result = new SchemaGroupOLapParser((SchemaGroup)element);
		}
		else if( element instanceof Field  )
		{
			result = new FieldOLapParser((Field)element);
		}
		else if( element instanceof FieldGroup  )
		{
			result = new FieldGroupOLapParser((FieldGroup)element);
		}
		else if( element instanceof Factory  )
		{
			result = new FactoryOLapParser((Factory)element);
		}
		else if( element instanceof AttributeLibrary  )
		{
			result = new AttributeLibraryOLapParser((AttributeLibrary)element);
		}
		else if( element instanceof RelationGroup  )
		{
			result = new RelationGroupOLapParser((RelationGroup)element);
		}
		else if( element instanceof NoneExists  )
		{
			result = new NoneExistsOLapParser((NoneExists)element);
		}
		else if( element instanceof Exists  )
		{
			result = new ExistsOLapParser((Exists)element);
		}
		else if( element instanceof FieldValueExpress  )
		{
			result = new FieldValueExpressOLapParser((FieldValueExpress)element);
		}
		else if( element instanceof Filter  )
		{
			result = new FilterOLapParser((Filter)element);
		}
		else if( element instanceof ViewRelation  )
		{
			result = new ViewRelationOLapParser((ViewRelation)element);
		}
		else if( element instanceof LibraryGroup  )
		{
			result = new LibraryGroupOLapParser((LibraryGroup)element);
		}
		else if( element instanceof ServiceField  )
		{
			result = new ServiceFieldOLapParser((ServiceField)element);
		}
		else if( element instanceof SchemaDefine  )
		{
			result = new SchemaDefineOLapParser((SchemaDefine)element);
		}
		return result;
	}
	private static OLapParserAble getQueryDefineInterpreterIndicateClsName(CTXMLElement element) throws Exception
	{
		OLapParserAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		String tmpElementClassName = element.getClass().getName();
		if( tmpElementClassName.equals(  DataService.class.getName())  )
		{
			result = new DataServiceOLapParser((DataService)element);
		}
		else if( tmpElementClassName.equals(  Update.class.getName())  )
		{
			result = new UpdateOLapParser((Update)element);
		}
		else if( tmpElementClassName.equals(  AttributeGroup.class.getName())  )
		{
			result = new AttributeGroupOLapParser((AttributeGroup)element);
		}
		else if( tmpElementClassName.equals(  Form.class.getName())  )
		{
			result = new FormOLapParser((Form)element);
		}
		else if( tmpElementClassName.equals(  ExpressGroup.class.getName())  )
		{
			result = new ExpressGroupOLapParser((ExpressGroup)element);
		}
		else if( tmpElementClassName.equals(  FieldsExpress.class.getName())  )
		{
			result = new FieldsExpressOLapParser((FieldsExpress)element);
		}
		else if( tmpElementClassName.equals(  Query.class.getName())  )
		{
			result = new QueryOLapParser((Query)element);
		}
		else if( tmpElementClassName.equals(  RightOuterJoin.class.getName())  )
		{
			result = new RightOuterJoinOLapParser((RightOuterJoin)element);
		}
		else if( tmpElementClassName.equals(  Parameter.class.getName())  )
		{
			result = new ParameterOLapParser((Parameter)element);
		}
		else if( tmpElementClassName.equals(  Relation.class.getName())  )
		{
			result = new RelationOLapParser((Relation)element);
		}
		else if( tmpElementClassName.equals(  LeftOuterJoin.class.getName())  )
		{
			result = new LeftOuterJoinOLapParser((LeftOuterJoin)element);
		}
		else if( tmpElementClassName.equals(  Express.class.getName())  )
		{
			result = new ExpressOLapParser((Express)element);
		}
		else if( tmpElementClassName.equals(  Service.class.getName())  )
		{
			result = new ServiceOLapParser((Service)element);
		}
		else if( tmpElementClassName.equals(  Library.class.getName())  )
		{
			result = new LibraryOLapParser((Library)element);
		}
		else if( tmpElementClassName.equals(  Transaction.class.getName())  )
		{
			result = new TransactionOLapParser((Transaction)element);
		}
		else if( tmpElementClassName.equals(  Schema.class.getName())  )
		{
			result = new SchemaOLapParser((Schema)element);
		}
		else if( tmpElementClassName.equals(  Delete.class.getName())  )
		{
			result = new DeleteOLapParser((Delete)element);
		}
		else if( tmpElementClassName.equals(  SchemaConfigure.class.getName())  )
		{
			result = new SchemaConfigureOLapParser((SchemaConfigure)element);
		}
		else if( tmpElementClassName.equals(  SqlLibrary.class.getName())  )
		{
			result = new SqlLibraryOLapParser((SqlLibrary)element);
		}
		else if( tmpElementClassName.equals(  View.class.getName())  )
		{
			result = new ViewOLapParser((View)element);
		}
		else if( tmpElementClassName.equals(  FormLibrary.class.getName())  )
		{
			result = new FormLibraryOLapParser((FormLibrary)element);
		}
		else if( tmpElementClassName.equals(  Insert.class.getName())  )
		{
			result = new InsertOLapParser((Insert)element);
		}
		else if( tmpElementClassName.equals(  ReferenceLibrary.class.getName())  )
		{
			result = new ReferenceLibraryOLapParser((ReferenceLibrary)element);
		}
		else if( tmpElementClassName.equals(  InnerJoin.class.getName())  )
		{
			result = new InnerJoinOLapParser((InnerJoin)element);
		}
		else if( tmpElementClassName.equals(  Define.class.getName())  )
		{
			result = new DefineOLapParser((Define)element);
		}
		else if( tmpElementClassName.equals(  Command.class.getName())  )
		{
			result = new CommandOLapParser((Command)element);
		}
		else if( tmpElementClassName.equals(  Attribute.class.getName())  )
		{
			result = new AttributeOLapParser((Attribute)element);
		}
		else if( tmpElementClassName.equals(  SchemaGroup.class.getName())  )
		{
			result = new SchemaGroupOLapParser((SchemaGroup)element);
		}
		else if( tmpElementClassName.equals(  Field.class.getName())  )
		{
			result = new FieldOLapParser((Field)element);
		}
		else if( tmpElementClassName.equals(  FieldGroup.class.getName())  )
		{
			result = new FieldGroupOLapParser((FieldGroup)element);
		}
		else if( tmpElementClassName.equals(  Factory.class.getName())  )
		{
			result = new FactoryOLapParser((Factory)element);
		}
		else if( tmpElementClassName.equals(  AttributeLibrary.class.getName())  )
		{
			result = new AttributeLibraryOLapParser((AttributeLibrary)element);
		}
		else if( tmpElementClassName.equals(  RelationGroup.class.getName())  )
		{
			result = new RelationGroupOLapParser((RelationGroup)element);
		}
		else if( tmpElementClassName.equals(  NoneExists.class.getName())  )
		{
			result = new NoneExistsOLapParser((NoneExists)element);
		}
		else if( tmpElementClassName.equals(  Exists.class.getName())  )
		{
			result = new ExistsOLapParser((Exists)element);
		}
		else if( tmpElementClassName.equals(  FieldValueExpress.class.getName())  )
		{
			result = new FieldValueExpressOLapParser((FieldValueExpress)element);
		}
		else if( tmpElementClassName.equals(  Filter.class.getName())  )
		{
			result = new FilterOLapParser((Filter)element);
		}
		else if( tmpElementClassName.equals(  ViewRelation.class.getName())  )
		{
			result = new ViewRelationOLapParser((ViewRelation)element);
		}
		else if( tmpElementClassName.equals(  LibraryGroup.class.getName())  )
		{
			result = new LibraryGroupOLapParser((LibraryGroup)element);
		}
		else if( tmpElementClassName.equals(  ServiceField.class.getName())  )
		{
			result = new ServiceFieldOLapParser((ServiceField)element);
		}
		else if( tmpElementClassName.equals(  SchemaDefine.class.getName())  )
		{
			result = new SchemaDefineOLapParser((SchemaDefine)element);
		}
		return result;
	}
}