package com.ran.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ran
 * @since JDK 1.8
 *
 *  SpringMVC:
 *      1.POM.XML 导入jar
 *      2.编写SpringMVC的配置文件:dispatcherServlet.xml
 *          2.1 开启Spring的注解扫描
 *          2.2 开启SpringMVC的注解支持
 *      3.配置web.xml的文件
 *          3.1 进行DispatcherServlet的配置
 *          3.2 需要配合default映射,url-pattern的内容为*.html
 *      4.进行controller的编写
 *      5.对应的请求方法
 *      6.在类上以及方法上加入SpringMVC的注解
 *
 *    RequestMapping 注解元素:
 *          1. value/path       --  访问路径的映射
 *          2. method           --  指定提交方式
 *              http协议1.1 支持的提交方式有8种
 *              GET:获取     POST:修改    PUT:添加     DELETE:删除
 *              HEAD:把数据存放在请求头中
 *         3.params             --  指定请求的参数
 *         4.produces           --  设置响应头,指定返回的数据类型以及编码格式
 */

/*
*   以前的写法
*   /HelloController?action=add
*
*   现在的写法
*   HelloController/add
* */
/*@Controller*/
@RestController
@RequestMapping("/HelloController")
public class HelloController {

    /*
    *   method = {RequestMethod.GET,RequestMethod.POST}
    *   支持GET和POST请求
    *
    * */
/*    @RequestMapping(value="/hello",method = {RequestMethod.GET,RequestMethod.POST})
    public String hello(){
        System.out.println("helloWorld");
        return "helloWorld";
    }*/

    /*
    *   params = {"username","password"}
    *   限制传递的参数为username 和 password
    *   不符合条件则会 400
    *
    * */
    @RequestMapping(value="/hello",params = {"username","password"})
    public String hello(String username,String password){
        System.out.println("username:"+username+",password:"+password);
        String json = "{username:zs,password:124}";
        return json;
    }

        @RequestMapping(value = "/add",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String add(){
        System.out.println("add");
        return "添加";
    }

    /*
    *   GetMapping:限制请求方式为Get
    *   限制请求方式为 GET
    *   用法跟RequestMapping 一样
    * */
    @GetMapping("/get")
    public void getMethod(){

    }
    @PostMapping("/post")
    public void postMethod(){

    }
    @PutMapping("/put")
    public void putMethod(){

    }
    @DeleteMapping("/delete")
    public void deleteMethod(){

    }
    @PatchMapping("/patch")
    public void patchMethod(){

    }

}
