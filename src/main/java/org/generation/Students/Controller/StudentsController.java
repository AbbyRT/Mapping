package org.generation.Students.Controller;

import org.generation.Students.data.entity.Student;
import org.generation.Students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentsController {

    private final StudentService studentService;

    public StudentsController(@Autowired StudentService studentService)
    {
        this.studentService = studentService;
       // StudentsApplication.studentService = studentService;
    }

    @GetMapping( "/student" ) //ok
    public Iterable<Student> getStudents() //colocar getters y setters en stundent
    {
        return studentService.all();
    }

    @GetMapping( "/student/{id}" ) //ok
    public Student getStudent(@PathVariable Integer id )
    {
        return studentService.get( id );
    }

    @PostMapping("/student") //se pone a prueba con postman ok
    public void saveStudent(@RequestBody Student student){
        studentService.save(student);

    }

    @DeleteMapping("/student/{id}") //ok
    public void deleteStudent(@PathVariable Integer id){
        studentService.delete(id);
    }

    @PutMapping("/student/{id}")
    public void updateStudent(@PathVariable Integer id, @RequestBody Student student){
       Student student1 = studentService.get( id );
       student1.setAddress(student.getAddress());
       student1.setEmail(student.getEmail());
       student1.setName(student.getName());
       studentService.save(student1);
    }


//    all()	GET	/student ---------OK
//    findById(@PathVariable String id)	GET	/student/{id} ----OK
//    save(@RequestBody Student student)	POST	/student ------OK
//    update(@RequestBody Student student)	PUT	/student -------ok
//    delete(@PathVariable String id)	DELETE	/student/{id}------ok

}


