## 2026-05-07 - Prevent XXE Vulnerability in XML Parsers
**Vulnerability:** DocumentBuilderFactory was configured insecurely, allowing XML External Entity (XXE) injection attacks which can lead to file disclosure, SSRF, and DoS.
**Learning:** By default, XML parsers often evaluate DOCTYPE declarations, DTDs, and external entities. The default `DocumentBuilderFactory.newInstance()` is vulnerable out-of-the-box unless specific security features are explicitly enabled.
**Prevention:** Always configure XML parsers securely by disabling DTDs, external general/parameter entities, expanding entity references, and XInclude. Use a centralized helper method to standardize secure configurations and catch ParserConfigurationException.
