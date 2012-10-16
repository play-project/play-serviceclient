/**
 *
 * Copyright (c) 2012, PetalsLink
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA 
 *
 */
package org.ow2.play.client.sample;

import org.ow2.play.governance.api.bean.Topic;
import org.ow2.play.service.client.PlayClient;

/**
 * Creates a new DSB topic and EC instance for a given topic. User will be able
 * to push notification to the platform using the endpoint.
 * 
 * @author chamerling
 * 
 */
public class CreateNotifyScenario {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		// FIXME = replace by the platform registry endpoint
		String endpoint = "http://localhost:8080/registry/RegistryService";

		Topic topic = new Topic();
		topic.setName("MyPubTopic");
		topic.setNs("http://play.ow2.org/sample");
		topic.setPrefix("p");

		PlayClient client = new PlayClient(endpoint);
		String notifyTo = client.getEventGovernance().createPublisherTopic(
				topic);

		System.out.println("You can now send WSN notifications to '" + notifyTo
				+ "' on topic '" + topic + "'");

	}
}
