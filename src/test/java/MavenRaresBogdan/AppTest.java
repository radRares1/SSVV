package MavenRaresBogdan;

import static org.junit.Assert.assertTrue;

import com.sun.jmx.mbeanserver.Repository;
import console.UI;
import domain.Nota;
import domain.Student;
import domain.Tema;
import org.junit.Test;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    private Validator<Student> studentValidator = new StudentValidator();
    private Validator<Tema> temaValidator = new TemaValidator();
    private Validator<Nota> notaValidator = new NotaValidator();

    private StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
    private TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
    private NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

    Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testAddStudentSuccess() {
        assertEquals(service.saveStudent("15", "Diana", 935), 1);
    }
    
    @Test
    public void testAddStudentFailure() {
        assertEquals(service.saveStudent("16", "Roland", 934), 1);
        assertEquals(service.saveStudent("16", "Roland", 934), 0);

    }

    @Test
    public void TC1_BBT_EC() {
        assertEquals(service.saveStudent("0", "Ema", 936), 1);
    }

    @Test
    public void TC2_BBT_EC() {
        assertEquals(service.saveStudent(null, "Ema", 936), 0);
    }

    @Test
    public void TC3_BBT_EC() { assertEquals(service.saveStudent("0", "Ema", 938), 0); }

    @Test
    public void TC4_BBT_EC() {
        assertEquals(service.saveStudent("0", "Ema", 939), 0);
    }

    @Test
    public void TC5_BBT_BVA() {
        assertEquals(service.saveStudent("0", "Ema", 111), 1);
    }

    @Test
    public void TC6_BBT_BVA() {
        assertEquals(service.saveStudent("0", "Ema", 109), 0);
    }

    @Test
    public void TC7_BBT_BVA() { assertEquals(service.saveStudent("0", "Ema", 937), 1); }

    @Test
    public void TC8_BBT_BVA() {
        assertEquals(service.saveStudent("0", "Ema", 938), 0);
    }

    @Test
    public void TC9_BBT_BVA() { assertEquals(service.saveStudent("0", "Ema", 200), 1); }

    @Test
    public void TC10_BBT_BVA() {
        assertEquals(service.saveStudent("0", "Ema", -1), 0);
    }

    @Test
    public void TC11_BBT_BVA() { assertEquals(service.saveStudent("0", "abc", 123), 1); }

    @Test
    public void TC12_BBT_BVA() {
        assertEquals(service.saveStudent("0", "", 123), 0);
    }

    @Test
    public void TC13_BBT_BVA() {
        assertEquals(service.saveStudent("0", null, 123), 0);
    }
}
