package mumtaz.binar.dependencyinjectionlistnews.listnews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*
import mumtaz.binar.dependencyinjectionlistnews.R
import mumtaz.binar.dependencyinjectionlistnews.listnews.model.GetAllNewsResponse
import mumtaz.binar.dependencyinjectionlistnews.listnews.model.GetAllNewsResponseItem

class NewsAdapter(private var onclick : (GetAllNewsResponseItem)->Unit): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var dataNews : List<GetAllNewsResponseItem>? = null

    fun setDataNews(news : List<GetAllNewsResponseItem>){
        this.dataNews = news
    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val tampilanUi = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)

        return ViewHolder(tampilanUi)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.itemView.tv_judulnews.text = dataNews!![position].title
        holder.itemView.tv_tglnews.text = dataNews!![position].createdAt
        holder.itemView.tv_author.text = dataNews!![position].author
        Glide.with(holder.itemView.context).load(dataNews!![position].image).into(holder.itemView.img_news)

        holder.itemView.card_news.setOnClickListener {
            onclick(dataNews!![position])
        }
    }

    override fun getItemCount(): Int {
        if (dataNews == null){
            return 0
        }else {
            return dataNews!!.size
        }
    }
}