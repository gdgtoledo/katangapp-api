package es.craftsmanship.toledo.katangapp.models;

import es.craftsmanship.toledo.katangapp.business.UnreferenceablePointException;

/**
 * @author mdelapenya
 */
public interface ReferenceablePoint {

	double distanceTo(ReferenceablePoint point)
		throws UnreferenceablePointException;

	double getLatitude();

	double getLongitude();

}
