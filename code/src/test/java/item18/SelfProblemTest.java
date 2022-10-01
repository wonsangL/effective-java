package item18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelfProblemTest {
    @Test
    void solveSelfProblemWithInheritance() {
        Controller controller = new Controller();
        ModelChangeCounter model = new ModelChangeCounter(controller);

        controller.doChange();

        assertEquals(1, model.counter);
    }
}
