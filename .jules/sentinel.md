## 2024-05-24 - Enable disallow-doctype-decl for XML parsing to prevent XXE

**Vulnerability:** GeoServer creates `DocumentBuilderFactory` and `SAXParserFactory` instances in multiple places without configuring security features to disable Document Type Definitions (DTDs) and external entities, making it vulnerable to XML External Entity (XXE) injection attacks when parsing untrusted XML input.

**Learning:** Although GeoServer relies heavily on XML for configuration and data exchanges (WFS, WMS, WCS, etc.), it's critical to ensure all generic XML parsers (`DocumentBuilderFactory`, `SAXParserFactory`) are explicitly configured with anti-XXE features. The most effective mitigation is `http://apache.org/xml/features/disallow-doctype-decl`, and falling back to disabling external entities (`http://xml.org/sax/features/external-general-entities`, `http://xml.org/sax/features/external-parameter-entities`, `http://apache.org/xml/features/nonvalidating/load-external-dtd`) and expanding entities (`setExpandEntityReferences(false)`) if DTDs cannot be completely disabled. The `setFeature` calls must be wrapped in individual try-catch blocks to prevent unsupported feature exceptions from aborting the configuration.

**Prevention:** Always configure XML parsers with security features to prevent XXE. Use a centralized utility method to create and configure parsers securely if possible.
