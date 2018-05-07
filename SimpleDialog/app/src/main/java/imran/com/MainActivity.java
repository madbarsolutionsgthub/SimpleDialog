package imran.com;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
    Button btnAlertOneObj, btnAlertTwoObj, btnAlertThreeObj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAlertOneObj = (Button)findViewById(R.id.btnAlertOne);
        btnAlertTwoObj = (Button)findViewById(R.id.btnAlertTwo);
        btnAlertThreeObj = (Button)findViewById(R.id.btnAlertThree);
        btnAlertOneObj.setOnClickListener(this);
        btnAlertTwoObj.setOnClickListener(this);
        btnAlertThreeObj.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnAlertOne){
            alertOne();
        }else if(v.getId()==R.id.btnAlertTwo){
            alertTwo();
        }else{
            alertThree();
        }


    }

    public void alertOne(){
        new AlertDialog.Builder(MainActivity.this).setTitle("First Alert")
        .setMessage("This is First Btn message")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        showMsg("Click First Btn");
                    }
                }).show();

    }
    public void alertTwo(){
        new AlertDialog.Builder(MainActivity.this).setTitle("Second Alert")
                .setMessage("Do you want delete?")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        showMsg("Successfully Delete data");
                        dialogInterface.cancel();
                    }
                })
                .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showMsg("You Click Cancel");
                        dialogInterface.cancel();
                    }
        }).show();
    }
    public void alertThree(){
         final CharSequence[] items = {"Dhaka", "Borisal","Khulna"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Select Your City");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                showMsg("You select "+items[i]);
                dialogInterface.dismiss();
            }
        });

        builder.show();
    }

    public void showMsg(String msg){
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_SHORT).show();
    }



}
