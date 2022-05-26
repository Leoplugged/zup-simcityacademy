package br.com.zup.filme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoMensagem = findViewById<Button>(R.id.botao_mensagem)
        /** setOnClickListener: toda vez que o botão é clicado, executa a seguinte lógica entre as chaves:*/
        botaoMensagem.setOnClickListener {
            /** Toast: aparecerá uma mensagem temporária ao ser executado.*/
            Toast.makeText(this, "IMDb: 7,8. \"Esse filme é inspirador!\"", Toast.LENGTH_LONG).show()
        }

        val botaoDetalheFilme = findViewById<Button>(R.id.botao_detalhe_filme)
        botaoDetalheFilme.setOnClickListener {
            /** Criação dessa intenção linka a transição da MainActivity e para o DetalheFilme.*/
            val intent = Intent(this, DetalheFilme::class.java)
            startActivity(intent)
        }
    }
}