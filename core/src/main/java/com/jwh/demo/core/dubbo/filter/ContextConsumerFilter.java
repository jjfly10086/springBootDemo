package com.jwh.demo.core.dubbo.filter;

import com.alibaba.dubbo.rpc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class ContextConsumerFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(ContextConsumerFilter.class);
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
        logger.info("invoke before-------------->URL:{}",RpcContext.getContext().getUrl());
        RpcContext.getContext().setAttachment("key","11111111");
        Result result = invoker.invoke(invocation);
        return result;
        //return invoker.invoke(invocation);
    }
}
