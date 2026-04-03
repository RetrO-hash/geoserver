## 2024-04-03 - Prevent XXE via DocumentBuilderFactory
**Vulnerability:** DocumentBuilderFactory default configuration is vulnerable to XML External Entity (XXE) attacks when parsing user-supplied XML documents.
**Learning:** Default XML parser configurations in Java fail to securely restrict entity expansion and DTD processing.
**Prevention:** Explicitly configure DocumentBuilderFactory with `disallow-doctype-decl` set to true and `external-general-entities` set to false. Catch configuration exceptions and fail securely by throwing a RuntimeException rather than failing open.
