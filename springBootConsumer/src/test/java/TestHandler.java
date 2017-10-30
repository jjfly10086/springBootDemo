import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/6/9 0009.
 * JDK Proxy
 */
public class TestHandler implements InvocationHandler {

    private Object target;
    public TestHandler(Object target){
        super();
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin ...");
        method.invoke(target,args);
        System.out.println("end ...");
        return null;
    }
}
