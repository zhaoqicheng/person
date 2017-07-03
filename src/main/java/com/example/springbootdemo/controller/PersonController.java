package com.example.springbootdemo.controller;

import com.example.springbootdemo.domain.Person;
import com.example.springbootdemo.domain.Result;
import com.example.springbootdemo.enums.ResultEnum;
import com.example.springbootdemo.exception.PersonException;
import com.example.springbootdemo.repository.PersonRepository;
import com.example.springbootdemo.service.PersonService;
import com.example.springbootdemo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by zhaoqicheng on 2017/3/21.
 *
 * 实现jpa方式的CRUD操作
 */
@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    /**
     * 获取所有的Person
     * @return
     */
    @GetMapping(value = "/getPerson")
    public List<Person> personList(){
        List<Person> personList = this.personRepository.findAll();
        return personList;
    }

    /**
     *获取所有的Person
     * @param id
     * @return
     */
    @GetMapping(value = "/getPerson/{id}")
    public Person getPersonById(@PathVariable(value = "id") Integer id){
        Person p = this.personRepository.findOne(id);
        return p;
    }

    /**
     * 添加Person
     * @param id
     * @param name
     * @param work
     * @return
     */
    @PutMapping(value = "/putPerson")
    public String putPerson(@RequestParam(value = "id") Integer id , @RequestParam(value = "age") Integer age  , @RequestParam(value = "name") String name, @RequestParam(value = "work")String work){
        Person p = new Person();
        p.setId(id);
        p.setName(name);
        p.setWork(work);
        p.setAge(age);
        Person per = this.personRepository.save(p);
        return per.toString();
    }

    /**
     * 添加Person并且   添加表单验证
     * @param person
     * @return
     */
    @PutMapping(value = "/putPerson/valid")
    public Result putPerson2(@Valid Person person , BindingResult bindingResult){
        ResultUtil resultUtil = new ResultUtil();
        if(bindingResult.hasErrors()){
            return resultUtil.error("400" , bindingResult.getFieldError().getDefaultMessage());
        }
        person.setId(person.getId());
        person.setName(person.getName());
        person.setWork(person.getWork());
        Person per = this.personRepository.save(person);
        return resultUtil.success(per);
    }

    /**
     * 删除Person
     * @param id
     * @return
     */
    @DeleteMapping(value = "/deletePerson/{id}")
    public String deletePerson(@PathVariable(value = "id")Integer id){
        Person p = new Person();
        p.setId(id);
        this.personRepository.delete(p);
        return null;
    }

    /**
     * 修改Person
     * @param id
     * @param name
     * @param work
     * @return
     */
    @PostMapping(value = "/postPerson")
    public Person postPerson(@RequestParam(value = "id") Integer id,@RequestParam(value = "age") Integer age ,@RequestParam(value = "name")String name , @RequestParam(value = "work") String work){
        Person p = new Person();
        p.setId(id);
        p.setName(name);
        p.setWork(work);
        p.setAge(age);
        Person person = this.personRepository.save(p);
        return person;
    }

    /**
     * 模拟事务的产生
     */
    @PutMapping(value = "/putPerson/two")
    public void addTwoPerson(){
        this.personService.addTwoPerson();
    }

    /**
     * 判断Person年龄使用自定义异常来实现
     */
    @GetMapping(value = "/getPersonAge/{id}")
    public void getPersonAge(@PathVariable(value = "id") Integer id) throws Exception{
        Person person = this.personRepository.findOne(id);
        Integer age = person.getAge();
        if(age<16){
            //返回信息"未成年"
            throw new PersonException(ResultEnum.WEICHENGNNIAN_ERROR);
        }

        if(age>16){
            //返回信息"已成年"
            throw new PersonException(ResultEnum.WEICHENGNNIAN_ERROR);
        }
    }

}
