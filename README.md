# kmp-lsp Extension

Adds Kotlin, Java and Swift LSP support using [kmp-lsp](https://github.com/Hessesian/kmp-lsp) — fast, low-memory LSP server written in Rust (~10MB).

## Installation

Install via Xed-Editor's extension marketplace or from a ZIP file (Settings > Extensions > Install from storage).

Verify:
```bash
kmp-lsp --help
```

## Usage

Basic LSP works immediately

```bash
# Index the project
kmp-lsp index --root . --verbose

# Extract library sources (Gradle projects)
kmp-lsp extract-sources

# For local JARs (app/libs/*.jar), create workspace.json:
# { "jarPaths": ["<WORKSPACE>/app/libs"] }

# Verify sources
kmp-lsp sources --root . --json
```

## Build

```bash
./compileDebug
# or release
./compileRelease
```