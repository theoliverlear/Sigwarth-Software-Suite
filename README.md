# Sigwarth Software Suite ✨
## Focused libraries, better solutions. ⚡

---

Sigwarth Software Suite is a collection of Java modules that solve common
problems so you can ship faster. Each module is self‑contained and published 
under the MIT License.

This repository is a Maven multi‑module project. You can use modules 
individually or together.

## ⭐️ What’s inside
- Java-Suite (parent for Java libraries) 📦
  - Builder-Suite — tiny factory/builder helper interfaces to standardize object construction.
  - Net-Suite — simple HTTP/HTTPS utilities for fetching data with minimal setup.
  - OpenAi-Suite — minimal wrappers for calling the OpenAI API using Java 11+ HttpClient.
  - Spring-Boot-Suite 🌱
    - Spring-Boot-Communication — small DTOs and helpers for API responses.
    - Spring-Boot-Config — common Spring beans (e.g., ObjectMapper), basic security config.
    - Spring-Boot-WebSocket — base WebSocket handler that parses requests and serializes responses.
  - String-Suite — tiny string utilities (e.g., title case formatting). ✂️

## 🧭 Typical use cases
- Quickly add a generic WebSocket handler and focus only on your Request-to-Response logic.
- Fetch data from an HTTPS endpoint without pulling in a large HTTP client stack.
- Call OpenAI’s Chat Completions with a minimal, readable wrapper.
- Share common Spring Boot configuration across services.
- Perform simple string transformations in utilities or services.

## ✅ Why it’s handy
- Small and focused: minimal code, easy to read, easy to extend.
- Modular: depend on only what you need.
- Modern Java: builds against Java 23 (compatible with current JDKs in CI).
- MIT licensed: permissive and business‑friendly.

## 🚀 Quick start

1) Clone and build all modules locally 🛠️
- Prereqs: JDK 23+ and Maven 3.9+ 📚
- Windows PowerShell:

```
# From the repository root
mvn -T 1C -DskipTests install
```

2) Add a module to your project (example: String-Suite) ➕

- pom.xml
```
<dependency>
  <groupId>com.sigwarthsoftware</groupId>
  <artifactId>string-suite</artifactId>
  <version>0.0.6</version>
</dependency>
```

If you prefer consuming from GitHub Packages instead of a local install, add the GitHub Packages repository to your pom.xml or settings.xml and use the same coordinates. See the parent pom for the distributionManagement configuration. 📦

## 🧩 Usage examples

- String-Suite (TitleFormatter) 🔡
```java
import com.sigwarthsoftware.string.TitleFormatter;

String once = TitleFormatter.formatTitleCase("hello world");       // "Hello world"
String words = TitleFormatter.formatTitleCases("hello big world"); // "Hello Big World"
```

- Net-Suite (ApiDataRetriever) 🌐
```java
import com.sigwarthsoftware.net.ApiDataRetriever;

ApiDataRetriever retriever = new ApiDataRetriever("https://api.github.com");
String json = retriever.getResponse();
```

- Spring-Boot-WebSocket (base handler) 🔌
```java
import com.sigwarthsoftware.springboot.websocket.WebSocketHandler;

class EchoRequest { public String message; }
class EchoResponse { public String message; }

public class EchoHandler extends WebSocketHandler<EchoRequest, EchoResponse> {
  @Override
  public EchoResponse makeResponse(EchoRequest request) {
    EchoResponse res = new EchoResponse();
    res.message = "Echo: " + request.message;
    return res;
  }
}
```

- OpenAi-Suite (simple chat request) 🤖
```java
import com.sigwarthsoftware.openai.message.ApiCall;
import com.sigwarthsoftware.openai.message.ApiSettings;
import com.sigwarthsoftware.openai.model.AiModel;

ApiCall call = new ApiCall(AiModel.GPT_4, ApiSettings.DEFAULT, "Say hello");
call.fetchResponse();
String aiResponse = call.getResponse();
```
Note: Set environment variable OPENAI_KEY before running. 🔐

## 🛣️ Roadmap / Future ecosystems
Beyond Java, the suite aims to provide helpers and publishing for multiple ecosystems:
- NPM (Node.js) 📦 — utilities and tooling published to the npm registry.
- PyPI (Pip) 🐍 — Python helpers available via pip install.
- NuGet (.NET) 💠 — .NET packages for common tasks.

This README will evolve as cross-language modules land. Contributions are welcome! 🙌

## 🛠️ Technology
- Language: Java 23 ☕
- Build: Maven (multi‑module reactor)
- Libraries: Spring Boot (select modules), SLF4J, Lombok, Java HttpClient

## ❓ Questions or help
Email Oliver Lear Sigwarth (@theoliverlear): sigwarthsoftware@gmail.com 📬

## 📄 License
MIT — see the license section in the project pom.xml for details.
