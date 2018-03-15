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

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * @author mdelapenya
 */
public class RouteResultTest {

	@Test
	public void testCompareShouldBeEquals() {
		RouteResult one = new RouteResult("", 1000);
		RouteResult two = new RouteResult("", 1000);

		assertThat(one.compareTo(two)).isEqualTo(0);
	}

	@Test
	public void testCompareShouldBeEqualsButOrderedByRouteId_1() {
		RouteResult one = new RouteResult("L01", 1000);
		RouteResult two = new RouteResult("L02", 1000);

		List<RouteResult> list = new ArrayList<>();

		list.add(one);
		list.add(two);

		Collections.sort(list);

		assertThat(list.get(0)).isEqualTo(one);
		assertThat(list.get(1)).isEqualTo(two);
	}

	@Test
	public void testCompareShouldBeEqualsButOrderedByRouteId_2() {
		RouteResult one = new RouteResult("L01", 1000);
		RouteResult two = new RouteResult("L02", 1000);

		List<RouteResult> list = new ArrayList<>();

		list.add(two);
		list.add(one);

		Collections.sort(list);

		assertThat(list.get(0)).isEqualTo(one);
		assertThat(list.get(1)).isEqualTo(two);
	}

	@Test
	public void testCompareShouldBeEqualsButOrderedByRouteId_3() {
		RouteResult one = new RouteResult("L01", 1000);
		RouteResult two = new RouteResult("L02", 1000);
		RouteResult three = new RouteResult("L03", 1000);

		List<RouteResult> list = new ArrayList<>();

		list.add(three);
		list.add(two);
		list.add(one);

		Collections.sort(list);

		assertThat(list.get(0)).isEqualTo(one);
		assertThat(list.get(1)).isEqualTo(two);
		assertThat(list.get(2)).isEqualTo(three);
	}

	@Test
	public void testCompareShouldBeGreaterThan() {
		RouteResult one = new RouteResult("", 2000);
		RouteResult two = new RouteResult("", 1000);

		assertThat(one.compareTo(two)).isEqualTo(1);

		List<RouteResult> list = new ArrayList<>();

		list.add(one);
		list.add(two);

		Collections.sort(list);

		assertThat(list.get(0)).isEqualTo(two);
		assertThat(list.get(1)).isEqualTo(one);
	}

	@Test
	public void testCompareShouldBeLessThan() {
		RouteResult one = new RouteResult("", 1000);
		RouteResult two = new RouteResult("", 2000);

		assertThat(one.compareTo(two)).isEqualTo(-1);

		List<RouteResult> list = new ArrayList<>();

		list.add(one);
		list.add(two);

		Collections.sort(list);

		assertThat(list.get(0)).isEqualTo(one);
		assertThat(list.get(1)).isEqualTo(two);
	}

}
