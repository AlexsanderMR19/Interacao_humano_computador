package com.example.aula01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Executa quando a tela é criada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Liga a Activity ao layout XML
        setContentView(R.layout.activity_main)

        // Captura referências dos campos
        val edtNomeApp = findViewById<EditText>(R.id.edtNomeApp)
        val edtTarefaPrincipal = findViewById<EditText>(R.id.edtTarefaPrincipal)
        val edtEficacia = findViewById<EditText>(R.id.edtEficacia)
        val edtEficiencia = findViewById<EditText>(R.id.edtEficiencia)
        val edtSatisfacao = findViewById<EditText>(R.id.edtSatisfacao)
        val edtAcessibilidade = findViewById<EditText>(R.id.edtAcessibilidade)

        val btnGerarDocumento = findViewById<Button>(R.id.btnGerarDocumento)
        val txtDocumento = findViewById<TextView>(R.id.txtDocumento)

        // Clique do botão: gera documento UX após validar campos
        btnGerarDocumento.setOnClickListener {

            // Lê os dados do formulário
            val nomeApp = edtNomeApp.text.toString().trim()
            val tarefa = edtTarefaPrincipal.text.toString().trim()
            val eficacia = edtEficacia.text.toString().trim()
            val eficiencia = edtEficiencia.text.toString().trim()
            val satisfacao = edtSatisfacao.text.toString().trim()
            val acessibilidade = edtAcessibilidade.text.toString().trim()

            // ✅ Prevenção de erros (Heurística de Nielsen):
            // Não deixe o usuário "gerar documento" com dados vazios.
            if (nomeApp.isEmpty() || tarefa.isEmpty() || eficacia.isEmpty() ||
                eficiencia.isEmpty() || satisfacao.isEmpty() || acessibilidade.isEmpty()
            ) {
                Toast.makeText(
                    this,
                    "Preencha todos os campos para gerar o Documento UX.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            // Monta um documento simples e organizado (facilita leitura e análise)
            val documentoUx = """
                📄 DOCUMENTO SIMPLES — REQUISITOS DE USABILIDADE (UX)
                
                1) Sistema / App:
                - Nome: $nomeApp
                
                2) Tarefa principal do usuário:
                - $tarefa
                
                3) Requisitos de USABILIDADE
                3.1 EFICÁCIA (o usuário consegue concluir?)
                - $eficacia
                
                3.2 EFICIÊNCIA (tempo, cliques, esforço)
                - $eficiencia
                
                3.3 SATISFAÇÃO (percepção do usuário)
                - $satisfacao
                
                3.4 ACESSIBILIDADE (princípios básicos)
                - $acessibilidade
                
                ✅ Observação:
                Estes requisitos devem ser testados em protótipos e versões do app.
            """.trimIndent()

            // Exibe o documento na tela (feedback/visibilidade)
            txtDocumento.text = documentoUx

            // Feedback adicional: confirma que a ação foi concluída
            Toast.makeText(
                this,
                "Documento UX gerado! Agora revise e refine os requisitos.",
                Toast.LENGTH_SHORT
            ).show()

        }
    }
}
