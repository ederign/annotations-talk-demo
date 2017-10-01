package me.ederign.cola.dora;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import me.ederign.jdora.JDoraTest;

public class DoraExecutor {

    private int success = 0;
    private int errors = 0;
    private String errorLog = "";
    private String successLog = "";

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            DoraExecutor doraExecutor = new DoraExecutor();
            doraExecutor.execute("me.ederign.cola.dora.SampleTest");
            doraExecutor.results();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void results() {
        System.out.println("Success: " + success);
        System.out.println(successLog);
        System.out.println("Error: " + errors);
        System.out.println(errorLog);
    }

    private void execute(String fqcn) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> testClass = Class.forName(fqcn);

        Object testObject = testClass.newInstance();
        for (Method method : testObject.getClass().getDeclaredMethods()) {
            if (method.getAnnotation(JDoraTest.class) != null) {

                JDoraTest annotation = method.getAnnotation(JDoraTest.class);

//                if (annotation.expected() == Object.class) {
//                    executeTest(testObject,
//                                method);
//                } else {
//                    executeWithExpectedException(testObject,
//                                                 method,
//                                                 annotation);
//                }
            }
        }
    }

    private void executeWithExpectedException(Object testObject,
                                              Method method,
                                              JDoraTest annotation) {
        try {
            method.invoke(testObject);
            error(method);
        } catch (Exception e) {
            //TODO check if the exception is the right one
            success(method);
        }
    }

    private String executeTest(Object testObject,
                               Method method) {
        try {
            method.invoke(testObject);
            success(method);
        } catch (Exception e) {
            error(method);
        }
        return errorLog;
    }

    private void success(Method method) {
        successLog += "Success on method " + method.getName() + "\n";
        success++;
    }

    private void error(Method method) {
        errorLog += "Error on method " + method.getName() + "\n";
        errors++;
    }
}
