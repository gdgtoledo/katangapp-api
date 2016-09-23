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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represents a route of buses, identified by <code>id</code> and
 * <code>name</code>, containing an ordered list of bus stops.
 * 
 * @author mdelapenya
 */
public class Route extends BaseLinkableModel implements Serializable {

	public Route() {
		this.busStops = Collections.emptyList();
	}

	public Route(String id, String name) {
		this();

		this.id = id;
		this.name = name;
	}

	public void addBusStop(BusStop busStop) {
		if (busStops == null) {
			busStops = new ArrayList<>();
		}

		this.busStops.add(busStop);
	}

	public List<BusStop> getBusStops() {
		return busStops;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setBusStops(List<BusStop> busStops) {
		this.busStops = busStops;
	}

	private List<BusStop> busStops;
	private String id;
	private String name;

}
