## 2024-06-25 - Prevent XML External Entity (XXE) Vulnerabilities in ReaderUtils

**Vulnerability:** Found multiple instances of `DocumentBuilderFactory` and `SAXParserFactory` instantiations missing configurations that prevent XML External Entity (XXE) attacks. The instances are explicitly found in `src/platform/src/main/java/org/geoserver/util/ReaderUtils.java` and `src/main/src/main/java/org/geoserver/catalog/util/ReaderUtils.java`.

**Learning:** It's common in legacy Java applications for XML parsers to not have the proper security features set by default, making them vulnerable to XXE. Both `DocumentBuilderFactory` and `SAXParserFactory` must be explicitly configured to disallow external entities and DTDs. Setting these features can prevent sensitive local files from being read or Denial of Service (DoS) attacks via billion laughs.

**Prevention:** Always configure XML parsers (e.g., `DocumentBuilderFactory`, `SAXParserFactory`, `XMLInputFactory`) to disable DTDs, external general entities, and external parameter entities when processing untrusted input. Use `setFeature("http://apache.org/xml/features/disallow-doctype-decl", true)` and similar features. Wrap configurations in `try-catch` blocks logging any `Exception` using `java.util.logging.Logger` to handle environments where the features might not be supported but log the error appropriately.
