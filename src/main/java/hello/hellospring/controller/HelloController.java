package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("data", "hello~?");
        return "hello";
    }

    @GetMapping("/hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false, defaultValue = "spring?!") String name, Model model){
        model.addAttribute("name", name);

        return "hello-template";
    }

    @GetMapping("/hello-string")
    @ResponseBody
    public String helloString(@RequestParam(value = "name", required = false, defaultValue = "spring?!") String name){
        return "hello " + name;
    }

    @GetMapping("/hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam(value = "name", required = false, defaultValue = "spring?!") String name){
        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }

    @GetMapping("/hello-api2")
    @ResponseBody
    public Hello helloApi2(Hello hello){

        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
