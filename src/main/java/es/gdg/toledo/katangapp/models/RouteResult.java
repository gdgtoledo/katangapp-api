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

package es.gdg.toledo.katangapp.models;

import java.io.Serializable;

/**
 * This class represents the time needed for a bus of a route, identified by the
 * field <code>idl</code>, to arrive to a specific bus stop.
 *
 * @author mdelapenya
 */
public class RouteResult implements Comparable<RouteResult>, Serializable {

	/**
	 * Public empty constructor for automatic Jackson parsing
	 */
	public RouteResult() {
		super();
	}

	public RouteResult(String routeId, long time) {
		this.idl = routeId;
		this.time = time;
	}

	/**
	 * Note: this class has a natural ordering that is inconsistent with equals.
	 *
	 * If the time is equals, points will be ordered by Route ID (idl field)
	 *
	 * @param that
	 * @return
	 */
	@Override
	public int compareTo(RouteResult that) {
		if (this.time < that.getTime()) {
			return -1;
		}
		else if (this.time > that.time) {
			return 1;
		}
		else {
			return idl.compareTo(that.getIdl());
		}
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}

		if (!(that instanceof RouteResult)) {
			return false;
		}

		RouteResult routeResultThat = (RouteResult)that;

		if ((this.time == routeResultThat.time) &&
			(this.idl.equals(routeResultThat.idl))) {

			return true;
		}

		return false;
	}

	public String getIdl() {
		return idl;
	}

	public long getTime() {
		return time;
	}

	@Override
	public int hashCode() {
		int hashCode = 31;

		long l = Double.doubleToLongBits(time);

		int c = (int) (l ^ (l >>> 32));

		hashCode = 37 * hashCode + c;

		c = idl.hashCode();

		hashCode = 37 * hashCode + c;

		return hashCode;
	}

	@Override
	public String toString() {
		return "idl: " + idl + ", time: " + time;
	}

	/**
	 * Identifier of the route arriving to a specific bus stop.
	 */
	private String idl;

	/**
	 * Time in minutes for a bus stop of a route to arrive to a specific bus
	 * stop.
	 */
	private long time;

}
