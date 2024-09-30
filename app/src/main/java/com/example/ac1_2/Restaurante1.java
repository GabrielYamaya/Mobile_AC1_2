package com.example.ac1_2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Restaurante1 extends AppCompatActivity {

    Button btnMapa1, btnSite1, btnLigar1;
    TextView txtDescricao1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_restaurante1);

        btnMapa1 = (Button)findViewById(R.id.btnMapa1);
        btnSite1 = (Button)findViewById(R.id.btnSite1);
        btnLigar1 = (Button)findViewById(R.id.btnLigar1);
        txtDescricao1 = (TextView)findViewById(R.id.txtRestauranteDescricao1);


        txtDescricao1.setText("Bem-vindo à Câmara Oculta, o restaurante temático que traz à vida o universo mágico de Harry Potter! Aqui, você será transportado para um ambiente encantado, inspirado nos mistérios e aventuras da saga. Com uma decoração repleta de referências ao mundo bruxo, desde quadros falantes até caldeirões borbulhantes, cada detalhe foi cuidadosamente elaborado para criar uma atmosfera mágica e acolhedora.\n" +
                "Nosso cardápio apresenta uma variedade de pratos e bebidas que capturam a essência da magia. Experimente a famosa Cerveja Amanteigada, delicie-se com tortas de abóbora e aproveite refeições inspiradas nos banquetes de Hogwarts. Temos opções para todos os gostos, incluindo pratos vegetarianos e veganos, tudo preparado com ingredientes frescos e de qualidade, garantindo uma experiência gastronômica verdadeiramente mágica.\n" +
                "Na Câmara Oculta, a magia não para na comida. Oferecemos uma programação especial com atividades interativas, desafios de feitiçaria e funcionários vestidos como bruxos que tornam sua visita ainda mais imersiva. Venha viver momentos inesquecíveis em um lugar onde o sabor e a fantasia se encontram, e descubra por que a Câmara Oculta é o destino perfeito para fãs de Harry Potter e amantes da boa comida.\n");

        btnMapa1.setOnClickListener( v -> {
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Rua+Marcarenhas+" +
                    "camelo+660");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            // mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });

        btnLigar1.setOnClickListener(v -> {
            Uri uri = Uri.parse("tel:15997740095");
            Intent intent = new Intent(Intent.ACTION_DIAL,uri);
            int permissionCheck =
                    ContextCompat.checkSelfPermission(
                            this, android.Manifest.permission.CALL_PHONE);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.
                        requestPermissions(this,
                                new String[]{
                                        android.Manifest.permission.CALL_PHONE},1);
            } else {
                startActivity(intent);
            }
        });

        btnSite1.setOnClickListener(v -> {
            Uri webpage = Uri.parse("https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwiM4NKIhumIAxWrrJUCHZgiKpMQFnoECAsQAQ&url=https%3A%2F%2Fwww.instagram.com%2Fcamaraoculta.oficial%2F&usg=AOvVaw0V_Ev5v7VVdGeXoyzBj-PT&opi=89978449");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}