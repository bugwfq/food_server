package cn.fuqiang.food.service;

import cn.fuqiang.food.utilities.PageTools;

public interface IDeskManager {
	/**
	 * ���ݴ����ֵ�½�һ�����ݵ����ݿ�
	 * @param dName   ���ӵ�����
	 * @param dCondition  ���ӵ�Ԥ��״̬
	 * @param targetDate  ���ӵ�Ԥ������
	 * @return  ������ӵ�״̬ true�ɹ�
	 */
	public boolean addDesk(String dName,String dCondition,String targetDate);
	/**
	 *���ݴ������Ϣ�޸����ݿ��е�����
	 * @param dId �޸ĵĲ���id
	 * @param dName �޸ĵĲ�������
	 * @param dCondition �޸ĵĲ�����״̬
	 * @param targetDate �޸ĵĲ�����Ԥ������
	 * @return  trueΪ�ɹ�  falseΪʧ��
	 */
	public boolean updateDesk(String dId,String dName,String dCondition,String targetDate);
	
	/**
	 * ���ݴ���������͵�ǰҳ��ѯָ����Χ���ݣ�������Ĭ�ϲ�����
	 * @param name  ��ѯ������
	 * @param curPage  ��ǰҳ
	 * @param lineNumber ÿҳ��ʾ������
	 * @return
	 */
	public PageTools getPageTools(String name,String curPage, String lineNumber);
	/**
	 * ���ݴ����idɾ��ָ������
	 * @param id Ҫɾ����id
	 * @return
	 */
	public boolean deleteDesk(String id);
	
}
