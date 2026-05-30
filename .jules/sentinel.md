## 2024-05-18 - Prevent XXE in DocumentBuilderFactory
**Vulnerability:** DocumentBuilderFactory instantiated without security features disabled, making it vulnerable to XML External Entity (XXE) attacks.
**Learning:** Each setFeature call must be wrapped in its own try-catch block. Otherwise, if the parser does not support one feature, the remaining security features will be skipped, leaving the parser vulnerable.
**Prevention:** Explicitly disable DOCTYPE declarations, external general entities, external parameter entities, and load-external-dtd, catching exceptions individually for each feature.
