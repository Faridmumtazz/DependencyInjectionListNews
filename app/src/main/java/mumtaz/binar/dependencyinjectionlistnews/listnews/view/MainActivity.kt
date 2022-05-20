package mumtaz.binar.dependencyinjectionlistnews.listnews.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import mumtaz.binar.dependencyinjectionlistnews.R
import mumtaz.binar.dependencyinjectionlistnews.listnews.adapter.NewsAdapter
import mumtaz.binar.dependencyinjectionlistnews.listnews.viewmodel.ViewModelNews

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var adapternews:NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDataNews()
    }




     fun getDataNews(){
        val newsAdapter = NewsAdapter(){
            val pindah = Intent(this, DetailActivity::class.java)
            pindah.putExtra("detailnews", it)
            startActivity(pindah)
        }

        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.adapter = newsAdapter

        val viewModel = ViewModelProvider(this).get(ViewModelNews::class.java)

        viewModel.news.observe(this){
            if (it != null){
                newsAdapter.setDataNews(it)
                newsAdapter.notifyDataSetChanged()
            }
        }

    }



}