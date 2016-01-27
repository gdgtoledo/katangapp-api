package es.craftsmanship.toledo.katangapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * This class represents the bus stops that are closer to the user when
 * searching for bus stops. For each bus stop that is close to the user, it will
 * store the distance <strong>in meters</strong> from the user to that bus stop,
 * plus a list of routes that stops in that bus stop, sorted by arrival time. 
 * 
 * @author mdelapenya
 * 
 * @see QueryResult
 * @see RouteResult
 */
public class BusStopResult {

	public BusStopResult(
		double distance, BusStop busStop, List<RouteResult> results) {

		this.busStop = busStop;
		this.distance = distance;
		this.results = results;
	}

	public BusStop getBusStop() {
		return busStop;
	}

	public double getDistance() {
		return distance;
	}

	public List<RouteResult> getResults() {
		return results;
	}

	/**
	 * Distance in meters from the user to the bus stop.
	 */
	@JsonProperty("distancia")
	private double distance;

	@JsonProperty("parada")
	private BusStop busStop;

	@JsonProperty("tiempos")
	private List<RouteResult> results;

}
