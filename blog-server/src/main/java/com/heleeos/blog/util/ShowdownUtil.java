package com.heleeos.blog.util;

import org.springframework.util.ResourceUtils;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;

/**
 * showdown工具
 * Created by liyu 2019/03/18
 */
public class ShowdownUtil {

    /**
     * @param markdown
     *
     * @return
     */
    public static String markdownToHtml(String markdown) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine jsEngine = manager.getEngineByName("nashorn");
        try {
            String jsFile = ResourceUtils.getURL("/app/public/lib/showdown/showdown.min.js").getPath();
            jsEngine.eval(new FileReader(jsFile));
            Object showdownConverter = jsEngine.eval("new showdown.Converter()");
            return ((Invocable) jsEngine).invokeMethod(showdownConverter, "makeHtml", markdown) + "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
