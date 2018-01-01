package cn.fuqiang.food.utilities;

import java.util.List;
import java.util.Map;

public class PageTools {
	/**
	 * ��ǰҳ
	 */
	private Integer curPage;
	/**
	 *������ �����ݿ�����
	 */
	private Integer totalNumber;
	/**
	 * ÿҳ��ʾ������
	 */
	private Integer lineNumber=10;
	/**
	 * ��ҳ��
	 */
	private Integer totalPage;
	/**
	 * ��һҳ
	 */
	private Integer beforePage;
	/**
	 * ��һҳ
	 */
	private Integer afterPage;
	/**
	 * ��ʼ����
	 */
	private Integer beginLine; 
	/**
	 * ������
	 */
	private Integer endLine;
	/**
	 * �洢���ݵ�list����
	 */
	private List<Map> data;
	/**
	 *���뵱ǰҳ�����ݿ���������ÿҳ��ʾ�������Զ������ҳ
	 * @param curPage  ��ǰҳ
	 * @param totalNumber �������������ݿ��л�ȡ��
	 * @param lineNumber  ÿҳ��ʾ������
	 */
	public PageTools(Integer curPage, Integer totalNumber, Integer lineNumber) {
		//��ȡ��ǰҳ
		this.curPage = curPage;
		//��ȡ���ݿ�������
		this.totalNumber = totalNumber;
		//ÿҳ��ʾ������ ���С��1��Ĭ��10 ��
		this.lineNumber = lineNumber<1? this.lineNumber:lineNumber;
		//������ҳ��  �����ʣ����������һҳ
		this.totalPage = (totalNumber%this.lineNumber==0)?(totalNumber/this.lineNumber):(totalNumber/this.lineNumber+1);
		//����ǰһҳ���Ϊ��һҳ����ת
		this.beforePage = curPage>1 ?curPage-1:1;
		//������һҳһҳ���Ϊ���һҳҳ����ת
		this.afterPage = curPage<this.totalPage?this.curPage+1:totalPage;
		//���㿪ʼ������
		this.beginLine = (curPage-1)*this.lineNumber+1;
		//�������������
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
