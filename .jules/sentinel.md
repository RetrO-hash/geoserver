## 2024-05-14 - Fix XXE in DocumentBuilderFactory
**Vulnerability:** DocumentBuilderFactory used to parse XML from an external URL without XXE protections enabled.
**Learning:** When configuring DocumentBuilderFactory, failing to disable DTDs, external entities, and parameter entities allows for Server-Side Request Forgery and file disclosure. Different parsers may not support all features.
**Prevention:** Explicitly configure DocumentBuilderFactory to disable document type declarations, external general/parameter entities, and load-external-dtd. Each `setFeature` must be in a separate try/catch block so one failure does not skip the rest. XIncludeAware and ExpandEntityReferences should also be disabled.
