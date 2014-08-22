package org.zml.schema.parser.ersi;
import org.zml.schema.bind.Delete;
public class DeleteArcGISParser extends ArcGISParser implements ArcGISParserAble
{
	public DeleteArcGISParser( Delete element)
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
		if ( !(this.getQueryDefineElement() instanceof Delete))
		{
			throw new Exception(" DeleteArcGISParser only parse Delete");
		}
		result = true;
		return result;
	}
}