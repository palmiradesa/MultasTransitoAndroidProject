package com.example.palmira.multastransito;

    import android.app.ProgressDialog;
    import android.os.AsyncTask;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.View;
    import android.widget.ArrayAdapter;
    import android.widget.Button;
    import android.widget.ListView;
    import android.widget.TextView;
    import android.widget.Toast;

    import com.android.volley.Request;
    import com.android.volley.RequestQueue;
    import com.android.volley.Response;
    import com.android.volley.VolleyError;
    import com.android.volley.toolbox.JsonObjectRequest;
    import com.android.volley.toolbox.Volley;

    import org.json.JSONArray;
    import org.json.JSONException;
    import org.json.JSONObject;
    import org.w3c.dom.Text;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.net.HttpURLConnection;
    import java.net.MalformedURLException;
    import java.net.URL;

    public class TesteJson extends AppCompatActivity{
        Button listar;
        TextView lista;
        RequestQueue requestQueue;
        //o  url que contem a localizacao dos ficheiros php
        String insertUrl="http://192.168.43.89/tutorial/insertUser.php";
        String showUrl="http://192.168.43.89/tutorial/showUsers.php";
        ListView listView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.teste);


            listView = (ListView) findViewById(R.id.listView);
          //  salvar=(Button) findViewById(R.id.salvar);
            listar=(Button) findViewById(R.id.botaoJson);
            lista=(TextView) findViewById(R.id.textViewJson);

            requestQueue= Volley.newRequestQueue(getApplicationContext());

//
//            salvar.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v) {
//                    lista.setText("Ola Evento");
//                }
//            });
            System.out.println("Android Oncreate");

            listar.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view){
                    Toast toast=Toast.makeText(getApplicationContext(),"C evento comecou", Toast.LENGTH_SHORT);
                    toast.show();

                    JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, showUrl,
                            new Response.Listener<JSONObject>() {



                                @Override
                                public void onResponse(JSONObject response) {
                                    System.out.print("Json Respondeu");
                                    try {
                                        //buscar o array retornado pelo JSON que produzimos por php
                                        JSONArray students = response.getJSONArray("students");
                                        for(int i=0; i<students.length(); i++){
                                            //criamos um objecto json e colocamos o elemento actual do array
                                            JSONObject student= students.getJSONObject(i);

                                            String firstName= student.getString("contact");
                                            String lastName= student.getString("lastName");
                                            String age=student.getString("age");

                                            listar.append(firstName+" "+ lastName+ " "+age);
                                        }
                                        listar.append("===\n");

                                    }catch (JSONException e){
                                        e.printStackTrace();
                                        System.out.print("Json Exception");
                                    }
                                }
                            }, new Response.ErrorListener(){
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast toast=Toast.makeText(getApplicationContext(),"A resposta do request eh errada", Toast.LENGTH_SHORT);
                            toast.show();

                        }

                    });
                    requestQueue.add(jsonObjectRequest);
                }
            });
            }
    }



















