package ltd.newbee.mall.newbeemall.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RunRecommendApiHistory {
	private long categoryId;
	
	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public Date getRunDate() {
		return runDate;
	}

	public void setRunDate(Date runDate) {
		this.runDate = runDate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date runDate;
    
	
}
