package cn.fuqiang.food.dao;

import java.util.List;
import java.util.Map;

import cn.fuqiang.food.entity.Desk;

public interface IDeskDao {
	/**
	 * ����������ҳ��ѯ  ����һ����ѯ��list�����
	 * @param name   ģ�����ҵ�����
	 * @param beginLine  ��ʼ������
	 * @param endLine    ����������
	 * @return  List<Desk> �Ľ����
	 */
	public List<Map> getDesksByName(String name,Integer beginLine,Integer endLine);
	/**
	 * ����id����һ����ѯ��Desk����
	 * @param id ��Ҫ������id
	 * @return Desk����
	 */
	public Desk getDeskById(String id);
	/**
	 * ����ģ����ѯ���������ط�������������
	 * @param name ģ�����ҵ�����
	 * @return ���ط�������������
	 */
	public int getDesksCountByName(String name);
	/**
	 * ����һ��Deskʵ��������ݿ���
	 * @param newDesk ��Ҫ�������ݿ��е�ʵ��
	 * @return 0 Ϊ����ʧ������Ϊ�ɹ�
	 */
	public int addDesk(Desk newDesk);
	/**
	 *����һ���޸ĵ�����
	 *@param �޸ĳɹ���Desk����
	 *@return 0�޸�ʧ��  ����Ϊ�ɹ�
	 */
	public int updateDesk(Desk updateDesk);
	/**
	 * ����һ����Ҫɾ����id
	 * @param id ��Ҫɾ�����ݵ�id
	 * @return 0�޸�ʧ�� ����Ϊ�ɹ�
	 */
	public int deleteDeskById(String id);
}
