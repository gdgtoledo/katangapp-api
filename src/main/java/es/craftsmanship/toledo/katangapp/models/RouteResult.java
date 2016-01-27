package es.craftsmanship.toledo.katangapp.models;

/**
 * This class represents the time needed for a bus of a route, identified by the
 * field <code>idl</code>, to arrive to a specific bus stop.
 * 
 * @author mdelapenya
 */
public class RouteResult implements Comparable<RouteResult> {

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
