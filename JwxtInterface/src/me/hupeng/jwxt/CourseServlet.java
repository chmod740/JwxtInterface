package me.hupeng.jwxt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.hupeng.jwxt.course.Configuration;
import me.hupeng.jwxt.course.Course;
import me.hupeng.jwxt.course.JwxtCourse;

import com.google.gson.Gson;

@WebServlet("/course.html")
public class CourseServlet extends HttpServlet{
	private String zjh;
	private String mm;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		zjh = req.getParameter("zjh");
		mm = req.getParameter("mm");
		Configuration configuration = new Configuration(zjh, mm);
		JwxtCourse jwxtCourse = new JwxtCourse();
		List<Course> list = jwxtCourse.getCourseList(configuration);
		resp.setHeader("Content-Type", "text/html; charset=utf-8");
		resp.getOutputStream().write(new Gson().toJson(list).getBytes());
	}
	
}