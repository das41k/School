package com.spring.school.controller;

import com.spring.school.dao.GradeDAO;
import com.spring.school.entity.Grade;
import com.spring.school.entity.Squad;
import com.spring.school.entity.Subject;
import com.spring.school.entity.Teacher;
import com.spring.school.service.GradeService;
import com.spring.school.service.SquadService;
import com.spring.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private SquadService squadService;

    @Autowired
    private GradeService gradeService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "authTeacher";
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute Teacher teacher, Model model, HttpSession session) {
        Teacher teacherDb = teacherService.getTeacherByCode(teacher.getEntryCode());
        if (teacherDb != null) {
            model.addAttribute("teacher", teacherDb);
            session.setAttribute("teacher", teacherDb);
            List<Squad> squads = squadService.getAllSquads();
            model.addAttribute("squads", squads);
            return "teacher-work";
        } else {
            model.addAttribute("error", "Учителя с таким кодом нет в системе!");
            return "authTeacher";
        }
    }

    @RequestMapping("/check-grades")
    public String checkGrades(
            @RequestParam(value = "squad", required = false) Integer squadParam,
            @RequestParam(value = "subject", required = false) Integer subjectParam,
            HttpSession session,
            Model model) {

        // Берём squad и subject либо из параметров, либо из сессии
        int squad = (squadParam != null) ? squadParam : (int) session.getAttribute("squad");
        int subject = (subjectParam != null) ? subjectParam : (int) session.getAttribute("subject");

        List<Grade> grades = gradeService.getGradesBySquadAndSubject(squad, subject);
        Teacher teacher = (Teacher) session.getAttribute("teacher");

        model.addAttribute("squads", squadService.getAllSquads());
        model.addAttribute("grades", grades);
        model.addAttribute("teacher", teacher);

        // Обновляем значения в сессии (если пришли новые)
        session.setAttribute("squad", squad);
        session.setAttribute("subject", subject);

        return "teacher-work";
    }

    @RequestMapping("/delete-grades")
    public String deleteGrades(@RequestParam("idGrade") int id, HttpSession session) {
        gradeService.deleteGrade(id);
        return "redirect:/check-grades";
    }


}
