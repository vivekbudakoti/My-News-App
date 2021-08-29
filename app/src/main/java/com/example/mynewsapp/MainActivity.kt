package com.example.mynewsapp

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.provider.Settings
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.mynewsapp.R
import org.json.JSONException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.mynewsapp.Adapter.InterAdapter
import com.example.mynewsapp.model.News
import com.example.mynewsapp.util.ConnectionManager
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerInter : RecyclerView
    lateinit var layoutManager : RecyclerView.LayoutManager
    lateinit var recyclerAdapter : InterAdapter
    lateinit var progressLayout : RelativeLayout
    lateinit var progressBar : ProgressBar

    var newsInfoList = arrayListOf<News>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerInter = findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(this)
        progressLayout = findViewById(R.id.progressLayout)
        progressBar = findViewById(R.id.progressBar)
        progressLayout.visibility = View.VISIBLE

        //Volley starts here
        val queue = Volley.newRequestQueue(this)
        val url = "https://api.nytimes.com/svc/topstories/v2/world.json?api-key=bktTaXoH2c9GANLGV1HhmPm2GbAb8VG3"


        if(ConnectionManager().checkConnectivity(this)){
            val jasonObjectRequest =
                object : JsonObjectRequest(
                    Method.GET,
                    url,
                    null,
                    com.android.volley.Response.Listener {

                        progressLayout.visibility = View.GONE
                        progressBar.visibility = View.GONE

                        print("Result is $it")
                      try{

                          val success = it.getString("status")

                          if(success=="OK"){
                              val data = it.getJSONArray("results")
                              for(i in 0 until data.length()){
                                  val newsObject = data.getJSONObject(i)
                                  val titel = newsObject.getString("title")
                                  val abstract = newsObject.getString("abstract")
                                  val section = newsObject.getString("section").capitalize()
                                  val url = newsObject.getString("url")
                                  val updateDate = newsObject.getString("updated_date").split("T")
                                  val date = updateDate[0]
                                  val time = updateDate[1]
                                  val multimedia = newsObject.getJSONArray("multimedia")
                                  val multimediaObjetc = multimedia.getJSONObject(0)
                                  val image = multimediaObjetc.getString("url")

                                  val news = News(time,titel,abstract, date,image,url)
                                  newsInfoList.add(news)

                              }
                          }
                          else{
                              Toast.makeText(this,"No Response Recieived!!",Toast.LENGTH_SHORT).show()
                          }
                          recyclerAdapter =
                              InterAdapter(this, newsInfoList)
                          recyclerInter.adapter = recyclerAdapter
                          recyclerInter.layoutManager = layoutManager
                      }
                      catch (e: JSONException)
                      {
                          print("Exception is $e")
                          Toast.makeText(this,"Server Side Error!!", Toast.LENGTH_SHORT).show()
                      }
                    },
                    com.android.volley.Response.ErrorListener {
                        if(this!=null) {
                            Toast.makeText(this, "Data Not Fetched!! $it", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }) {

//                    override fun getHeaders(): MutableMap<String, String> {
//                        val header = HashMap<String, String>()
//                        //header["Content-type"] = "application/json"
//                      //  header["X-Api-Key"] = "a10cf1ba4c6f484d8d15160aeb11e273"
//                        return super.getHeaders()
               // }


        }
        queue.add(jasonObjectRequest)
        }
        else {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Failure")
            dialog.setMessage("No InterNet Connection Found")
            dialog.setPositiveButton("Open Settings") { text, listener ->

                startActivity(Intent(Settings.ACTION_WIRELESS_SETTINGS))
                this?.finish()
            }
            dialog.setNegativeButton("Exit") { text, listner ->
                ActivityCompat.finishAffinity(this)

            }
            dialog.create()
            dialog.show()

        }



    }
}