package ltd.newbee.mall.newbeemall.entity;

import java.util.Date;
import javax.annotation.Generated;

public class GoodsQa {

	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2022-04-25T19:12:27.7419151+09:00", comments = "Source field: goods_qa.qa_id")
	private Long qaId;
	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2022-04-25T19:12:27.7419151+09:00", comments = "Source field: goods_qa.goods_id")
	private Long goodsId;
	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2022-04-25T19:12:27.7419151+09:00", comments = "Source field: goods_qa.question")
	private String question;
	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2022-04-25T19:12:27.7419151+09:00", comments = "Source field: goods_qa.submit_date")
	private Date submitDate;
	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2022-04-25T19:12:27.7419151+09:00", comments = "Source field: goods_qa.answer")
	private String answer;
	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2022-04-25T19:12:27.7419151+09:00", comments = "Source field: goods_qa.answer_date")
	private Date answerDate;

	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2022-04-25T19:12:27.7419151+09:00", comments = "Source field: goods_qa.qa_id")
	public Long getQaId() {
		return qaId;
	}

	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2022-04-25T19:12:27.7419151+09:00", comments = "Source field: goods_qa.qa_id")
	public void setQaId(Long qaId) {
		this.qaId = qaId;
	}

	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2022-04-25T19:12:27.7419151+09:00", comments = "Source field: goods_qa.goods_id")
	public Long getGoodsId() {
		return goodsId;
	}

	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2022-04-25T19:12:27.7419151+09:00", comments = "Source field: goods_qa.goods_id")
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2022-04-25T19:12:27.7419151+09:00", comments = "Source field: goods_qa.question")
	public String getQuestion() {
		return question;
	}

	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2022-04-25T19:12:27.7419151+09:00", comments = "Source field: goods_qa.question")
	public void setQuestion(String question) {
		this.question = question == null ? null : question.trim();
	}

	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2022-04-25T19:12:27.7419151+09:00", comments = "Source field: goods_qa.submit_date")
	public Date getSubmitDate() {
		return submitDate;
	}

	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2022-04-25T19:12:27.7419151+09:00", comments = "Source field: goods_qa.submit_date")
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2022-04-25T19:12:27.7419151+09:00", comments = "Source field: goods_qa.answer")
	public String getAnswer() {
		return answer;
	}

	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2022-04-25T19:12:27.7419151+09:00", comments = "Source field: goods_qa.answer")
	public void setAnswer(String answer) {
		this.answer = answer == null ? null : answer.trim();
	}

	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2022-04-25T19:12:27.7419151+09:00", comments = "Source field: goods_qa.answer_date")
	public Date getAnswerDate() {
		return answerDate;
	}

	@Generated(value = "org.mybatis.generator.api.MyBatisGenerator", date = "2022-04-25T19:12:27.7419151+09:00", comments = "Source field: goods_qa.answer_date")
	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}
}