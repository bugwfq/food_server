package cn.fuqiang.food.service;

import cn.fuqiang.food.utilities.PageTools;

public interface IOrderFormManager {
	
	/**
	 * ���ݴ������Ϣ����һ�����ݵ����ݿ�
	 * @param foodID  ��Ʒid
	 * @param did	����id
	 * @param count ��Ʒ����
	 * @return
	 */
	public boolean addOrderFormList(String foodID,String did,String count);
	
	/**
	 * ���ݴ������Ϣ�޸����ݿ��е���Ϣ
	 * @param fid Ҫ�޸ĵ�id
	 * @param foodID  Ҫ�޸ĵĲ�Ʒid
	 * @param did Ҫ�޸ĵĲ���id��
	 * @param count Ԥ������
	 * @return
	 */
	public boolean updateOrderFormList(String fid,String foodID,String did,String count);
	
	
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
	public boolean deleteOrderForm(String id);
}
