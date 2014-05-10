package org.zml.data.vo.command.parser;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import org.zml.data.vo.command.bind.CommandDefine;

public class SQLCommandReversedComparor implements Comparator<CommandDefine> {
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
		
		return  index2 - index1 ;
	}

	@Override
	public Comparator<CommandDefine> reversed() {
		// TODO Auto-generated method stub
		return new SQLCommandComparor();
	}

	@Override
	public Comparator<CommandDefine> thenComparing(
			Comparator<? super CommandDefine> other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U> Comparator<CommandDefine> thenComparing(
			Function<? super CommandDefine, ? extends U> keyExtractor,
			Comparator<? super U> keyComparator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U extends Comparable<? super U>> Comparator<CommandDefine> thenComparing(
			Function<? super CommandDefine, ? extends U> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<CommandDefine> thenComparingInt(
			ToIntFunction<? super CommandDefine> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<CommandDefine> thenComparingLong(
			ToLongFunction<? super CommandDefine> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comparator<CommandDefine> thenComparingDouble(
			ToDoubleFunction<? super CommandDefine> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

}
