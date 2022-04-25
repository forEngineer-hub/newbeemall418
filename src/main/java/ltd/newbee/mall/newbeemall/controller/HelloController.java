package ltd.newbee.mall.newbeemall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
    @ResponseBody
    public String hello() {
		String str = "";
        return "hello,spring boot";
    }
}
