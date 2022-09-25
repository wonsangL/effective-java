package item09;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AutoCloseableTest {
    public static void main(String[] args) {
        try {
            autoCloseTest();
        } catch (IOException e) {
            e.printStackTrace();

            Throwable[] suppressed = e.getSuppressed();

            for (Throwable throwable : suppressed) {
                throwable.printStackTrace();
            }
        }
    }

    private static void autoCloseTest() throws IOException {
        try (BufferedReader reader = new BufferedReader(new TestFileReader("./item_019.md"))) {
            throw new IOException();
        }
    }

    private static class TestFileReader extends FileReader {
        public TestFileReader(String fileName) throws FileNotFoundException {
            super(fileName);
        }

        @Override
        public void close() throws IOException {
            throw new IOException();
        }
    }
}
