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

package es.craftsmanship.toledo.katangapp.models.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonDeserializer;

import es.craftsmanship.toledo.katangapp.models.BusStop;

import java.io.IOException;

/**
 * This class deserialize a BusStop object in a specific manner, not using the
 * JSON attribute names for default Jackson deserialize process. Instead, it
 * will use the conversion defined in the deserialize(...) method.
 *
 * @author mdelapenya
 */
public class BusStopDeserializer extends JsonDeserializer<BusStop> {

	/**
	 * Deserializes a JSON object representing a BusStop into a BusStop model.
	 * It will expect <code>id, address, lat and long</code> attributes in the
	 * JSON to fill in <code>id, address, latitude and longitude</code> model
	 * fields, respectively. Fields <code>routeId and order</code> will be
	 * populated with a null value.
	 *
	 * @param jsonParser
	 * @param deserializationContext
	 *
	 * @return a BusStop object represented the JSON
	 *
	 * @see BusStop
	 * @throws IOException if the JSON cannot be deserialized
	 */
	@Override
	public BusStop deserialize(
			JsonParser jsonParser,
			DeserializationContext deserializationContext)
		throws IOException {

		JsonNode node = jsonParser.getCodec().readTree(jsonParser);

		String id = node.get("id").asText();
		String address = node.get("address").asText();
		double latitude = node.get("lat").asDouble();
		double longitude = node.get("long").asDouble();

		// route data are not filled in here

		return new BusStop(null, id, null, latitude, longitude, address);
	}

}
