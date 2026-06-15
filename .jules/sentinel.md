## 2024-05-24 - XXE Vulnerability in DocumentBuilderFactory
**Vulnerability:** RemoteDocumentReaderImpl parses XML from a URL without disabling external entities or DTD processing, allowing XXE attacks.
**Learning:** XML parsers must have their security features individually configured and wrapped in try-catch blocks to prevent missing features from bypassing other security configurations.
**Prevention:** Always disable `disallow-doctype-decl`, `external-general-entities`, `external-parameter-entities`, and `load-external-dtd` when instantiating an XML parser.
