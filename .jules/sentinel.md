## 2026-04-10 - Disable XML External Entities (XXE)
**Vulnerability:** DocumentBuilderFactory was used without explicitly disabling `disallow-doctype-decl`, `external-general-entities`, `external-parameter-entities`, and `load-external-dtd`, creating a potential vulnerability to XML External Entity (XXE) attacks when parsing untrusted XML data.
**Learning:** By default, XML parsers often resolve external entities, allowing malicious input to potentially read local files, execute server-side requests (SSRF), or launch denial-of-service attacks.
**Prevention:** Always explicitly configure DocumentBuilderFactory to turn off external entities using `setFeature()` for DOCTYPE declarations, general entities, parameter entities, and DTDs. Catch ParserConfigurationException and fail securely.
