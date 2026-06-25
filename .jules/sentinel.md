## 2024-05-18 - Fix XXE vulnerabilities in XML Parsers
**Vulnerability:** XML parsers (`DocumentBuilderFactory` and `SAXParserFactory`) were used without disabling external entities, creating XXE (XML External Entity) vulnerabilities.
**Learning:** By default, Java's XML parsers are vulnerable to XXE. Any code parsing XML from untrusted sources must explicitly disable external entities and DOCTYPE declarations.
**Prevention:** Always configure `DocumentBuilderFactory` and `SAXParserFactory` with features like `http://apache.org/xml/features/disallow-doctype-decl` (true), `http://xml.org/sax/features/external-general-entities` (false), `http://xml.org/sax/features/external-parameter-entities` (false), and `http://apache.org/xml/features/nonvalidating/load-external-dtd` (false).
