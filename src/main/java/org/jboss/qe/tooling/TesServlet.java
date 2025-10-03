package org.jboss.qe.tooling;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Logger;

@SuppressWarnings("serial")
@WebServlet("/test")
public class TesServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(TesServlet.class.getName());

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession(true);
		CustomSerializableObject object = null;
		Instant start = Instant.now();
		if(session.getAttribute(CustomSerializableObject.class.getName()) == null){
			log.info("Creating new CustomSerializableObject...");
			object = new CustomSerializableObject();
			session.setAttribute(CustomSerializableObject.class.getName(), object);
		} else {
			log.info("CustomSerializableObject already exists...");
			for (int i = 0; i < 1000000; i++) {
				object = (CustomSerializableObject) session.getAttribute(CustomSerializableObject.class.getName());
			}
		}
		Instant finish = Instant.now();
		resp.setContentType("text/html");

		PrintWriter writer = resp.getWriter();
		writer.print("Session: " + session.getId());
		Date currentDate = new Date();
		writer.print("<p>CustomSerializableObject: " + dateFormat.format(object == null ? null : object.getDate()) + " (" + dateFormat.format(currentDate) + ")</p>");
		writer.print("<p>elapsed: " + Duration.between(start, finish) + "</p>");
		writer.close();
	}

}
