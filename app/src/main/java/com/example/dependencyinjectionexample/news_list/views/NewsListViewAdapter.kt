package com.example.dependencyinjectionexample.news_list.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dependencyinjectionexample.R
import com.example.dependencyinjectionexample.news_list.data.models.News
import com.example.dependencyinjectionexample.news_list.data.models.NewsListModel


/**
 * The Adapter for the RecyclerView of the news
 */
class NewsListViewAdapter(
  private val model: NewsListModel,
  private val listener: OnViewHolderItemSelected<News?>? = null
) :
  RecyclerView.Adapter<NewsListItemViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListItemViewHolder {
    val itemView =
      LayoutInflater.from(parent.context)
        .inflate(R.layout.news_list_item_layout, parent, false)
    return NewsListItemViewHolder(itemView, listener)
  }

  override fun getItemCount(): Int = model.newsList.size

  override fun onBindViewHolder(holder: NewsListItemViewHolder, position: Int) {
    holder.bind(model.newsList[position])
  }
}