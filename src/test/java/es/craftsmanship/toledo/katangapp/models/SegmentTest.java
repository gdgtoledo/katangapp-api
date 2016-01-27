package es.craftsmanship.toledo.katangapp.models;

import es.craftsmanship.toledo.katangapp.business.UnreferenceablePointException;
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