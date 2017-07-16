package com.example.kotlin.springBootKotlin;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author chensy
 * @since 2017/6/28.
 */
public class Test {
    @org.junit.Test
    public void test() {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }

    @org.junit.Test
    public void test1() throws IOException {
        StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("hello,${name.key}");
        Map<String, String> map = new HashMap<>();
        map.put("key", "dddd");
        Object b = map;
        t.binding("name", b);
        String str = t.render();
        System.out.println(str);
    }

    @org.junit.Test
    public void test2() throws InterruptedException {
        Map map = new HashMap();
        map.put("a", "a");
        LinkedList linkedList = new LinkedList();
        linkedList.add(map);
        System.out.println(linkedList);
        map.clear();
        map = null;
        System.out.println(linkedList);
    }
}
