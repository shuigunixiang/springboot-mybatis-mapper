package com.igancao.framework.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.igancao.framework.mybatis.MyMapper;

public abstract class AbstractGenericService<T> implements GenericService<T> {

	private MyMapper<T> myMapper;

	public MyMapper<T> getMyMapper() {
		return myMapper;
	}

	@Autowired
	public void setMyMapper(MyMapper<T> myMapper) {
		this.myMapper = myMapper;
	}

	@Override
	public List<T> getList(T t) {
		List<T> list = myMapper.select(t);
		handlerData(list);
		return list;
	}

	@Override
	public int getCount(T t) {
		return myMapper.selectCount(t);
	}

	@Override
	public List<T> getAll() {
		List<T> all = myMapper.selectAll();
		handlerData(all);
		return all;
	}

	@Override
	public T getOne(T t) {
		T one = myMapper.selectOne(t);
		handlerData(one);
		return one;
	}

	@Override
	public T getOneByPk(Object pk) {
		T one = myMapper.selectByPrimaryKey(pk);
		handlerData(one);
		return one;

	}

	@Override
	public int create(T t) {
		return myMapper.insertSelective(t);
	}

	@Override
	public int createBatch(List<T> list) {
		return myMapper.insertList(list);
	}

	@Override
	public int updateByPk(T t) {
		return myMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public int delete(T t) {
		return myMapper.delete(t);
	}

	@Override
	public int deleteByPk(Object pk) {
		return myMapper.deleteByPrimaryKey(pk);
	}

	/**
	 * 
	 * 数据处理
	 * 
	 * @param obj
	 */
	protected abstract void handlerData(Object obj);

}
