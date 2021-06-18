package Lab2Maven;

import static org.junit.Assert.assertTrue;

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

    private StudentXMLRepository fileRepository1;
    private TemaXMLRepository fileRepository2;
    private NotaXMLRepository fileRepository3;

    Service service = new Service(fileRepository1, fileRepository2, fileRepository3);



    @Before
    public void setup() {
        Validator<Student> vs = new StudentValidator();
        Validator<Nota> ns = new NotaValidator();
        Validator<Tema> ts = new TemaValidator();


        fileRepository1 = new StudentXMLRepository(vs, "studenti.xml");
        fileRepository3 = new NotaXMLRepository(ns, "note.xml");
        fileRepository2 = new TemaXMLRepository(ts, "teme.xml");
        service = new Service(fileRepository1, fileRepository2, fileRepository3);

    }

    @After
    public void tearDown() {
        try {
            String defaultFileContent = new String(Files.readAllBytes(Paths.get("default")), StandardCharsets.UTF_8);
            String defaultFileContentTeme = new String(Files.readAllBytes(Paths.get("defaultTeme")), StandardCharsets.UTF_8);
            String defaultFileContentNota = new String(Files.readAllBytes(Paths.get("defaultNote.xml")), StandardCharsets.UTF_8);

            PrintWriter printWriter = new PrintWriter("studenti.xml");
            PrintWriter printWriterTeme = new PrintWriter("teme.xml");
            PrintWriter printWriterNota = new PrintWriter("note.xml");

            printWriter.print(defaultFileContent);
            printWriterTeme.print(defaultFileContentTeme);
            printWriterNota.print(defaultFileContentNota);
            printWriterTeme.close();
            printWriter.close();
            printWriterNota.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

//    @Test
//    public void testAddStudentSuccess() {
//        assertEquals(service.saveStudent("15", "Diana", 935), 1);
//    }
//
//    @Test
//    public void testAddStudentFailure() {
//        assertEquals(service.saveStudent("16", "Roland", 934), 1);
//        assertEquals(service.saveStudent("16", "Roland", 934), 0);
//
//    }

//    @Test
//    public void TC1_BBT_EC() {
//        assertEquals(service.saveStudent("0", "Ema", 938), 0);
//    }
//
//    @Test
//    public void TC2_BBT_EC() {
//        assertEquals(service.saveStudent(null, "Ema", 936), 0);
//    }
//
//    @Test
//    public void TC3_BBT_EC() {
//        assertEquals(service.saveStudent("0", "", 936), 0);
//    }
//
//    @Test
//    public void TC4_BBT_EC() {
//        assertEquals(service.saveStudent("0", "Ema", 938), 0);
//    }
//
//    @Test
//    public void TC5_BBT_BVA() {
//        assertEquals(service.saveStudent("0", "Ema", 111), 1);
//    }
//
//    @Test
//    public void TC6_BBT_BVA() {
//        assertEquals(service.saveStudent("0", "Ema", 109), 0);
//    }
//
//    @Test
//    public void TC7_BBT_BVA() { assertEquals(service.saveStudent("0", "Ema", 937), 1); }
//
//    @Test
//    public void TC8_BBT_BVA() {
//        assertEquals(service.saveStudent("0", "Ema", 938), 0);
//    }
//
//    @Test
//    public void TC9_BBT_BVA() { assertEquals(service.saveStudent("0", "Ema", 200), 1); }
//
//    @Test
//    public void TC10_BBT_BVA() {
//        assertEquals(service.saveStudent("0", "Ema", -1), 0);
//    }
//
//    @Test
//    public void TC11_BBT_BVA() { assertEquals(service.saveStudent("0", "abc", 123), 1); }
//
//    @Test
//    public void TC12_BBT_BVA() {
//        assertEquals(service.saveStudent("0", "", 123), 0);
//    }
//
//    @Test
//    public void TC13_BBT_BVA() {
//        assertEquals(service.saveStudent("0", null, 123), 0);
//    }

    /// wbt

//    @Test
//    public void testAddAssignmentSuccess() {
//        assertEquals(service.saveTema("5", "Primul Laborator", 8, 6), 1);
//    }
//
//    @Test
//    public void testAddAssignmentFailure() {
//        assertEquals(service.saveTema("8", "g", 8, 7), 1);
//        assertEquals(service.saveTema("8", "g", 8, 7), 0);
//    }

//    @Test
//    public void TC1_WBT(){
//        assertEquals(service.saveTema(null,"idk",2,1),0);
//    }
//
//    @Test
//    public void TC2_WBT(){
//        assertEquals(service.saveTema("1","",2,1),0);
//    }
//
//    @Test
//    public void TC3_WBT(){
//        assertEquals(service.saveTema("1","idk",-1,2),0);
//    }
//
//    @Test
//    public void TC4_WBT(){
//        assertEquals(service.saveTema("1","idk",1,-1),0);
//    }
//
//    @Test
//    public void TC5_WBT(){
//        assertEquals(service.saveTema("1","idk",2,1),1);
//    }
//
//    @Test
//    public void TC6_WBT(){
//        assertEquals(service.saveTema("1","idk",2,1),1);
//        assertEquals(service.saveTema("1","idk",2,1),0);
//    }


    //lab 4 THE BIG BIG BANG

    @Test
    public void testAddAssignment(){
        assertEquals(service.saveTema("1", "1", 8, 7), 1);
    }

    @Test
    public void testAddStudent(){
        assertEquals(service.saveStudent("6", "Andrei", 231), 1);
    }

    @Test
    public void testAddGrade(){
        assertEquals(service.saveNota("1000", "1000", 9, 3, "good"), -1);
    }


    @Test
    public void testBigBang(){
        testAddAssignment();
        testAddStudent();
        testAddGrade();
    }

    //incremental integration

    @Test
    public void testIncrementalAssignment(){
        testAddStudent();
        testAddAssignment();
    }

    @Test
    public void testIncrementalGrade(){
        testAddStudent();
        testAddAssignment();
        testAddGrade();
    }
}
