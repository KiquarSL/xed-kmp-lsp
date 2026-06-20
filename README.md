# kmp-lsp Extension

This extension adds Kotlin and Java LSP

[kmp-lsp](https://github.com/Hessesian/kmp-lsp.git) - Fast, low-memory LSP server for Kotlin and Java, written in Rust.

Total memory usage: ~10MB

### Installation

Install the extension through the Xed-Editor's extension marketplace, and you're ready to go! Alternatively, you can download the latest release ZIP file and install it via Settings > Extensions > Install from storage.

After install extension install kotlin and lsp in Settings > Editor > Language servers > Kotlin > Install

Check installed:
```bash
kmp-lsp --help
```

## Build

Debug build:
```bash
./gradlew assembleDebug
./gradlew :app:createFinalZip
```

Release build:
```bash
./gradlew assembleRelease
./gradlew :app:createFinalZip
```

Or use files `./compileDebug` or `./compileRelease`