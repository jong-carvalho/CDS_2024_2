package com.example.jokenpo;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView ringueIAPapel, ringueIAPedra, ringueIATesoura;
    private ImageView ringueJogadorPapel, ringueJogadorPedra, ringueJogadorTesoura;
    private ImageView circuloAzul, circuloVermelho;
    private TextView vitoriaJogador01, vitoriaJogador02, vitoriaJogador03, nomeJogador;
    private TextView vitoriaIA01, vitoriaIA02, vitoriaIA03, nomeIA, versus;

    private ImageView vencedor, perdedor;

    private int jogadorVenceu = 0;
    private int iaVenceu = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // referenciando as views
        ringueIAPapel = findViewById(R.id.ringueIAPapel);
        ringueIAPedra = findViewById(R.id.ringueIAPedra);
        ringueIATesoura = findViewById(R.id.ringueIATesoura);

        ringueJogadorPapel = findViewById(R.id.ringueJogadorPapel);
        ringueJogadorPedra = findViewById(R.id.ringueJogadorPedra);
        ringueJogadorTesoura = findViewById(R.id.ringueJogadorTesoura);

        vitoriaJogador01 = findViewById(R.id.vitoriaJogador01);
        vitoriaJogador02 = findViewById(R.id.vitoriaJogador02);
        vitoriaJogador03 = findViewById(R.id.vitoriaJogador03);
        nomeJogador = findViewById(R.id.nomeJogador);

        vitoriaIA01 = findViewById(R.id.vitoriaIA01);
        vitoriaIA02 = findViewById(R.id.vitoriaIA02);
        vitoriaIA03 = findViewById(R.id.vitoriaIA03);
        nomeIA = findViewById(R.id.nomeIA);

        versus = findViewById(R.id.versus);

        circuloAzul = findViewById(R.id.circuloAzul);
        circuloVermelho = findViewById(R.id.circuloVermelho);

        vencedor = findViewById(R.id.vencedor);
        perdedor = findViewById(R.id.perdedor);

        // definimos os listener e conforme a escolha, chamamos o método jogar passando por parametro um número correspondente a escolha
        // 0 - papel ... 1 - pedra ... 2 - tesoura
        findViewById(R.id.escolhaJogadorPapel).setOnClickListener(view -> jogar(0));
        findViewById(R.id.escolhaJogadorPedra).setOnClickListener(view -> jogar(1));
        findViewById(R.id.escolhaJogadorTesoura).setOnClickListener(view -> jogar(2));

        // Tornando as imagens invisíveis no início
        resetarVisibilidade();
    }

    private void jogar(int escolhaJogador) {
        resetarVisibilidade();

        // 0 = Papel, 1 = Pedra, 2 = Tesoura
        int escolhaIA = new Random().nextInt(3);
        mostrarEscolhaIA(escolhaIA);
        mostrarEscolhaJogador(escolhaJogador);

        // Determina o vencedor da rodada
        if (escolhaJogador == escolhaIA) {
            /*
            como atividade os alunos podem tentar implementar a exibição da palavra empate
            ou então marcar um ponto para cada jogador
            */
        } else if ((escolhaJogador == 0 && escolhaIA == 1) ||  // Papel vence Pedra
                (escolhaJogador == 1 && escolhaIA == 2) ||  // Pedra vence Tesoura
                (escolhaJogador == 2 && escolhaIA == 0)) {  // Tesoura vence Papel
            jogadorVenceu++;
            contabilizarVitoriaJogador();
        } else {
            iaVenceu++;
            contabilizarVitoriaIA();
        }

        // Verifica se alguém venceu 3 vezes
        verificarVencedor();
    }

    private void mostrarEscolhaIA(int escolha) {
        switch (escolha) {
            case 0:
                ringueIAPapel.setVisibility(View.VISIBLE);
                break;
            case 1:
                ringueIAPedra.setVisibility(View.VISIBLE);
                break;
            case 2:
                ringueIATesoura.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void mostrarEscolhaJogador(int escolha) {
        switch (escolha) {
            case 0:
                ringueJogadorPapel.setVisibility(View.VISIBLE);
                break;
            case 1:
                ringueJogadorPedra.setVisibility(View.VISIBLE);
                break;
            case 2:
                ringueJogadorTesoura.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void contabilizarVitoriaJogador() {
        if (jogadorVenceu == 1) {
            vitoriaJogador01.setVisibility(View.VISIBLE);
        } else if (jogadorVenceu == 2) {
            vitoriaJogador02.setVisibility(View.VISIBLE);
        } else if (jogadorVenceu == 3) {
            vitoriaJogador03.setVisibility(View.VISIBLE);
        }
    }

    private void contabilizarVitoriaIA() {
        if (iaVenceu == 1) {
            vitoriaIA01.setVisibility(View.VISIBLE);
        } else if (iaVenceu == 2) {
            vitoriaIA02.setVisibility(View.VISIBLE);
        } else if (iaVenceu == 3) {
            vitoriaIA03.setVisibility(View.VISIBLE);
        }
    }

    private void verificarVencedor() {
        if (jogadorVenceu == 3) {
            esconderPlacarERingue();
            vencedor.setVisibility(View.VISIBLE);

            // Aguardar 3 segundos e resetar o jogo
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    resetarJogo();
                }
            }, 3000); // 3000 milissegundos = 3 segundos

        } else if (iaVenceu == 3) {
            esconderPlacarERingue();
            perdedor.setVisibility(View.VISIBLE);

            // Aguardar 3 segundos e resetar o jogo
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    resetarJogo();
                }
            }, 3000); // 3000 milissegundos = 3 segundos
        }
    }

    private void resetarJogo() {
        // Reinicializar os contadores de vitórias
        jogadorVenceu = 0;
        iaVenceu = 0;

        // Tornar os placares e nomes visíveis novamente
        vitoriaJogador01.setVisibility(View.INVISIBLE);
        vitoriaJogador02.setVisibility(View.INVISIBLE);
        vitoriaJogador03.setVisibility(View.INVISIBLE);
        nomeJogador.setVisibility(View.VISIBLE);

        vitoriaIA01.setVisibility(View.INVISIBLE);
        vitoriaIA02.setVisibility(View.INVISIBLE);
        vitoriaIA03.setVisibility(View.INVISIBLE);
        nomeIA.setVisibility(View.VISIBLE);

        // Tornar o ringue visível novamente
        circuloAzul.setVisibility(View.VISIBLE);
        circuloVermelho.setVisibility(View.VISIBLE);
        versus.setVisibility(View.VISIBLE);

        // Esconder as imagens de vencedor e perdedor
        vencedor.setVisibility(View.INVISIBLE);
        perdedor.setVisibility(View.INVISIBLE);
    }

    private void resetarVisibilidade() {
        ringueIAPapel.setVisibility(View.INVISIBLE);
        ringueIAPedra.setVisibility(View.INVISIBLE);
        ringueIATesoura.setVisibility(View.INVISIBLE);
        ringueJogadorPapel.setVisibility(View.INVISIBLE);
        ringueJogadorPedra.setVisibility(View.INVISIBLE);
        ringueJogadorTesoura.setVisibility(View.INVISIBLE);
        vencedor.setVisibility(View.INVISIBLE);
        perdedor.setVisibility(View.INVISIBLE);
    }

    private void esconderPlacarERingue() {
        // Escondendo o placar
        vitoriaJogador01.setVisibility(View.INVISIBLE);
        vitoriaJogador02.setVisibility(View.INVISIBLE);
        vitoriaJogador03.setVisibility(View.INVISIBLE);
        nomeJogador.setVisibility(View.INVISIBLE);

        vitoriaIA01.setVisibility(View.INVISIBLE);
        vitoriaIA02.setVisibility(View.INVISIBLE);
        vitoriaIA03.setVisibility(View.INVISIBLE);
        nomeIA.setVisibility(View.INVISIBLE);

        // Escondendo o ringue
        ringueIAPapel.setVisibility(View.INVISIBLE);
        ringueIAPedra.setVisibility(View.INVISIBLE);
        ringueIATesoura.setVisibility(View.INVISIBLE);
        ringueJogadorPapel.setVisibility(View.INVISIBLE);
        ringueJogadorPedra.setVisibility(View.INVISIBLE);
        ringueJogadorTesoura.setVisibility(View.INVISIBLE);
        circuloAzul.setVisibility(View.INVISIBLE);
        circuloVermelho.setVisibility(View.INVISIBLE);
        versus.setVisibility(View.INVISIBLE);
    }
}