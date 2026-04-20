## 2024-05-24 - Fix XXE in ReaderUtils XML parsing
**Vulnerability:** DocumentBuilderFactory and SAXParserFactory instances in `org.geoserver.util.ReaderUtils` and `org.geoserver.catalog.util.ReaderUtils` were not securely configured, making them vulnerable to XML External Entity (XXE) attacks.
**Learning:** XML parsers must be explicitly configured to disable doctype declarations, external general entities, and external parameter entities to prevent XXE. Even if `setValidating(false)` is used, XXE can still occur.
**Prevention:** Always use the secure configuration boilerplate for `DocumentBuilderFactory` and `SAXParserFactory` when instantiating them, setting features like `http://apache.org/xml/features/disallow-doctype-decl` to true.
