## 2024-05-24 - XML External Entity (XXE) Prevention
**Vulnerability:** The `DocumentBuilderFactory` and `SAXParserFactory` in `ReaderUtils` were instantiated without explicitly disabling document type declarations and external entities, leading to potential XML External Entity (XXE) vulnerabilities.
**Learning:** XML parsers must be explicitly configured to reject DTDs and external entities to prevent XXE.
**Prevention:** Always set `http://apache.org/xml/features/disallow-doctype-decl` to true, and disable external general/parameter entities and `load-external-dtd` when instantiating XML parsers. For `DocumentBuilderFactory`, also set `setXIncludeAware(false)` and `setExpandEntityReferences(false)`. Catch configuration exceptions and explicitly throw runtime exceptions to fail securely.
