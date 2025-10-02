package org.jboss.qe.tooling;

import net.jcip.annotations.Immutable;

import java.io.Serializable;
import java.util.Date;

@Immutable
public class CustomSerializableImmutableObject implements Serializable {
	private static final long serialVersionUID = 1L;
	private final String name;
	private final Date date;

	public CustomSerializableImmutableObject() {
		this.name = CustomSerializableImmutableObject.class.getName();
		this.date = new Date();
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}
}
