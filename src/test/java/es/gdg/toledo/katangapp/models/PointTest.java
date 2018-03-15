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

package es.gdg.toledo.katangapp.models;

import static org.fest.assertions.Assertions.assertThat;

import es.gdg.toledo.katangapp.business.DistanceCalculator;
import es.gdg.toledo.katangapp.business.UnreferenceablePointException;

import java.util.Random;

import org.junit.Test;

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
