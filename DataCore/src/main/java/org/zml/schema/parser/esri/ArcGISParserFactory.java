package org.zml.schema.parser.ersi;
import org.zml.schema.bind.*;
import org.zml.tools.xml.parser.CTXMLElement;
public class ArcGISParserFactory
{
	public static ArcGISParserAble getQueryDefineInterpreter(CTXMLElement element) throws Exception
	{
		ArcGISParserAble result = null;
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
	private static ArcGISParserAble getQueryDefineInterpreterForNoEquals(CTXMLElement element) throws Exception
	{
		ArcGISParserAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		if( element instanceof DataService  )
		{
			result = new DataServiceArcGISParser((DataService)element);
		}
		else if( element instanceof Update  )
		{
			result = new UpdateArcGISParser((Update)element);
		}
		else if( element instanceof AttributeGroup  )
		{
			result = new AttributeGroupArcGISParser((AttributeGroup)element);
		}
		else if( element instanceof Form  )
		{
			result = new FormArcGISParser((Form)element);
		}
		else if( element instanceof ExpressGroup  )
		{
			result = new ExpressGroupArcGISParser((ExpressGroup)element);
		}
		else if( element instanceof FieldsExpress  )
		{
			result = new FieldsExpressArcGISParser((FieldsExpress)element);
		}
		else if( element instanceof Query  )
		{
			result = new QueryArcGISParser((Query)element);
		}
		else if( element instanceof RightOuterJoin  )
		{
			result = new RightOuterJoinArcGISParser((RightOuterJoin)element);
		}
		else if( element instanceof Parameter  )
		{
			result = new ParameterArcGISParser((Parameter)element);
		}
		else if( element instanceof Relation  )
		{
			result = new RelationArcGISParser((Relation)element);
		}
		else if( element instanceof LeftOuterJoin  )
		{
			result = new LeftOuterJoinArcGISParser((LeftOuterJoin)element);
		}
		else if( element instanceof Express  )
		{
			result = new ExpressArcGISParser((Express)element);
		}
		else if( element instanceof Service  )
		{
			result = new ServiceArcGISParser((Service)element);
		}
		else if( element instanceof Library  )
		{
			result = new LibraryArcGISParser((Library)element);
		}
		else if( element instanceof Transaction  )
		{
			result = new TransactionArcGISParser((Transaction)element);
		}
		else if( element instanceof Schema  )
		{
			result = new SchemaArcGISParser((Schema)element);
		}
		else if( element instanceof Delete  )
		{
			result = new DeleteArcGISParser((Delete)element);
		}
		else if( element instanceof SchemaConfigure  )
		{
			result = new SchemaConfigureArcGISParser((SchemaConfigure)element);
		}
		else if( element instanceof SqlLibrary  )
		{
			result = new SqlLibraryArcGISParser((SqlLibrary)element);
		}
		else if( element instanceof View  )
		{
			result = new ViewArcGISParser((View)element);
		}
		else if( element instanceof FormLibrary  )
		{
			result = new FormLibraryArcGISParser((FormLibrary)element);
		}
		else if( element instanceof Insert  )
		{
			result = new InsertArcGISParser((Insert)element);
		}
		else if( element instanceof ReferenceLibrary  )
		{
			result = new ReferenceLibraryArcGISParser((ReferenceLibrary)element);
		}
		else if( element instanceof InnerJoin  )
		{
			result = new InnerJoinArcGISParser((InnerJoin)element);
		}
		else if( element instanceof Define  )
		{
			result = new DefineArcGISParser((Define)element);
		}
		else if( element instanceof Command  )
		{
			result = new CommandArcGISParser((Command)element);
		}
		else if( element instanceof Attribute  )
		{
			result = new AttributeArcGISParser((Attribute)element);
		}
		else if( element instanceof SchemaGroup  )
		{
			result = new SchemaGroupArcGISParser((SchemaGroup)element);
		}
		else if( element instanceof Field  )
		{
			result = new FieldArcGISParser((Field)element);
		}
		else if( element instanceof FieldGroup  )
		{
			result = new FieldGroupArcGISParser((FieldGroup)element);
		}
		else if( element instanceof Factory  )
		{
			result = new FactoryArcGISParser((Factory)element);
		}
		else if( element instanceof AttributeLibrary  )
		{
			result = new AttributeLibraryArcGISParser((AttributeLibrary)element);
		}
		else if( element instanceof RelationGroup  )
		{
			result = new RelationGroupArcGISParser((RelationGroup)element);
		}
		else if( element instanceof NoneExists  )
		{
			result = new NoneExistsArcGISParser((NoneExists)element);
		}
		else if( element instanceof Exists  )
		{
			result = new ExistsArcGISParser((Exists)element);
		}
		else if( element instanceof FieldValueExpress  )
		{
			result = new FieldValueExpressArcGISParser((FieldValueExpress)element);
		}
		else if( element instanceof Filter  )
		{
			result = new FilterArcGISParser((Filter)element);
		}
		else if( element instanceof ViewRelation  )
		{
			result = new ViewRelationArcGISParser((ViewRelation)element);
		}
		else if( element instanceof LibraryGroup  )
		{
			result = new LibraryGroupArcGISParser((LibraryGroup)element);
		}
		else if( element instanceof ServiceField  )
		{
			result = new ServiceFieldArcGISParser((ServiceField)element);
		}
		else if( element instanceof SchemaDefine  )
		{
			result = new SchemaDefineArcGISParser((SchemaDefine)element);
		}
		return result;
	}
	private static ArcGISParserAble getQueryDefineInterpreterIndicateClsName(CTXMLElement element) throws Exception
	{
		ArcGISParserAble result = null;
		if (element == null)
		{
			throw new Exception(" element is null. please check. ");
		}
		String tmpElementClassName = element.getClass().getName();
		if( tmpElementClassName.equals(  DataService.class.getName())  )
		{
			result = new DataServiceArcGISParser((DataService)element);
		}
		else if( tmpElementClassName.equals(  Update.class.getName())  )
		{
			result = new UpdateArcGISParser((Update)element);
		}
		else if( tmpElementClassName.equals(  AttributeGroup.class.getName())  )
		{
			result = new AttributeGroupArcGISParser((AttributeGroup)element);
		}
		else if( tmpElementClassName.equals(  Form.class.getName())  )
		{
			result = new FormArcGISParser((Form)element);
		}
		else if( tmpElementClassName.equals(  ExpressGroup.class.getName())  )
		{
			result = new ExpressGroupArcGISParser((ExpressGroup)element);
		}
		else if( tmpElementClassName.equals(  FieldsExpress.class.getName())  )
		{
			result = new FieldsExpressArcGISParser((FieldsExpress)element);
		}
		else if( tmpElementClassName.equals(  Query.class.getName())  )
		{
			result = new QueryArcGISParser((Query)element);
		}
		else if( tmpElementClassName.equals(  RightOuterJoin.class.getName())  )
		{
			result = new RightOuterJoinArcGISParser((RightOuterJoin)element);
		}
		else if( tmpElementClassName.equals(  Parameter.class.getName())  )
		{
			result = new ParameterArcGISParser((Parameter)element);
		}
		else if( tmpElementClassName.equals(  Relation.class.getName())  )
		{
			result = new RelationArcGISParser((Relation)element);
		}
		else if( tmpElementClassName.equals(  LeftOuterJoin.class.getName())  )
		{
			result = new LeftOuterJoinArcGISParser((LeftOuterJoin)element);
		}
		else if( tmpElementClassName.equals(  Express.class.getName())  )
		{
			result = new ExpressArcGISParser((Express)element);
		}
		else if( tmpElementClassName.equals(  Service.class.getName())  )
		{
			result = new ServiceArcGISParser((Service)element);
		}
		else if( tmpElementClassName.equals(  Library.class.getName())  )
		{
			result = new LibraryArcGISParser((Library)element);
		}
		else if( tmpElementClassName.equals(  Transaction.class.getName())  )
		{
			result = new TransactionArcGISParser((Transaction)element);
		}
		else if( tmpElementClassName.equals(  Schema.class.getName())  )
		{
			result = new SchemaArcGISParser((Schema)element);
		}
		else if( tmpElementClassName.equals(  Delete.class.getName())  )
		{
			result = new DeleteArcGISParser((Delete)element);
		}
		else if( tmpElementClassName.equals(  SchemaConfigure.class.getName())  )
		{
			result = new SchemaConfigureArcGISParser((SchemaConfigure)element);
		}
		else if( tmpElementClassName.equals(  SqlLibrary.class.getName())  )
		{
			result = new SqlLibraryArcGISParser((SqlLibrary)element);
		}
		else if( tmpElementClassName.equals(  View.class.getName())  )
		{
			result = new ViewArcGISParser((View)element);
		}
		else if( tmpElementClassName.equals(  FormLibrary.class.getName())  )
		{
			result = new FormLibraryArcGISParser((FormLibrary)element);
		}
		else if( tmpElementClassName.equals(  Insert.class.getName())  )
		{
			result = new InsertArcGISParser((Insert)element);
		}
		else if( tmpElementClassName.equals(  ReferenceLibrary.class.getName())  )
		{
			result = new ReferenceLibraryArcGISParser((ReferenceLibrary)element);
		}
		else if( tmpElementClassName.equals(  InnerJoin.class.getName())  )
		{
			result = new InnerJoinArcGISParser((InnerJoin)element);
		}
		else if( tmpElementClassName.equals(  Define.class.getName())  )
		{
			result = new DefineArcGISParser((Define)element);
		}
		else if( tmpElementClassName.equals(  Command.class.getName())  )
		{
			result = new CommandArcGISParser((Command)element);
		}
		else if( tmpElementClassName.equals(  Attribute.class.getName())  )
		{
			result = new AttributeArcGISParser((Attribute)element);
		}
		else if( tmpElementClassName.equals(  SchemaGroup.class.getName())  )
		{
			result = new SchemaGroupArcGISParser((SchemaGroup)element);
		}
		else if( tmpElementClassName.equals(  Field.class.getName())  )
		{
			result = new FieldArcGISParser((Field)element);
		}
		else if( tmpElementClassName.equals(  FieldGroup.class.getName())  )
		{
			result = new FieldGroupArcGISParser((FieldGroup)element);
		}
		else if( tmpElementClassName.equals(  Factory.class.getName())  )
		{
			result = new FactoryArcGISParser((Factory)element);
		}
		else if( tmpElementClassName.equals(  AttributeLibrary.class.getName())  )
		{
			result = new AttributeLibraryArcGISParser((AttributeLibrary)element);
		}
		else if( tmpElementClassName.equals(  RelationGroup.class.getName())  )
		{
			result = new RelationGroupArcGISParser((RelationGroup)element);
		}
		else if( tmpElementClassName.equals(  NoneExists.class.getName())  )
		{
			result = new NoneExistsArcGISParser((NoneExists)element);
		}
		else if( tmpElementClassName.equals(  Exists.class.getName())  )
		{
			result = new ExistsArcGISParser((Exists)element);
		}
		else if( tmpElementClassName.equals(  FieldValueExpress.class.getName())  )
		{
			result = new FieldValueExpressArcGISParser((FieldValueExpress)element);
		}
		else if( tmpElementClassName.equals(  Filter.class.getName())  )
		{
			result = new FilterArcGISParser((Filter)element);
		}
		else if( tmpElementClassName.equals(  ViewRelation.class.getName())  )
		{
			result = new ViewRelationArcGISParser((ViewRelation)element);
		}
		else if( tmpElementClassName.equals(  LibraryGroup.class.getName())  )
		{
			result = new LibraryGroupArcGISParser((LibraryGroup)element);
		}
		else if( tmpElementClassName.equals(  ServiceField.class.getName())  )
		{
			result = new ServiceFieldArcGISParser((ServiceField)element);
		}
		else if( tmpElementClassName.equals(  SchemaDefine.class.getName())  )
		{
			result = new SchemaDefineArcGISParser((SchemaDefine)element);
		}
		return result;
	}
}