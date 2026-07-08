## 2024-11-20 - Fix XML External Entity (XXE) Vulnerability in ReaderUtils
**Vulnerability:** DocumentBuilderFactory and SAXParserFactory instances in ReaderUtils were vulnerable to XXE as they did not disable DOCTYPE declarations or external entities.
**Learning:** XML parsers must be explicitly configured to prevent XXE by disallowing DOCTYPE and external entities, even if validation and namespace awareness are disabled.
**Prevention:** Always set features like `disallow-doctype-decl`, `external-general-entities`, `external-parameter-entities`, and `load-external-dtd` to true/false respectively on DocumentBuilderFactory and SAXParserFactory.
