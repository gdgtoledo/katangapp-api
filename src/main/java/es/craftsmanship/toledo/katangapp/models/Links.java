package es.craftsmanship.toledo.katangapp.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author mdelapenya
 */
public class Links implements Serializable {

	public String getSelf() {
		return self;
	}

	public String getPrev() {
		return prev;
	}

	public String getNext() {
		return next;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public void setPrev(String prev) {
		this.prev = prev;
	}

	public void setNext(String next) {
		this.next = next;
	}

	private String self;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String prev;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String next;

}