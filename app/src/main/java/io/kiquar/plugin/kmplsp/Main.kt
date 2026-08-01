package io.kiquar.plugin.kmplsp

import androidx.annotation.Keep
import com.rk.extension.ExtensionAPI
import com.rk.extension.ExtensionContext
import com.rk.lsp.LspRegistry
import com.rk.utils.getTempDir
import com.rk.file.child
import java.io.File
import com.rk.activities.main.MainActivity 

@Keep
@Suppress("unused")
class Main(context: ExtensionContext) : ExtensionAPI(context) {
    
    private var kmpServer: KmpServer? = null
    
    override fun onLoad() {
        loadServer()
    }

    override fun onDispose() {
        dispose()
    }
    
    private fun acquireLspInstallScript(): File {
        val assetStream = context.assets.open("install-kmp-lsp.sh")
        val assetContent = assetStream.bufferedReader().use { it.readText() }
        val scriptFile = getTempDir().child("install-kmp-lsp.sh").also {
            it.writeText(assetContent)
            it.setExecutable(true)
        }
        return scriptFile
    }
    
    private fun dispose() {
        kmpServer?.let {
            LspRegistry.unregisterServer(it)
            kmpServer = null
        }
    }
    
    private fun loadServer() {
        dispose()
        kmpServer = KmpServer(
            installScript = acquireLspInstallScript(),
            context = context
        ).also {
            LspRegistry.registerServer(it)
        }
    }
}