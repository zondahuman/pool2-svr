package com.abin.lee.pool2.common;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * Created by abin on 2016/12/17 2016/12/17.
 * pool2-svr
 * com.abin.lee.pool2.common
 */
public class AutoClearGenericObjectPool<T> extends GenericObjectPool<T> {

    public AutoClearGenericObjectPool(PooledObjectFactory<T> factory, GenericObjectPoolConfig config) {
        super(factory, config);
    }

    public AutoClearGenericObjectPool(PooledObjectFactory<T> factory) {
        super(factory);
    }

    public void returnObject(T object){
        super.returnObject(object);
        //空闲数>=激活数时，清理掉空闲连接
        if(getNumIdle() >= getNumActive()){
            clear();
        }
    }

}
