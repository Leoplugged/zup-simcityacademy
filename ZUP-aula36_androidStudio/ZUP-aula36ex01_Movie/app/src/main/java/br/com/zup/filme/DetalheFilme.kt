package br.com.zup.filme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class DetalheFilme : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_filme)
        /** Back button na toolbar da tela. */
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        /** seta o título da tela na toolbar referenciando um valor no strings.xml. */
        supportActionBar?.setTitle(R.string.titulo_detalhe_filme)
    }

    /** onOptionsItemSelected: habilita a volta a tela quando acionado. */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}