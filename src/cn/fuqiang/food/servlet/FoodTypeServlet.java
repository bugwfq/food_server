package cn.fuqiang.food.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.fuqiang.food.service.imp.FoodTypeManager;
import cn.fuqiang.food.utilities.PageTools;

/**
 * Servlet implementation class FoodServlet
 */
public class FoodTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private FoodTypeManager manager = new FoodTypeManager();
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
	private void add(HttpServletRequest request, HttpServletResponse response, String name, String curPage) throws ServletException, IOException {
		String typeName = request.getParameter("typeName");
		manager.addFoodType(typeName);
		//ת������Ӧ��ҳ��
		requestDispantche(request, response, name, curPage);
	}
	private void select(HttpServletRequest request, HttpServletResponse response, String name, String curPage) throws ServletException, IOException {
		if(request.getParameter("lineNumber")!=null){
			//������򸲸Ǹ�ֵ û����ʹ��Ĭ��
			lineNumber = request.getParameter("lineNumber");
		}
		//ת������Ӧ��ҳ��
		requestDispantche(request, response, name, curPage);
	}
	/**
	 * �޸�
	 */
	private void update(HttpServletRequest request, HttpServletResponse response, String name, String curPage) throws ServletException, IOException {

		String typeId = request.getParameter("typeId");
	
		String typeName = request.getParameter("typeName");
		manager.updateFoodType(typeId, typeName);
		//ת������Ӧ��ҳ��
		requestDispantche(request, response, name, curPage);
	}
	/**
	 * ɾ��
	 * @param request
	 * @param response
	 * @param name
	 * @param curPage
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response, String name, String curPage) throws ServletException, IOException {
		//��ȡҪɾ����dId
		String id = request.getParameter("id");
		//���ö�Ӧ�ķ���
		manager.deleteFoodType(id);
		//ת������Ӧ��ҳ��
		requestDispantche(request, response, name, curPage);
	}
	/**
	 * ����ѯ����ֵת������Ӧ��ҳ��
	 * @param request
	 * @param response
	 * @param name
	 * @param curPage
	 * @throws ServletException
	 * @throws IOException
	 */
	private void requestDispantche(HttpServletRequest request, HttpServletResponse response, String name,
			String curPage) throws ServletException, IOException {
		PageTools pageTools = manager.getPageTools(name, curPage, lineNumber );
		request.setAttribute("pageTools", pageTools);
		request.getRequestDispatcher("/detail/cuisineList.jsp").forward(request, response);
	}
	/**��ѯ
	private void select(HttpServletRequest request, HttpServletResponse response, String name, String curPage) throws ServletException, IOException {
		if(request.getParameter("lineNumber")!=null){
			//������򸲸Ǹ�ֵ û����ʹ��Ĭ��
			lineNumber = request.getParameter("lineNumber");
		}
		
		requestDispantche(request, response, name, curPage);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
