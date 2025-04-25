package com.example.activityapenas // Define o pacote da aplicação

import android.os.Bundle // Importa a classe Bundle, usada para salvar/restaurar dados temporários
import android.os.PersistableBundle // (Não está sendo usada no código atual)
import android.util.Log // Importa a classe Log para exibir mensagens no Logcat
import android.widget.Button // Importa o widget de botão
import android.widget.TextView // Importa o widget de texto
import androidx.activity.enableEdgeToEdge // (Não está sendo usada diretamente)
import androidx.appcompat.app.AppCompatActivity // Importa a base de uma activity compatível com versões antigas do Android
import androidx.core.view.ViewCompat // (Não está sendo usada diretamente)
import androidx.core.view.WindowInsetsCompat // (Não está sendo usada diretamente)

private const val TAG = "MainActivity" // Define uma constante para identificar logs no Logcat

class MainActivity : AppCompatActivity() { // Declara a MainActivity que herda de AppCompatActivity

    var counter = 0 // Declara a variável contador, começando com valor 0

    override fun onCreate(savedInstanceState: Bundle?) { // Método chamado ao criar a Activity
        super.onCreate(savedInstanceState) // Chama o método da superclasse
        setContentView(R.layout.activity_main) // Define o layout da interface que será exibido

        Log.d(TAG, "onCreate chamado") // Mostra no Logcat que o onCreate foi chamado

        val tv_count =
            findViewById<TextView>(R.id.tv_count) // Busca o TextView com o id tv_count no layout
        val btn_count =
            findViewById<Button>(R.id.btn_count) // Busca o Button com o id btn_count no layout

        if (savedInstanceState != null) { // Se houver um estado salvo anteriormente
            counter = savedInstanceState.getInt("myCount") // Recupera o valor salvo do contador
            tv_count.text = counter.toString() // Atualiza o texto com o valor do contador
        }

        btn_count.setOnClickListener { // Define o que acontece ao clicar no botão
            counter = counter + 1 // Incrementa o contador

            if (counter != 0) { // Se o contador for diferente de zero
                tv_count.text = counter.toString() // Atualiza o texto com o novo valor
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) { // Método chamado para salvar o estado da activity
        outState.putInt("myCount", counter) // Salva o valor do contador no bundle
        super.onSaveInstanceState(outState) // Chama o método da superclasse
    }

    override fun onStart() { // Chamado quando a activity se torna visível ao usuário
        super.onStart()
        Log.d(TAG, "onStart chamado") // Log para indicar que onStart foi chamado
    }

    override fun onPause() { // Chamado quando a activity está parcialmente visível
        super.onPause()
        Log.d(TAG, "onPause chamado") // Log para indicar que onPause foi chamado
    }

    override fun onStop() { // Chamado quando a activity não está mais visível
        super.onStop()
        Log.d(TAG, "onsStop chamado") // Log para indicar que onStop foi chamado
    }

    override fun onDestroy() { // Chamado antes da activity ser destruída
        Log.d(TAG, "onDestroy chamado") // Log para indicar que onDestroy foi chamado
        super.onDestroy()
    }

}
