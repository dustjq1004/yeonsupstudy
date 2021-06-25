package com.example.studyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.activity_out_stargram_my_post_list.*
import kotlinx.android.synthetic.main.activity_out_stargram_my_post_list.all_list
import kotlinx.android.synthetic.main.activity_out_stargram_my_post_list.user_info
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OutStargramMyPostListActivity : AppCompatActivity() {

    lateinit var myPosRecyclerView: RecyclerView
    lateinit var glide : RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_out_stargram_my_post_list)

        myPosRecyclerView = mypost_recyclerview
        glide = Glide.with(this@OutStargramMyPostListActivity)
        createList()


        upload.setOnClickListener {
            startActivity(Intent(this@OutStargramMyPostListActivity, OutStargramUpldActivity::class.java))
        }

        user_info.setOnClickListener {
            startActivity(Intent(this@OutStargramMyPostListActivity, OutStargramUserInfo::class.java))
        }

        all_list.setOnClickListener {
            startActivity(Intent(this@OutStargramMyPostListActivity, OutStargramPostListActivity::class.java))
        }
    }

    fun createList(){
        (application as MasterApplication).service.getUserPostList().enqueue(
            object : Callback<ArrayList<Post>>{
                override fun onResponse(
                    call: Call<ArrayList<Post>>,
                    response: Response<ArrayList<Post>>
                ) {
                    if(response.isSuccessful){
                        val myPostList = response.body()
                        val adapter = MyPostAdapter(myPostList!!,
                            LayoutInflater.from(this@OutStargramMyPostListActivity),
                            glide
                        )
                        myPosRecyclerView.adapter = adapter
                        myPosRecyclerView.layoutManager = LinearLayoutManager(this@OutStargramMyPostListActivity)
                    }

                }

                override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            }
        )
    }
}

class MyPostAdapter(
    var postList : ArrayList<Post>,
    val inflater: LayoutInflater,
    val glide: RequestManager
): RecyclerView.Adapter<MyPostAdapter.ViewHolder>() {

    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val postOwner : TextView
        val postImage : ImageView
        val postContent : TextView
        init  {
            postOwner = itemView.findViewById(R.id.post_owner)
            postImage = itemView.findViewById(R.id.postImage)
            postContent = itemView.findViewById(R.id.post_content)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.ouststargram_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.postOwner.setText(postList.get(position).owner)
        holder.postContent.setText(postList.get(position).content)
        glide.load(postList.get(position).Imageq).into(holder.postImage)
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}