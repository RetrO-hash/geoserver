## 2024-05-24 - XXE Vulnerability in XML Parsing
**Vulnerability:** DocumentBuilderFactory and SAXParserFactory instances were created without disabling DOCTYPE declarations or external entities, leading to potential XML External Entity (XXE) vulnerabilities.
**Learning:** Default configurations of XML parsers in Java are inherently insecure and will resolve external entities unless explicitly disabled.
**Prevention:** Always explicitly disable DOCTYPE declarations (`http://apache.org/xml/features/disallow-doctype-decl`), external general entities, external parameter entities, and external DTDs when configuring DocumentBuilderFactory or SAXParserFactory. Also set `setXIncludeAware(false)` and `setExpandEntityReferences(false)` for DocumentBuilderFactory.
