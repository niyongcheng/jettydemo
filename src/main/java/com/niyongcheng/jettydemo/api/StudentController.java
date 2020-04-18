package com.niyongcheng.jettydemo.api;

import com.niyongcheng.jettydemo.model.StudentX;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class StudentController {

    @RequestMapping(value = "/student/{id}",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public StudentX getStudent(
            @PathVariable("id") String id
    ) {
        return StudentX.builder().age(10).name("zan").weight("100kg").build();
    }
}
