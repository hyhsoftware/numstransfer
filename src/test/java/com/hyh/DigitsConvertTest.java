package com.hyh;

import org.junit.Test;

import java.util.List;

/**
 * 单元测试类
 * @author hongyuhao
 * @date 2020-02-14
 */
public class DigitsConvertTest {


    @Test
    public void testCombine() {
        DigitsConverter digitsConverter = new DigitsConverter();
        List<String> result = digitsConverter.combine(9, 9);
        System.out.println(result.toString());
    }
}
