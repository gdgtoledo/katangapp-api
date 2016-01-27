package es.craftsmanship.toledo.katangapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class QueryResult {

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
