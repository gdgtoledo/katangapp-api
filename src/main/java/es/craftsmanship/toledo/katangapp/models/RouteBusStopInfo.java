package es.craftsmanship.toledo.katangapp.models;

/**
 * @author mdelapenya
 */
public class RouteBusStopInfo {

	public RouteBusStopInfo(String routeId, String orderId) {
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
