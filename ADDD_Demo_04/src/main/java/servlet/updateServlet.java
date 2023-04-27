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
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PHONE = "^1[3-9]\\d{9}$";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		try {
			session.removeAttribute("msg");
			session.removeAttribute("color");
			session.removeAttribute("originalUser");
			session.removeAttribute("updatedUser");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String idString = request.getParameter("uid");
		String uname = request.getParameter("uname");
		String uphone = request.getParameter("uphone");
		String usex = request.getParameter("usex");
		String uage = request.getParameter("uage");
		
		if(!"".equals(idString) && !"".equals(uname) && !"".equals(uphone) && uphone.matches(PHONE) && !"".equals(usex) && !"".equals(uage) && idString.matches("^\\d{1,10}$") && uage.matches("^\\d{1,10}$")) {
			
			Integer uid = Integer.valueOf(idString);
			
			User originalUser = Model.getByID(uid);
			
			if(originalUser != null) {
				
				Boolean flag = Model.updateByID(uid, uname, uphone, usex, Integer.parseInt(uage));
				if(flag) {
					User updatedUser = Model.getByID(uid);
					session.setAttribute("originalUser", originalUser);
					session.setAttribute("updatedUser", updatedUser);
					session.setAttribute("msg", "用户ID为 "+idString+" 的信息修改成功!");
					session.setAttribute("color", "green");
				}else {
					session.setAttribute("msg", "修改失败， 原因：用户信息与其他用户发生冲突（比如：手机号）！");
					session.setAttribute("color", "red");
				}
				
			}else {
				session.setAttribute("msg", "修改失败， 原因：用户不存在！");
				session.setAttribute("color", "red");
			}
			
		}else {
			session.setAttribute("msg", "输入的内容不合法，请仔细检查后重新尝试！");
			session.setAttribute("color", "red");
		}
		
		response.sendRedirect("updateShow.jsp");
		
	}

}
