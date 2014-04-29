package org.zml.data.vo.parser;
import org.zml.data.vo.bind.Relation;
import org.zml.data.vo.bind.TableRelation;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;

public class RelationSQLParser extends SQLParser implements SQLParserAble
{
	public RelationSQLParser( Relation element)
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
		if ( !(this.getQueryDefineElement() instanceof Relation))
		{
			throw new Exception(" RelationSQLParser only parse Relation");
		}
		result = true;
		return result;
	}
	
	@Override
	public CommandForm parserCommand(
			VOForm form,
			CommandForm leftForm,
			CommandForm rightForm, 
			TableRelation tableRelation 
			)throws DataServiceException{
		throw new DataServiceException("Relation 是一个抽象类。" );
	}
	
	@Override
	public CommandForm parserCommand(VOForm form) throws DataServiceException{		
		
		throw new DataServiceException("Relation 是一个抽象类。" );
	}
	
	
}