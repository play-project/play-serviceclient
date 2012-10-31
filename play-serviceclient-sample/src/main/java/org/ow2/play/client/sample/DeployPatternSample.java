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

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.io.FileUtils;
import org.ow2.play.governance.api.GovernanceExeption;
import org.ow2.play.governance.api.SimplePatternService;
import org.ow2.play.service.client.ClientException;
import org.ow2.play.service.client.PlayClient;

/**
 * @author chamerling
 * 
 */
public class DeployPatternSample {

	/**
	 * @param args
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws ClientException
	 * @throws GovernanceExeption
	 */
	public static void main(String[] args) throws IOException,
			URISyntaxException, ClientException, GovernanceExeption {
		String registryEndpoint = "http://46.105.181.221:8080/registry/RegistryService";
		PlayClient client = new PlayClient(registryEndpoint);

		String patternId = "MyPattern_" + System.currentTimeMillis();
		String pattern = FileUtils.readFileToString(new File(
				DeployPatternSample.class.getResource("/fb.txt").toURI()));

		SimplePatternService patternClient = client.getPatternService();

		System.out.println("Input topics from pattern : "
				+ patternClient.getInputTopics(pattern));

		System.out.println("Output topics from pattern : "
				+ patternClient.getOutputTopics(pattern));

		String result = client.getPatternService().deploy(patternId, pattern);
		System.out.println("Pattern deployment returned : " + result);
	}

}
