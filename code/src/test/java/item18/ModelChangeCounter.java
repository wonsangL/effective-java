package item18;

public class ModelChangeCounter extends Model {
    int counter;

    public ModelChangeCounter(Controller controller) {
        super(controller);
    }

    @Override
    public void makeChange() {
        counter++;
        super.makeChange();
    }
}
