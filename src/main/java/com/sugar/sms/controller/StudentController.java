package com.sugar.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sugar.sms.entity.Student;
import com.sugar.sms.service.StudentService;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }


    // handler method to handle list student and return model and view
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }
    
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }


    @GetMapping("/student/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }


    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
        // model.addAttribute("student",studentService.getStudentById(id));
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());


        studentService.updatSetudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/student/{id}")
    public String deleteStudent(@PathVariable Long id, Model model) {
        // model.addAttribute("student",studentService.getStudentById(id));
        


        studentService.deleteStudent(id);
        return "redirect:/students";
    }
    

    // handler method to handle add student 
    @GetMapping("/students/new")
    public String addStudent(Model model) {
        Student student =  new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

}
