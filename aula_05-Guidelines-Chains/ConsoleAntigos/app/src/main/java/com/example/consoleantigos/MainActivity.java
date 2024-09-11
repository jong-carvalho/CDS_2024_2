package com.example.consoleantigos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewSaida;

    private Button buttonHistoria;
    private Button buttonPublicadora;
    private Button buttonLancamento;

    private CheckBox checkBoxAtari;
    private CheckBox checkBoxNes;
    private CheckBox checkBoxMasterSystem;
    private CheckBox checkBoxMegaDrive;
    private CheckBox checkBoxGameBoy;
    private CheckBox checkBoxSnes;
    private CheckBox checkBoxNintendo64;
    private CheckBox checkBoxPsx;
    private CheckBox checkBoxSegaDreamcast;
    private CheckBox checkBoxNeoGeo;
    private CheckBox checkBoxPs2;
    private CheckBox checkBoxXbox;
    private CheckBox checkBoxPs3;
    private CheckBox checkBoxNintendoWii;

    private Switch switchIdioma;

    private boolean isEnglish = false;

    private ConsolesAntigos[] consolesPTBR;
    private ConsolesAntigos[] consolesENG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Arrays com textos em português e inglês
        consolesPTBR = new ConsolesAntigos[]{
                new ConsolesAntigos("Atari 2600", 1977, "Atari", "O Atari 2600 popularizou os jogos eletrônicos nos anos 80."),
                new ConsolesAntigos("NES", 1983, "Nintendo", "O Nintendo Entertainment System revolucionou a indústria dos games."),
                new ConsolesAntigos("Master System", 1985, "Sega", "O Master System foi o principal concorrente do NES."),
                new ConsolesAntigos("Mega Drive", 1988, "Sega", "Conhecido como Genesis nos EUA, foi um sucesso na década de 90."),
                new ConsolesAntigos("Nintendo Game Boy", 1989, "Nintendo", "O Game Boy popularizou os jogos portáteis."),
                new ConsolesAntigos("SNES", 1990, "Nintendo", "O Super Nintendo Entertainment System foi um dos consoles mais amados."),
                new ConsolesAntigos("Nintendo 64", 1996, "Nintendo", "O Nintendo 64 foi o último grande console a usar cartuchos."),
                new ConsolesAntigos("PSX", 1994, "Sony", "O PlayStation original trouxe os CDs para os jogos de console."),
                new ConsolesAntigos("Sega Dreamcast", 1999, "Sega", "O Dreamcast foi o primeiro console a incluir um modem para jogos online."),
                new ConsolesAntigos("NEO Geo", 1990, "SNK", "O Neo Geo era conhecido por seus jogos de arcade e preço elevado."),
                new ConsolesAntigos("PS2", 2000, "Sony", "O PlayStation 2 é o console mais vendido de todos os tempos."),
                new ConsolesAntigos("XBOX", 2001, "Microsoft", "O Xbox foi o primeiro console da Microsoft, introduzindo o Xbox Live."),
                new ConsolesAntigos("PS3", 2006, "Sony", "O PlayStation 3 trouxe o Blu-ray para os jogos de console."),
                new ConsolesAntigos("Nintendo Wii", 2006, "Nintendo", "O Wii popularizou os controles por movimento e foi um enorme sucesso.")
        };

        consolesENG = new ConsolesAntigos[]{
                new ConsolesAntigos("Atari 2600", 1977, "Atari", "The Atari 2600 popularized video games in the 80s."),
                new ConsolesAntigos("NES", 1983, "Nintendo", "The Nintendo Entertainment System revolutionized the gaming industry."),
                new ConsolesAntigos("Master System", 1985, "Sega", "The Master System was the main competitor to the NES."),
                new ConsolesAntigos("Mega Drive", 1988, "Sega", "Known as Genesis in the US, it was a hit in the 90s."),
                new ConsolesAntigos("Nintendo Game Boy", 1989, "Nintendo", "The Game Boy made handheld gaming popular."),
                new ConsolesAntigos("SNES", 1990, "Nintendo", "The Super Nintendo Entertainment System was one of the most beloved consoles."),
                new ConsolesAntigos("Nintendo 64", 1996, "Nintendo", "The Nintendo 64 was the last major console to use cartridges."),
                new ConsolesAntigos("PSX", 1994, "Sony", "The original PlayStation brought CDs to console gaming."),
                new ConsolesAntigos("Sega Dreamcast", 1999, "Sega", "The Dreamcast was the first console to include a modem for online play."),
                new ConsolesAntigos("NEO Geo", 1990, "SNK", "The Neo Geo was known for its arcade games and high price."),
                new ConsolesAntigos("PS2", 2000, "Sony", "The PlayStation 2 is the best-selling console of all time."),
                new ConsolesAntigos("XBOX", 2001, "Microsoft", "The Xbox was Microsoft's first console, introducing Xbox Live."),
                new ConsolesAntigos("PS3", 2006, "Sony", "The PlayStation 3 brought Blu-ray to console gaming."),
                new ConsolesAntigos("Nintendo Wii", 2006, "Nintendo", "The Wii popularized motion controls and was a huge success.")
        };

        textViewSaida = findViewById(R.id.textViewSaida);
        buttonHistoria = findViewById(R.id.buttonHistoria);
        buttonLancamento = findViewById(R.id.buttonLancamento);
        buttonPublicadora = findViewById(R.id.buttonPublicadora);

        checkBoxAtari = findViewById(R.id.checkBoxAtari);
        checkBoxNes = findViewById(R.id.checkBoxNes);
        checkBoxMasterSystem = findViewById(R.id.checkBoxMasterSystem);
        checkBoxMegaDrive = findViewById(R.id.checkBoxMegaDrive);
        checkBoxGameBoy = findViewById(R.id.checkBoxGameBoy);
        checkBoxSnes = findViewById(R.id.checkBoxSnes);
        checkBoxNintendo64 = findViewById(R.id.checkBoxNintendo64);
        checkBoxPsx = findViewById(R.id.checkBoxPsx);
        checkBoxSegaDreamcast = findViewById(R.id.checkBoxSegaDreamcast);
        checkBoxNeoGeo = findViewById(R.id.checkBoxNeoGeo);
        checkBoxPs2 = findViewById(R.id.checkBoxPs2);
        checkBoxXbox = findViewById(R.id.checkBoxXbox);
        checkBoxPs3 = findViewById(R.id.checkBoxPs3);
        checkBoxNintendoWii = findViewById(R.id.checkBoxNintendoWii);


        switchIdioma = findViewById(R.id.switchIdioma);

        switchIdioma.setOnCheckedChangeListener((buttonView, isChecked) -> {
            isEnglish = isChecked;
        });

        buttonHistoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConsolesAntigos consoleEscolhido = buscarConsoleSelecionado(); // Obtém o console selecionado
                if (consoleEscolhido != null) {
                    String historia = consoleEscolhido.getHistoria(); // Acessa a história do console
                    textViewSaida.setText(historia);
                } else {
                    textViewSaida.setText("Nenhum console selecionado.");
                }
            }
        });


        buttonPublicadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConsolesAntigos consoleEscolhido = buscarConsoleSelecionado();
                if (consoleEscolhido != null) {
                    String publicadora = consoleEscolhido.getPublisher();
                    textViewSaida.setText(publicadora);
                } else {
                    textViewSaida.setText("Nenhum console selecionado.");
                }
            }
        });

        buttonLancamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConsolesAntigos consoleEscolhido = buscarConsoleSelecionado();
                if (consoleEscolhido != null) {
                    String lancamento = String.valueOf(consoleEscolhido.getAnoLancamento());
                    textViewSaida.setText(lancamento);
                } else {
                    textViewSaida.setText("Nenhum console selecionado.");
                }
            }
        });
    }


    private ConsolesAntigos buscarConsoleSelecionado() {
        ConsolesAntigos[] consolesSelecionados = isEnglish ? consolesENG : consolesPTBR;

//        essa lógica pode ser melhorada -> deixando assim para ficar mais simples de entender
        if (checkBoxAtari.isChecked()) return buscarConsolePorNome("Atari 2600", consolesSelecionados);
        if (checkBoxNes.isChecked()) return buscarConsolePorNome("NES", consolesSelecionados);
        if (checkBoxMasterSystem.isChecked()) return buscarConsolePorNome("Master System", consolesSelecionados);
        if (checkBoxMegaDrive.isChecked()) return buscarConsolePorNome("Mega Drive", consolesSelecionados);
        if (checkBoxGameBoy.isChecked()) return buscarConsolePorNome("Nintendo Game Boy", consolesSelecionados);
        if (checkBoxSnes.isChecked()) return buscarConsolePorNome("SNES", consolesSelecionados);
        if (checkBoxNintendo64.isChecked()) return buscarConsolePorNome("Nintendo 64", consolesSelecionados);
        if (checkBoxPsx.isChecked()) return buscarConsolePorNome("PSX", consolesSelecionados);
        if (checkBoxSegaDreamcast.isChecked()) return buscarConsolePorNome("Sega Dreamcast", consolesSelecionados);
        if (checkBoxNeoGeo.isChecked()) return buscarConsolePorNome("NEO Geo", consolesSelecionados);
        if (checkBoxPs2.isChecked()) return buscarConsolePorNome("PS2", consolesSelecionados);
        if (checkBoxXbox.isChecked()) return buscarConsolePorNome("XBOX", consolesSelecionados);
        if (checkBoxPs3.isChecked()) return buscarConsolePorNome("PS3", consolesSelecionados);
        if (checkBoxNintendoWii.isChecked()) return buscarConsolePorNome("Nintendo Wii", consolesSelecionados);

        return null;
    }

    private ConsolesAntigos buscarConsolePorNome(String nome, ConsolesAntigos[] consolesSelecionados) {
        for (ConsolesAntigos console : consolesSelecionados) {
            if (console.getNome().equalsIgnoreCase(nome)) {
                return console;
            }
        }
        return null;
    }
}
