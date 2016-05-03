package info.sugengbin.learn.common.test.beanutils;

public interface IMethodCallBack {

    String getMethodName();

    ToBean callMethod(FromBean frombean)  throws Exception;

}