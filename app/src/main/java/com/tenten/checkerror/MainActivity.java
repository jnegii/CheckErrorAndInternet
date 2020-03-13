package com.tenten.checkerror;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.tenten.checkinternetconnectionanderrors.ErrorDialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ErrorDialog errorDialog;
private boolean check=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //errorDialogInit();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//             check=    new ErrorDialog.Builder(MainActivity.this)
//                .setBackgroundGradient(getResources().getColor(R.color.colorAccent),getResources().getColor(R.color.colorPrimaryDark))
//                        .setCancelButtonStrokeColor(getResources().getColor(R.color.greenYellow))
//                        .setCancelButtonTextColor(getResources().getColor(R.color.dark_red))
//                        .setReryButtonTextColor(getResources().getColor(R.color.dark_goldenrod))
//                        .setReryButtonColor(getResources().getColor(R.color.light_pink))
//                        .setErrorOccuredHeading("yash Verma")
//                        .setErrorOccuredSubText("hehaheha")
//                        .setNoInternetHeading("nhi ara tower")
//                        .setNoInternetSubText("Kya ukhad lega")
//                        .setRetryButtonClickListner(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                Toast.makeText(MainActivity.this, "Retry fuck it", Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .setCancelButtonClickListner(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                Toast.makeText(MainActivity.this, "Cancel it", Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .buildCheckInternetOnly();
//                if (check){
//                    Toast.makeText(getApplicationContext(), "Found", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(getApplicationContext(), "Not Found", Toast.LENGTH_SHORT).show();
//                }
//
//
//



















                //TODO FULL BUILD
                    new ErrorDialog.Builder(MainActivity.this)
//                        .setBackgroundGradient(getResources().getColor(R.color.colorAccent),getResources().getColor(R.color.colorPrimaryDark))
//                        .setCancelButtonStrokeColor(getResources().getColor(R.color.greenYellow))
//                        .setCancelButtonTextColor(getResources().getColor(R.color.dark_red))
//                        .setReryButtonTextColor(getResources().getColor(R.color.dark_goldenrod))
//                        .setReryButtonColor(getResources().getColor(R.color.light_pink))
//                        .setErrorOccuredHeading("yash Verma")
//                        .setErrorOccuredSubText("hehaheha")
//                        .setNoInternetHeading("nhi ara tower")
//                        .setNoInternetSubText("Kya ukhad lega")
                        .setRetryButtonClickListner(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this, "Retry fuck it", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setCancelButtonClickListner(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this, "Cancel it", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build();


            }
        });


    }

//    private void errorDialogInit() {
//        errorDialog = new ErrorDialog(this);
//        errorDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        errorDialog.setCancelable(false);
//        errorDialog.setCanceledOnTouchOutside(false);
//       // errorDialog.setBackground(1,2);
//
//    }
//



















    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
