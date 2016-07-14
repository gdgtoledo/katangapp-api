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
