package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONType;

import entity.User;
import model.Model;

/**
 * Servlet implementation class insertByExcelServlet
 */
@WebServlet("/insertByExcelServlet")
public class insertByExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public insertByExcelServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");

		String usersString = request.getParameter("users");

		HttpSession session = request.getSession();

		try {
			session.removeAttribute("user");
			session.removeAttribute("msg");
			session.removeAttribute("color");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		PrintWriter printWriter = response.getWriter();

		if (!"".equals(usersString)) {
			JSONArray jsonArray = JSON.parseArray(usersString);
			List<User> users = new ArrayList<User>();
			String msg = "";
			for (Object object : jsonArray) {
				User user = JSON.toJavaObject(JSON.parseObject(object.toString()), User.class);
				boolean flag = Model.insertUser(user.getUname(), user.getUphone(), user.getUsex(), user.getUage());
				if (flag) {
					msg += user.getUname() + "：添加成功！<br/>";
				}else {
					msg += user.getUname() + "：添加失败, 原因：用户已存在！<br/>";
				}
				users.add(Model.getByPhone(user.getUphone()));
			}
			String uString = JSON.toJSONString(users);
			session.setAttribute("users", uString);
			session.setAttribute("msg", msg);
			session.setAttribute("color", "black");
		} else {
			session.setAttribute("msg", "数据不能为空！");
			session.setAttribute("color", "red");
		}

		response.sendRedirect("insertShow.jsp");

	}

}
