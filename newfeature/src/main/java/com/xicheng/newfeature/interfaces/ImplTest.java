package com.xicheng.newfeature.interfaces;

import org.junit.Test;

/**
 * @author xichengxml
 * @date 2018/12/29
 * @description
 */
public class ImplTest implements ITest01, ITest02 {

    @Test
    public void testDefault() {
        test01();
        test02();
    }
}
