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

/**
 * @author mdelapenya
 */
public class RouteBusStopInfo implements Serializable {

	/**
	 * Public empty constructor for automatic Jackson parsing
	 */
	public RouteBusStopInfo() {
		super();
	}

	public RouteBusStopInfo(String routeId, String orderId) {
		this();

		this.orderId = orderId;
		this.routeId = routeId;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getRouteId() {
		return routeId;
	}

	private String orderId;
	private String routeId;

}
