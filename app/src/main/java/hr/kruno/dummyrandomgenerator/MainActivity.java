package hr.kruno.dummyrandomgenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int vidljivost = View.INVISIBLE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void prikaziUputu(View v){
        TextView uputa = findViewById(R.id.tekstUputa);
        Button b = findViewById(R.id.gumbPrikaziUpute);
        if (vidljivost == View.INVISIBLE) {
            vidljivost = View.VISIBLE;
            b.setText(getString(R.string.sakrij_upute));
        }
        else {
            vidljivost = View.INVISIBLE;
            b.setText(getString(R.string.prikazi_upute));
        }
        uputa.setVisibility(vidljivost);
    }
    public void generirajBroj(View v){
        Intent i = new Intent(this, SlucajniActivity.class);
        i.putExtra("pocetakIntervala",1);
        i.putExtra("krajIntervala",100);
        startActivity(i);
    }
}
