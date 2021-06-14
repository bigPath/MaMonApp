package com.example.mamonapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    TextView textValue, errorText,text;
    ImageButton fullButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textValue = (TextView)findViewById(R.id.textRes);
        text = (TextView)findViewById(R.id.textView2);
        fullButton = (ImageButton)findViewById(R.id.imgButtonFull);

        fullButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // new Task().execute();

                //textValue.setText("recordData");
               /* Intent intentFu = new Intent(MainActivity.this, FullOptionsActivity.class);
                intentFu.putExtra("textR", "recordData");
                startActivity(intentFu);*/

                ExecutorService executorService = Executors.newSingleThreadExecutor();
                Handler handler = new Handler(Looper.getMainLooper());

                executorService.execute(new Runnable() {
                    //Connection conn = null;
                    ResultSet resultSet = null;
                    String record = "";

                    /*String url = "jdbc:mysql://localhost/mamonapp";
                    String usr = "root";
                    String pass = "";*/



                    @Override
                    public void run() {
                       // text.setText("Avant");

                        try {

                            String url = "jdbc:mysql://localhost:3306/mamonapp";
                           // String url = "jdbc:mysql://localhost/mamonapp";
                            String usr = "root";
                            String pass = "";

                            Class.forName("com.mysql.jdbc.Driver");
                            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mamonapp","root","");
                            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mamonapp","root","");
                            //conn = DriverManager.getConnection(url, usr, pass);
                            //conn = DriverManager.getConnection("jdbc:mysql://localhost/mamonapp?" +
                            //"user=root&password=''");

                           // Statement statement = conn.createStatement();
                          //  resultSet = statement.executeQuery("SELECT datetime, accumulatedvolume from dailyreport");
                            //text.setText(conn.toString());
                            //testTextMain.setText("record");
                          /*  while (true) {
                                text.setText("Avant");
                            }*/
                            text.setText("Before Resulset");

                        /*while (resultSet.next()){
                          //  record += resultSet.getString(1)+"\n";
                            //text.setText(resultSet.getString(1)+"\n");
                            text.setText("Resulset Work");
                        }*/
                            // text.setText(record);

                    } catch (Exception e) {
                    // catch (SQLException e) {
                      //  System.out.println(e.getMessage());
                    }
                    }
                });


               /* new Thread(() -> {
                    // int counter = 0;

                    Connection conn = null;
                    ResultSet resultSet = null;
                    String record = "";

                    try {
                       // String url = "jdbc:mysql://localhost:3306/mamonapp";
                        String url = "jdbc:mysql://localhost/mamonapp";
                        String usr = "root";
                        String pass = "";

                        conn = DriverManager.getConnection(url, usr, pass);

                        Statement statement = conn.createStatement();
                        resultSet = statement.executeQuery("SELECT datetime, accumulatedvolume from dailyreport");

                        //testTextMain.setText("record");
                        while (true) {
                            text.setText("Avant");
                        }*/

                       /* while (resultSet.next()){
                          //  record += resultSet.getString(1)+"\n";
                        //    text.setText(resultSet.getString(1)+"\n");

                        }*/
                       // text.setText(record);

                   /* } //catch (Exception e) {
                     catch (SQLException e) {
                      //  System.out.println(e.getMessage());
                    }*/ /*finally {
                    try{
                        if(conn != null)
                        conn.close();
                    }catch(SQLException ex){
                        System.out.println(ex.getMessage());
                    }*/


                  /*  while (true) {
                        try {
                            if (!resultSet.next()) break;
                            else {
                                record += resultSet.getString(1)+"\n";

                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        //Log.d("Thread", "count: " + counter);
                       // counter++;
                    }*/



                //}).start();

            }
        });

    }

   /* class Task extends Thread implements Runnable{


    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
              //  Toast.makeText(this,"Menu 1 selected", Toast.LENGTH_SHORT);
                Intent intentFu = new Intent(MainActivity.this, FullOptionsActivity.class);
                startActivity(intentFu);
                return true;
            case R.id.menu2:
              //  Toast.makeText(this,"Menu 2 selected", Toast.LENGTH_SHORT);
                Intent intentCu = new Intent(MainActivity.this, CustomiseActivity.class);
                startActivity(intentCu);
                return true;

            case R.id.menu3:
              //  Toast.makeText(this,"Menu 3 selected", Toast.LENGTH_SHORT);
                Intent intentViewP = new Intent(MainActivity.this, ViewByPeriodActivity.class);
                startActivity(intentViewP);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}