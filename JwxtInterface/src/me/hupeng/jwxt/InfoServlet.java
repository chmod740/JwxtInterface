package me.hupeng.jwxt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import me.hupeng.JwxtUtil.main.JwxtUtil;

@WebServlet("/info.html")
public class InfoServlet extends HttpServlet{
	private String zjh;
	private String mm;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		zjh = request.getParameter("zjh");
		mm = request.getParameter("mm");
		JwxtUtil jwxtUtil = new JwxtUtil();
		try {
			jwxtUtil.setStuNum(zjh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jwxtUtil.setPassword(mm);
		response.setHeader("Content-Type", "text/html; charset=utf-8");
		try {
			response.getOutputStream().write(new Gson().toJson(jwxtUtil.GetstudentInfo()).getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.getOutputStream().write("null".getBytes());
			e.printStackTrace();
		}
	}
}
