package org.zml.schema.parser.ersi;
import org.zml.schema.bind.SchemaGroup;
public class SchemaGroupArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public SchemaGroupArcGISParser( SchemaGroup element)
	{
		setQueryDefineElement(element);
	}
	public boolean checkQueryElementComfort() throws Exception
	{
		boolean result = false;
		if ( this.getQueryDefineElement()  == null )
		{
			throw new Exception(" queryDefineElement cannot be null. ");
		}
		if ( !(this.getQueryDefineElement() instanceof SchemaGroup))
		{
			throw new Exception(" SchemaGroupArcGISParser only parse SchemaGroup");
		}
		result = true;
		return result;
	}
}