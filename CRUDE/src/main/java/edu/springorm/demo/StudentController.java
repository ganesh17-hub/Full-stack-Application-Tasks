package edu.springorm.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // Display all students
    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", service.getAll());
        return "students/list";
    }

    // Show form to create new student
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/form";
    }

    // Save new student
    @PostMapping
    public String create(@Validated @ModelAttribute("student") Student student,
                         BindingResult result) {

        if (result.hasErrors()) {
            return "students/form";
        }

        service.create(student);
        return "redirect:/students";
    }

    // Show edit form
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {

        Student student = service.getById(id);

        if (student == null) {
            return "redirect:/students";
        }

        model.addAttribute("student", student);
        return "students/form";
    }

    // Update student
    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @Validated @ModelAttribute("student") Student student,
                         BindingResult result) {

        if (result.hasErrors()) {
            return "students/form";
        }

        service.update(id, student);
        return "redirect:/students";
    }

    // Delete student
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {

        service.delete(id);
        return "redirect:/students";
    }
}