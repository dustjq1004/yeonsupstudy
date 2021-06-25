package com.example.studyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studyapp.RecyclerViewAdapter.ViewHolder
import kotlinx.android.synthetic.main.activity_recycle_view.*

class RecycleViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)
        val carList = ArrayList<Car>()
        for (i in 0 until 40) {
            carList.add((Car("" + i + "번째 자동차", "" + i + " 순위 엔진")))
        }
        val adapter = RecyclerViewAdapter(carList, LayoutInflater.from(this@RecycleViewActivity))
        recyclerview.adapter = adapter
        //recyclerview.layoutManager = LinearLayoutManager(this@RecycleViewActivity)
        recyclerview.layoutManager = GridLayoutManager(this@RecycleViewActivity, 2)
    }
}

class RecyclerViewAdapter (
    val itemList : ArrayList<Car>,
    val inflater : LayoutInflater
): RecyclerView.Adapter<ViewHolder>() {

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val carName : TextView
        val carEngine : TextView
        init {
            carName = itemView.findViewById(R.id.car_name)
            carEngine = itemView.findViewById(R.id.car_engine)
            itemView.setOnClickListener{
                val position : Int = adapterPosition
                val engineName = itemList.get(position).engine

            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.carName.setText(itemList.get(position).name)
        holder.carEngine.setText(itemList.get(position).engine)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}