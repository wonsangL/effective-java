package item18;

public class Model {
    private final Controller controller;

    public Model(Controller controller) {
        this.controller = controller;
        this.controller.register(this);
    }

    public void makeChange() {
        System.out.println("Call make change!!");
    }
}
