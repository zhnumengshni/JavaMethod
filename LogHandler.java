package com.pukka.cloud.metanlp;

import javassist.*;

import java.io.IOException;

/**
 * 在spring出现报错被第三方异常代替，将异常拦截后显示最初的异常
 */
public class LogHandler {
    public static void addLog() {
        try {
            ClassPool pool = ClassPool.getDefault();
            // 替换为目标类的完整类名
            CtClass targetClass = pool.get("com.zaxxer.hikari.pool.ProxyConnection");

            CtMethod targetMethod = targetClass.getDeclaredMethod("checkException");
            String logCode = "LOGGER.error(\"拦截gbase checkException 发现异常 errMsg:{}\",$1.getMessage(),$1);";
            targetMethod.insertBefore(logCode);

            targetClass.toBytecode();
            pool.toClass(targetClass);
        } catch (NotFoundException | CannotCompileException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
