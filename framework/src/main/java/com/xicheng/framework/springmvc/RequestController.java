package com.xicheng.framework.springmvc;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author xichengxml
 * @date 2019/1/2
 * @description
 */

@RestController
public class RequestController {

    @GetMapping("/get")
    public String getTest(String id, String name) {
        return id + "--" + name;
    }


    @PostMapping("post")
    public String postTest(@RequestBody User user) {
        return user.toString();
    }


    static class User {
        @Setter
        @Getter
        private String id;
        @Setter
        @Getter
        private String name;

        @Override
        public String toString() {
            return "User{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
