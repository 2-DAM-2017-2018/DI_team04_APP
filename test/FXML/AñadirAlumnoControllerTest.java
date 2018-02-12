/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import Main.Alumno;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author icc
 */
public class AñadirAlumnoControllerTest {
    
    public AñadirAlumnoControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setDialogStage method, of class AñadirAlumnoController.
     */
    @Test
    public void testSetDialogStage() {
        System.out.println("setDialogStage");
        Stage dialogStage = null;
        AñadirAlumnoController instance = new AñadirAlumnoController();
        instance.setDialogStage(dialogStage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPerson method, of class AñadirAlumnoController.
     */
    @Test
    public void testSetPerson() {
        System.out.println("setPerson");
        Alumno alumn = null;
        AñadirAlumnoController instance = new AñadirAlumnoController();
        instance.setPerson(alumn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOkClicked method, of class AñadirAlumnoController.
     */
    @Test
    public void testIsOkClicked() {
        System.out.println("isOkClicked");
        AñadirAlumnoController instance = new AñadirAlumnoController();
        boolean expResult = false;
        boolean result = instance.isOkClicked();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
