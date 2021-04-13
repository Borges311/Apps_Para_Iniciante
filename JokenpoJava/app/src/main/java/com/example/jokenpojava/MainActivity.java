package com.example.jokenpojava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imgOptionApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    imgOptionApp = findViewById(R.id.imgOptionApp);
    }

      // Passando os valores pelo click da imagem
    public void stoneSelected(View view){
        this.optionSelected(getString(R.string.stone));
    }

    public void paperSelected(View view){
        this.optionSelected(getString(R.string.paper));
    }

    public void scissorSelected(View view){
        this.optionSelected(getString(R.string.scissor));
    }

    public void optionSelected(String optionSelected){
        // numero randomico para o app
        int rand = new Random().nextInt(3);
        String options[] = {"Pedra","Papel", "Tesoura"};

        String appChoice = options[rand];

        switch(appChoice){
            case "Pedra" : imgOptionApp.setImageResource(R.drawable.stone);
            break;
            case "Papel" : imgOptionApp.setImageResource(R.drawable.paper);
            break;
            case "Tesoura" : imgOptionApp.setImageResource(R.drawable.scissor);
            break;

        }

        // Compara os valores e escolhe a resposta para setar a mensagem de perda ou ganho
        if (optionSelected.equals(appChoice))
            this.setMessageForDialog(
                    getString(R.string.draw), getString(R.string.again), getString(R.string.deft));
        else if (optionSelected.equals(options[0]) && appChoice.equals(options[1]))
            this.setMessageForDialog(
                    getString(R.string.lost0),getString(R.string.lostTitle), getString(R.string.paper));

        else if (optionSelected.equals(options[0]) && appChoice.equals(options[2]))
            this.setMessageForDialog(
                    getString(R.string.win0), getString(R.string.wwcd), getString(R.string.stone));

        else if (optionSelected.equals(options[1]) && appChoice.equals(options[0]))
            this.setMessageForDialog(
                    getString(R.string.win1), getString(R.string.wwcd), getString(R.string.paper));

        else if (optionSelected.equals(options[1]) && appChoice.equals(options[2]))
            this.setMessageForDialog(
                    getString(R.string.lost1),getString(R.string.lostTitle), getString(R.string.scissor));

        else if (optionSelected.equals(options[2]) && appChoice.equals(options[0]))
            setMessageForDialog(
                    getString(R.string.lost2),getString(R.string.lostTitle), getString(R.string.stone));

        else if (optionSelected.equals(options[2]) && appChoice.equals(options[1]))
            setMessageForDialog(
                    getString(R.string.win2), getString(R.string.wwcd), getString(R.string.scissor));
    }

    // Configuração da mensagem de alerta
    public void setMessageForDialog(String message,String msgTitle, String iconWinner){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        switch(iconWinner){
            case "Empate" : builder.setIcon(R.drawable.def_padrao);
            break;
            case "Pedra" : builder.setIcon(R.drawable.stone);
                break;
            case "Papel" : builder.setIcon(R.drawable.paper);
                break;
            case "Tesoura" : builder.setIcon(R.drawable.scissor);
                break;
        }
        builder.setTitle(msgTitle);
        builder.setMessage(message);
        builder.setNeutralButton(getString(R.string.close), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(MainActivity.this, SplashScreenActivity.class);
        startActivity(intent);
    }
}

