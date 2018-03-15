/**
 *    Copyright 2016-today GDG Toledo ES
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package es.gdg.toledo.katangapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

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
public class BusStopResult implements Serializable {

	/**
	 * Public empty constructor for automatic Jackson parsing
	 */
	public BusStopResult() {
		super();
	}

	/**
	 * Represents a favorite bus stop, which we don't want to know the distance
	 *
	 * @param busStop
	 * @param results
	 */
	public BusStopResult(BusStop busStop, List<RouteResult> results) {
		this.busStop = busStop;
		this.distance = null;
		this.results = results;
	}

	public BusStopResult(
		double distance, BusStop busStop, List<RouteResult> results) {

		this(busStop, results);

		this.distance = distance;
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
	private Double distance;

	@JsonProperty("parada")
	private BusStop busStop;

	@JsonProperty("tiempos")
	private List<RouteResult> results;

}
