package com.hasyim.konversisuhu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    double hitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txAngka = (EditText) findViewById(R.id.angka);
        Button btnHitung = (Button) findViewById(R.id.btnHitung);
        Button btnHapus = (Button) findViewById(R.id.btnHapus);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final TextView txHasil = (TextView) findViewById(R.id.etHasil);

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txAngka.setText("");
                txHasil.setText("");
                spinner.setSelection(0);
            }
        });

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String angka = txAngka.getText().toString();
                if (angka.isEmpty()){
                    Toast.makeText(MainActivity.this, "Angka belum diisi bro :)", Toast.LENGTH_LONG).show();
                }else {
                    double suhu = Double.parseDouble(angka);
                    int position = spinner.getSelectedItemPosition();

                    switch (position){
                        case 0:
                            hitung = 4.0/5.0*suhu;
                            break;
                        case 1:
                            hitung = (9.0/5.0)*suhu+32;
                            break;
                        case 2:
                            hitung = suhu+237;
                            break;
                        case 3:
                            hitung = 5.0/4.0*suhu;
                            break;
                        case 4:
                            hitung = 9.0/4.0*suhu+32;
                            break;
                        case 5:
                            hitung = 5.0/4.0*suhu+273;
                            break;
                        case 6:
                            hitung = 5.0/9.0*(suhu-32);
                            break;
                        case 7:
                            hitung = 4.0/9.0*(suhu-32);
                            break;
                        case 8:
                            hitung = 5.0/9.0*(suhu-32)+273;
                            break;
                        case 9:
                            hitung = suhu-273;
                            break;
                        case 10:
                            hitung = 4.0/5.0*(suhu-273);
                            break;
                        case 11:
                            hitung = 9.0/5.0*(suhu-273)+32;
                            break;
                    }
                    txHasil.setText("Hasil Konversi : "+hitung);
                }
            }
        });
    }

}
