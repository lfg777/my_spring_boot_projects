package com.lfg.java2groovy;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author fg.Li
 * 2018/7/24:15:00
 * <p>
 *
 **/
public class GroovyDemo {

    private static String script = "package com.lfg.java2groovy;\n" +
            "class Groovy {\n" +
            "\n" +
            "    String abc(String str) {\n" +
            "        return \"print \"+str;\n" +
            "    }\n" +
            "}";

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("groovy");
        Object eval = engine.eval(script);
        Invocable invocable = (Invocable)engine;
        invocable.invokeFunction("abc", "lfg");

    }
}
