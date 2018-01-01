package cn.fuqiang.food.utilities;

import java.util.List;
import java.util.Map;

public class PageTools {
	/**
	 * 当前页
	 */
	private Integer curPage;
	/**
	 *总条数 （数据库查出）
	 */
	private Integer totalNumber;
	/**
	 * 每页显示的行数
	 */
	private Integer lineNumber=10;
	/**
	 * 总页数
	 */
	private Integer totalPage;
	/**
	 * 上一页
	 */
	private Integer beforePage;
	/**
	 * 下一页
	 */
	private Integer afterPage;
	/**
	 * 开始行数
	 */
	private Integer beginLine; 
	/**
	 * 结束行
	 */
	private Integer endLine;
	/**
	 * 存储数据的list集合
	 */
	private List<Map> data;
	/**
	 *传入当前页，数据库总行数，每页显示的行数自动计算分页
	 * @param curPage  当前页
	 * @param totalNumber 总行数（从数据库中获取）
	 * @param lineNumber  每页显示的行数
	 */
	public PageTools(Integer curPage, Integer totalNumber, Integer lineNumber) {
		//获取当前页
		this.curPage = curPage;
		//获取数据库总条数
		this.totalNumber = totalNumber;
		//每页显示的行数 如果小于1则默认10 条
		this.lineNumber = lineNumber<1? this.lineNumber:lineNumber;
		//计算总页数  如果有剩余的条数则加一页
		this.totalPage = (totalNumber%this.lineNumber==0)?(totalNumber/this.lineNumber):(totalNumber/this.lineNumber+1);
		//计算前一页如果为第一页则不跳转
		this.beforePage = curPage>1 ?curPage-1:1;
		//计算下一页一页如果为最后一页页则不跳转
		this.afterPage = curPage<this.totalPage?this.curPage+1:totalPage;
		//计算开始的行数
		this.beginLine = (curPage-1)*this.lineNumber+1;
		//计算结束的行数
		this.endLine = curPage*this.lineNumber;
	}
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}
	public Integer getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getBeforePage() {
		return beforePage;
	}
	public void setBeforePage(Integer beforePage) {
		this.beforePage = beforePage;
	}
	public Integer getAfterPage() {
		return afterPage;
	}
	public void setAfterPage(Integer afterPage) {
		this.afterPage = afterPage;
	}
	public Integer getBeginLine() {
		return beginLine;
	}
	public void setBeginLine(Integer beginLine) {
		this.beginLine = beginLine;
	}
	public Integer getEndLine() {
		return endLine;
	}
	public void setEndLine(Integer endLine) {
		this.endLine = endLine;
	}
	public List<Map> getData() {
		return data;
	}
	public void setData(List<Map> data) {
		this.data = data;
	}
	
	
}
