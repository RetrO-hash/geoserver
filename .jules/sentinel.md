## 2026-04-01 - 🛡️ Sentinel: [CRITICAL] Prevent XXE in XML parsers
**Vulnerability:** DocumentBuilderFactory was used across the codebase without disabling DOCTYPE declarations, opening the application to XML External Entity (XXE) vulnerabilities.
**Learning:** Found two commonly used XML parsers in `ReaderUtils` that had this vulnerability.
**Prevention:** Explicitly configured `setFeature` on `DocumentBuilderFactory` for `disallow-doctype-decl` and `external-general-entities` to false. Throw a `RuntimeException` to securely fail when security features cannot be enabled.
