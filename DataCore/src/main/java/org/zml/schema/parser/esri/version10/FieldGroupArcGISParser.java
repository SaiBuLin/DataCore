package org.zml.schema.parser.esri.version10;
import org.zml.schema.bind.FieldGroup;
public class FieldGroupArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public FieldGroupArcGISParser( FieldGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof FieldGroup))
		{
			throw new Exception(" FieldGroupArcGISParser only parse FieldGroup");
		}
		result = true;
		return result;
	}
}