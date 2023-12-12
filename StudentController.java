import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {


    @GetMapping
    public String showAllStudents(Model model) {
    
        List<Student> students = model.addAttribute("students", students);
        return "student/list";
    }

    @GetMapping("/{id}")
    public String showStudentDetails(@PathVariable Long id, Model model) {
        
        Student student = model.addAttribute("student", student);
        return "student/details";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        // Retrieve student by id from the service/repository
        Student student = // get student by id from service/repository
        model.addAttribute("student", student);
        return "student/edit";
    }

    @PostMapping("/{id}/edit")
    public String updateStudent(@PathVariable Long id, @Valid @ModelAttribute("student") Student student,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "student/edit";
        }


        redirectAttributes.addFlashAttribute("successMessage", "Student updated successfully");
        return "redirect:/students";
    }

    @GetMapping("/{id}/delete")
    public String deleteStudent(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        // Delete student by id from the service/repository

        redirectAttributes.addFlashAttribute("successMessage", "Student deleted successfully");
        return "redirect:/students";
    }
}
