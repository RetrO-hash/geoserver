## 2024-04-18 - [Secure XML Parsing (XXE Prevention)]
**Vulnerability:** ReaderUtils.java instantiates DocumentBuilderFactory and SAXParserFactory without disabling external entities and doctype declarations, which makes the parsing vulnerable to XML External Entity (XXE) attacks.
**Learning:** Default XML parsers are often insecure against XXE. It's necessary to explicitly configure these factories to prevent entity expansion and external DTD loading.
**Prevention:** Always explicitly set features on XML parser factories to disable 'http://apache.org/xml/features/disallow-doctype-decl', external general entities, external parameter entities, and 'load-external-dtd'. Catch configuration exceptions, log them, and fail securely by throwing RuntimeException.
