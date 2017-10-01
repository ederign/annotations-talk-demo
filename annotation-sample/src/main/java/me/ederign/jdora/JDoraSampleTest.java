package me.ederign.jdora;

public class JDoraSampleTest {

    @JDoraTest
    public void testSuccess() {
        //success
        System.out.println("YAY!");
    }

    public void noAnnotation() {
        System.out.println("error!");
    }

    //    @JDoraTest
//    public void testError() {
//        error
//    }

//
//    @JDoraTest(expected = RuntimeException.class)
//    public void testExpected() {
//        throw new RuntimeException();
//    }
//
//    @JDoraTest(expected = RuntimeException.class)
//    public void testErrorExpected() {
//    }
//
//    @JDoraTest
//    public void assertTestError() {
//        DoraTestUtils.assertEquals(1,
//                                   2);
//    }
//
//    @JDoraTest
//    public void assertTestSuccess() {
//        DoraTestUtils.assertEquals(2,
//                                   2);
//    }
}
