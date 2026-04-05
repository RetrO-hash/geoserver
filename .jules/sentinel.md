## 2024-05-24 - Secure DocumentBuilderFactory to Prevent XXE

**Vulnerability:** `DocumentBuilderFactory` in `org.geoserver.util.ReaderUtils` was not securely configured, allowing XML External Entity (XXE) processing. If an attacker provided a crafted XML document with an external entity declaration, the parser could process it, potentially leading to server-side request forgery (SSRF), information disclosure, or denial of service.

**Learning:** When configuring `DocumentBuilderFactory` for XML parsing in this codebase, explicitly setting features to disable document type declarations ('http://apache.org/xml/features/disallow-doctype-decl') and external general entities is critical. Not all parsers are secure by default.

**Prevention:** Always explicitly disable document type declarations and external general entities when creating a new `DocumentBuilderFactory` via `DocumentBuilderFactory.newInstance()`. Catch configuration exceptions, log them using `java.util.logging.Logger`, and explicitly throw a `RuntimeException` to fail securely rather than failing open.