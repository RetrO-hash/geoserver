## 2026-05-11 - Disable XXE in ReaderUtils XML Parsers
**Vulnerability:** DocumentBuilderFactory and SAXParserFactory instances in `org.geoserver.util.ReaderUtils` were susceptible to XML External Entity (XXE) injection attacks because they did not explicitly disable processing of document type declarations, external general entities, and external parameter entities.
**Learning:** XML parsers must be securely configured by default to prevent XXE. Simply setting `setNamespaceAware` and `setValidating` to false does not prevent XXE.
**Prevention:** Always explicitly disable DTDs (`http://apache.org/xml/features/disallow-doctype-decl`) and external entities when configuring XML parsers. Use standard configuration patterns for `DocumentBuilderFactory` and `SAXParserFactory`.
