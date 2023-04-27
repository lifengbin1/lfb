package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import model.Model;

/**
 * Servlet implementation class deleByIDServlet
 */
@WebServlet("/deleByIDServlet")
public class deleByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleByIDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String idString = request.getParameter("uid");
		
		HttpSession session = request.getSession();
		try {
			session.removeAttribute("msg");
			session.removeAttribute("color");
			session.removeAttribute("user");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if(!"".equals(idString) && idString.length() <= 10 && idString.matches("^\\d{1,}$")) {
			
			Integer uid = Integer.valueOf(idString);
			
			User user = Model.getByID(uid);
			
			boolean flag = Model.deleByID(uid);
			
			if(flag && user != null) {
				session.setAttribute("user", user);
				session.setAttribute("msg", "ɾ���û� "+user.getUname()+" �ɹ���");
				session.setAttribute("color", "green");
			}else {
				session.setAttribute("msg", "ɾ���û�IDΪ "+idString+" ���û�ʧ�ܣ�ԭ���û������ڣ�");
				session.setAttribute("color", "red");
			}
			
		}else {
			session.setAttribute("msg", "ID��ʽ����");
			session.setAttribute("color", "red");
		}
		
		
		response.sendRedirect("deleShow.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
