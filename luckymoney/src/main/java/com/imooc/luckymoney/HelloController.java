package com.imooc.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 廖师兄
 * 2019-02-27 17:54
 * @Controller + @ResponseBody = @RestController
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	// 引入其他类创建对象
	private LimitConfig limitConfig;

	@PostMapping("/say")
	public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
//		return "说明：" + limitConfig.getDescription();
		return "id:" + myId;
	}
}
