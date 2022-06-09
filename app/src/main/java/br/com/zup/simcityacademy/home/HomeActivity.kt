package br.com.zup.simcityacademy.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
//import android.widget.Toast
//import android.widget.EditText
import br.com.zup.simcityacademy.*
import br.com.zup.simcityacademy.databinding.ActivityHomeBinding
import br.com.zup.simcityacademy.informacao.InformacaoActivity
import br.com.zup.simcityacademy.model.Alune

class HomeActivity : AppCompatActivity() {
    /*Declaração de atributos que serão inicializados depois:
    Seguem exemplos de vinculação de views de várias formas diferentes usando: lateinit var, by
    lazy e variavel nullable com viewBinding. Boas práticas manda usarmos apenas uma forma.

    //TODO [OK] adicionar viewBinding no projeto para vincular os campos de nota três e quatro
    1. lateinit var:
    private lateinit var editTextNomeAlune: EditText */
    private lateinit var nome: String
    private lateinit var primeiraNota: String
    private lateinit var segundaNota: String
    private lateinit var terceiraNota: String
    private lateinit var quartaNota: String
    /*
    2. by lazy:
    private val editTextNomeAlune: EditText by lazy { findViewById(R.id.etNomeAlune) }
    private val editTextNotaUm: EditText by lazy { findViewById(R.id.etNotaUm) }
    private val editTextNotaDois: EditText by lazy { findViewById(R.id.etNotaDois) }
    private val editTextNotaTres: EditText by lazy { findViewById(R.id.etNotaTres) }
    private val editTextNotaQuatro: EditText by lazy { findViewById(R.id.etNotaQuatro) }
    private val btnCalcularMedia: EditText by lazy { findViewById(R.id.btnCalcularMedia) }

    3.a variavel nullable:*/
    private var btnCalcularMedia: Button? = null
    /*
    3.b com viewBinding: (Exemplo de inicialização de view com o uso de findViewById)
    private fun initViews() {
    editTextNomeAlune = findViewById(R.id.etNomeAlune)
    var editTextNotaUm = findViewById(R.id.etNotaUm)
    var editTextNotaDois = findViewById(R.id.etNotaDois)
    var editTextNotaTres = findViewById(R.id.etNotaTres)
    var editTextNotaQuatro = findViewById(R.id.etNotaQuatro)
    } */

    //Declaração do viewBinding no projeto
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inicialização da variavel binding
        binding = ActivityHomeBinding.inflate(layoutInflater)
        //Adicionando o binding.root para o método que seta o layout que será exibido ao usuário
        setContentView(binding.root)
        btnCalcularMedia = findViewById(R.id.btnCalcularMedia)
        //initViews()

        //Exemplo de uso do binding pelo id da view
        //binding.etNotaUm
        //binding.etNotaDois
        //binding.etNotaTres
        //binding.etNotaQuatro

        btnCalcularMedia?.setOnClickListener {
            //TODO [OK] alterar o código abaixo
            enviarDadosAlune()
        }
    }

    private fun enviarDadosAlune() {
        //TODO [OK] realizar a lógica para recuperar os dados
        /*Para checar se o botão funciona conforme planejado:
        val nomeAlune = binding.etNomeAlune.text
        Toast.makeText(this, "Nome digitado: $nomeAlune", Toast.LENGTH_LONG).show()*/
        recuperarDadosCampoEdicao()
        if (!verificarCamposEdicao()) {
            //Cria o objeto do tipo Alune
            val alune = Alune(
                nome,
                primeiraNota.toDouble(),
                segundaNota.toDouble(),
                terceiraNota.toDouble(),
                quartaNota.toDouble()
            )

            //TODO [OK] realizar a lógica para enviar os dados
            /*Cria a Intent mandando um objeto do tipo Parcelable. Lembrando que todos os objetos
            que serao enviados de uma tela para outra é preciso anotar a classe com @Parcelize e
            implementar a interface Parcelable*/
            val intent = Intent(this, InformacaoActivity::class.java).apply {
                putExtra(ALUNE, alune)
            }
            startActivity(intent)
            limparOsCamposEdicao()
        }
    }

    //Método que recupera o texto digitado pelo usuário e adiciona nos atributos declarados
    private fun recuperarDadosCampoEdicao() {
        this.nome = binding.etNomeAlune.text.toString()
        this.primeiraNota = binding.etNotaUm.text.toString()
        this.segundaNota = binding.etNotaDois.text.toString()
        this.terceiraNota = binding.etNotaTres.text.toString()
        this.quartaNota = binding.etNotaQuatro.text.toString()
    }

    //Método que verifica se nenhum campo está vazio antes de mudar de tela
    private fun verificarCamposEdicao(): Boolean {
        when {
            this.nome.isEmpty() -> {
                binding.etNomeAlune.error = "Por favor preencha o campo de nome!"
                return true
            }
            this.primeiraNota.isEmpty() -> {
                binding.etNotaUm.error = MENSAGEM_CAMPO_NOTA_OBRIGATORIO
                return true
            }
            this.segundaNota.isEmpty() -> {
                binding.etNotaDois.error = MENSAGEM_CAMPO_NOTA_OBRIGATORIO
                return true
            }
            this.terceiraNota.isEmpty() -> {
                binding.etNotaTres.error = MENSAGEM_CAMPO_NOTA_OBRIGATORIO
                return true
            }
            this.quartaNota.isEmpty() -> {
                binding.etNotaQuatro.error = MENSAGEM_CAMPO_NOTA_OBRIGATORIO
                return true
            }
        }
        return false
    }

    //Método que limpa os editText
    private fun limparOsCamposEdicao() {
        binding.etNomeAlune.text.clear()
        binding.etNotaUm.text.clear()
        binding.etNotaDois.text.clear()
        binding.etNotaTres.text.clear()
        binding.etNotaQuatro.text.clear()
    }
}