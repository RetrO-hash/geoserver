/* (c) 2018 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.metadata.data.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.geoserver.metadata.data.service.RemoteDocumentReader;
import org.geotools.util.logging.Logging;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;

@Repository
public class RemoteDocumentReaderImpl implements RemoteDocumentReader {
    static final Logger LOGGER = Logging.getLogger(RemoteDocumentReaderImpl.class);

    @Override
    public Document readDocument(URL url) throws IOException {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
            dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            dbf.setXIncludeAware(false);
            dbf.setExpandEntityReferences(false);
            try (InputStream stream = url.openStream()) {
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(stream);
                doc.getDocumentElement().normalize();
                return doc;
            }
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Failed to securely parse XML", e);
            throw new IOException("Failed to securely parse XML", e);
        }
    }
}
