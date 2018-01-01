package cn.fuqiang.food.dao;

import java.util.List;
import java.util.Map;

import cn.fuqiang.food.entity.FoodType;


public interface IFoodTypeDao {
	/**
	 * ����������ҳ��ѯ  ����һ����ѯ��list�����
	 * @param name   ģ�����ҵ�����
	 * @param beginLine  ��ʼ������
	 * @param endLine    ����������
	 * @return  List<FoodType> �Ľ����
	 */
	public List<Map> getFoodTypesByName(String name,Integer beginLine,Integer endLine);
	/**
	 * ����id����һ����ѯ��FoodType����
	 * @param id ��Ҫ������id
	 * @return FoodType����
	 */
	public FoodType getFoodTypeById(String id);
	/**
	 * ����ģ����ѯ���������ط�������������
	 * @param name ģ�����ҵ�����
	 * @return ���ط�������������
	 */
	public int getFoodTypesCountByName(String name);
	/**
	 * ����һ��FoodTypeʵ��������ݿ���
	 * @param newFoodType ��Ҫ�������ݿ��е�ʵ��
	 * @return 0 Ϊ����ʧ������Ϊ�ɹ�
	 */
	public int addFoodType(FoodType newFoodType);
	/**
	 *����һ���޸ĵ�����
	 *@param �޸ĳɹ���FoodType����
	 *@return 0�޸�ʧ��  ����Ϊ�ɹ�
	 */
	public int updateFoodType(FoodType updateFoodType);
	/**
	 * ����һ����Ҫɾ����id
	 * @param id ��Ҫɾ�����ݵ�id
	 * @return 0�޸�ʧ�� ����Ϊ�ɹ�
	 */
	public int deleteFoodTypeById(String id);
}
