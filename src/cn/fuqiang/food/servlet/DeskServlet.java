package cn.fuqiang.food.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.fuqiang.food.service.imp.DeskManager;
import cn.fuqiang.food.utilities.PageTools;

/**
 * Servlet implementation class DeskServlet
 */
public class DeskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//�������÷�������
	private DeskManager manager = new DeskManager();
	private String lineNumber = "6";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������Ӧ���ַ���
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//�鿴����ķ�����
		String service = request.getParameter("method");
		
		//�鿴�Ƿ���ģ������
		String name = request.getParameter("name");
		//�鿴��ǰҳ
		String curPage = request.getParameter("curPage");
		
		//����ǲ鿴
		if(service.equals("select")){
			select(request, response, name, curPage);
			return;
		}else if(service.equals("add")){
			add(request, response, name, curPage);
			return;
		}else if(service.equals("update")){
			update(request, response, name, curPage);
			return;
		}else if(service.equals("delete")){
			delete(request, response, name, curPage);
			return;
		}
	}
	/**
	 * ��ȡ�����е�dId����ɾ����Ӧ������
	 * @param request 
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response,String name,String curPage) throws ServletException, IOException {
		//��ȡҪɾ����dId
		String dId = request.getParameter("id");
		//���ö�Ӧ�ķ���
		manager.deleteDesk(dId);
		//ת������Ӧ�ı���
		requestDispatcher(request, response, name, curPage);
	}
	/**
	 * ����������ת����ĳ��λ��
	 * @param request
	 * @param response
	 * @param name
	 * @param curPage
	 * @throws ServletException
	 * @throws IOException
	 */
	private void requestDispatcher(HttpServletRequest request, HttpServletResponse response, String name,
			String curPage) throws ServletException, IOException {
		PageTools pageTools = manager.getPageTools(name, curPage, lineNumber );
		request.setAttribute("pageTools", pageTools);
		request.getRequestDispatcher("/detail/boardList.jsp").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response, String name, String curPage)
			throws ServletException, IOException {
		//��ȡҪ�޸ĵ�did
		String dId = request.getParameter("dId");
		//��ȡ�޸ĵ�������
		String dName = request.getParameter("dName");
		//��ȡ״̬
		String dCondition = request.getParameter("condition");
		String targetDate = request.getParameter("targetDate");
		manager.updateDesk(dId, dName, dCondition, targetDate);
		requestDispatcher(request, response, name, curPage);
	}

	private void add(HttpServletRequest request, HttpServletResponse response, String name, String curPage)
			throws ServletException, IOException {
		String dName = request.getParameter("dName");
		String dCondition = request.getParameter("dCondition");
		String targetDate = request.getParameter("targetDate");
		manager.addDesk(dName, dCondition, targetDate);
		requestDispatcher(request, response, name, curPage);
	}

	private void select(HttpServletRequest request, HttpServletResponse response, String name, String curPage)
			throws ServletException, IOException {
		if(request.getParameter("lineNumber")!=null){
			//������򸲸Ǹ�ֵ û����ʹ��Ĭ��
			lineNumber = request.getParameter("lineNumber");
		}
		
		requestDispatcher(request, response, name, curPage);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
