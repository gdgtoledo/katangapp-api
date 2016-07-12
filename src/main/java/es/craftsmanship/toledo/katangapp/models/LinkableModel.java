package es.craftsmanship.toledo.katangapp.models;

/**
 * @author mdelapenya
 */
public interface LinkableModel {

	Links getLinks();

	void setNext(String next);

	void setPrev(String prev);

	void setSelf(String self);

}