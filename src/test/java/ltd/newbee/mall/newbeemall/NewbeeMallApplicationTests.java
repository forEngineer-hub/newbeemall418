package ltd.newbee.mall.newbeemall;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ltd.newbee.mall.newbeemall.service.GoodsDetailService;
import ltd.newbee.mall.newbeemall.service.RunRecommendApiHistoryService;

@SpringBootTest
class NewbeeMallApplicationTests {

	@Resource
	RunRecommendApiHistoryService runRecommendApiHistoryService;

	@Resource
	GoodsDetailService goodsDetailService;
	
	@Test
	void testGoodsServiceImpl() {
		goodsDetailService.getGoodsImages(10003);
	} 
	/*
	 * @Test void contextLoads() { List<RunRecommendApiHistory> list = new
	 * ArrayList<RunRecommendApiHistory>(); RunRecommendApiHistory h1 = new
	 * RunRecommendApiHistory(); h1.setCategoryId(0); h1.setRunDate(new Date());
	 * list.add(h1); int cnt =
	 * runRecommendApiHistoryService.insertRunRecommendApiHistory(list);
	 * assertEquals(1, cnt); }
	 */

	/*
	 * @Test void testSelectRecCat() {
	 * 
	 * List<Long> list = runRecommendApiHistoryService.selectRecCat();
	 * assertEquals(2, list.size()); assertTrue(list.contains(51l));
	 * assertTrue(list.contains(47l));
	 * 
	 * }
	 */
}
