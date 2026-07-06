## 2026-07-06 - Fix XXE vulnerabilities in ReaderUtils
**Vulnerability:** DocumentBuilderFactory and SAXParserFactory in `org.geoserver.util.ReaderUtils` were vulnerable to XML External Entity (XXE) injections.
**Learning:** XML parsers in Java are often vulnerable to XXE by default. Explicitly setting features such as `disallow-doctype-decl` and disabling external entities is required to prevent XXE.
**Prevention:** Always configure `DocumentBuilderFactory` and `SAXParserFactory` securely by explicitly disabling DOCTYPE declarations and external entity resolution before parsing untrusted XML inputs.
