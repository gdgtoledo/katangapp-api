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

/**
 * @author mdelapenya
 */
public interface ReferenceablePoint {

	double distanceTo(ReferenceablePoint point)
		throws UnreferenceablePointException;

	double distanceTo(
			ReferenceablePoint point, DistanceCalculator distanceCalculator)
		throws UnreferenceablePointException;

	double getLatitude();

	double getLongitude();

}
