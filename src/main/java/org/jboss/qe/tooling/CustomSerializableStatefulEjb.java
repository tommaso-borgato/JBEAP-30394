package org.jboss.qe.tooling;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateful;
import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;
import java.util.Date;

@Stateful
@LocalBean
@SessionScoped
public class CustomSerializableStatefulEjb implements Serializable {
	private static final long serialVersionUID = 1L;
	private final String name;
	private final Date date;

	public CustomSerializableStatefulEjb() {
		this.name = CustomSerializableStatefulEjb.class.getName();
		this.date = new Date();
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}
}
