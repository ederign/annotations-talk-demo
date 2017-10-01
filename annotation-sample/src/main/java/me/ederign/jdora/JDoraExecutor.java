package me.ederign.jdora;

import java.lang.reflect.InvocationTargetException;

public class JDoraExecutor {

    private int success;
    private int error;

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            JDoraExecutor JDoraExecutor = new JDoraExecutor();
            JDoraExecutor.execute("me.ederign.jdora.JDoraSampleTest");
            JDoraExecutor.results();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void results() {
        System.out.println("Test executed");
        System.out.println("su " + success);
        System.out.println("err " + error);
    }

    private void execute(String fqcn) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {

    }
}
