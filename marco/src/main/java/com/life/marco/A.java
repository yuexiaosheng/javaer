package com.life.marco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
/**
 * class A 测试循环调用类问题 和 B联调
 *
 * @author walter ge
 * @date 2023/06/02
 */
@Service
public class A {

    private B b;

    @Autowired
    public A(B b) {
        this.b = b;
    }
}


