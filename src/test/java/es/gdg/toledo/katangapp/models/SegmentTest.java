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

import es.gdg.toledo.katangapp.business.UnreferenceablePointException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author mdelapenya
 */
public class SegmentTest {

	@Rule
	public ExpectedException thrownException = ExpectedException.none();

	@Test
	public void testConstructorWithNullFromThrowsException() throws Exception {
		thrownException.expect(UnreferenceablePointException.class);

		new Segment(null, null);
	}

	@Test
	public void testConstructorWithNullToThrowsException() throws Exception {
		thrownException.expect(UnreferenceablePointException.class);

		ReferenceablePoint from = TestPointFactory.getPuertaBisagra();

		new Segment(from, null);
	}

	@Test
	public void testCompareEqualsToMinusOne() throws Exception {
		ReferenceablePoint from = new Point(0, 0);
		ReferenceablePoint one = TestPointFactory.getHospitalVirgenDeLaSalud();
		ReferenceablePoint two = TestPointFactory.getPuertaBisagra();

		Segment segment1 = new Segment(from, one);
		Segment segment2 = new Segment(from, two);

		int compareTo = segment2.compareTo(segment1);

		assertThat(compareTo).isEqualTo(-1);
	}

	@Test
	public void testCompareEqualsToOne() throws Exception {
		ReferenceablePoint from = new Point(0, 0);
		ReferenceablePoint one = TestPointFactory.getHospitalVirgenDeLaSalud();
		ReferenceablePoint two = TestPointFactory.getPuertaBisagra();

		Segment segment1 = new Segment(from, one);
		Segment segment2 = new Segment(from, two);

		int compareTo = segment1.compareTo(segment2);

		assertThat(compareTo).isEqualTo(1);
	}

	@Test
	public void testCompareEqualsToZero() throws Exception {
		ReferenceablePoint from = TestPointFactory.getPuertaBisagra();
		ReferenceablePoint to = TestPointFactory.getPuertaBisagra();

		Segment segment = new Segment(from, to);

		int compareTo = segment.compareTo(segment);

		assertThat(compareTo).isEqualTo(0);
	}

}
