package org.jboss.qe.tooling;

import java.io.Serializable;
import java.util.Date;

public class CustomSerializableObject implements Serializable {
	private static final long serialVersionUID = 1L;
	private final String name;
	private final Date date;

	public CustomSerializableObject() {
		this.name = CustomSerializableObject.class.getName();
		this.date = new Date();
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}
}
