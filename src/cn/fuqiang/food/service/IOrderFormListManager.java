package cn.fuqiang.food.service;

import cn.fuqiang.food.utilities.PageTools;

public interface IOrderFormListManager {
	/**
	 * ���ݴ�������ݴ���һ�����ݵ����ݿ�
	 * @param fId Ҫ��ӵĶ���id
	 * @param orderdate ����������
	 * @param condition ������֧��״̬
	 * @return
	 */
	public boolean addOrderForm(String fId,String orderdate,String condition);
	/**
	 * 
	 * @param listId�����б��id
	 *@param fId Ҫ�޸ĵĶ���id
	 * @param orderdate ����������
	 * @param condition ������֧��״̬
	 * @return
	 */
	public boolean updateOrderForm(String listId,String fId,String orderdate,String condition);
	
	
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
	public boolean deleteOrderFormList(String id);
}
