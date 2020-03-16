package com.example.pruebatecnica

import android.content.Context
import android.util.Log
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

object VolleyRequest {
    private var queue : RequestQueue? = null
    private var url = ""

    fun setContext(context : Context){
        if(queue == null){
            queue = Volley.newRequestQueue(context)
        }
    }

    fun changeURL(url:String){
        this.url = url
    }

    fun getAPI(id: String){
        url += id
        val jsonArrayRequest = JsonArrayRequest(url,
            Response.Listener { response ->
            Log.i("DASU", "Response is $response")
            },
            Response.ErrorListener { error ->
                error.printStackTrace()
            })
        if(queue == null){
            queue?.add(jsonArrayRequest)
        }
        else {
            Log.e("DASU", "Error the VolleyRequest need context")
        }
    }

    fun getAPIAll(){
       getAPI("")
    }
}