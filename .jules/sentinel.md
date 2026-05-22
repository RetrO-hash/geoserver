## 2026-05-22 - Missing XXE protection in ReaderUtils
**Vulnerability:** `DocumentBuilderFactory` and `SAXParserFactory` are used to parse XML without disabling Document Type Declarations (DTDs) and external entities, leading to potential XML External Entity (XXE) vulnerabilities.
**Learning:** XML parsers in Java default to resolving external entities. We must explicitly disable them, along with XInclude and entity expansion. Catching generic `Exception e` instead of `SAXException` matches existing codebase error handling.
**Prevention:** Always configure `DocumentBuilderFactory` and `SAXParserFactory` with `setFeature("http://apache.org/xml/features/disallow-doctype-decl", true)` and disable external entity resolution to prevent XXE.
