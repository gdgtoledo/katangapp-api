package es.craftsmanship.toledo.katangapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * This class represents the main search concept of the application.
 * 
 * A user will perform a search, returning a list of the closest to the user bus
 * stops, sorted by distance to the user.
 * 
 * @author mdelapenya
 * 
 * @see BusStopResult
 */
public class QueryResult implements Serializable {

	/**
	 * Public empty constructor for automatic Jackson parsing
	 */
	public QueryResult() {
		super();
	}

	public QueryResult(List<BusStopResult> results) {
		this.results = results;
	}

	public List<BusStopResult> getResults() {
		return results;
	}

	/**
	 * The list of the closest to the user bus stops.
	 */
	@JsonProperty("paradas")
	private List<BusStopResult> results;

}
