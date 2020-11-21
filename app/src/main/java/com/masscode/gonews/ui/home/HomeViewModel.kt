package com.masscode.gonews.ui.home

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.masscode.gonews.domain.usecase.ArticleUseCase

class HomeViewModel(articleUseCase: ArticleUseCase) : ViewModel() {
    val articles = LiveDataReactiveStreams.fromPublisher(articleUseCase.getAllArticles())
}