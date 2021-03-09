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
        assertEquals(service.saveStudent("9", "Diana", 935), 1);
    }


    @Test
    public void testAddStudentFailure() {
        assertEquals(service.saveStudent("8", "Roland", 934), 1);
        assertEquals(service.saveStudent("8", "Roland", 934), 0);

    }
}
