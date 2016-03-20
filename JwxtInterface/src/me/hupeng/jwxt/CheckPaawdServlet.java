package me.hupeng.jwxt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.hupeng.JwxtUtil.main.JwxtUtil;

@WebServlet("/check.html")
public class CheckPaawdServlet extends HttpServlet{
	
	private String zjh;
	private String mm;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		zjh = req.getParameter("zjh");
		mm = req.getParameter("mm");
		JwxtUtil jwxtUtil = new JwxtUtil();
		try {
			jwxtUtil.setStuNum(zjh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			resp.getOutputStream().write("0".getBytes());
			e.printStackTrace();
			return;
		}
		jwxtUtil.setPassword(mm);
		try {
			if (jwxtUtil.checkStuPasswd()) {
				resp.getOutputStream().write("1".getBytes());
			}else{
				resp.getOutputStream().write("0".getBytes());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.getOutputStream().write("0".getBytes());
			return;
		}
	}
}
