package hr.kruno.dummyrandomgenerator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class SlucajniActivity extends AppCompatActivity {
    private int poc, kraj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slucajni);
        // dohvaća poslane parametre
        Intent i = getIntent();
        // drugi parametar je inicijalna vrijednost u slučaju da
        // parametri nisu predani.
        poc = i.getIntExtra("pocetakIntervala",1);
        kraj = i.getIntExtra("krajIntervala",100);

    }

    public void generirajBroj(View v){
        EditText dg = findViewById(R.id.donjaGranica);
        EditText gg = findViewById(R.id.gornjaGranica);
        // Ako je unesena donja granica - inače je 1
        if (dg.getText().toString().length() > 0)
            poc = Integer.parseInt(dg.getText().toString());
        else
            poc = 1;
        // Ako je unesena gornja granica - inače je 100
        if (gg.getText().toString().length() > 0)
            kraj = Integer.parseInt(gg.getText().toString());
        else
            kraj = 100;
        Random r = new Random();
        int rezultat = r.nextInt(kraj-poc)+poc;
        TextView slucajni = findViewById(R.id.slucajni);
        slucajni.setText(Integer.toString(rezultat));
    }
}