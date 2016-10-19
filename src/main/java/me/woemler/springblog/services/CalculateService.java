package me.woemler.springblog.services;

/**
 * 执行计算的服务，可能耗时较长，适于使用异步线程场景
 * @author PC
 *
 */
public interface CalculateService {

	/**
	 * 执行加法运算
	 */
	void executePlus(String key);
	
}
