## 2024-05-14 - Fix XXE in ReaderUtils DocumentBuilderFactory
**Vulnerability:** XML External Entity (XXE) vulnerability via insecure `DocumentBuilderFactory` in `org.geoserver.util.ReaderUtils`.
**Learning:** In Java, default XML parser configurations are often insecure. Unconfigured `DocumentBuilderFactory` can process external DTDs and entities, leading to XXE attacks.
**Prevention:** Always configure XML parsers (e.g., `DocumentBuilderFactory`, `SAXParserFactory`) to disable `http://apache.org/xml/features/disallow-doctype-decl`, external general entities, external parameter entities, and `load-external-dtd`. Set `setXIncludeAware(false)` and `setExpandEntityReferences(false)`. Catch configuration exceptions and fail securely.
