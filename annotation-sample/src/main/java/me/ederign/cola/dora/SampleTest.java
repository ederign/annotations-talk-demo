package me.ederign.cola.dora;

public class SampleTest {

    public void noAnnotation() {
    }

    @DoraTest
    public void testSuccess() {
        //success
    }

    @DoraTest(expected = RuntimeException.class)
    public void testExpected() {
        throw new RuntimeException();
    }

    @DoraTest(expected = RuntimeException.class)
    public void testErrorExpected() {
    }

    @DoraTest
    public void assertTestError() {
        DoraTestUtils.assertEquals(1,
                                   2);
    }

    @DoraTest
    public void assertTestSuccess() {
        DoraTestUtils.assertEquals(2,
                                   2);
    }
}
