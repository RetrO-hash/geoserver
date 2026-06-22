/* (c) 2018 Open Source Geospatial Foundation - all rights reserved
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.metadata.data.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.geoserver.metadata.data.service.RemoteDocumentReader;
import org.geotools.util.logging.Logging;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

@Repository
public class RemoteDocumentReaderImpl implements RemoteDocumentReader {
    static final Logger LOGGER = Logging.getLogger(RemoteDocumentReaderImpl.class);

    @Override
    public Document readDocument(URL url) throws IOException {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            try {
                dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Failed to set disallow-doctype-decl feature", e);
                throw new IOException(e);
            }
            try {
                dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Failed to set external-general-entities feature", e);
                throw new IOException(e);
            }
            try {
                dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Failed to set external-parameter-entities feature", e);
                throw new IOException(e);
            }
            try {
                dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Failed to set load-external-dtd feature", e);
                throw new IOException(e);
            }
            dbf.setXIncludeAware(false);
            dbf.setExpandEntityReferences(false);
            try (InputStream stream = url.openStream()) {
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(stream);
                doc.getDocumentElement().normalize();
                return doc;
            }
        } catch (MalformedURLException | ParserConfigurationException | SAXException | IllegalStateException e) {
            LOGGER.log(Level.WARNING, "", e);
        }
        throw new IOException("Could not read metadata from:" + url);
    }
}
