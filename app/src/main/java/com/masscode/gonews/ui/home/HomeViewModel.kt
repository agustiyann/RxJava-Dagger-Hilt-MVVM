package com.masscode.gonews.ui.home

import androidx.lifecycle.ViewModel
import com.masscode.gonews.domain.usecase.ArticleUseCase

class HomeViewModel(articleUseCase: ArticleUseCase) : ViewModel() {
    val articles = articleUseCase.getAllArticles()
}