package com.example.dependencyinjectionexample.news_details.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.dependencyinjectionexample.App
import com.example.dependencyinjectionexample.R
import com.example.dependencyinjectionexample.base.APIHelper
import com.example.dependencyinjectionexample.news_details.di.DaggerNewsDetailsComponent
import com.example.dependencyinjectionexample.news_details.viewmodels.NewsDetailsViewModel
import com.example.dependencyinjectionexample.news_list.data.NewsDataManagerImpl
import com.example.dependencyinjectionexample.news_list.data.remote.NewsAPI
import com.example.dependencyinjectionexample.news_list.di.DaggerNewsListComponent
import kotlinx.android.synthetic.main.fragment_news_details.*


class NewsDetailsFragment : Fragment() {

    lateinit var viewModel: NewsDetailsViewModel

    companion object {

        const val NEWS_ID = "news_id"

        fun create(bundle: Bundle?): NewsDetailsFragment = NewsDetailsFragment().apply {
            arguments = bundle
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerNewsDetailsComponent.builder()
            .applicationComponent((activity?.application as App).applicationComponent)
            .build().inject(this)


        val apiHelper = APIHelper(activity!!.applicationContext)
        val newsAPIHelper = NewsAPI(apiHelper)
        val newsDataManager = NewsDataManagerImpl(newsAPIHelper)
        viewModel = NewsDetailsViewModel(newsDataManager)

        viewModel.newsItem.observe(this, Observer {
            news_detail_title.text = it.title
            news_detail_body.text = it.body
        })

        arguments?.getLong(NEWS_ID)?.let { newsId ->
            viewModel.getNewsItem(newsId)
        }
    }

}