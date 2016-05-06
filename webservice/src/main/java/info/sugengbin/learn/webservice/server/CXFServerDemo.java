package info.sugengbin.learn.webservice.server;

import javax.jws.WebService;

@WebService
public interface CXFServerDemo {

	public String sayHello(String foo);
}
