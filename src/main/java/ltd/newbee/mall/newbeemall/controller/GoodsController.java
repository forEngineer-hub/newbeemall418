package ltd.newbee.mall.newbeemall.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ltd.newbee.mall.newbeemall.service.GoodsDetailService;
import ltd.newbee.mall.newbeemall.util.Result;
import ltd.newbee.mall.newbeemall.util.ResultGenerator;

@Controller
public class GoodsController {
	
	@Resource
	GoodsDetailService goodsDetailService;
	
	@PostMapping("/goods/detail")
	@ResponseBody
	public Result getGooodses(long goodsId) {

		return ResultGenerator.genSuccessResult(goodsDetailService.getGoodsDetail(goodsId));
	}

}
