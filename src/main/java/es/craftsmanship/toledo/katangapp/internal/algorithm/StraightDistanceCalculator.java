package es.craftsmanship.toledo.katangapp.internal.algorithm;

import es.craftsmanship.toledo.katangapp.business.DistanceCalculator;
import es.craftsmanship.toledo.katangapp.business.UnreferenceablePointException;
import es.craftsmanship.toledo.katangapp.models.Constants;
import es.craftsmanship.toledo.katangapp.models.ReferenceablePoint;

/**
 * @author mdelapenya
 */
public class StraightDistanceCalculator implements DistanceCalculator {

	@Override
	public double distance(ReferenceablePoint from, ReferenceablePoint to)
		throws UnreferenceablePointException {

		if (to == null) {
			throw new UnreferenceablePointException();
		}

		double fromLatitude = from.getLatitude();
		double fromLongitude = from.getLongitude();

		double toLatitude = to.getLatitude();
		double toLongitude = to.getLongitude();

		double latitudeRadians = Math.toRadians(toLatitude - fromLatitude);

		double longitudeRadians = Math.toRadians(toLongitude - fromLongitude);

		double a = Math.sin(latitudeRadians / 2) *
			Math.sin(latitudeRadians / 2) +
			Math.cos(Math.toRadians(fromLatitude)) *
				Math.cos(Math.toRadians(toLatitude)) *
				Math.sin(longitudeRadians / 2) *
				Math.sin(longitudeRadians / 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

		return (Constants.EARTH_RADIUS_METERS * c);
	}

}