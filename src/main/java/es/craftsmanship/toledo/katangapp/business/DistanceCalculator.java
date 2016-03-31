package es.craftsmanship.toledo.katangapp.business;

import es.craftsmanship.toledo.katangapp.models.ReferenceablePoint;

/**
 * @author mdelapenya
 */
public interface DistanceCalculator {

	double distance(ReferenceablePoint from, ReferenceablePoint to)
		throws UnreferenceablePointException;

}