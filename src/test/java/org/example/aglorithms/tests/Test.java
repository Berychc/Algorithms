package org.example.aglorithms.tests;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.assertj.core.api.Assertions;


public class Tests {

    private static void m1() {
        final var expected = "Hello, World!";

        App.main(null);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        App.main(null);

        final var actual = out.toString().trim();

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
