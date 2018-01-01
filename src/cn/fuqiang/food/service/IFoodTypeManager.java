package cn.fuqiang.food.service;

import cn.fuqiang.food.utilities.PageTools;

public interface IFoodTypeManager {
	/**
	 * ���ݴ���Ĳ�ϵ���Ƽ��뵽���ݿ�
	 * @param typeName ��ϵ����
	 * @return
	 */
	public boolean addFoodType(String typeName);
	/**
	 * ���ݴ������Ϣ�޸����ݿ�������
	 * @param typeId   Ҫ�޸ĵĲ�ϵId
	 * @param typeName Ҫ�޸ĵĲ�ϵ����
	 * @return
	 */
	public boolean updateFoodType(String typeId,String typeName);
	/**
	 * ���ݴ���������͵�ǰҳ��ѯָ����Χ���ݣ�������Ĭ�ϲ�����
	 * @param name  ��ѯ������
	 * @param curPage  ��ǰҳ
	 * @param lineNumber ÿҳ��ʾ������
	 * @return
	 */
	public PageTools getPageTools(String name,String curPage, String lineNumber);
	/**
	 * ���ݴ����idɾ�����ݿ����ƶ�����
	 * @param id  Ҫɾ�����ݵ�id
	 * @return
	 */
	public boolean deleteFoodType(String id);
}
