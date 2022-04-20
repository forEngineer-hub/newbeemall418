package ltd.newbee.mall.newbeemall.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ltd.newbee.mall.newbeemall.dao.IndexConfigMapper;
import ltd.newbee.mall.newbeemall.entity.IndexConfig;
import ltd.newbee.mall.newbeemall.entity.NewBeeMallGoods;
import ltd.newbee.mall.newbeemall.service.NewBeeMallIndexConfigService;
import ltd.newbee.mall.newbeemall.vo.NewBeeMallGoodsDetailVO;

@Service
public class NewBeeMallIndexConfigServiceImpl implements NewBeeMallIndexConfigService {
	

	@Resource
    private IndexConfigMapper indexConfigMapper;
	
	@Override
	public List<NewBeeMallGoodsDetailVO> getConfigGoodsesForIndex(int configType,int number) {
		
		List<IndexConfig> idxConfList = indexConfigMapper.findIndexConfigsByTypeAndNum(configType, number);
		
		List<Long> ids = new ArrayList<Long>();
		// List<IndexConfig> => List<Long>
		for(IndexConfig iConf : idxConfList) {
			ids.add(iConf.getGoodsId());
		}
		
		
		List<NewBeeMallGoods> entityList = indexConfigMapper.selectByPrimaryKeys(ids);
		
		List<NewBeeMallGoodsDetailVO> voList = new ArrayList<NewBeeMallGoodsDetailVO>();
		
		//#1 entity的list => vo的list
		for(NewBeeMallGoods entity : entityList) {
			NewBeeMallGoodsDetailVO vo = new NewBeeMallGoodsDetailVO();
			
			vo.setGoodsId(entity.getGoodsId());
			
			vo.setGoodsName(entity.getGoodsName());
			
			vo.setGoodsIntro(entity.getGoodsIntro());
			
			vo.setGoodsCoverImg(entity.getGoodsCoverImg());
			
			vo.setSellingPrice(entity.getSellingPrice());
			
			String name = vo.getGoodsName();
			//#2 转换名字
			// HUAWEI Mate 30 4000万超感光徕卡影像 麒麟显卡 16G内存 无线充电
			// 超过30字符的话，30以后用...来代替,如下
			//HUAWEI Mate 30 4000万超感光徕卡影像 麒麟...
			
			if (name.length() > 30) {
				vo.setGoodsName(name.substring(0,30) + "...");
			}
			
			voList.add(vo);
		}
		
		
		
		return voList;
		
	}

}
