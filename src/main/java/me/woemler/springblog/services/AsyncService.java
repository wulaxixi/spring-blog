package me.woemler.springblog.services;

/**
 * 
 * �첽����ӿ�
 * @author PC
 *
 */
public interface AsyncService {
	
	/**
	 * @param cacheKey
	 * @throws Exception
	 */
	void asyncMethod(String cacheKey) throws Exception;
	
	/**
	 * @param cacheKey
	 * @return
	 * @throws Exception
	 */
	Object getProcess(String cacheKey) throws Exception;
	
	/**
	 * @param cacheKey
	 * @throws Exception
	 */
	void clearCache(String cacheKey) throws Exception;
}
