## 2024-05-15 - Prevent XXE Vulnerabilities in ReaderUtils
**Vulnerability:** XML parsers in `ReaderUtils` (`DocumentBuilderFactory` and `SAXParserFactory`) were not explicitly configured to prevent XML External Entity (XXE) processing.
**Learning:** XML parsers default to expanding external entities, which can lead to sensitive file disclosure or SSRF if an attacker provides malicious XML.
**Prevention:** Always explicitly disable `DOCTYPE` declarations and external entities when configuring `DocumentBuilderFactory`, `SAXParserFactory`, and `XMLInputFactory`.
