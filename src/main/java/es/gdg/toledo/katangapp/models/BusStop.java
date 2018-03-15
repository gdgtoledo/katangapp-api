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

import es.gdg.toledo.katangapp.business.DistanceCalculator;
import es.gdg.toledo.katangapp.business.UnreferenceablePointException;
import es.gdg.toledo.katangapp.internal.algorithm.StraightDistanceCalculator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a bus stop, identified by the route which it belongs,
 * the order of the bus stop in the route, its latitude and longitude
 * coordinates, and its human address.
 *
 * Latitude and Longitude coordinates will represent the <code>Point</code>
 * object of the application model.
 *
 * When serializing to JSON, it will ignore the Point representing the bus stop,
 * and will order the fields alphabetically.
 *
 * @author mdelapenya
 *
 * @see Point
 */
@JsonPropertyOrder(alphabetic = true)
public class BusStop extends BaseLinkableModel
	implements ReferenceablePoint, Serializable {

	/**
	 * Public empty constructor for automatic Jackson parsing
	 */
	public BusStop() {
		super();

		routes = new ArrayList<>();
	}

	public BusStop(
		String routeId, String id, String order, double latitude,
		double longitude, String address) {

		this();

		this.address = address;
		this.routeId = routeId;
		this.order = order;
		this.id = id;
		this.point = new Point(latitude, longitude);
	}

	/**
	 * Delegates the distance calculation to the point.
	 *
	 * @param to the Point to calculate the distance
	 *
	 * @return the distance in meters
	 *
	 * @throws UnreferenceablePointException when the <code>to</code> point is
	 *                                       not referenced or is null.
	 */
	public double distanceTo(ReferenceablePoint to)
		throws UnreferenceablePointException {

		return distanceTo(to, new StraightDistanceCalculator());
	}

	/**
	 * Delegates the distance calculation to the point, using a strategy for the
	 * distance calculation.
	 *
	 * @param to the Point to calculate the distance
	 * @param distanceCalculator the Strategy to calculate the distance
	 *
	 * @return the distance in meters
	 *
	 * @throws UnreferenceablePointException when the <code>to</code> point is
	 *                                       not referenced or is null.
	 */
	@Override
	public double distanceTo(
			ReferenceablePoint to, DistanceCalculator distanceCalculator)
		throws UnreferenceablePointException {

		return point.distanceTo(to, distanceCalculator);
	}

	public String getAddress() {
		return address;
	}

	public String getRouteId() {
		return routeId;
	}

	public String getOrder() {
		return order;
	}

	public String getId() {
		return id;
	}

	@Override
	public double getLatitude() {
		return getPoint().getLatitude();
	}

	@Override
	public double getLongitude() {
		return getPoint().getLongitude();
	}

	public Point getPoint() {
		return point;
	}

	public List<RouteBusStopInfo> getRoutes() {
		return routes;
	}

	@Override
	public String toString() {
		return "routeId: " + routeId + ", id: " + id + ", order: " + order +
			", " + point + ", address:" + address;
	}

	public void setCoordinates(double latitude, double longitude) {
		if (point == null) {
			point = new Point(latitude, longitude);
		}
		else {
			point.setLatitude(latitude);
			point.setLongitude(longitude);
		}
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public void setRoutes(List<RouteBusStopInfo> routes) {
		this.routes = routes;
	}

	@JsonInclude(Include.NON_NULL)
	private String routeId;

	private List<RouteBusStopInfo> routes;

	@JsonInclude(Include.NON_NULL)
	private String order;

	private String id;

	private String address;

	@JsonUnwrapped
	private Point point;

}
