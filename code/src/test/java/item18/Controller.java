package item18;

public class Controller {
    private Model model;

    public void register(Model model) {
        this.model = model;
    }

    public void doChange() {
        model.makeChange();
    }
}
