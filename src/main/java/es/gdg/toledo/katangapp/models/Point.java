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

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

/**
 * This class represents a point in the surface of the Earth, identified by its
 * latitude and longitude coordinates.
 *
 * As it is on Earth surface, it's possible to calculate the distance to another
 * point in meters using trigonometry, as the Earth's radius is a well-known
 * constant.
 *
 * @author mdelapenya
 */
@JsonPropertyOrder(alphabetic = true)
public class Point implements ReferenceablePoint, Serializable {

	/**
	 * Public empty constructor for automatic Jackson parsing
	 */
	public Point() {
		super();
	}

	public Point(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * Calculates the distance from this point to the point passed as argument,
	 * using Earth's radius and trigonometry.
	 *
	 * @param to
	 *
	 * @return the distance in meters to the <code>to</code> point.
	 *
	 * @throws UnreferenceablePointException when the <code>to</code> point is
	 *                                       not referenced or is null.
	 */
	public double distanceTo(ReferenceablePoint to)
		throws UnreferenceablePointException {

		return distanceTo(to, new StraightDistanceCalculator());
	}

	/**
	 * Calculates the distance from this point to the point passed as argument,
	 * using the strategy defined by the distanceCalculator algorithm.
	 *
	 * @param to
	 * @param distanceCalculator the Strategy to calculate the distance
	 *
	 * @return the distance in meters to the <code>to</code> point.
	 *
	 * @throws UnreferenceablePointException when the <code>to</code> point is
	 *                                       not referenced or is null.
	 */
	public double distanceTo(
			ReferenceablePoint to, DistanceCalculator distanceCalculator)
		throws UnreferenceablePointException {

		if (distanceCalculator == null) {
			distanceCalculator = new StraightDistanceCalculator();
		}

		return distanceCalculator.distance(this, to);
	}

	@Override
	public boolean equals(final Object that) {
		if (this == that) {
			return true;
		}

		if (!(that instanceof Point)) {
			return false;
		}

		Point thatPoint = (Point)that;

		return ((this.latitude == thatPoint.latitude) &&
			(this.longitude == thatPoint.longitude));
	}

	@Override
	public double getLatitude() {
		return latitude;
	}

	@Override
	public double getLongitude() {
		return longitude;
	}

	@Override
	public int hashCode() {
		int hashCode = 31;

		long l = Double.doubleToLongBits(latitude);

		int c = (int) (l ^ (l >>> 32));

		hashCode = 37 * hashCode + c;

		l = Double.doubleToLongBits(longitude);

		c = (int) (l ^ (l >>> 32));

		hashCode = 37 * hashCode + c;

		return hashCode;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "lt: " + latitude + ", ln: " + longitude;
	}

	private double latitude;
	private double longitude;

}
