package com.example.Subject.controller;

import com.example.Subject.dto.response.CourseResponse;
import com.example.Subject.entity.Course;
import com.example.Subject.service.CoursetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {
    @Autowired
    CoursetService coursetService;

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course) {
        Course course1 = coursetService.create(course);
        return ResponseEntity.ok().body(course1);
    }
    @GetMapping
    public ResponseEntity<?> findAll() {

        return ResponseEntity.ok().body(coursetService.getAll());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        coursetService.delete(id);
        return ResponseEntity.ok().body(null);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable long id,@RequestBody Course course) {
        Course course1 = coursetService.update(id,course);
        return ResponseEntity.ok().body(course1);
    }
    @GetMapping("{id}")
    public ResponseEntity<CourseResponse> studentSameSubject(@PathVariable long id) {
        CourseResponse courseResponse = coursetService.studentSameSubject(id);
        return  ResponseEntity.ok().body(courseResponse);
    }
}
