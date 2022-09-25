package item02.consistency;

public class Constructor {
    public static void main(String[] args) throws InterruptedException {
        NutritionFacts nutritionFacts = new NutritionFacts(10);

        new Thread(() -> {
            System.out.println("nutrition serving size: " + nutritionFacts.getServingSize());
        }).start();

        new Thread(() -> {
            //객체가 생성될 때 값이 설정되기 때문에 일관성을 보장한다(thread-safe 하다.).
            System.out.println("nutrition serving size: " + nutritionFacts.getServingSize());
        }).start();

        //모든 thread 수행하기를 기다린다.
        Thread.sleep(1000);
    }
    private static class NutritionFacts {
        private final int servingSize;
        //...생략

        public NutritionFacts(int servingSize) {
            if (servingSize == 0) {
                throw new IllegalArgumentException();
            }

            this.servingSize = servingSize;
        }

        public int getServingSize() {
            return servingSize;
        }
    }
}
