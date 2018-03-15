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

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author mdelapenya
 */
public class Links implements Serializable {

	public String getSelf() {
		return self;
	}

	public String getPrev() {
		return prev;
	}

	public String getNext() {
		return next;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public void setPrev(String prev) {
		this.prev = prev;
	}

	public void setNext(String next) {
		this.next = next;
	}

	private String self;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String prev;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String next;

}
