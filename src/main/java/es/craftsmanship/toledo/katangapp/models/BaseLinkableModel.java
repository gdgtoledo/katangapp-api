package es.craftsmanship.toledo.katangapp.models;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author mdelapenya
 */
public abstract class BaseLinkableModel implements LinkableModel {

	public BaseLinkableModel() {
		links = new Links();
	}

	@Override
	public Links getLinks() {
		return links;
	}

	@Override
	public void setNext(String next) {
		links.setNext(next);
	}

	@Override
	public void setPrev(String prev) {
		links.setPrev(prev);
	}

	@Override
	public void setSelf(String self) {
		links.setSelf(self);
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Links links;

}
