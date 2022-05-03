package ltd.newbee.mall.newbeemall.service.impl;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ltd.newbee.mall.newbeemall.dao.DetailPageMapper;
import ltd.newbee.mall.newbeemall.service.DetailPageService;

@Service
public class DetailPageServiceImpl implements DetailPageService {
	
	@Autowired
	DetailPageMapper detailPageMapper;
	
	@Override
	public int insertReview(Map<String, Object> review) {
		//採番 MAX IDを取得してプラス１
		long newReviewId = detailPageMapper.selectMaxReviewId() + 1;
		review.replace("reviewId", newReviewId);
		review.replace("reviewDate", new Date());
		return detailPageMapper.insertReview(review);
	}

}
