## 2024-05-24 - Secure XML Parsers Against XXE
**Vulnerability:** XML eXternal Entity (XXE) vulnerabilities found in `DocumentBuilderFactory` and `SAXParserFactory` instantiations across the codebase (e.g., `ReaderUtils.java`, `GetMapXmlReader.java`).
**Learning:** Default factory configurations allow parsing external entities and DTDs, which can lead to information disclosure or server-side request forgery.
**Prevention:** Explicitly disable DTDs, external general entities, and parameter entities using secure `setFeature` configurations wrapped in individual try-catch blocks to ensure robust security regardless of parser capabilities.
