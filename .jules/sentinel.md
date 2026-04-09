## 2024-05-24 - [GeoServer ReaderUtils XXE]
**Vulnerability:** ReaderUtils.java configured a DocumentBuilderFactory for XML parsing without explicitly disabling features like DOCTYPE declarations or external entities, leaving the application open to XXE vulnerabilities.
**Learning:** DocumentBuilderFactory requires explicit secure feature configurations. Setting 'setExpandEntityReferences(false)' is not enough; DOCTYPE, external general and parameter entities, and load-external-dtd must all be explicitly disallowed.
**Prevention:** Always configure DocumentBuilderFactory with standard XXE prevention features when processing untrusted XML. Catch ParserConfigurationException and fail securely.
