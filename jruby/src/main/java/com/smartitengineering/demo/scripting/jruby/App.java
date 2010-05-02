package com.smartitengineering.demo.scripting.jruby;

import java.io.InputStream;
import org.jruby.embed.ScriptingContainer;
import org.jruby.javasupport.JavaEmbedUtils;
import org.jruby.javasupport.JavaEmbedUtils.EvalUnit;
import org.jruby.runtime.builtin.IRubyObject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ScriptingContainer container = new ScriptingContainer();
        String filename = "jruby-script.rb";
        InputStream scriptStream = App.class.getClassLoader().getResourceAsStream(filename);
        EvalUnit evalUnit = container.parse(scriptStream, filename);
        container.put("@test", "TEST");
        IRubyObject rObj = evalUnit.run();
        System.out.println(JavaEmbedUtils.rubyToJava(rObj));
    }
}
