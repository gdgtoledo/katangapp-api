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

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author mdelapenya
 */
public abstract class BaseLinkableModel implements LinkableModel {

	/**
	 * Public empty constructor for automatic Jackson parsing
	 */
	public BaseLinkableModel() {
		links = new Links();
	}

	@Override
	public Links getLinks() {
		return links;
	}

	@Override
	public void setNext(String next) {
		links.setNext(next);
	}

	@Override
	public void setPrev(String prev) {
		links.setPrev(prev);
	}

	@Override
	public void setSelf(String self) {
		links.setSelf(self);
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Links links;

}
