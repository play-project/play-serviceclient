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

import org.ow2.play.governance.api.bean.Subscription;
import org.ow2.play.governance.api.bean.Topic;
import org.ow2.play.service.client.PlayClient;

/**
 * Create a DSB topic and an event cloud for complex events ie you will be able
 * to subscribe to the DSB topic to receive events from CEP engine.
 * 
 * @author chamerling
 * 
 */
public class CreateComplexScenario {

	public static void main(String[] args) throws Exception {

		// FIXME : replace by the platform registry endpoint
//		String endpoint = "http://localhost:8080/registry/RegistryService";
		String endpoint = "http://46.105.181.221:8080/registry/RegistryService";


		Topic topic = new Topic();
		topic.setName("MySubTopic");
		topic.setNs("http://play.ow2.org/sample");
		topic.setPrefix("p");

		PlayClient client = new PlayClient(endpoint);
		String subscribeTo = client.getEventGovernance().createSubscriberTopic(
				topic);

		System.out.println("Subscribe to : " + subscribeTo);
		// we can now subscribe to the DSB topic. The WSN subscribe endpoint has
		// been returned by the governance operation call.
		// You can use the standard WSN subscribe API or use the governance one like below:
		
		// Subscriber endpoint ie the service which subscribe to receive notifications
		/*
		String subscriberEndpoint = "http://localhost:8889/sample/Subscriber";
		
		Subscription subscription = new Subscription();
		subscription.setTopic(topic);
		subscription.setProvider(subscribeTo);
		subscription.setSubscriber(subscriberEndpoint);
		Subscription result = client.getSubscriptionService().subscribe(subscription);

		System.out.println("Subscribed : " + result);
		*/
		// you will now receive notification on your endpoint when they are published to the EC by the CEP.
	}

}
