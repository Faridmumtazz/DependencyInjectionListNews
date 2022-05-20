package mumtaz.binar.dependencyinjectionlistnews.listnews.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import mumtaz.binar.dependencyinjectionlistnews.R
import mumtaz.binar.dependencyinjectionlistnews.listnews.model.GetAllNewsResponseItem

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailnews = intent.getParcelableExtra<GetAllNewsResponseItem>("detailnews")

        tv_detaljudulnews.text = detailnews?.title
        tv_tanggal.text = detailnews?.createdAt
        tv_detalauthor.text = detailnews?.author
        tv_desc.text = detailnews?.description

        Glide.with(this).load(detailnews?.image).into(img_detail)
    }
}