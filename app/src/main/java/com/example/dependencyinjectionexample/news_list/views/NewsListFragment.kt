package com.example.dependencyinjectionexample.news_list.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dependencyinjectionexample.App
import com.example.dependencyinjectionexample.R
import com.example.dependencyinjectionexample.base.APIHelper
import com.example.dependencyinjectionexample.news_details.views.NewsDetailsFragment
import com.example.dependencyinjectionexample.news_list.data.NewsDataManagerImpl
import com.example.dependencyinjectionexample.news_list.data.models.NewsListModel
import com.example.dependencyinjectionexample.news_list.data.remote.NewsAPI
import com.example.dependencyinjectionexample.news_list.di.DaggerNewsListComponent
import com.example.dependencyinjectionexample.news_list.view_models.NewsListViewModel
import kotlinx.android.synthetic.main.fragment_news_list.*
import javax.inject.Inject


class NewsListFragment : Fragment() {

    lateinit var newsListAdapter: NewsListViewAdapter
    @Inject
    lateinit var viewModel: NewsListViewModel
    @Inject
    lateinit var newsListModel: NewsListModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        DaggerNewsListComponent.builder()
            .applicationComponent((activity?.application as App).applicationComponent)
            .build().inject(this)
        super.onViewCreated(view, savedInstanceState)





        newsListAdapter = NewsListViewAdapter(newsListModel) { selectedNews ->
            val bundle = Bundle().apply {
                putLong(NewsDetailsFragment.NEWS_ID, selectedNews?.id ?: -1)
            }
            fragmentManager?.run {
                beginTransaction()
                    .replace(R.id.anchor, NewsDetailsFragment.create(bundle))
                    .addToBackStack(null)
                    .commit()
            }
        }

        news_recycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        val dividerItemDecoration = DividerItemDecoration(
            context,
            LinearLayoutManager.VERTICAL
        )
        news_recycler.addItemDecoration(dividerItemDecoration)
        news_recycler.adapter = newsListAdapter
        viewModel.newsList.observe(this, Observer {
                newsListModel.newsList = it.newsList
                newsListAdapter.notifyDataSetChanged()
        })


        viewModel.getNewsList()
    }


}