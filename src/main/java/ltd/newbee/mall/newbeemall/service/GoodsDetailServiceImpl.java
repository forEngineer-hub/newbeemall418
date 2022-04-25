package ltd.newbee.mall.newbeemall.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ltd.newbee.mall.newbeemall.dao.GoodsDetailMapper;
import ltd.newbee.mall.newbeemall.entity.GoodsDetail;
import ltd.newbee.mall.newbeemall.vo.GoodsDetailVo;

@Service
public class GoodsDetailServiceImpl implements GoodsDetailService {
	
	@Resource
	GoodsDetailMapper goodsDetailMapper;
	
	@Override
	public List<GoodsDetailVo> getGoodsDetail(long goodsId) {
		List<GoodsDetail> entityList = goodsDetailMapper.getGoodsDetail(goodsId);
		List<GoodsDetailVo> voList = new ArrayList<GoodsDetailVo>();
		for(GoodsDetail e: entityList) {
			GoodsDetailVo vo = new GoodsDetailVo();
			vo.setColor(e.getColor());
			vo.setGoodsId(e.getGoodsId());
			vo.setMaterial(e.getMaterial());
			String size = "";
			if(e.getSize1()!=null && e.getSize1()!=0) {
				size = e.getSize1Name() + e.getSize1();
			}
			
			if(e.getSize2()!=null && e.getSize2()!=0) {
				size  = size +  "x" + e.getSize2Name() + e.getSize2();
			}
			
			if(e.getSize3()!=null && e.getSize3()!=0) {
				size = size +  "x" + e.getSize3Name() + e.getSize3();
			}
			
			if(e.getSizeUnit()!=null && !e.getSizeUnit().equals("")) {
				size = size + e.getSizeUnit();
			}
			vo.setSize(size);
			vo.setWarrantyYears(e.getWarranty() + e.getWarrantyUnit());
			vo.setWrapSize(null);
			
			voList.add(vo);
			
		}
		return voList;
	}

}
