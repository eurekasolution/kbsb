package web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// REST vs. 이전 http://localhost/main.php?cmd=test&idx=3
// http://localhost/hello
// JSON(JavaScript Onbject Notation)를 매핑해준다.
// Method의 종류 : GET, POST, PUT, DELETE
/*
    HTTP Error Code
    1xx : Trying
    2xx : OK
    3xx : Temporary Error, Redirection Error
    4xx : Permanent Error, Client Error
        403 : Forbidden
        404 : Not Found
        405 : Method Not Allowed
    5xx : Server Error
    6xx : Global Error

    스프링 부트 : POST(insert), PUT(update)을 구분
    cf. DELETE (삭제)
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }
}
