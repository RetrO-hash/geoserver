## 2024-06-19 - [CRITICAL] Prevent XXE in DocumentBuilderFactory
**Vulnerability:** DocumentBuilderFactory instances in multiple places were instantiated without explicit directives to disable external entities.
**Learning:** By default, XML parsers often resolve external entities, introducing risk for XXE injection when parsing untrusted XML. This requires multiple setFeature calls to disable.
**Prevention:** Ensure we always disable `http://apache.org/xml/features/disallow-doctype-decl`, external entities and parameter entities upon DocumentBuilderFactory instantiation.
