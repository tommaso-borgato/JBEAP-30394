package org.jboss.qe.tooling;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Logger;

@SuppressWarnings("serial")
@WebServlet("/test")
public class CustomSerializableObjectServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(CustomSerializableObjectServlet.class.getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession(true);
		CustomSerializableObject object;
		if( session.getAttribute(CustomSerializableObjectServlet.class.getName()) == null){
			log.info("Creating new CustomSerializableObject");
			object = new CustomSerializableObject(CustomSerializableObjectServlet.class.getName());
			session.setAttribute(CustomSerializableObjectServlet.class.getName(), object);
		} else {
			log.info("CustomSerializableObject already exists");
			object = (CustomSerializableObject) session.getAttribute(CustomSerializableObjectServlet.class.getName());
		}
		resp.setContentType("text/html");

		PrintWriter writer = resp.getWriter();
		writer.print("Session: " + session.getId());
		writer.print("CustomSerializableObject: " + object.getDate() + " (" + new Date() + ")");
		writer.close();
	}

}
