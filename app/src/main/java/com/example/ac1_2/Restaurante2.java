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

public class Restaurante2 extends AppCompatActivity {

    Button btnMapa2, btnSite2, btnLigar2;
    TextView txtDescricao2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_restaurante2);

        btnMapa2 = (Button)findViewById(R.id.btnMapa2);
        btnSite2 = (Button)findViewById(R.id.btnSite2);
        btnLigar2 = (Button)findViewById(R.id.btnLigar2);
        txtDescricao2 = (TextView)findViewById(R.id.txtRestauranteDescricao2);

        txtDescricao2.setText("Bem-vindo ao Outback Steakhouse, onde a hospitalidade e o sabor se encontram em um ambiente inspirado na Austrália! Desde o momento em que você chega, nossos hosts estão prontos para recebê-lo com um sorriso e garantir que sua experiência comece da melhor forma possível. Aqui, cada detalhe é pensado para que você se sinta à vontade enquanto aproveita o melhor da nossa culinária.\n" +
                "\nNossos atendentes estão sempre à disposição para ajudá-lo a escolher pratos e bebidas que combinem com seu gosto. No bar, oferecemos uma seleção de drinques exclusivos, chopes refrescantes e coquetéis preparados com perfeição. Quer você esteja comemorando uma ocasião especial ou apenas curtindo uma refeição casual, estamos aqui para tornar seu momento ainda mais especial.\n" +
                "\nNa cozinha, preparamos cada prato com cuidado. Dos cortes suculentos de carne aos acompanhamentos e sobremesas irresistíveis, tudo é feito com ingredientes frescos e de alta qualidade. Com uma equipe dedicada e gerentes atentos a cada detalhe, garantimos que você tenha uma experiência incrível do início ao fim. Venha viver o #MomentoOutback!");

        btnMapa2.setOnClickListener( v -> {
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Avenida+Gisele+" +//
                    "Constantino+1850");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            // mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });

        btnLigar2.setOnClickListener(v -> {
            Uri uri = Uri.parse("tel:1532473497");
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

        btnSite2.setOnClickListener(v -> {
            Uri webpage = Uri.parse("https://www.outback.com.br/restaurante/shopping-iguatemi-esplanada-ala-sul");
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