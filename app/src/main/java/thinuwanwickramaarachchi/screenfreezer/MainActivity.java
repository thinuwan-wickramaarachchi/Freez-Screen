package thinuwanwickramaarachchi.screenfreezer;

import android.app.Activity;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    Toast toast;
    Button button_1,button_2,button_3,button_4,button_5,button_6,button_7,button_8,button_ok;
    String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startToast();
    }

    private void buttonClick(String buttonId){
        switch (buttonId){
            case "1":
                password += "1";
                break;
            case "2":
                password += "2";
                break;
            case "3":
                password += "3";
                break;
            case "4":
                password += "4";
                break;
            case "5":
                password += "5";
                break;
            case "6":
                password += "6";
                break;
            case "7":
                password += "7";
                break;
            case "8":
                password += "8";
                break;
            case "ok":
                if(password.contains("11") && password.contains("22")
                   && password.contains("33") && password.contains("44")
                   && password.contains("55") && password.contains("66")
                   && password.contains("77") && password.contains("88")){
                    toast.cancel();
                    this.finish();
                    System.exit(0);
                }
                break;
        }
    }

    private void startToast(){

        (new Thread(new Runnable()
        {

            @Override
            public void run()
            {
                while (!Thread.interrupted())
                    try
                    {
                        Thread.sleep(500);
                        runOnUiThread(new Runnable() // start actions in UI thread
                        {

                            @Override
                            public void run()
                            {
                                showToast(); // this action have to be in UI thread
                            }
                        });
                    }
                    catch (InterruptedException e)
                    {
                        // ooops
                    }
            }
        })).start(); // the while thread will start in BG thread

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                moveTaskToBack(true);
                //Do something after 100ms
            }
        }, 4000);
    }

    private void showToast(){

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,
                (ViewGroup) findViewById(R.id.toast_layout));

        button_1 =layout.findViewById(R.id.button_1);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("1");
            }
        });

        button_2 =layout.findViewById(R.id.button_2);
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("2");
            }
        });

        button_3 =layout.findViewById(R.id.button_3);
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("3");
            }
        });

        button_4 =layout.findViewById(R.id.button_4);
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("4");
            }
        });

        button_5 =layout.findViewById(R.id.button_5);
        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("5");
            }
        });

        button_6 =layout.findViewById(R.id.button_6);
        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("6");
            }
        });

        button_7 =layout.findViewById(R.id.button_7);
        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("7");
            }
        });

        button_8 =layout.findViewById(R.id.button_8);
        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("8");
            }
        });

        button_ok=layout.findViewById(R.id.button_ok);
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick("ok");
            }
        });


        toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.FILL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
