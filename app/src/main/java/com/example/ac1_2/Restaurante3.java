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

public class Restaurante3 extends AppCompatActivity {

    Button btnMapa3, btnSite3, btnLigar3;
    TextView txtDescricao3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_restaurante3);

        btnMapa3 = (Button)findViewById(R.id.btnMapa3);
        btnSite3 = (Button)findViewById(R.id.btnSite3);
        btnLigar3 = (Button)findViewById(R.id.btnLigar3);
        txtDescricao3 = (TextView)findViewById(R.id.txtRestauranteDescricao3);


        txtDescricao3.setText("Johnny Rockets é uma rede de restaurantes que traz o espírito das clássicas lanchonetes americanas dos anos 50, proporcionando uma experiência nostálgica e divertida. Com uma decoração retrô, jukeboxes e funcionários simpáticos, o ambiente é acolhedor e descontraído, ideal para famílias, amigos e qualquer um que queira reviver a era de ouro das lanchonetes. " +
                "\nO cardápio é centrado em hambúrgueres artesanais, preparados com ingredientes frescos e combinados com batatas fritas crocantes e anéis de cebola. Além disso, os milkshakes são uma especialidade da casa, batidos à mão e disponíveis em sabores clássicos como baunilha, morango e chocolate. Tudo é feito para proporcionar uma explosão de sabor em cada mordida.\n" +
                "\nCom seu serviço atencioso e atmosfera alegre, o Johnny Rockets oferece mais do que apenas uma refeição – é uma experiência completa que celebra a cultura americana dos anos 50. Seja para uma refeição casual ou para comemorar um momento especial, o restaurante é um destino que combina sabor, diversão e uma viagem no tempo.\n");

        btnMapa3.setOnClickListener( v -> {
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=Avenida+Gisele+" +//
                    "Constantino+1850");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            // mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });

        btnLigar3.setOnClickListener(v -> {
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

        btnSite3.setOnClickListener(v -> {
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