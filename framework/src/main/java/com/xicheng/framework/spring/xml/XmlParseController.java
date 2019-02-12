package com.xicheng.framework.spring.xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * @author xichengxml
 * @date 2019/2/12 9:24
 */
public class XmlParseController {

    @Test
    public void test01() throws Exception {
        File file = new File("D:\\user\\github\\woodencottage\\framework\\src\\main\\resources\\xml\\testxml.xml");
        SAXReader reader = new SAXReader();
        Document document = reader.read(file);
        Element rootElement = document.getRootElement();
        // 所有元素
        List<Element> elements = rootElement.elements();

        for (Element element : elements) {
            // 获取bean中属性class的值
            String className = element.attributeValue("class");
            System.out.println(className);
            // 通过反射调用类方法
            Class<?> xmlBeanClass = Class.forName(className);
            XmlBean xmlBeanInstance = (XmlBean) xmlBeanClass.newInstance();
            xmlBeanInstance.testInvocation();

        }
    }
}
