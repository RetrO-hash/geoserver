## 2024-05-24 - Fix XXE in DocumentBuilderFactory configuration
**Vulnerability:** XML External Entity (XXE) vulnerability in `RemoteDocumentReaderImpl.java` due to insecure `DocumentBuilderFactory` defaults.
**Learning:** `DocumentBuilderFactory` needs multiple specific features disabled (like external entities and doctype declarations) wrapped in individual try-catch blocks to ensure robust security without failing abruptly on unsupported features.
**Prevention:** Always explicitly configure `DocumentBuilderFactory` and `SAXParserFactory` using defense-in-depth features in isolated try-catch blocks to prevent XXE, throwing an exception on failure.
