package me.ederign.cola.dora;

public class SampleTest {

    @DoraTest
    public void testSuccess() {
        //success
    }

    @DoraTest
    public void assertTestError() {
        DoraTestUtils.assertEquals(1,
                                   2);
    }

    public void noAnnotation() {
    }

    @DoraTest(expected = RuntimeException.class)
    public void testExpected() {
        throw new RuntimeException();
    }

    @DoraTest(expected = RuntimeException.class)
    public void testErrorExpected() {
    }

    @DoraTest
    public void assertTestSuccess() {
        DoraTestUtils.assertEquals(2,
                                   2);
    }
}
