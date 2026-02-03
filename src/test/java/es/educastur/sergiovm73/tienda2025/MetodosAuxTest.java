/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package es.educastur.sergiovm73.tienda2025;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 1dawd24
 */
public class MetodosAuxTest {
    
    public MetodosAuxTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of esInt method, of class MetodosAux.
     */
    @Test
    public void testEsInt() {
        assertTrue(MetodosAux.esInt("5"));
        assertTrue(MetodosAux.esInt("-5"));
        assertFalse(MetodosAux.esInt("5.5"));
        assertFalse(MetodosAux.esInt("dcdjcdc"));
        
    }

    /**
     * Test of esDouble method, of class MetodosAux.
     */
    @Test
    public void testEsDouble() {
        assertTrue(MetodosAux.esDouble("5"));
        assertTrue(MetodosAux.esDouble("-5"));
        assertTrue(MetodosAux.esDouble("5.5"));
        assertFalse(MetodosAux.esDouble("dcdjcdc"));
    }

    /**
     * Test of validarDNI method, of class MetodosAux.
     */
    @Test
    public void testValidarDNI() {
        assertTrue(MetodosAux.validarDNI("80580845T"));
        assertTrue(MetodosAux.validarDNI("36347775R"));
        assertFalse(MetodosAux.validarDNI("36347775A"));
        assertFalse(MetodosAux.validarDNI("80580845P"));
    }
    
}
