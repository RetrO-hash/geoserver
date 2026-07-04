## 2026-07-04 - XML External Entity (XXE) Vulnerability in ReaderUtils
**Vulnerability:** `DocumentBuilderFactory.newInstance()` is used across the codebase without explicitly disabling external entity processing (XXE), which can allow XML parsing to access external files or cause a DoS attack.
**Learning:** XML parsers must be explicitly configured to prevent XXE when parsing untrusted input. The properties to set include disabling DOCTYPE declarations (`http://apache.org/xml/features/disallow-doctype-decl`) and external entities.
**Prevention:** Always configure `DocumentBuilderFactory` and `SAXParserFactory` to disable external entity resolution and DOCTYPE declarations, using the recommended features like `http://apache.org/xml/features/disallow-doctype-decl`.
