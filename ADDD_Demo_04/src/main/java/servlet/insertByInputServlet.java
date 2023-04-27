package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import entity.User;
import model.Model;

/**
 * Servlet implementation class insertByInputServlet
 */
@WebServlet("/insertByInputServlet")
public class insertByInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PHONE = "^1[3-9]\\d{9}$";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertByInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		HttpSession session = request.getSession();
		
		try {
			session.removeAttribute("user");
			session.removeAttribute("msg");
			session.removeAttribute("color");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String uname = request.getParameter("uname");
		String uphone = request.getParameter("uphone");
		String uage = request.getParameter("uage");
		String usex = request.getParameter("usex");
		
		if(!"".equals(uname) && !"".equals(uphone) && !"".equals(usex) && !"".equals(uage) && uphone.matches(PHONE)) {
			// ��ʽ��ȷ
			boolean flag = Model.insertUser(uname, uphone, usex, Integer.valueOf(uage));
			if(flag) {
				User user = Model.getByPhone(uphone);
				
				if(user != null) {
					List<User> users = new ArrayList<User>();
					users.add(user);
					String usersString = JSON.toJSONString(users);
					session.setAttribute("users", usersString);
					session.setAttribute("msg", "�û� "+uname+" ��ӳɹ���");
					session.setAttribute("color", "green");
				}
				
			}else {
				session.setAttribute("msg", "�û� "+uname+" ���ʧ�ܣ�ԭ���û��Ѵ��ڣ�");
				session.setAttribute("color", "red");
			}
		}else {
			// ��ʽ����
			session.setAttribute("msg", "�������ݸ�ʽ������˶Ժ��ٴγ��ԣ�");
			session.setAttribute("color", "red");
		}
		
		response.sendRedirect("insertShow.jsp");
		
	}

}
