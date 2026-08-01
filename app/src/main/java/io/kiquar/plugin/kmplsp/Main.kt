package io.kiquar.plugin.kmplsp

import androidx.annotation.Keep
import com.rk.extension.ExtensionAPI
import com.rk.extension.ExtensionContext
import com.rk.utils.toast
import com.rk.lsp.LspRegistry
import com.rk.utils.getTempDir
import com.rk.file.child
import kotlinx.coroutines.runBlocking
import kotlin.io.writeText

@Keep
@Suppress("unused")
class Main(context: ExtensionContext) : ExtensionAPI(context) {
	
	private var kmpServer: KmpServer? = null
	
	override fun onInstalled() {
		loadServer()
		kmpServer?.install()
    }
	
    override fun onLoad() {
		loadServer()
    }

    override fun onDispose() {
		dispose()
    }
	
	override fun onUpdated() {
        dispose()
    }
	
	// Local functions 
	
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
        }
    }
	
	private fun loadServer() {
		kmpServer = KmpServer(
            installScript = acquireLspInstallScript(),
			context = context
        ).also {
            LspRegistry.registerServer(it)
        }
	}
}