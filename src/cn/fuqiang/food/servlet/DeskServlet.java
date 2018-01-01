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

	//用来调用方法的类
	private DeskManager manager = new DeskManager();
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
	/**
	 * 获取请求中的dId并且删除对应的数据
	 * @param request 
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response,String name,String curPage) throws ServletException, IOException {
		//获取要删除的dId
		String dId = request.getParameter("id");
		//调用对应的方法
		manager.deleteDesk(dId);
		//转发到对应的便利
		requestDispatcher(request, response, name, curPage);
	}
	/**
	 * 将数据请求转发到某个位置
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
		//获取要修改的did
		String dId = request.getParameter("dId");
		//获取修改的新姓名
		String dName = request.getParameter("dName");
		//获取状态
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
			//如果有则覆盖该值 没有则使用默认
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
