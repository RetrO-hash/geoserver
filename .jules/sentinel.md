## 2024-05-24 - XML External Entity (XXE) Injection Prevention in ReaderUtils

**Vulnerability:** XML External Entity (XXE) injection was possible because `DocumentBuilderFactory` and `SAXParserFactory` instances were not configured to disable DOCTYPE declarations or external entities, which could allow arbitrary file reading or SSRF.
**Learning:** Default Java XML parsers are vulnerable to XXE. All instances need explicit features set to disable DOCTYPEs, external general entities, external parameter entities, and external DTD loading.
**Prevention:** Always configure `DocumentBuilderFactory` and `SAXParserFactory` with anti-XXE features (`http://apache.org/xml/features/disallow-doctype-decl`, etc.) when creating new instances, and fail securely if the features are not supported.
