package com.example.jokenpo

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        intent = Intent(this@MainActivity, SplashScreenActivity::class.java)
        startActivity(intent)
    }

    // Passando os valores pelo click da imagem
    fun stoneSelected(view: View){
        this.optionSelected(getString(R.string.stone))
    }

    fun paperSelected(view: View){
        this.optionSelected(getString(R.string.paper))
    }

    fun scissorSelected(view: View){
        this.optionSelected(getString(R.string.scissor))
    }

    fun optionSelected(optionSelected: String){
        // numero randomico para o app
        var rand:Int = Random().nextInt(3)
        val options = arrayOf("Pedra", "Papel", "Tesoura")

        var appChoice = options[rand]

        when(appChoice){
             "Pedra" -> imgOptionApp.setImageResource(R.drawable.stone)
             "Papel" -> imgOptionApp.setImageResource(R.drawable.paper)
             "Tesoura"-> imgOptionApp.setImageResource(R.drawable.scissor)
        }

       // Compara os valores e escolhe a resposta para setar a mensagem de perda ou ganho
       if (optionSelected == appChoice)
            this.setMessageForDialog(
                getString(R.string.draw), getString(R.string.again), getString(R.string.deft))

        else if (optionSelected.equals(options[0]) && appChoice.equals(options[1]))
                this.setMessageForDialog(
                    getString(R.string.lost0),getString(R.string.lostTitle), getString(R.string.paper))

        else if (optionSelected.equals(options[0]) && appChoice.equals(options[2]))
                this.setMessageForDialog(
                    getString(R.string.win0), getString(R.string.wwcd),getString(R.string.stone) )

        else if (optionSelected.equals(options[1]) && appChoice.equals(options[0]))
            this.setMessageForDialog(
                getString(R.string.win1), getString(R.string.wwcd), getString(R.string.paper))

        else if (optionSelected.equals(options[1]) && appChoice.equals(options[2]))
            this.setMessageForDialog(
                getString(R.string.lost1),getString(R.string.lostTitle), getString(R.string.scissor))

        else if (optionSelected.equals(options[2]) && appChoice.equals(options[0]))
            setMessageForDialog(
                getString(R.string.lost2),getString(R.string.lostTitle),getString(R.string.stone))

        else if (optionSelected.equals(options[2]) && appChoice.equals(options[1]))
            setMessageForDialog(
                getString(R.string.win2), getString(R.string.wwcd),getString(R.string.scissor))
    }

    // Configuração da mensagem de alerta
    fun setMessageForDialog(message:String, msgTitle:String, iconWinner:String){
        val builder = AlertDialog.Builder(this@MainActivity)
        when(iconWinner){
            "Empate" -> builder.setIcon(R.drawable.def_padrao)
            "Pedra" -> builder.setIcon(R.drawable.stone)
            "Papel" -> builder.setIcon(R.drawable.paper)
            "Tesoura"-> builder.setIcon(R.drawable.scissor)
        }
        builder.setTitle(msgTitle)
        builder.setMessage(message)
        builder.setNeutralButton(getString(R.string.close)){ dialog, which ->
        dialog.cancel()

        }
        val dialog = builder.create()
        dialog.show()

    }
}
