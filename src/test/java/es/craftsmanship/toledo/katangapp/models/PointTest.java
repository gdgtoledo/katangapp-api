package es.craftsmanship.toledo.katangapp.models;

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

}
