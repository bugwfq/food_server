package cn.fuqiang.food.dao;

import java.util.List;
import java.util.Map;

import cn.fuqiang.food.entity.Food;

public interface IFoodDao {
	/**
	 * ����������ҳ��ѯ  ����һ����ѯ��list�����
	 * @param name   ģ�����ҵ�����
	 * @param beginLine  ��ʼ������
	 * @param endLine    ����������
	 * @return  List<Food> �Ľ����
	 */
	public List<Map> getFoodsByName(String name,Integer beginLine,Integer endLine);
	/**
	 * ����id����һ����ѯ��Food����
	 * @param id ��Ҫ������id
	 * @return food����
	 */
	public Food getFoodById(String id);
	/**
	 * ����ģ����ѯ���������ط�������������
	 * @param name ģ�����ҵ�����
	 * @return ���ط�������������
	 */
	public int getFoodsCountByName(String name);
	/**
	 * ����һ��Foodʵ��������ݿ���
	 * @param newFood ��Ҫ�������ݿ��е�ʵ��
	 * @return 0 Ϊ����ʧ������Ϊ�ɹ�
	 */
	public int addFood(Food newFood);
	/**
	 *����һ���޸ĵ�����
	 *@param �޸ĳɹ���food����
	 *@return 0�޸�ʧ��  ����Ϊ�ɹ�
	 */
	public int updateFood(Food updateFood);
	/**
	 * ����һ����Ҫɾ����id
	 * @param id ��Ҫɾ�����ݵ�id
	 * @return 0�޸�ʧ�� ����Ϊ�ɹ�
	 */
	public int deleteFoodById(String id);
}
