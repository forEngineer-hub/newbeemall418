package ltd.newbee.mall.newbeemall.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ltd.newbee.mall.newbeemall.dao.GoodsCategoryMapper;
import ltd.newbee.mall.newbeemall.entity.GoodsCategory;
import ltd.newbee.mall.newbeemall.service.NewBeeMallCategoryService;
import ltd.newbee.mall.newbeemall.vo.NewBeeMallIndexCategoryVO;
import ltd.newbee.mall.newbeemall.vo.SecondLevelCategoryVO;
import ltd.newbee.mall.newbeemall.vo.ThirdLevelCategoryVO;

@Service
public class NewBeeMallCategoryServiceImpl implements NewBeeMallCategoryService {

	@Resource
	GoodsCategoryMapper goodsCategoryMapper;


	@Override
	public List<NewBeeMallIndexCategoryVO> getCategoriesForIndex() {
		// level 1
		List<Long> lev1ParentsList = new ArrayList<Long>();
		// not 01 => o L
		lev1ParentsList.add(0l);

		List<GoodsCategory> lev1CateList = new ArrayList<GoodsCategory>();
		lev1CateList = goodsCategoryMapper.selectByLevelAndParentIdsAndNumber(lev1ParentsList, 1, 100);

		List<Long> cateList1 = new ArrayList<Long>();

		for (GoodsCategory gc : lev1CateList) {
			cateList1.add(gc.getCategoryId());
		}

		// level2
		List<GoodsCategory> lev2CateList = new ArrayList<GoodsCategory>();
		lev2CateList = goodsCategoryMapper.selectByLevelAndParentIdsAndNumber(cateList1, 2, 100);

		List<Long> cateList2 = new ArrayList<Long>();
		for (GoodsCategory gc : lev2CateList) {
			cateList2.add(gc.getCategoryId());
		}

		// level2
		List<GoodsCategory> lev3CateList = new ArrayList<GoodsCategory>();
		lev3CateList = goodsCategoryMapper.selectByLevelAndParentIdsAndNumber(cateList2, 3, 100);
		
		// level1  entity => vo
		
		List<NewBeeMallIndexCategoryVO> rsList = new ArrayList<NewBeeMallIndexCategoryVO>();
		
		for (GoodsCategory gc : lev1CateList) {
			
			NewBeeMallIndexCategoryVO vo = new NewBeeMallIndexCategoryVO();
			vo.setCategoryId(gc.getCategoryId());
			vo.setCategoryLevel(gc.getCategoryLevel());
			vo.setCategoryName(gc.getCategoryName());
			// cateList2装的是所以第二级别的category
			// 过滤 
			// 第二级别的category.parentID = gc.getCategoryId()
			List<SecondLevelCategoryVO> Levl2CateVoList = new ArrayList<SecondLevelCategoryVO>();
			
			for(GoodsCategory gc2: lev2CateList) {
				SecondLevelCategoryVO levl2CateVo = new SecondLevelCategoryVO(); 
				if(gc2.getParentId() == gc.getCategoryId()) {
					levl2CateVo.setCategoryId(gc2.getCategoryId());
					levl2CateVo.setCategoryLevel(gc2.getCategoryLevel());
					levl2CateVo.setCategoryName(gc2.getCategoryName());
					levl2CateVo.setParentId(gc2.getParentId());
					//levl2CateVo.setThirdLevelCategoryVOS(null);
					List<ThirdLevelCategoryVO> levl3VoList = new ArrayList<ThirdLevelCategoryVO>();
					for(GoodsCategory gC3: lev3CateList) {
						ThirdLevelCategoryVO levl3CateVo = new ThirdLevelCategoryVO(); 
						if(gC3.getParentId() == gc2.getCategoryId()) {
							levl3CateVo.setCategoryId(gC3.getCategoryId());
							levl3CateVo.setCategoryLevel(gC3.getCategoryLevel());
							levl3CateVo.setCategoryName(gC3.getCategoryName());
							levl3VoList.add(levl3CateVo);
							levl2CateVo.setThirdLevelCategoryVOS(levl3VoList);
						}
					}
					Levl2CateVoList.add(levl2CateVo);
				}
			}
			
			vo.setSecondLevelCategoryVOS(Levl2CateVoList);
			rsList.add(vo);
		}

		
		return rsList;
	}

	

}
