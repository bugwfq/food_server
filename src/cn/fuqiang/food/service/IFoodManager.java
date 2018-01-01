package cn.fuqiang.food.service;

import cn.fuqiang.food.entity.Food;
import cn.fuqiang.food.utilities.PageTools;

public interface IFoodManager {
	/**
	 * ���ݴ������Ϣ����ֵ�������ݿ�
	 * @param typeId     ��ϵid
	 * @param foodName   ����
	 * @param price		  ����
	 * @param imgPath	  ͼƬ·��
	 * @return ture Ϊ�ɹ�   false Ϊʧ��
	 */
	public boolean addFood(String typeId,String foodName,String price,String imgPath);
	/**
	 * ���ݴ������Ϣ�޸�ָ��������
	 * @param foodId  Ҫ�޸ĵĲ�Ʒid
	 * @param typeId  Ҫ�޸ĵĲ�ϵid
	 * @param foodName Ҫ�޸ĵĲ���
	 * @param price    Ҫ�޸ĵĵ���
	 * @param imgPath  Ҫ�޸ĵ�ͼƬ·��
	 * @return
	 */
	public boolean updateFood(String foodId,String typeId,String foodName,String price,String imgPath);
	
	/**
	 * ����ָ��������ȡһ����ҳ���߶���
	 * @param name    ��Ҫ��ѯ�Ĳ���  ������Ϊ��
	 * @param curPage   ��ǰҳ
	 * @param lineNumber  ÿҳ��ʾ������
	 * @return
	 */
	public PageTools getPageTools(String name,String curPage, String lineNumber);
	/**
	 * ����һ��idɾ����Ӧ�Ĳ�Ʒ��Ϣ
	 * @param id   ĳ����Ʒ��id
	 * @return
	 */
	public boolean deleteFood(String id);
}
