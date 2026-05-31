## 2024-05-30 - Fix XXE in DocumentBuilderFactory
**Vulnerability:** DocumentBuilderFactory was used without disabling external entity processing (XXE), which can allow read access to local files.
**Learning:** By default, DocumentBuilderFactory allows external entities. They need to be explicitly disabled with multiple features.
**Prevention:** Always disable external entity processing on DocumentBuilderFactory instances unless strictly required, using a sequence of setFeature calls in try-catch blocks.
