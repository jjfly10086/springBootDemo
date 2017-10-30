package com.jwh.demo.core.dubbo.filter;

import com.alibaba.dubbo.rpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class ContextProviderFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(ContextProviderFilter.class);
    /**
     * do invoke filter.
     * <p>
     * <code>
     * // before filter
     * Result result = invoker.invoke(invocation);
     * // after filter
     * return result;
     * </code>
     *
     * @param invoker    service
     * @param invocation invocation.
     * @return invoke result.
     * @throws RpcException
     * @see Invoker#invoke(Invocation)
     */
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        logger.info("invoke after ---------------------->"+RpcContext.getContext().getAttachment("key"));
        return invoker.invoke(invocation);
    }
}
