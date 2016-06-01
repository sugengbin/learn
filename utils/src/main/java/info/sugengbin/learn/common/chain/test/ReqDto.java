package info.sugengbin.learn.common.chain.test;

import java.io.Serializable;

/**
 * 
 * ClassName: ReqDto <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年6月1日 下午11:06:27 <br/>
 * 
 * @author sugengbin
 * @version
 * @since JDK 1.7
 */
public class ReqDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3605578439783378176L;
	private String device;
	private String user;
	private String version;

	public String getDevice() {
		return device;
	}

	public ReqDto setDevice(String device) {
		this.device = device;
		return this;
	}

	public String getUser() {
		return user;
	}

	public ReqDto setUser(String user) {
		this.user = user;
		return this;
	}

	public String getVersion() {
		return version;
	}

	public ReqDto setVersion(String version) {
		this.version = version;
		return this;
	}

}
