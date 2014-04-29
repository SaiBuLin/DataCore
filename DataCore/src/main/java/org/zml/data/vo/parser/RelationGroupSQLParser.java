package org.zml.data.vo.parser;
import org.zml.data.vo.bind.OperationLogical;
import org.zml.data.vo.bind.RelationGroup;
import org.zml.data.vo.bind.TableRelation;
import org.zml.data.vo.bind.Relation;
import org.zml.data.vo.command.bind.CommandConfiguration;
import org.zml.data.vo.command.parser.SQLCommandAble;
import org.zml.data.vo.command.parser.SQLCommandFactory;
import org.zml.data.vo.exception.DataServiceException;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.util.UtilTools;

public class RelationGroupSQLParser extends SQLParser implements SQLParserAble
{
	public RelationGroupSQLParser( RelationGroup element)
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
		if ( !(this.getQueryDefineElement() instanceof RelationGroup))
		{
			throw new Exception(" RelationGroupSQLParser only parse RelationGroup");
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
		CommandForm result = null;
		
		try{
			logger.debug("RelationGroupSQLParser开始执行parserCommand。");
			if(!( this.checkQueryElementComfort() )){
				return result;
			}
			
			if( form == null ){
				throw new Exception("入口参数form 为空。");
			}
			
			if( form.getProperties() == null ){
				throw new Exception("入口参数form的Properties 为空。");
			}
			
			if( leftForm == null ){
				throw new Exception("入口leftForm 为空。");
			}
			
			if( rightForm == null ){
				throw new Exception("入口rightForm 为空。");
			}
			
			
			String leftAlias = UtilTools.getTrim( leftForm.getAlias());
			
			String rightAlias = UtilTools.getTrim( rightForm.getAlias());
			
			if( UtilTools.isNull(leftAlias) ){
				throw new Exception("Left Form 没有配置别名alias.");
			}
			
			if( UtilTools.isNull(rightAlias) ){
				throw new Exception("Right Form 没有配置别名alias.");
			}
			
		
			
			SQLCommandAble leftComAble = SQLCommandFactory.getQueryDefineInterpreter(  leftForm.getCommand() );
			
			SQLCommandAble rightComAble = SQLCommandFactory.getQueryDefineInterpreter(  rightForm.getCommand() );
			
			String leftTable = "";// leftForm.getCommand();
			if( leftComAble != null ){
				leftTable = leftComAble.getRequestTaskContent();
			}
			
			String rightTable = "";//rightForm.getCommand();
			if( rightComAble != null ){
				rightTable = rightComAble.getRequestTaskContent();
			}
			
			if( UtilTools.isNull( leftTable ) ){
				throw new Exception( "LeftForm 的Command的属性为空。" );
			}
			
			if( UtilTools.isNull( rightTable ) ){
				throw new Exception( "RightForm 的Command的属性为空。" );
			}
			
			Boolean leftKuohao =  isSQLSelectString( leftTable );
			if( leftKuohao ){
				leftTable = "( " + leftTable + ") ";
			}
			
			Boolean  rightKuohao =  isSQLSelectString( rightTable );
			if( rightKuohao ){
				rightTable = "( " + rightTable + ") ";
			}
			
			String relationString = this.parserRelationFieldString(
					form,
					leftAlias,
					rightAlias
					);
			
			if(UtilTools.isNull(relationString)){
				throw new Exception("关系字符串生成错误。");
			}
			
			StringBuffer sBuf = new StringBuffer();
			
			sBuf.append(" SELECT ");			
			sBuf.append(" * ");			
			sBuf.append(" FROM ");
			
			if( tableRelation == TableRelation.INNER_JOIN ){
				sBuf.append( leftTable );
				sBuf.append(" ");
				
				sBuf.append( leftAlias );
				sBuf.append(" INNER JOIN ");
				
				sBuf.append( rightTable );
				sBuf.append(" ");
				sBuf.append( rightAlias );
				
				sBuf.append(" ON ");
				
				sBuf.append(relationString);
				
			}else if ( tableRelation == TableRelation.LEFT_OUTER_JOIN ){
				sBuf.append( leftTable );
				sBuf.append(" ");
				
				sBuf.append( leftAlias );
				sBuf.append(" LEFT OUTER JOIN ");
				
				sBuf.append( rightTable );
				sBuf.append(" ");
				sBuf.append( rightAlias );
				
				sBuf.append(" ON ");
				
				sBuf.append(relationString);
			}
			else if ( tableRelation == TableRelation.RIGHT_OUTER_JOIN ){
				sBuf.append( leftTable );
				sBuf.append(" ");
				
				sBuf.append( leftAlias );
				sBuf.append(" RIGHT OUTER JOIN ");
				
				sBuf.append( rightTable );
				sBuf.append(" ");
				sBuf.append( rightAlias );
				
				sBuf.append(" ON ");
				
				sBuf.append(relationString);
			}
			else if ( tableRelation == TableRelation.EXISTS ){
				sBuf.append( leftTable );
				sBuf.append(" ");				
				sBuf.append( leftAlias );
				sBuf.append(" WHERE ");
				sBuf.append(" EXISTS  ");
				sBuf.append(" (  ");
				sBuf.append( rightTable );
				sBuf.append(" ");
				sBuf.append( rightAlias );
				sBuf.append(" WHERE ");
				sBuf.append(relationString);
				sBuf.append(" )  ");
			}
			else if ( tableRelation == TableRelation.NOT_EXISTS ){
				sBuf.append( leftTable );
				sBuf.append(" ");
				sBuf.append( leftAlias );
				
				sBuf.append(" WHERE ");
				sBuf.append(" NOT EXISTS  ");
				sBuf.append(" (  ");
				sBuf.append( rightTable );
				sBuf.append(" ");
				sBuf.append( rightAlias );
				sBuf.append(" WHERE ");
				sBuf.append(relationString);
				sBuf.append(" )  ");
			}
			result = new CommandForm();
			
			/* 生成命令 */
			CommandConfiguration resultCommand = new CommandConfiguration();
			
			SQLCommandAble resultCommandAble = SQLCommandFactory.getQueryDefineInterpreter(resultCommand);
			if( resultCommandAble != null ){
				resultCommandAble.insertRequestTask("RL001", sBuf.toString());				
			}else{
				logger.error("SQLCommandFactory 执行getQueryDefineInterpreter错误，resultCommand 没有对应的SQLCommandAble。");
			}
			result.setCommand( resultCommand );
			logger.debug("RelationGroupSQLParser执行parserCommand完毕。");
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("RelationGroupSQLParser::parserCommand 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("RelationGroupSQLParser::parserCommand 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("RelationGroupSQLParser::parserCommand 抛出异常， 异常信息：" + localMessage);
				}
			}
			result = null;
		}
		return result;
	}
	
	@Override
	public String parserRelationFieldString(
			VOForm form,
			String leftalias,
			String rightalias
			) throws DataServiceException{
		
		String result = "";
		try{
			
			if(!( this.checkQueryElementComfort() )){
				return result;
			}

			if(UtilTools.isNull( leftalias )){
				throw new Exception("左Form的别名为空，无法进行关系映射。");
			}
			
			if(UtilTools.isNull( rightalias )){
				throw new Exception("右边Form的别名为空，无法进行关系映射。");
			}
			
			String tmpLeftAlias = UtilTools.getTrim( leftalias );
			String tmpRightAlias = UtilTools.getTrim( rightalias );
			
			RelationGroup config = (RelationGroup) this.queryDefineElement;
			
			if( config == null ){
				throw new Exception("RelationGroup 没有被强制转换出来。");
			}
			
			if( config.getRelation() == null ){
				throw new Exception("RelationGroup 没有配置Relation, 无法进行关系字符串生成。");
			}
			
			int m_Count = 0;
			int mSize = config.getRelation().size() ;
			
			if( mSize == 0 ){
				throw new Exception("RelationGroup 没有配置Relation, 无法进行关系字符串生成。");
			}
			StringBuffer sBuf = new StringBuffer();
			
			for( int ii = 0; ii < mSize; ii++ ){
				Relation relation = config.getRelation().get(ii);
				if( relation == null){
					logger.error("从RelationGroup的属性Relation 读取空对象， 下标：" + ii);
					continue;
				}
				
				SQLParserAble RelationAble = SQLParserFactory.getQueryDefineInterpreter(relation);
				if( RelationAble == null ){
					logger.error("从Relation 不能正确进行Parser， 下标：" + ii);
					continue;
				}
				
				String relationString = RelationAble.parserRelationFieldString(
						form,
						tmpLeftAlias,
						tmpRightAlias
						);
				
				if(UtilTools.isNull(relationString)){
					logger.error("从Relation 没有正确生成Relation Field 的字符串， 下标：" + ii);
					continue;
				}
				
				if( m_Count > 0){
					if( config.getReloperation() == null ){
						sBuf.append( OperationLogical.AND.toString() );
					}
					else{
						sBuf.append(config.getReloperation().toString());
					}
				}
				
				sBuf.append(" ( ");
				
				sBuf.append( relationString );
				
				sBuf.append(" ) ");
				m_Count++;
				
			}
			
			result = sBuf.toString();
			return result;
		}catch(Exception e){
			if( e != null ){
				String execeptionClassName =  e.getClass().toString();
				if( !UtilTools.isNull(execeptionClassName)){
					logger.error("RelationGroupSQLParser::parserRelationFieldString 抛出异常， 异常类：" + execeptionClassName);
				}
				logger.error("RelationGroupSQLParser::parserRelationFieldString 抛出异常， 异常信息：" + e.getMessage());
				String localMessage = e.getLocalizedMessage();
				if( !UtilTools.isNull(localMessage)){
					logger.error("RelationGroupSQLParser::parserRelationFieldString 抛出异常， 异常信息：" + localMessage);
				}
			}
			result = "";
		}
		
		
		return result;
	}
}