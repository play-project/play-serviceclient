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
package org.ow2.play.service.client;

import org.ow2.play.governance.api.TopicAware;
import org.ow2.play.service.registry.api.Constants;
import org.ow2.play.service.registry.api.Registry;
import org.ow2.play.service.registry.api.RegistryException;
import org.petalslink.dsb.cxf.CXFHelper;

/**
 * Getting CXF-generated client classes for the PLAY platform access...
 * 
 * @author chamerling
 * 
 */
public class PlayClient {

	protected String registryEndpoint;

	public PlayClient(String registryEndpoint) {
		this.registryEndpoint = registryEndpoint;
	}

	protected Registry getRegistryClient() {
		return CXFHelper
				.getClientFromFinalURL(registryEndpoint, Registry.class);
	}

	protected <T> T getWSClient(String key, Class<T> clazz)
			throws ClientException {
		try {
			return CXFHelper.getClientFromFinalURL(
					getRegistryClient().get(key), clazz);
		} catch (RegistryException e) {
			throw new ClientException(e);
		}
	}

	/**
	 * Where to manage DSB business topics...
	 * 
	 * @return
	 * @throws ClientException
	 */
	public TopicAware getDSBTopicAware() throws ClientException {
		return getWSClient(Constants.DSB_BUSINESS_TOPIC_MANAGEMENT,
				TopicAware.class);
	}

}
