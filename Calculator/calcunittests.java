package Module9hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class calcunittests {

    private CalcController calcController;

    @BeforeEach
    void setUp() {
        calcController = new CalcController();
    }

    @Test
    void testActionButton() {
       
        String expectedOutput = "1";

        calcController.ActionButton(new ActionEvent("1"));

        assertEquals(expectedOutput, calcController.output.getText());
    }

    @Test
    void testOperationButton_Addition() {
       
        calcController.output.setText("2");
        String expectedOutput = "2 + ";

        calcController.OperationButton(new ActionEvent("+"));

        assertEquals(expectedOutput, calcController.output.getText());
    }

    @Test
    void testOperationButton_Equal() {
        
        calcController.output.setText("2 + 2");
        String expectedOutput = "4";

        calcController.OperationButton(new ActionEvent("="));

        assertEquals(expectedOutput, calcController.output.getText());
    }

    @Test
    void testClearButton() {
        
        calcController.output.setText("2 + 2");

        calcController.ClearButton(new ActionEvent());

        assertEquals("", calcController.output.getText());
    }

   
}
