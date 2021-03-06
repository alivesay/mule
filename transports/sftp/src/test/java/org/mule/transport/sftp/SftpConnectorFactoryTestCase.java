/*
 * $Id$
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.transport.sftp;

import org.mule.api.endpoint.InboundEndpoint;
import org.mule.tck.junit4.AbstractMuleContextTestCase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SftpConnectorFactoryTestCase extends AbstractMuleContextTestCase
{

    @Test
    public void testCreateFromFactory() throws Exception
    {
        InboundEndpoint endpoint = muleContext.getEndpointFactory().getInboundEndpoint(
            getEndpointURI());
        assertNotNull(endpoint);
        assertNotNull(endpoint.getConnector());
        assertTrue(endpoint.getConnector() instanceof SftpConnector);
        assertEquals(getEndpointURI(), endpoint.getEndpointURI().getAddress());
    }

    public String getEndpointURI()
    {
        return "sftp://ms/data";
    }
}
