/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FXML;

import Main.MainApp;
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
public class ListaAlumnosControllerTest {
    
    public ListaAlumnosControllerTest() {
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
     * Test of setMainApp method, of class ListaAlumnosController.
     */
    @Test
    public void testSetMainApp() {
        System.out.println("setMainApp");
        MainApp mainApp = null;
        ListaAlumnosController instance = new ListaAlumnosController();
        instance.setMainApp(mainApp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
