package me.ederign.jdora;

import java.lang.reflect.InvocationTargetException;

public class JDoraExecutor {

    private int success;
    private int error;

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            JDoraExecutor JDoraExecutor = new JDoraExecutor();
            String fqcn = "me.ederign.jdora.JDoraSampleTest";
            JDoraExecutor.execute(fqcn);
            JDoraExecutor.results(fqcn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void results(String fqcn) {
        System.out.println("====================================================");
        System.out.println("Test results for: " + fqcn);
//        System.out.println("su " + success);
//        System.out.println("err " + error);
    }

    private void execute(String fqcn) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {

    }
}
