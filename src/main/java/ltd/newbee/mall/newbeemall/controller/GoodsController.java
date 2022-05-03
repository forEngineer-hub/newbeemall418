package ltd.newbee.mall.newbeemall.controller;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ltd.newbee.mall.newbeemall.service.DetailPageService;
import ltd.newbee.mall.newbeemall.service.GoodsDetailService;
import ltd.newbee.mall.newbeemall.util.Result;
import ltd.newbee.mall.newbeemall.util.ResultGenerator;

@Controller
public class GoodsController {

	@Resource
	GoodsDetailService goodsDetailService;

	@Resource
	DetailPageService detailPageService;
	
	/*
	 * http://localhost:8080/goods/detail?goodsId=10003
	 */
	@PostMapping("/goods/detail")
	@ResponseBody
	public Result getGooodses(long goodsId) {

		return ResultGenerator.genSuccessResult(goodsDetailService.getGoodsDetail(goodsId));
	}

	/**
	 * restful风格的参数请求
	 * @param id
	 */
	@RequestMapping(value = "/goods/detail/review/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Result queryProduct(@PathVariable("id") String id) {
		return ResultGenerator.genSuccessResult(id);
	}

	@DeleteMapping("/goods/detail/review")
	@ResponseBody
	public Result review(@RequestParam(value = "reviewId", required = true) long reviewId) {
		System.out.println(reviewId);
		return ResultGenerator.genSuccessResult(reviewId);
	}

	@PostMapping("/goods/detail/review")
	@ResponseBody
	public Result review(@RequestBody HashMap<String, Object> reviewMap) {
		System.out.println(reviewMap);
		return ResultGenerator.genSuccessResult(detailPageService.insertReview(reviewMap));
	}

}
