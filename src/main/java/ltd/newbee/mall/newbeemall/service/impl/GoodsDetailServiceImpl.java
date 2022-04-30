package ltd.newbee.mall.newbeemall.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import ltd.newbee.mall.newbeemall.dao.GoodsDetailMapper;
import ltd.newbee.mall.newbeemall.entity.GoodsDetail;
import ltd.newbee.mall.newbeemall.entity.GoodsImage;
import ltd.newbee.mall.newbeemall.service.GoodsDetailService;
import ltd.newbee.mall.newbeemall.util.BeanUtil;
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
			
			BeanUtil.copyProperties(e, vo);

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

	@Override
	public List<ArrayList<GoodsImage>> getGoodsImages(long goodsId) {
		// TODO Auto-generated method stub
		List<GoodsImage> list = goodsDetailMapper.getGoodsImages(goodsId);
		// => list<list<goodsImage>>
		List<ArrayList<GoodsImage>> rsList = new ArrayList<ArrayList<GoodsImage>>();
		
		ArrayList<GoodsImage> tempList = new ArrayList<GoodsImage>();
		
		for (int i = 0; i < list.size(); i++) {
					
			tempList.add(list.get(i));
			
			//0 ~7
			// 0 % 8 == 0 ?
			if((i+1)%8 == 0) {
				rsList.add(tempList);  //copy?
				//tempList.clear();
				tempList = new ArrayList<GoodsImage>();
			}
			
			// 2 
			if( i == (list.size()-1) && (i+1)%8 != 0) {
				rsList.add(tempList);  //copy?
				//tempList.clear();
			}
						
		}
		return rsList;
	}

}
