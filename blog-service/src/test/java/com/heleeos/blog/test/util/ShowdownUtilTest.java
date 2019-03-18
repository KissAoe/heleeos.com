package com.heleeos.blog.test.util;

import com.heleeos.blog.util.ShowdownUtil;

/**
 *
 * Created by liyu 2019/03/18
 */
public class ShowdownUtilTest {

    public static void main(String[] args) {
        String html = ShowdownUtil.markdownToHtml("# 1.首页");
        System.out.println(html);
    }
}
