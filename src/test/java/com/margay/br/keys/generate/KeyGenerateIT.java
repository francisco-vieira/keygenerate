/*
 * Desenvolvido por: Margay Sistemas
 * http://margay.com.br
 * contato@margay.com.br
 * (93)99155-3577
 */
package com.margay.br.keys.generate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author francisco
 */
public class KeyGenerateIT {
    
    public KeyGenerateIT() {
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
     * Test of produtoKey method, of class KeyGenerate.
     */
    @Test
    @Ignore
    public void testProdutoKey() {
        System.out.println("produtoKey");
        String expResult = "";
        String result = KeyGenerate.produtoKey();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readData method, of class KeyGenerate.
     */
    @Test
    @Ignore
    public void testReadData() {
        System.out.println("readData");
        String expResult = "000913C";
        String result = KeyGenerate.readData();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeData method, of class KeyGenerate.
     */
    @Test
    @Ignore
    public void testWriteData() {
        System.out.println("writeData");
        String readData = "";
        String fileNameExtension = "readFile.sys";
        String expResult = "";
        String result = KeyGenerate.writeData(readData, fileNameExtension);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keyCode method, of class KeyGenerate.
     */
    @Test
    @Ignore
    public void testKeyCode() {
        System.out.println("keyCode");
        String expResult = "";
        String result = KeyGenerate.keyCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
