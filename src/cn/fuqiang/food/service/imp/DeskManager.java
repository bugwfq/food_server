package cn.fuqiang.food.service.imp;

import java.util.Date;

import cn.fuqiang.food.dao.imp.DeskDao;
import cn.fuqiang.food.entity.Desk;
import cn.fuqiang.food.service.IDeskManager;
import cn.fuqiang.food.utilities.DateUtils;
import cn.fuqiang.food.utilities.PageTools;

public class DeskManager implements IDeskManager {
	private DeskDao deskDao = new DeskDao();
	@Override
	public boolean addDesk(String dName, String dCondition, String targetDate) {
		
		//�жϴ���������Ƿ�Ϊ�������Ϊ����ת������
		Integer condition = null;
		Date date= null;
		//�����Ϊnull��ת��
		if(dCondition !=null){
			condition = Integer.parseInt(dCondition);
		}
		if(targetDate!=null){
			date = DateUtils.stringToDate(targetDate);
		}	
		Desk desk = new Desk(dName,condition,date);
		//��ȡִ�н��
		int result = deskDao.addDesk(desk);
		//��Ϊ0��ʧ�ܣ�������ɹ�
		return result>0?true:false;
	}

	@Override
	public boolean updateDesk(String dId, String dName, String dCondition, String targetDate) {
		//�жϴ���������Ƿ�Ϊ�������Ϊ����ת������
		Integer id = null;
		Integer condition = null;
		Date date= null;
		//�����Ϊnull��ת��
		if(dId!=null){
			id = Integer.parseInt(dId);
		}
		if(dCondition !=null){
			condition = Integer.parseInt(dCondition);
		}
		if(targetDate!=null && !"".equals(targetDate)){
			date = DateUtils.stringToDate(targetDate);
		}	
		Desk desk = new Desk(id,dName,condition,date);
		//��ȡִ�н��
		int result = deskDao.updateDesk(desk);
		//��Ϊ0��ʧ�ܣ�������ɹ�
		return result>0?true:false;
	}

	@Override
	public PageTools getPageTools(String name, String curPage, String lineNumber) {
		Integer cPage = 1;
		Integer line = 0;
		if(name==null){
			name="";
		}
		if(curPage!=null){
			cPage = Integer.parseInt(curPage);
		}
		if(lineNumber!=null){
			line=Integer.parseInt(lineNumber);
		}
		//��ȡ�����������ݿ��е�������
		Integer totalNumber = deskDao.getDesksCountByName(name);
		//������ҳ���߶���
		PageTools pageTools = new PageTools(cPage, totalNumber, line);
		//���鵽�����ݴ��뵽��������
		pageTools.setData(deskDao.getDesksByName(name, pageTools.getBeginLine(), pageTools.getEndLine()));
		return pageTools;
	}

	@Override
	public boolean deleteDesk(String id) {
		if(id==null || id.equals("")){
			return false;
		}
		int result = deskDao.deleteDeskById(id);
		return result>0?true:false;
	}

}
