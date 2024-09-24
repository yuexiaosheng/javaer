package com.life.marco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

/**
 * class B 测试循环调用类问题 ScopedProxyMode.TARGET_CLASS 表示动态调用
 *
 * @author walter ge
 * @date 2023/06/02
 */
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Service
public class B {

    private A a;

    @Autowired
    public B(A a) {
        this.a = a;
    }

}
