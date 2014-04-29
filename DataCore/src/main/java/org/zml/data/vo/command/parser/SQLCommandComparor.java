package org.zml.data.vo.command.parser;

import java.util.Comparator;

import org.zml.data.vo.command.bind.CommandDefine;

public class SQLCommandComparor implements Comparator<CommandDefine> {

	@Override
	public int compare(CommandDefine o1, CommandDefine o2) {
		int index1 = -1;
		int index2 = -1;
		
		if( o1 != null ){
			index1 = (o1.getIndex() < 0 )?-1:o1.getIndex();
		}
		
		if( o2 != null ){
			index2 = (o2.getIndex() < 0 )?-1:o2.getIndex();
		}
		
		return index1 - index2;
	}

}
