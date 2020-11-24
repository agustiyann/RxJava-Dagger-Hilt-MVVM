package com.masscode.gonews.ui.home

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.masscode.gonews.domain.usecase.UserUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(userUseCase: UserUseCase) : ViewModel() {
    val articles = LiveDataReactiveStreams.fromPublisher(userUseCase.getAllArticles())
}