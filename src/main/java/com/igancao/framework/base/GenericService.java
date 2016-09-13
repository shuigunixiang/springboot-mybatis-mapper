package com.igancao.framework.base;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface GenericService<T> {

	/**
	 * 根据对象获取数据列表
	 * 
	 * @param t
	 * @return
	 */
	public List<T> getList(T t);

	/**
	 * 根据对象获取数据列表总数
	 * 
	 * @param t
	 * @return
	 */
	public int getCount(T t);

	/**
	 * 获取全部数据列表
	 * 
	 * @param t
	 * @return
	 */
	public List<T> getAll();

	/**
	 * 根据对象获取单条数据
	 * 
	 * @param t
	 * @return
	 */
	public T getOne(T t);

	/**
	 * 根据主键获取单条数据
	 * 
	 * @param pk
	 * @return
	 */
	public T getOneByPk(Object pk);

	/**
	 * 单条数据新增
	 * 
	 * @param t
	 * @return
	 */
	public int create(T t);

	/**
	 * 批量数据新增
	 * 
	 * @param t
	 * @return
	 */
	public int createBatch(List<T> list);

	/**
	 * 根据主键修改数据
	 * 
	 * @param t
	 * @return
	 */
	public int updateByPk(T t);

	/**
	 * 
	 * 删除数据
	 * 
	 * @param t
	 * @return
	 */
	public int delete(T t);

	/**
	 * 
	 * 根据主键删除数据
	 * 
	 * @param pk
	 * @return
	 */
	public int deleteByPk(Object pk);

}
