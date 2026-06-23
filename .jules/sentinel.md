## 2024-05-23 - XXE Vulnerability in Metadata RemoteDocumentReaderImpl
**Vulnerability:** DocumentBuilderFactory in RemoteDocumentReaderImpl is instantiated without disabling DOCTYPE declarations, external entities, and external DTDs, exposing it to XXE.
**Learning:** When parsing external metadata XML files, explicitly configuring factory features is necessary to prevent XML External Entity injection.
**Prevention:** Always apply secure configurations using `setFeature` wrapped in `try-catch` blocks that throw an Exception upon failure for `DocumentBuilderFactory` instances parsing untrusted XML.
