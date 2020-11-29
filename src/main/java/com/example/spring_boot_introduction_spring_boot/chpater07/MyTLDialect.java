package com.example.spring_boot_introduction_spring_boot.chpater07;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MyTLDialect extends AbstractDialect implements IExpressionObjectDialect {

    private static final Map<String, Object> EXPRESSION_OBJECT;

    static {
        Map<String, Object> objects = new HashMap<>();
        objects.put("myTLHelper", new MyTLUtility());
        EXPRESSION_OBJECT = Collections.unmodifiableMap(objects);
    }

    public MyTLDialect() {
        super("hello-dialect");
    }

    public static Map<String, Object> getExpressionObject() {
        return EXPRESSION_OBJECT;
    }

    @Override
    public IExpressionObjectFactory getExpressionObjectFactory() {
        return null;
    }
}
