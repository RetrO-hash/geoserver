## 2024-05-17 - XXE in ReaderUtils XML parsing
**Vulnerability:** DocumentBuilderFactory and SAXParserFactory in `org.geoserver.util.ReaderUtils` are instantiated without disabling external entities or DTDs, which can lead to XXE (XML External Entity) attacks.
**Learning:** Default XML parsers in Java are generally vulnerable to XXE. They must be explicitly configured to disable external entities.
**Prevention:** Always set XML parser features to disable DOCTYPE declarations (`http://apache.org/xml/features/disallow-doctype-decl`) and external general/parameter entities (`http://xml.org/sax/features/external-general-entities` and `http://xml.org/sax/features/external-parameter-entities`), and throw exceptions securely if configuration fails.
