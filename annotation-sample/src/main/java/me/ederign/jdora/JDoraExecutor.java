package me.ederign.jdora;

public class JDoraExecutor {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            JDoraExecutor JDoraExecutor = new JDoraExecutor();
            JDoraExecutor.execute("me.ederign.jdora.SampleTest");
            JDoraExecutor.results();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void results() {
        System.out.println("Test executed");
    }

    private void execute(String fqcn) {

    }
}
