package info.sugengbin.learn.common.chain;

/**
 * 
 * ClassName: ICheckHandler <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2016年6月1日 下午11:08:57 <br/> 
 * 
 * @author sugengbin 
 * @version @param <Req> 
 * @since JDK 1.7
 */
public interface ICheckHandler<Req> {

	/**
	 * handler的开关
	 * 
	 * @param req
	 * @return
	 */
	boolean isOpen(Req req);

	/**
	 * 条件检查
	 * 
	 * @param req
	 * @return
	 */
	boolean doCheck(Req req);
}
