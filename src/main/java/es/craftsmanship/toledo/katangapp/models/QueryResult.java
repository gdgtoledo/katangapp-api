/**
 *    Copyright 2016-today Software Craftmanship Toledo
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
