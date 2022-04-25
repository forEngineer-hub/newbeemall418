package ltd.newbee.mall.newbeemall.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ltd.newbee.mall.newbeemall.entity.RunRecommendApiHistory;
import ltd.newbee.mall.newbeemall.service.CheckUserExistsService;
import ltd.newbee.mall.newbeemall.service.NewBeeMallCategoryService;
import ltd.newbee.mall.newbeemall.service.NewBeeMallIndexConfigService;
import ltd.newbee.mall.newbeemall.service.RescentCheckGoodsService;
import ltd.newbee.mall.newbeemall.service.RunRecommendApiHistoryService;
import ltd.newbee.mall.newbeemall.util.Result;
import ltd.newbee.mall.newbeemall.util.ResultGenerator;

@Controller
public class IndexController {
	@Resource
	private NewBeeMallIndexConfigService newBeeMallIndexConfigService;

	@Resource
	private NewBeeMallCategoryService newBeeMallCategoryService;

	@Resource
	private CheckUserExistsService checkUserExistsService;

	@Resource
	private RescentCheckGoodsService rescentCheckGoodsService;
	
	@Resource
	RunRecommendApiHistoryService runRecommendApiHistoryService;
	
	@GetMapping("/gooodses")
	@ResponseBody
	public Result getGooodses(int configType) {

		return ResultGenerator.genSuccessResult(newBeeMallIndexConfigService.getConfigGoodsesForIndex(configType, 5));
	}

	@GetMapping("/categories")
	@ResponseBody
	public Result getCategories() {

		return ResultGenerator.genSuccessResult(newBeeMallCategoryService.getCategoriesForIndex());
	}

	@GetMapping("/user")
	@ResponseBody
	public Result user(long userId) {
		// MallUser user = checkUserExistsService.checkUserExists(userId);
		int count = checkUserExistsService.checkUserExistsReturnCount(userId);
		if (count == 0) {
			return ResultGenerator.genFailResult("failed");
		} else {
			return ResultGenerator.genSuccessResult(rescentCheckGoodsService.getRescChkGoodses(userId, 6));
		}

	}
	
	@GetMapping("/runRecommendApi")
	@ResponseBody
	public Result runRecommendApi() {
		
		List<RunRecommendApiHistory> list = runRecommendApiHistoryService.selectRecCat();
		for(RunRecommendApiHistory r : list) {
			r.setRunDate(new Date());
		}
		int count = runRecommendApiHistoryService.insertRunRecommendApiHistory(list);
		
		if (count == 0) {
			return ResultGenerator.genFailResult("failed");
		} else {
			return ResultGenerator.genSuccessResult("success");
		}

	}
	
}
