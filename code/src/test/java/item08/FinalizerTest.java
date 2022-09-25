package item08;

public class FinalizerTest {
    public static void main(String[] args) {
        FinalizedObject finalizedObject = new FinalizedObject();
        finalizedObject = null; //객체 참조 해제

        System.gc();
    }

    private static class FinalizedObject {
        protected void finalize() {
            System.out.println("finalized!!");
        }
    }
}
