package item06;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class KeySetTest {
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(KeySetTest::concurrentHashMapTest);
        Thread t2 = new Thread(KeySetTest::hashMapTest);

//        t1.start();
        t2.start();

//        t1.join();
        t2.join();
    }

    private static void concurrentHashMapTest() {
        ConcurrentHashMap<String, String> sharedMap = new ConcurrentHashMap<>();
        sharedMap.put("key", "value");

        new Thread(() -> {
            try {
                ConcurrentHashMap.KeySetView<String, String> keys = sharedMap.keySet();
                Thread.sleep(1000);
                keys.remove("key");
//                keys.clear();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                ConcurrentHashMap.KeySetView<String, String> keys = sharedMap.keySet();
                Thread.sleep(2000);

                if (!keys.contains("key")) {
                    System.out.println("ConcurrentHashMap key has been deleted!!");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void hashMapTest() {
        HashMap<String, String> sharedMap = new HashMap<>();
        sharedMap.put("key", "value");

        new Thread(() -> {
            try {
                Set<String> keys = sharedMap.keySet();
                Thread.sleep(1000);
                keys.remove("key");
//                keys.clear();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Set<String> keys = sharedMap.keySet();
                Thread.sleep(2000);

                if (!keys.contains("key")) {
                    System.out.println("HashMap key has been deleted!!");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
