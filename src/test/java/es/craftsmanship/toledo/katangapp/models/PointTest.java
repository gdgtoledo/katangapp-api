package es.craftsmanship.toledo.katangapp.models;

import es.craftsmanship.toledo.katangapp.business.DistanceCalculator;
import es.craftsmanship.toledo.katangapp.business.UnreferenceablePointException;

import java.util.Random;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author mdelapenya
 */
public class PointTest {

	@Test
	public void testDistanceToIsIdempotent() throws Exception {
		Point puertaBisagra = TestPointFactory.getPuertaBisagra();

		Point hospitalVirgenDeLaSalud =
			TestPointFactory.getHospitalVirgenDeLaSalud();

		double distanceTo1 = puertaBisagra.distanceTo(hospitalVirgenDeLaSalud);
		double distanceTo2 = hospitalVirgenDeLaSalud.distanceTo(puertaBisagra);

		assertThat(distanceTo1).isEqualTo(distanceTo2);
	}

	@Test
	public void testDistanceToSelfIsZero() throws Exception {
		Point puertaBisagra = TestPointFactory.getPuertaBisagra();

		double distanceTo = puertaBisagra.distanceTo(puertaBisagra);

		assertThat(distanceTo).isEqualTo(0);
	}

	@Test
	public void testDistanceToSelfIWillMockStrategy() throws Exception {
		Point puertaBisagra = TestPointFactory.getPuertaBisagra();

		final double random = new Random().nextDouble();

		double distanceTo = puertaBisagra.distanceTo(
			puertaBisagra, new DistanceCalculator() {

				@Override
				public double distance(
						ReferenceablePoint from, ReferenceablePoint to)
					throws UnreferenceablePointException {

					return random;
				}
		});

		assertThat(distanceTo).isEqualTo(random);
	}

	@Test
	public void testDistanceToSelfIWithNullStrategy() throws Exception {
		Point puertaBisagra = TestPointFactory.getPuertaBisagra();

		double distanceTo = puertaBisagra.distanceTo(puertaBisagra, null);

		assertThat(distanceTo).isEqualTo(0);
	}

}
