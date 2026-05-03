## 2024-06-19 - Prevent XXE in Utility XML Parsers
**Vulnerability:** XML External Entity (XXE) Injection due to improperly configured DocumentBuilderFactory and SAXParserFactory.
**Learning:** Shared utility functions handling XML (like ReaderUtils) are high-risk targets for XXE if not explicitly configured to block external entities and DTDs.
**Prevention:** Explicitly configure XML parser factories (DocumentBuilderFactory, SAXParserFactory) to disable DTDs, external general entities, and external parameter entities. Log exceptions when configuring features and fail securely (e.g., throwing a RuntimeException).
