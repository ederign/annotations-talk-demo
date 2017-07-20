package me.ederign.cola.dora;

public class DoraTestUtils {

    public static void assertEquals(int a,
                                    int b) {

        if (a != b) {
            throw new RuntimeException();
        }
    }
}
