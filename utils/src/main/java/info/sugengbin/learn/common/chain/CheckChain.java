package info.sugengbin.learn.common.chain;

import java.util.List;

/**
 * 
 * ClassName: CheckChain <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason: TODO ADD REASON(可选). <br/> 
 * date: 2016年6月1日 下午11:08:29 <br/> 
 * 
 * @author sugengbin 
 * @version @param <Req> 
 * @since JDK 1.7
 */
public class CheckChain<Req> {

	private List<ICheckHandler<Req>> checkHandlers;

	public void setCheckHandlers(List<ICheckHandler<Req>> checkHandlers) {
		this.checkHandlers = checkHandlers;
	}

	/**
	 * 
	 * @param req
	 * @return
	 */
	public boolean check(Req req) {
		boolean isAllRight = false;
		for (ICheckHandler<Req> handler : checkHandlers) {
			if (handler.isOpen(req)) {
				isAllRight = handler.doCheck(req);
				if (!isAllRight) {
					break;
				}
			}
		}
		return isAllRight;
	}
}
