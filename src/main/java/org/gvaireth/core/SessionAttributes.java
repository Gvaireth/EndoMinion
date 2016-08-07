package org.gvaireth.core;

public enum SessionAttributes {
	ENDOMONDO_SESSION("endomondoSession");

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private SessionAttributes(String name) {
		this.setName(name);
	}

}
