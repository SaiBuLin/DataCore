package org.zml.data.vo.tools.action.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zml.data.dataset.bind.NetDataSet;
import org.zml.data.vo.bind.Form;
import org.zml.data.vo.form.CommandForm;
import org.zml.data.vo.form.VOForm;
import org.zml.data.vo.tools.action.IFormActionTools;
import org.zml.data.vo.tools.connection.IConnectionAble;
import org.zml.util.UtilTools;

public class SQLGenerateFormAction implements IFormActionTools {

	private static Logger logger = LogManager.getLogger("DataSerivce.vo.parser.v2013");

	@Override
	public String getFromQueryString(VOForm voForm, CommandForm selectForm,
			CommandForm whereForm, CommandForm orderForm,
			CommandForm groupbyForm, CommandForm dataset) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFromQueryString(VOForm voForm, CommandForm viewForm)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFromUpdateString(VOForm voForm, CommandForm selectForm,
			CommandForm whereForm, CommandForm orderForm,
			CommandForm groupbyForm, CommandForm dataset) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFromInsertString(VOForm voForm, CommandForm selectForm,
			CommandForm whereForm, CommandForm orderForm,
			CommandForm groupbyForm, CommandForm dataset) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFromDeleteString(VOForm voForm, CommandForm selectForm,
			CommandForm whereForm, CommandForm orderForm,
			CommandForm groupbyForm, CommandForm dataset) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NetDataSet executeQuery(IConnectionAble connection, VOForm voForm,
			CommandForm cmdForm) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NetDataSet executeUpdate(IConnectionAble connection, VOForm voForm,
			CommandForm cmdForm) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NetDataSet executeInsert(IConnectionAble connection, VOForm voForm,
			CommandForm cmdForm) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NetDataSet executeDelete(IConnectionAble connection, VOForm voForm,
			CommandForm cmdForm) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String parseSelectFieldForQuery(String alias, String field,
			String extendString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String parseSelectFieldForUpdate(String alias, String field,
			String extendString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String parseSelectFieldForInsert(String alias, String field,
			String extendString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String parseSelectFieldForDelete(String alias, String field,
			String extendString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String parseWhereFieldForQuery(String alias, String field,
			String extendString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String parseWhereFieldForUpdate(String alias, String field,
			String extendString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String parseWhereFieldForInsert(String alias, String field,
			String extendString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String parseWhereFieldForDelete(String alias, String field,
			String extendString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String parseOrderFieldForQuery(String alias, String field,
			String extendString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String parseGroupbyFieldForQuery(String alias, String field,
			String extendString) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
