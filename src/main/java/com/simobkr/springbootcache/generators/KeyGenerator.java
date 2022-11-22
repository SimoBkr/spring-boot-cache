package com.simobkr.springbootcache.generators;

import java.lang.reflect.Method;

@FunctionalInterface
public interface KeyGenerator {

    Object generate(Object target, Method method, Object... params);
}
