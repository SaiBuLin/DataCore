package org.zml.data.vo.tools.action.impl;

import org.zml.data.vo.command.bind.RequestTask;
import org.zml.data.vo.tools.action.IFormActionTools;

/**
 * 
 * @author zlmwork
 * 改FormAction 用来进行数据挖掘的方式查询数据
 */
public class DataMiningFormAction implements IFormActionTools {

	@Override
	public RequestTask parseSelectFieldForQuery(String alias, String field,
			String extendString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestTask parseSelectFieldForUpdate(String alias, String field,
			String extendString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestTask parseSelectFieldForInsert(String alias, String field,
			String extendString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestTask parseSelectFieldForInsertValues(String alias,
			String field, String extendString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestTask parseSelectFieldForDelete(String alias, String field,
			String extendString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestTask parseWhereFieldForQuery(String alias, String field,
			String extendString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestTask parseWhereFieldForUpdate(String alias, String field,
			String extendString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestTask parseWhereFieldForInsert(String alias, String field,
			String extendString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestTask parseWhereFieldForDelete(String alias, String field,
			String extendString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestTask parseOrderFieldForQuery(String alias, String field,
			String extendString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestTask parseGroupbyFieldForQuery(String alias, String field,
			String extendString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestTask parserCommandForQuery(RequestTask selectTask,
			RequestTask whereTask, RequestTask orderbyTask,
			RequestTask groupbyTask, RequestTask dataset) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestTask parserCommandForInsert(RequestTask selectTask,
			RequestTask valuesTask, RequestTask dataset) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestTask parserCommandForDelete(RequestTask whereTask,
			RequestTask dataset) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequestTask parserCommandForUpdate(RequestTask selectTask,
			RequestTask whereTask, RequestTask dataset) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
