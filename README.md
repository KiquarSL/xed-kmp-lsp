# kmp-lsp Extension

This extension install go and gopls

## Installation

Install via Xed-Editor's extension marketplace or from a ZIP file (Settings > Extensions > Install from storage).

After installation, go to **Settings > Editor > Language servers > Kotlin > Install** to set up the LSP.

Verify:
```bash
gopls --help
```

Build

```bash
./gradlew assembleDebug && ./gradlew :app:createFinalZip
# or release
./gradlew assembleRelease && ./gradlew :app:createFinalZip
```