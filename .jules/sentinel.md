## 2026-05-04 - [CRITICAL] Prevent XXE in Default XML Parsers
**Vulnerability:** Found unconfigured `DocumentBuilderFactory` and `SAXParserFactory` being initialized using `.newInstance()` in `ReaderUtils.java`. The default configurations of these parsers are vulnerable to XML External Entity (XXE) Injection because they permit document type declarations (`DOCTYPE`), external general entities, and external parameter entities. This would allow an attacker to read arbitrary files or cause SSRF attacks when parsing crafted XML input.
**Learning:** In standard Java XML processing, security properties are disabled by default. Initializing parsers without explicit defensive configurations is inherently insecure. Specifically, `DocumentBuilderFactory` and `SAXParserFactory` must manually have external entities and DOCTYPE declarations disabled before creating parsers.
**Prevention:** Always follow OWASP guidelines to manually secure Java XML factories:
1. Set the feature `http://apache.org/xml/features/disallow-doctype-decl` to `true`.
2. Set `http://xml.org/sax/features/external-general-entities` and `http://xml.org/sax/features/external-parameter-entities` to `false`.
3. Set `http://apache.org/xml/features/nonvalidating/load-external-dtd` to `false`.
4. For `DocumentBuilderFactory`, also set `.setXIncludeAware(false)` and `.setExpandEntityReferences(false)`.
5. Fail securely: Ensure configuration exceptions are caught, logged, and thrown securely.
