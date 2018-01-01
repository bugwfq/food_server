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
		//设置响应的字符集
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//查看请求的方方法
		String service = request.getParameter("method");
		
		//查看是否是模糊查找
		String name = request.getParameter("name");
		//查看当前页
		String curPage = request.getParameter("curPage");
		
		//如果是查看
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
		//转发到对应的页面
		requestDispantche(request, response, name, curPage);
	}
	private void select(HttpServletRequest request, HttpServletResponse response, String name, String curPage) throws ServletException, IOException {
		if(request.getParameter("lineNumber")!=null){
			//如果有则覆盖该值 没有则使用默认
			lineNumber = request.getParameter("lineNumber");
		}
		//转发到对应的页面
		requestDispantche(request, response, name, curPage);
	}
	/**
	 * 修改
	 */
	private void update(HttpServletRequest request, HttpServletResponse response, String name, String curPage) throws ServletException, IOException {

		String typeId = request.getParameter("typeId");
	
		String typeName = request.getParameter("typeName");
		manager.updateFoodType(typeId, typeName);
		//转发到对应的页面
		requestDispantche(request, response, name, curPage);
	}
	/**
	 * 删除
	 * @param request
	 * @param response
	 * @param name
	 * @param curPage
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response, String name, String curPage) throws ServletException, IOException {
		//获取要删除的dId
		String id = request.getParameter("id");
		//调用对应的方法
		manager.deleteFoodType(id);
		//转发到对应的页面
		requestDispantche(request, response, name, curPage);
	}
	/**
	 * 将查询到的值转发到对应的页面
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
	/**查询
	private void select(HttpServletRequest request, HttpServletResponse response, String name, String curPage) throws ServletException, IOException {
		if(request.getParameter("lineNumber")!=null){
			//如果有则覆盖该值 没有则使用默认
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
