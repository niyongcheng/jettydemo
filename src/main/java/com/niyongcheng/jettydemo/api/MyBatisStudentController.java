package com.niyongcheng.jettydemo.api;


import com.niyongcheng.jettydemo.entity.Student;
import com.niyongcheng.jettydemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class MyBatisStudentController {
    private StudentService studentService;

    @Autowired
    public MyBatisStudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "student/{id}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Student selectOne(@PathVariable("id") Integer id) {
        return this.studentService.queryById(id);
    }

    @RequestMapping(value = "student", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Student addOne(@RequestBody  Student student){
        return  this.studentService.insert(student);
    }

}
