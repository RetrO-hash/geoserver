## 2026-05-15 - [CRITICAL] Prevent XXE in ReaderUtils XML parsing

**Vulnerability:** `DocumentBuilderFactory` and `SAXParserFactory` in `org.geoserver.util.ReaderUtils` were vulnerable to XML External Entity (XXE) attacks because they did not explicitly disable external entity resolution, loading of external DTDs, and document type declarations.
**Learning:** Even utility classes intended for internal configuration parsing or validation must have robust XXE protections because they may inadvertently process untrusted user-supplied XML or be reused in contexts where inputs are not strictly controlled.
**Prevention:** Always explicitly configure `DocumentBuilderFactory` and `SAXParserFactory` using `.setFeature()` to disable `disallow-doctype-decl`, `external-general-entities`, `external-parameter-entities`, and `load-external-dtd`. Additionally, ensure `XIncludeAware` and `ExpandEntityReferences` are disabled for `DocumentBuilderFactory`.
