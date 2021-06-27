package cn.xbmchina.auth.test;

import org.junit.Test;
import org.springframework.util.AntPathMatcher;

/**
 * 使用Spring自带工具对uri进行通配符匹配
 * https://blog.csdn.net/qq_34977392/article/details/103053358
 */
public class Testttt {

    @Test
    public void testMatch() {
        AntPathMatcher matcher = new AntPathMatcher();
        String pattern = "/abc/**/a.jsp";
        System.out.println("pattern:" + pattern);
        System.out.println("/abc/aa/bb/a.jsp:" + matcher.match(pattern, "/abc/aa/bb/a.jsp"));
        System.out.println("/aBc/aa/bb/a.jsp:" + matcher.match(pattern, "/aBc/aa/bb/a.jsp"));
        System.out.println("/abc/a.jsp:" + matcher.match(pattern, "/abc/a.jsp"));
    }

}
