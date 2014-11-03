package org.zml.schema.parser.olap;
import org.zml.schema.bind.Factory;
public class FactoryOlapParser extends OlapParser implements OlapParserAble
{
	public FactoryOlapParser( Factory element)
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
		if ( !(this.getQueryDefineElement() instanceof Factory))
		{
			throw new Exception(" FactoryOlapParser only parse Factory");
		}
		result = true;
		return result;
	}
}