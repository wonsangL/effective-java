package item02.consistency;

public class JavaBeansPattern {

    public static void main(String[] args) throws InterruptedException {
        NutritionFacts nutritionFacts = new NutritionFacts();

        new Thread(() -> {
            System.out.println("nutrition serving size: " + nutritionFacts.getServingSize());
        }).start();

        //출력되는 것보다 값이 빠르게 설정되는 것을 방지
        Thread.sleep(500);
        nutritionFacts.setServingSize(10);

        new Thread(() -> {
            //객체에 접근하는 타이밍에 따라 값이 변할 수 있다(일관성이 무너진 상태이다.).
            System.out.println("nutrition serving size: " + nutritionFacts.getServingSize());
        }).start();

        //모든 thread 수행하기를 기다린다.
        Thread.sleep(1000);
    }

    private static class NutritionFacts {
        private int servingSize;
        //...생략

        public NutritionFacts() {

        }

        public void setServingSize(int servingSize) {
            //servingSize가 0일 경우 유효하지 않다고 가정한다.
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
