package com.niyongcheng.jettydemo.service;

import com.niyongcheng.jettydemo.entity.Student;

import java.util.List;

public interface StudentService {
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Student queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Student> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param studentX 实例对象
     * @return 实例对象
     */
    Student insert(Student studentX);

    /**
     * 修改数据
     *
     * @param studentX 实例对象
     * @return 实例对象
     */
    Student update(Student studentX);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
}
